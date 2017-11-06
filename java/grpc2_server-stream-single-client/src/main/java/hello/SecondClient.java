package hello;


import static hello.SecondServiceGrpc.newBlockingStub;
import static java.util.stream.Collectors.joining;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;

import hello.SecondServiceGrpc.SecondServiceBlockingStub;
import hello.test.FirstRequest;
import hello.test.SecondResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


@SuppressWarnings("ALL")
public class SecondClient {
    private static final Logger logger = Logger.getLogger(SecondClient.class.getName());

    private ManagedChannel channel;
    private SecondServiceBlockingStub blockingStub;

    public SecondClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        blockingStub = newBlockingStub(channel);
    }

    public void getCombineServerStream(int counter, String phrase) {
        FirstRequest req = FirstRequest.newBuilder()
                .setCounter(counter)
                .setPhrase(phrase)
                .build();

        // the type of res here has changed to iterator
        Iterator<SecondResponse> res;
        try {
            res = blockingStub.getCombineServerStream(req);
            for (int i = 1; res.hasNext(); i++) {
                SecondResponse currRes = res.next();
                printRes(currRes);
            }
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
        }
    }

    private void printRes(SecondResponse currRes) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String combinedRes = currRes.getInnerMessage().getCombineList().asByteStringList().stream().map(ByteString::toStringUtf8).collect(joining(","));

        System.out.println("########");
        System.out.println(dtf.format(LocalDateTime.now()));
        System.out.println("INDEX: " + currRes.getIndex() + " | MESSAGE: {" + combinedRes + "}");
        System.out.println("########");
    }

    private List<ByteString> prepareResponse(ProtocolStringList res) {
        return res.asByteStringList();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
