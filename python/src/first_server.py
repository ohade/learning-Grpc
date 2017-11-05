import grpc
import time
from proto import test_pb2_grpc
from concurrent import futures
from first_service import FirstService


class FirstServer(object):
    def __init__(self):
        server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
        test_pb2_grpc.add_FirstServiceServicer_to_server(
            FirstService(), server)
        server.add_insecure_port('[::]:50051')
        server.start()
        print "server started, listening to port:", 50051
        try:
            while True:
                time.sleep(86400)
        except KeyboardInterrupt:
            print "Got request to stop server, stopping"
            server.stop(0)
            print "Server stopped"


if __name__ == '__main__':
    FirstServer()
