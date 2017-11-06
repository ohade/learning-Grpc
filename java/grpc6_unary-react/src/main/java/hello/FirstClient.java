package hello;


import static hello.FirstServiceGrpc.newFutureStub;
import static hello.FirstServiceGrpc.newStub;

import java.util.List;
import java.util.concurrent.CompletableFuture;
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
import io.grpc.stub.StreamObserver;


@SuppressWarnings("ALL")
public class FirstClient {
    private static final Logger logger = Logger.getLogger(FirstClient.class.getName());

    private ManagedChannel channel;
    private FirstServiceGrpc.FirstServiceStub reactStub;

    public FirstClient(int port) {
        channel = ManagedChannelBuilder.forAddress("localhost", port).usePlaintext(true).build();
        reactStub = newStub(channel);
    }

    public List<ByteString> getCombine(int counter, String phrase) {
        FirstRequest req = FirstRequest.newBuilder()
                .setCounter(counter)
                .setPhrase(phrase)
                .build();
        final CompletableFuture<FirstResponse> completableFuture = new CompletableFuture<>();
        final StreamObserver<FirstResponse> responseObserver = new StreamObserver<FirstResponse>() {

            @Override
            public void onNext(FirstResponse firstResponse) {
                completableFuture.complete(firstResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                logger.warning("Error from gRPC service");
                completableFuture.completeExceptionally(throwable);
            }

            @Override
            public void onCompleted() {
                logger.info("done");
            }
        };
        reactStub.getCombine(req, responseObserver);
        FirstResponse res = null;
        try {
            res = completableFuture.get(5, TimeUnit.SECONDS);
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
