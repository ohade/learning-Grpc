package hello;


import static hello.FirstServiceGrpc.newBlockingStub;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;

import hello.FirstServiceGrpc.FirstServiceBlockingStub;
import hello.test.FirstRequest;
import hello.test.FirstResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


@SuppressWarnings("ALL")
public class FirstClient {
    private static final Logger logger = Logger.getLogger(FirstClient.class.getName());

    private ManagedChannel channel;
    private FirstServiceBlockingStub blockingStub;

    public FirstClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        blockingStub = newBlockingStub(channel);
    }

    public List<ByteString> getCombine(int counter, String phrase) {
        FirstRequest req = FirstRequest.newBuilder()
                .setCounter(counter)
                .setPhrase(phrase)
                .build();

        FirstResponse res;
        try {
            res = blockingStub.getCombine(req);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return null;
        }
        return prepareResponse(res.getCombineList());
    }

    private List<ByteString> prepareResponse(ProtocolStringList res) {
        return res.asByteStringList();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
