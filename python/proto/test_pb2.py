# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: test.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
from google.protobuf import descriptor_pb2
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor.FileDescriptor(
  name='test.proto',
  package='hello',
  syntax='proto3',
  serialized_pb=_b('\n\ntest.proto\x12\x05hello\"-\n\x0c\x46irstRequest\x12\x0f\n\x07\x63ounter\x18\x01 \x01(\x05\x12\x0c\n\x04name\x18\x02 \x01(\t\" \n\rFirstResponse\x12\x0f\n\x07\x63ombine\x18\x01 \x03(\t2\x9f\x02\n\x0c\x46irstService\x12\x39\n\nGetCombine\x12\x13.hello.FirstRequest\x1a\x14.hello.FirstResponse\"\x00\x12G\n\x16GetCombineClientStream\x12\x13.hello.FirstRequest\x1a\x14.hello.FirstResponse\"\x00(\x01\x12G\n\x16GetCombineServerStream\x12\x13.hello.FirstRequest\x1a\x14.hello.FirstResponse\"\x00\x30\x01\x12\x42\n\x0fGetCombineAsync\x12\x13.hello.FirstRequest\x1a\x14.hello.FirstResponse\"\x00(\x01\x30\x01\x42\r\n\x05helloB\x04testb\x06proto3')
)




_FIRSTREQUEST = _descriptor.Descriptor(
  name='FirstRequest',
  full_name='hello.FirstRequest',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='counter', full_name='hello.FirstRequest.counter', index=0,
      number=1, type=5, cpp_type=1, label=1,
      has_default_value=False, default_value=0,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
    _descriptor.FieldDescriptor(
      name='name', full_name='hello.FirstRequest.name', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=21,
  serialized_end=66,
)


_FIRSTRESPONSE = _descriptor.Descriptor(
  name='FirstResponse',
  full_name='hello.FirstResponse',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='combine', full_name='hello.FirstResponse.combine', index=0,
      number=1, type=9, cpp_type=9, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      options=None),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=68,
  serialized_end=100,
)

DESCRIPTOR.message_types_by_name['FirstRequest'] = _FIRSTREQUEST
DESCRIPTOR.message_types_by_name['FirstResponse'] = _FIRSTRESPONSE
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

FirstRequest = _reflection.GeneratedProtocolMessageType('FirstRequest', (_message.Message,), dict(
  DESCRIPTOR = _FIRSTREQUEST,
  __module__ = 'test_pb2'
  # @@protoc_insertion_point(class_scope:hello.FirstRequest)
  ))
_sym_db.RegisterMessage(FirstRequest)

FirstResponse = _reflection.GeneratedProtocolMessageType('FirstResponse', (_message.Message,), dict(
  DESCRIPTOR = _FIRSTRESPONSE,
  __module__ = 'test_pb2'
  # @@protoc_insertion_point(class_scope:hello.FirstResponse)
  ))
_sym_db.RegisterMessage(FirstResponse)


DESCRIPTOR.has_options = True
DESCRIPTOR._options = _descriptor._ParseOptions(descriptor_pb2.FileOptions(), _b('\n\005helloB\004test'))

_FIRSTSERVICE = _descriptor.ServiceDescriptor(
  name='FirstService',
  full_name='hello.FirstService',
  file=DESCRIPTOR,
  index=0,
  options=None,
  serialized_start=103,
  serialized_end=390,
  methods=[
  _descriptor.MethodDescriptor(
    name='GetCombine',
    full_name='hello.FirstService.GetCombine',
    index=0,
    containing_service=None,
    input_type=_FIRSTREQUEST,
    output_type=_FIRSTRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='GetCombineClientStream',
    full_name='hello.FirstService.GetCombineClientStream',
    index=1,
    containing_service=None,
    input_type=_FIRSTREQUEST,
    output_type=_FIRSTRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='GetCombineServerStream',
    full_name='hello.FirstService.GetCombineServerStream',
    index=2,
    containing_service=None,
    input_type=_FIRSTREQUEST,
    output_type=_FIRSTRESPONSE,
    options=None,
  ),
  _descriptor.MethodDescriptor(
    name='GetCombineAsync',
    full_name='hello.FirstService.GetCombineAsync',
    index=3,
    containing_service=None,
    input_type=_FIRSTREQUEST,
    output_type=_FIRSTRESPONSE,
    options=None,
  ),
])
_sym_db.RegisterServiceDescriptor(_FIRSTSERVICE)

DESCRIPTOR.services_by_name['FirstService'] = _FIRSTSERVICE

# @@protoc_insertion_point(module_scope)