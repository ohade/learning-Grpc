package hello;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.2.0)",
    comments = "Source: test2.proto")
public final class SecondServiceGrpc {

  private SecondServiceGrpc() {}

  public static final String SERVICE_NAME = "hello.SecondService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.FirstRequest,
      hello.test.SecondResponse> METHOD_GET_COMBINE_SERVER_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "hello.SecondService", "GetCombineServerStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.SecondResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecondServiceStub newStub(io.grpc.Channel channel) {
    return new SecondServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecondServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SecondServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static SecondServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SecondServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SecondServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCombineServerStream(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COMBINE_SERVER_STREAM, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_COMBINE_SERVER_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                hello.test.FirstRequest,
                hello.test.SecondResponse>(
                  this, METHODID_GET_COMBINE_SERVER_STREAM)))
          .build();
    }
  }

  /**
   */
  public static final class SecondServiceStub extends io.grpc.stub.AbstractStub<SecondServiceStub> {
    private SecondServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecondServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecondServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecondServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCombineServerStream(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_SERVER_STREAM, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SecondServiceBlockingStub extends io.grpc.stub.AbstractStub<SecondServiceBlockingStub> {
    private SecondServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecondServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecondServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecondServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<hello.test.SecondResponse> getCombineServerStream(
        hello.test.FirstRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_COMBINE_SERVER_STREAM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SecondServiceFutureStub extends io.grpc.stub.AbstractStub<SecondServiceFutureStub> {
    private SecondServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecondServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecondServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SecondServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_COMBINE_SERVER_STREAM = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecondServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecondServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMBINE_SERVER_STREAM:
          serviceImpl.getCombineServerStream((hello.test.FirstRequest) request,
              (io.grpc.stub.StreamObserver<hello.test.SecondResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class SecondServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hello.test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SecondServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecondServiceDescriptorSupplier())
              .addMethod(METHOD_GET_COMBINE_SERVER_STREAM)
              .build();
        }
      }
    }
    return result;
  }
}
