package hello;
import hello.SecondServiceGrpc.SecondServiceImplBase;
import hello.test.FirstRequest;
import hello.test.FirstResponse;
import hello.test.SecondResponse;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@SuppressWarnings("Duplicates")
public class SecondService extends SecondServiceImplBase {
    private static final Logger logger = Logger.getLogger(SecondService.class.getName());

    @Override
    public void getCombineServerStream(FirstRequest request, StreamObserver<SecondResponse> responseObserver) {
        String requestInfo = String.format("Got server stream grpc request!, Counter: %d, name: %s", request.getCounter(), request.getPhrase());
        logger.info(requestInfo);
        int sleepTime = 2;
        FirstResponse firstResponse = getFirstResponse(request.getCounter(), request.getPhrase());
        IntStream.range(1, request.getCounter()).forEach(
                n -> {
                    SecondResponse secondResponse = getSecondResponse(firstResponse, n);
                    responseObserver.onNext(secondResponse);
                    try {
                        TimeUnit.SECONDS.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );
        responseObserver.onCompleted();
    }

    private SecondResponse getSecondResponse(FirstResponse firstResponse, int n) {
        SecondResponse.Builder builder = SecondResponse.newBuilder();
        builder.setIndex(n);
        builder.setInnerMessage(firstResponse);
        return builder.build();
    }

    private FirstResponse getFirstResponse(int counter, String phrase) {
        FirstResponse.Builder builder = FirstResponse.newBuilder();
        IntStream.range(1, counter + 1).forEach(
                n -> builder.addCombine(String.format("%d. %s", n, phrase))
        );
        return builder.build();
    }
}
