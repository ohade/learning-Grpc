from proto import test_pb2_grpc
from proto.test_pb2 import FirstResponse


class FirstService(test_pb2_grpc.FirstServiceServicer):
    """Provides methods that implement functionality of route guide server."""
    def __init__(self):
        pass

    def GetCombine(self, request, context):
        counter = request.counter
        name = request.name
        print "Got grpc request!, Counter: {}, name: {}".format(request.counter, request.name)
        res = FirstResponse()
        for c in range(1, counter+1):
            res.combine.append("{}. {}".format(c, name))
        return res
