package hello;


import static hello.FourthServiceGrpc.newStub;
import static java.util.stream.Collectors.joining;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;

import hello.test.SecondResponse;
import hello.test.SleepRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;


@SuppressWarnings("Duplicates")
public class FourthClient {
    private static final Logger logger = Logger.getLogger(FourthClient.class.getName());
    private final String server1Name;
    private final String server2Name;

    private ManagedChannel channel;
    private FourthServiceGrpc.FourthServiceStub asyncStub;

    public FourthClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        asyncStub = newStub(channel);
        server1Name = ConsoleColors.WHITE_BACKGROUND + ConsoleColors.BLACK_BOLD + "Server 1" + ConsoleColors.RESET;
        server2Name = ConsoleColors.BLACK_BACKGROUND + ConsoleColors.WHITE_BOLD + "Server 2" + ConsoleColors.RESET;
    }

    public void getCombineServerStreamLessSimple(int counter, String phrase) {
        final CountDownLatch finishLatch = new CountDownLatch(2);
        StreamObserver<SleepRequest> requestObserver1 = getServerObserver(finishLatch, server1Name);
        StreamObserver<SleepRequest> requestObserver2 = getServerObserver(finishLatch, server2Name);
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
        try {
            requestObserver1.onNext(req1);
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver1.onError(e);
            throw e;
        }
        try {
            requestObserver2.onNext(req2);
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver1.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver1.onCompleted();
        requestObserver2.onCompleted();

        try {
            if (!finishLatch.await(1, TimeUnit.MINUTES)) {
                System.out.println("can not finish within 1 minutes");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private StreamObserver<SleepRequest> getServerObserver(CountDownLatch finishLatch, String serverName) {
        return asyncStub.getCombineServerStreamWithSleep(new StreamObserver<SecondResponse>() {
            @Override
            public void onNext(test.SecondResponse response) {
                printRes(response, serverName);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Failed: " + Status.fromThrowable(throwable));
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished receiving message from server");
                finishLatch.countDown();
            }
        });
    }

    private void printRes(SecondResponse currRes, String serverName) {
        System.out.println(serverName);
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

        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Background
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    }
}
