package hello;
import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class FirstServer {
    private static final Logger logger = Logger.getLogger(FirstServer.class.getName());
    private Server service;

    public void start() throws IOException {
        service = ServerBuilder
                .forPort(8980)
                .addService(new FirstService())
                .build()
                .start();
        logger.info("In process Server started, listening on port: " + 8980);
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
        FirstServer server = new FirstServer();
        server.start();
        server.blockUntilShutdown();
    }
}
