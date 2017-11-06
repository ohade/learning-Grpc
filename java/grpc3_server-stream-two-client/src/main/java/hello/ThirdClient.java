package hello;


import static hello.ThirdServiceGrpc.newBlockingStub;
import static java.util.stream.Collectors.joining;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;

import hello.ThirdServiceGrpc.ThirdServiceBlockingStub;
import hello.test.SecondResponse;
import hello.test.SleepRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


public class ThirdClient {
    private static final Logger logger = Logger.getLogger(ThirdClient.class.getName());

    private ManagedChannel channel;
    private ThirdServiceBlockingStub blockingStub;

    public ThirdClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        blockingStub = newBlockingStub(channel);
    }

    public void getCombineServerStreamLessSimple(int counter, String phrase) {
        SleepRequest req1 = SleepRequest.newBuilder()
                .setSleep(3)
                .setCounter(counter)
                .setPhrase(phrase)
                .build();

        SleepRequest req2 = SleepRequest.newBuilder()
                .setSleep(7)
                .setCounter(counter + 3)
                .setPhrase(phrase)
                .build();

        // the type of res here has changed to iterator
        Iterator<SecondResponse> res1;
        Iterator<SecondResponse> res2;
        try {
            res1 = blockingStub.getCombineServerStreamWithSleep(req1);
            res2 = blockingStub.getCombineServerStreamWithSleep(req2);

            for (; res1.hasNext() || res2.hasNext(); ) {
                System.out.print("res1 status: " + createInfoMessage(res1.hasNext()));
                System.out.println(", res2 status: " + createInfoMessage(res2.hasNext()));
                SecondResponse currRes;
                System.out.println("########");
                if(res1.hasNext()) {
                    currRes = res1.next();
                    System.out.println(ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Got response from Server 1!!!");
                    printRes(currRes);
                }
                if(res2.hasNext()) {
                    currRes = res2.next();
                    System.out.println(ConsoleColors.BLACK_BACKGROUND + ConsoleColors.WHITE_BOLD + "Got response from Server 2!!!");
                    printRes(currRes);
                } else {
                    throw new RuntimeException("This shouldn't happen!!!");
                }
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
    }

    private String createInfoMessage(boolean status) {
        String greenMessageFormat = ConsoleColors.GREEN + "True" + ConsoleColors.RESET;
        String redMessageFormat = ConsoleColors.RED + "False" + ConsoleColors.RESET;
        if(status) {
            return greenMessageFormat;
        } else {
            return redMessageFormat;
        }
    }

    private void printRes(SecondResponse currRes) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String combinedRes = currRes.getInnerMessage().getCombineList().asByteStringList().stream().map(ByteString::toStringUtf8).collect(joining(","));
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println("INDEX: " + currRes.getIndex() + " | MESSAGE: {" + combinedRes + "}" + ConsoleColors.RESET);
        System.out.println("########");
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private class ConsoleColors {
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN

        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Background
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    }
}
