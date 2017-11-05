package hello;
import hello.FourthServiceGrpc.FourthServiceImplBase;
import hello.test.SleepRequest;
import hello.test.FirstResponse;
import hello.test.SecondResponse;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@SuppressWarnings("Duplicates")
public class FourthService extends FourthServiceImplBase {
    private static final Logger logger = Logger.getLogger(FourthService.class.getName());

    @Override
    public StreamObserver<SleepRequest> getCombineServerStreamWithSleep(StreamObserver<SecondResponse> responseObserver) {
        return new StreamObserver<SleepRequest>() {
            private int counter;
            private String phrase;
            private int sleep;

            @Override
            public void onNext(SleepRequest request) {
                counter = request.getCounter();
                phrase = request.getPhrase();
                sleep = request.getSleep();
            }

            @Override
            public void onError(Throwable throwable) {
                logger.log(Level.WARNING, "problem");
            }

            @Override
            public void onCompleted() {
                String requestInfo = String.format("Got server stream grpc request!, Counter: %d, name: %s",
                        counter, phrase);
                logger.info(requestInfo);

                /*
                Same response code as before
                 */
                FirstResponse firstResponse = GetFirstResponse(counter, phrase);
                IntStream.range(1, counter).forEach(
                        n -> {
                            SecondResponse secondResponse = getSecondResponse(firstResponse, n);
                            responseObserver.onNext(secondResponse);
                            try {
                                TimeUnit.SECONDS.sleep(sleep);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                );
                responseObserver.onCompleted();
            }
        };
    }

    private void processResponse(
            int counter,
            String phrase,
            int sleepTime,
            StreamObserver<SecondResponse> responseObserver
    ) {
        FirstResponse firstResponse = GetFirstResponse(counter, phrase);
        IntStream.range(1, counter).forEach(
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

    private FirstResponse GetFirstResponse(int counter, String phrase) {
        FirstResponse.Builder builder = FirstResponse.newBuilder();
        IntStream.range(1, counter + 1).forEach(
                n -> builder.addCombine(String.format("%d. %s", n, phrase))
        );
        return builder.build();
    }
}
