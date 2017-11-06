package hello;
import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SecondServer {
    private static final Logger logger = Logger.getLogger(SecondServer.class.getName());
    private Server service;

    public void start() throws IOException {
        service = ServerBuilder
                .forPort(8980)
                .addService(new SecondService())
                .build()
                .start();
        logger.info("In process Server started, listening on port: " + 8980);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            SecondServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    public void stop() {
        if (service != null) {
            service.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (service != null) {
            service.awaitTermination();
        }
    }

    public static void main(String[] args) throws Exception {
        SecondServer server = new SecondServer();
        server.start();
        server.blockUntilShutdown();
    }
}
