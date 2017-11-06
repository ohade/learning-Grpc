package hello;


import static hello.FirstServiceGrpc.newFutureStub;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;

import hello.FirstServiceGrpc.FirstServiceFutureStub;
import hello.test.FirstRequest;
import hello.test.FirstResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;


@SuppressWarnings("ALL")
public class FirstClient {
    private static final Logger logger = Logger.getLogger(FirstClient.class.getName());

    private ManagedChannel channel;
    private FirstServiceFutureStub futureStub;

    public FirstClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        futureStub = newFutureStub(channel);
    }

    public List<ByteString> getCombine(int counter, String phrase) {
        FirstRequest req = FirstRequest.newBuilder()
                .setCounter(counter)
                .setPhrase(phrase)
                .build();

        ListenableFuture<FirstResponse> futureRes;
        try {
            futureRes = futureStub.getCombine(req);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return null;
        }

        /**
         * DO SOME OTHER WORK
         */
        FirstResponse res = null;
        try {
            logger.log(Level.INFO, "Waiting for RPC future");
            res = futureRes.get(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        if (res != null) {
            return prepareResponse(res.getCombineList());
        } else {
            return null;
        }
    }

    private List<ByteString> prepareResponse(ProtocolStringList res) {
        return res.asByteStringList();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
