package hello;
import hello.FirstServiceGrpc.FirstServiceImplBase;
import hello.test.FirstRequest;
import hello.test.FirstResponse;
import io.grpc.stub.StreamObserver;

import java.util.logging.Logger;
import java.util.stream.IntStream;

public class FirstService extends FirstServiceImplBase {
    private static final Logger logger = Logger.getLogger(FirstServer.class.getName());

    @Override
    public void getCombine(FirstRequest request, StreamObserver<FirstResponse> responseObserver) {
        String requestInfo = String.format("Got Blocking grpc request!, Counter: %d, name: %s", request.getCounter(), request.getPhrase());
        logger.info(requestInfo);
        responseObserver.onNext(GetFirstResponse(request.getCounter(), request.getPhrase()));
        responseObserver.onCompleted();
    }

    private FirstResponse GetFirstResponse(int counter, String phrase) {
        FirstResponse.Builder builder = FirstResponse.newBuilder();
        IntStream.range(1, counter + 1).forEach(
                n -> builder.addCombine(String.format("%d. %s", n, phrase))
        );
        return builder.build();
    }
}
