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
    comments = "Source: test4.proto")
public final class FourthServiceGrpc {

  private FourthServiceGrpc() {}

  public static final String SERVICE_NAME = "hello.FourthService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.SleepRequest,
      hello.test.SecondResponse> METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "hello.FourthService", "GetCombineServerStreamWithSleep"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.SleepRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.SecondResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FourthServiceStub newStub(io.grpc.Channel channel) {
    return new FourthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FourthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FourthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static FourthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FourthServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FourthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.SleepRequest> getCombineServerStreamWithSleep(
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP,
            asyncBidiStreamingCall(
              new MethodHandlers<
                hello.test.SleepRequest,
                hello.test.SecondResponse>(
                  this, METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP)))
          .build();
    }
  }

  /**
   */
  public static final class FourthServiceStub extends io.grpc.stub.AbstractStub<FourthServiceStub> {
    private FourthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FourthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FourthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FourthServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.SleepRequest> getCombineServerStreamWithSleep(
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FourthServiceBlockingStub extends io.grpc.stub.AbstractStub<FourthServiceBlockingStub> {
    private FourthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FourthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FourthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FourthServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class FourthServiceFutureStub extends io.grpc.stub.AbstractStub<FourthServiceFutureStub> {
    private FourthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FourthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FourthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FourthServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FourthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FourthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getCombineServerStreamWithSleep(
              (io.grpc.stub.StreamObserver<hello.test.SecondResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class FourthServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hello.test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FourthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FourthServiceDescriptorSupplier())
              .addMethod(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP)
              .build();
        }
      }
    }
    return result;
  }
}
