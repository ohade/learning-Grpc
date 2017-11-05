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
    comments = "Source: test.proto")
public final class FirstServiceGrpc {

  private FirstServiceGrpc() {}

  public static final String SERVICE_NAME = "hello.FirstService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.FirstRequest,
      hello.test.FirstResponse> METHOD_GET_COMBINE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "hello.FirstService", "GetCombine"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.FirstRequest,
      hello.test.FirstResponse> METHOD_GET_COMBINE_CLIENT_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "hello.FirstService", "GetCombineClientStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.FirstRequest,
      hello.test.FirstResponse> METHOD_GET_COMBINE_SERVER_STREAM =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING,
          generateFullMethodName(
              "hello.FirstService", "GetCombineServerStream"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<hello.test.FirstRequest,
      hello.test.FirstResponse> METHOD_GET_COMBINE_ASYNC =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING,
          generateFullMethodName(
              "hello.FirstService", "GetCombineAsync"),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(hello.test.FirstResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FirstServiceStub newStub(io.grpc.Channel channel) {
    return new FirstServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FirstServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FirstServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static FirstServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FirstServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FirstServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getCombine(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COMBINE, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.FirstRequest> getCombineClientStream(
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_COMBINE_CLIENT_STREAM, responseObserver);
    }

    /**
     */
    public void getCombineServerStream(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_COMBINE_SERVER_STREAM, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.FirstRequest> getCombineAsync(
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_GET_COMBINE_ASYNC, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_COMBINE,
            asyncUnaryCall(
              new MethodHandlers<
                hello.test.FirstRequest,
                hello.test.FirstResponse>(
                  this, METHODID_GET_COMBINE)))
          .addMethod(
            METHOD_GET_COMBINE_CLIENT_STREAM,
            asyncClientStreamingCall(
              new MethodHandlers<
                hello.test.FirstRequest,
                hello.test.FirstResponse>(
                  this, METHODID_GET_COMBINE_CLIENT_STREAM)))
          .addMethod(
            METHOD_GET_COMBINE_SERVER_STREAM,
            asyncServerStreamingCall(
              new MethodHandlers<
                hello.test.FirstRequest,
                hello.test.FirstResponse>(
                  this, METHODID_GET_COMBINE_SERVER_STREAM)))
          .addMethod(
            METHOD_GET_COMBINE_ASYNC,
            asyncBidiStreamingCall(
              new MethodHandlers<
                hello.test.FirstRequest,
                hello.test.FirstResponse>(
                  this, METHODID_GET_COMBINE_ASYNC)))
          .build();
    }
  }

  /**
   */
  public static final class FirstServiceStub extends io.grpc.stub.AbstractStub<FirstServiceStub> {
    private FirstServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirstServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirstServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FirstServiceStub(channel, callOptions);
    }

    /**
     */
    public void getCombine(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_COMBINE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.FirstRequest> getCombineClientStream(
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_CLIENT_STREAM, getCallOptions()), responseObserver);
    }

    /**
     */
    public void getCombineServerStream(hello.test.FirstRequest request,
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_SERVER_STREAM, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<hello.test.FirstRequest> getCombineAsync(
        io.grpc.stub.StreamObserver<hello.test.FirstResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(METHOD_GET_COMBINE_ASYNC, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class FirstServiceBlockingStub extends io.grpc.stub.AbstractStub<FirstServiceBlockingStub> {
    private FirstServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirstServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirstServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FirstServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public hello.test.FirstResponse getCombine(hello.test.FirstRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_COMBINE, getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<hello.test.FirstResponse> getCombineServerStream(
        hello.test.FirstRequest request) {
      return blockingServerStreamingCall(
          getChannel(), METHOD_GET_COMBINE_SERVER_STREAM, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FirstServiceFutureStub extends io.grpc.stub.AbstractStub<FirstServiceFutureStub> {
    private FirstServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FirstServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FirstServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FirstServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<hello.test.FirstResponse> getCombine(
        hello.test.FirstRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_COMBINE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_COMBINE = 0;
  private static final int METHODID_GET_COMBINE_SERVER_STREAM = 1;
  private static final int METHODID_GET_COMBINE_CLIENT_STREAM = 2;
  private static final int METHODID_GET_COMBINE_ASYNC = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FirstServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FirstServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_COMBINE:
          serviceImpl.getCombine((hello.test.FirstRequest) request,
              (io.grpc.stub.StreamObserver<hello.test.FirstResponse>) responseObserver);
          break;
        case METHODID_GET_COMBINE_SERVER_STREAM:
          serviceImpl.getCombineServerStream((hello.test.FirstRequest) request,
              (io.grpc.stub.StreamObserver<hello.test.FirstResponse>) responseObserver);
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
        case METHODID_GET_COMBINE_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getCombineClientStream(
              (io.grpc.stub.StreamObserver<hello.test.FirstResponse>) responseObserver);
        case METHODID_GET_COMBINE_ASYNC:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getCombineAsync(
              (io.grpc.stub.StreamObserver<hello.test.FirstResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class FirstServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return hello.test.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FirstServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FirstServiceDescriptorSupplier())
              .addMethod(METHOD_GET_COMBINE)
              .addMethod(METHOD_GET_COMBINE_CLIENT_STREAM)
              .addMethod(METHOD_GET_COMBINE_SERVER_STREAM)
              .addMethod(METHOD_GET_COMBINE_ASYNC)
              .build();
        }
      }
    }
    return result;
  }
}
