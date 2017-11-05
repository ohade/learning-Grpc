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
    comments = "Source: test3.proto")
public final class ThirdServiceGrpc {

  private ThirdServiceGrpc() {}

  public static final String SERVICE_NAME = "hello.ThirdService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.SleepRequest,
      hello.test.SecondResponse> METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "hello.ThirdService", "GetCombineServerStreamWithSleep"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.SleepRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.SecondResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ThirdServiceStub newStub(io.grpc.Channel channel) {
    return new ThirdServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ThirdServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ThirdServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ThirdServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ThirdServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ThirdServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCombineServerStreamWithSleep(hello.test.SleepRequest request,
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP,
            asyncServerStreamingCall(
              new MethodHandlers<
                hello.test.SleepRequest,
                hello.test.SecondResponse>(
                  this, METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP)))
          .build();
    }
  }

  /**
   */
  public static final class ThirdServiceStub extends io.grpc.stub.AbstractStub<ThirdServiceStub> {
    private ThirdServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThirdServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThirdServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThirdServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCombineServerStreamWithSleep(hello.test.SleepRequest request,
        io.grpc.stub.StreamObserver<hello.test.SecondResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ThirdServiceBlockingStub extends io.grpc.stub.AbstractStub<ThirdServiceBlockingStub> {
    private ThirdServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThirdServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThirdServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThirdServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<hello.test.SecondResponse> getCombineServerStreamWithSleep(
        hello.test.SleepRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ThirdServiceFutureStub extends io.grpc.stub.AbstractStub<ThirdServiceFutureStub> {
    private ThirdServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ThirdServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ThirdServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ThirdServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ThirdServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ThirdServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMBINE_SERVER_STREAM_WITH_SLEEP:
          serviceImpl.getCombineServerStreamWithSleep((hello.test.SleepRequest) request,
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

  private static final class ThirdServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hello.test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ThirdServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ThirdServiceDescriptorSupplier())
              .addMethod(METHOD_GET_COMBINE_SERVER_STREAM_WITH_SLEEP)
              .build();
        }
      }
    }
    return result;
  }
}
