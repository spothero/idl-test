// Code generated by protoc-gen-go. DO NOT EDIT.
// source: grpcv1/fortune_teller_api.proto

package grpcv1

import (
	context "context"
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion3 // please upgrade the proto package

type GetFortuneResponse_Animal int32

const (
	GetFortuneResponse_ANIMAL_INVALID GetFortuneResponse_Animal = 0
	GetFortuneResponse_ANIMAL_MONKEY  GetFortuneResponse_Animal = 1
	GetFortuneResponse_ANIMAL_OWL     GetFortuneResponse_Animal = 2
	GetFortuneResponse_ANIMAL_ANT     GetFortuneResponse_Animal = 3
	GetFortuneResponse_ANIMAL_LIZARD  GetFortuneResponse_Animal = 4
	GetFortuneResponse_ANIMAL_CAT     GetFortuneResponse_Animal = 5
)

var GetFortuneResponse_Animal_name = map[int32]string{
	0: "ANIMAL_INVALID",
	1: "ANIMAL_MONKEY",
	2: "ANIMAL_OWL",
	3: "ANIMAL_ANT",
	4: "ANIMAL_LIZARD",
	5: "ANIMAL_CAT",
}

var GetFortuneResponse_Animal_value = map[string]int32{
	"ANIMAL_INVALID": 0,
	"ANIMAL_MONKEY":  1,
	"ANIMAL_OWL":     2,
	"ANIMAL_ANT":     3,
	"ANIMAL_LIZARD":  4,
	"ANIMAL_CAT":     5,
}

func (x GetFortuneResponse_Animal) String() string {
	return proto.EnumName(GetFortuneResponse_Animal_name, int32(x))
}

func (GetFortuneResponse_Animal) EnumDescriptor() ([]byte, []int) {
	return fileDescriptor_88c3798fade0bb30, []int{1, 0}
}

type GetFortuneRequest struct {
	Name string `protobuf:"bytes,1,opt,name=name,proto3" json:"name,omitempty"`
	// this field may be absent
	OptionalCar *GetFortuneRequest_Car `protobuf:"bytes,3,opt,name=optional_car,json=optionalCar,proto3" json:"optional_car,omitempty"`
	// Types that are valid to be assigned to VehicleDescription:
	//	*GetFortuneRequest_CarNickname
	//	*GetFortuneRequest_BikeFrameSizeCm
	VehicleDescription   isGetFortuneRequest_VehicleDescription `protobuf_oneof:"vehicle_description"`
	FingerLengths        []int32                                `protobuf:"varint,6,rep,packed,name=finger_lengths,json=fingerLengths,proto3" json:"finger_lengths,omitempty"`
	SiblingAges          map[string]int32                       `protobuf:"bytes,7,rep,name=sibling_ages,json=siblingAges,proto3" json:"sibling_ages,omitempty" protobuf_key:"bytes,1,opt,name=key,proto3" protobuf_val:"varint,2,opt,name=value,proto3"`
	XXX_NoUnkeyedLiteral struct{}                               `json:"-"`
	XXX_unrecognized     []byte                                 `json:"-"`
	XXX_sizecache        int32                                  `json:"-"`
}

func (m *GetFortuneRequest) Reset()         { *m = GetFortuneRequest{} }
func (m *GetFortuneRequest) String() string { return proto.CompactTextString(m) }
func (*GetFortuneRequest) ProtoMessage()    {}
func (*GetFortuneRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_88c3798fade0bb30, []int{0}
}

func (m *GetFortuneRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetFortuneRequest.Unmarshal(m, b)
}
func (m *GetFortuneRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetFortuneRequest.Marshal(b, m, deterministic)
}
func (m *GetFortuneRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetFortuneRequest.Merge(m, src)
}
func (m *GetFortuneRequest) XXX_Size() int {
	return xxx_messageInfo_GetFortuneRequest.Size(m)
}
func (m *GetFortuneRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_GetFortuneRequest.DiscardUnknown(m)
}

var xxx_messageInfo_GetFortuneRequest proto.InternalMessageInfo

func (m *GetFortuneRequest) GetName() string {
	if m != nil {
		return m.Name
	}
	return ""
}

func (m *GetFortuneRequest) GetOptionalCar() *GetFortuneRequest_Car {
	if m != nil {
		return m.OptionalCar
	}
	return nil
}

type isGetFortuneRequest_VehicleDescription interface {
	isGetFortuneRequest_VehicleDescription()
}

type GetFortuneRequest_CarNickname struct {
	CarNickname string `protobuf:"bytes,4,opt,name=car_nickname,json=carNickname,proto3,oneof"`
}

type GetFortuneRequest_BikeFrameSizeCm struct {
	BikeFrameSizeCm int32 `protobuf:"varint,5,opt,name=bike_frame_size_cm,json=bikeFrameSizeCm,proto3,oneof"`
}

func (*GetFortuneRequest_CarNickname) isGetFortuneRequest_VehicleDescription() {}

func (*GetFortuneRequest_BikeFrameSizeCm) isGetFortuneRequest_VehicleDescription() {}

func (m *GetFortuneRequest) GetVehicleDescription() isGetFortuneRequest_VehicleDescription {
	if m != nil {
		return m.VehicleDescription
	}
	return nil
}

func (m *GetFortuneRequest) GetCarNickname() string {
	if x, ok := m.GetVehicleDescription().(*GetFortuneRequest_CarNickname); ok {
		return x.CarNickname
	}
	return ""
}

func (m *GetFortuneRequest) GetBikeFrameSizeCm() int32 {
	if x, ok := m.GetVehicleDescription().(*GetFortuneRequest_BikeFrameSizeCm); ok {
		return x.BikeFrameSizeCm
	}
	return 0
}

func (m *GetFortuneRequest) GetFingerLengths() []int32 {
	if m != nil {
		return m.FingerLengths
	}
	return nil
}

func (m *GetFortuneRequest) GetSiblingAges() map[string]int32 {
	if m != nil {
		return m.SiblingAges
	}
	return nil
}

// XXX_OneofWrappers is for the internal use of the proto package.
func (*GetFortuneRequest) XXX_OneofWrappers() []interface{} {
	return []interface{}{
		(*GetFortuneRequest_CarNickname)(nil),
		(*GetFortuneRequest_BikeFrameSizeCm)(nil),
	}
}

type GetFortuneRequest_Car struct {
	Make                 string   `protobuf:"bytes,1,opt,name=make,proto3" json:"make,omitempty"`
	Model                string   `protobuf:"bytes,2,opt,name=model,proto3" json:"model,omitempty"`
	Year                 int32    `protobuf:"varint,3,opt,name=year,proto3" json:"year,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *GetFortuneRequest_Car) Reset()         { *m = GetFortuneRequest_Car{} }
func (m *GetFortuneRequest_Car) String() string { return proto.CompactTextString(m) }
func (*GetFortuneRequest_Car) ProtoMessage()    {}
func (*GetFortuneRequest_Car) Descriptor() ([]byte, []int) {
	return fileDescriptor_88c3798fade0bb30, []int{0, 0}
}

func (m *GetFortuneRequest_Car) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetFortuneRequest_Car.Unmarshal(m, b)
}
func (m *GetFortuneRequest_Car) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetFortuneRequest_Car.Marshal(b, m, deterministic)
}
func (m *GetFortuneRequest_Car) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetFortuneRequest_Car.Merge(m, src)
}
func (m *GetFortuneRequest_Car) XXX_Size() int {
	return xxx_messageInfo_GetFortuneRequest_Car.Size(m)
}
func (m *GetFortuneRequest_Car) XXX_DiscardUnknown() {
	xxx_messageInfo_GetFortuneRequest_Car.DiscardUnknown(m)
}

var xxx_messageInfo_GetFortuneRequest_Car proto.InternalMessageInfo

func (m *GetFortuneRequest_Car) GetMake() string {
	if m != nil {
		return m.Make
	}
	return ""
}

func (m *GetFortuneRequest_Car) GetModel() string {
	if m != nil {
		return m.Model
	}
	return ""
}

func (m *GetFortuneRequest_Car) GetYear() int32 {
	if m != nil {
		return m.Year
	}
	return 0
}

type GetFortuneResponse struct {
	Fortune              string                    `protobuf:"bytes,1,opt,name=fortune,proto3" json:"fortune,omitempty"`
	LuckyNumbers         []int32                   `protobuf:"varint,2,rep,packed,name=lucky_numbers,json=luckyNumbers,proto3" json:"lucky_numbers,omitempty"`
	LuckyAnimal          GetFortuneResponse_Animal `protobuf:"varint,3,opt,name=lucky_animal,json=luckyAnimal,proto3,enum=grpc.v1.GetFortuneResponse_Animal" json:"lucky_animal,omitempty"`
	XXX_NoUnkeyedLiteral struct{}                  `json:"-"`
	XXX_unrecognized     []byte                    `json:"-"`
	XXX_sizecache        int32                     `json:"-"`
}

func (m *GetFortuneResponse) Reset()         { *m = GetFortuneResponse{} }
func (m *GetFortuneResponse) String() string { return proto.CompactTextString(m) }
func (*GetFortuneResponse) ProtoMessage()    {}
func (*GetFortuneResponse) Descriptor() ([]byte, []int) {
	return fileDescriptor_88c3798fade0bb30, []int{1}
}

func (m *GetFortuneResponse) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetFortuneResponse.Unmarshal(m, b)
}
func (m *GetFortuneResponse) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetFortuneResponse.Marshal(b, m, deterministic)
}
func (m *GetFortuneResponse) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetFortuneResponse.Merge(m, src)
}
func (m *GetFortuneResponse) XXX_Size() int {
	return xxx_messageInfo_GetFortuneResponse.Size(m)
}
func (m *GetFortuneResponse) XXX_DiscardUnknown() {
	xxx_messageInfo_GetFortuneResponse.DiscardUnknown(m)
}

var xxx_messageInfo_GetFortuneResponse proto.InternalMessageInfo

func (m *GetFortuneResponse) GetFortune() string {
	if m != nil {
		return m.Fortune
	}
	return ""
}

func (m *GetFortuneResponse) GetLuckyNumbers() []int32 {
	if m != nil {
		return m.LuckyNumbers
	}
	return nil
}

func (m *GetFortuneResponse) GetLuckyAnimal() GetFortuneResponse_Animal {
	if m != nil {
		return m.LuckyAnimal
	}
	return GetFortuneResponse_ANIMAL_INVALID
}

func init() {
	proto.RegisterEnum("grpc.v1.GetFortuneResponse_Animal", GetFortuneResponse_Animal_name, GetFortuneResponse_Animal_value)
	proto.RegisterType((*GetFortuneRequest)(nil), "grpc.v1.GetFortuneRequest")
	proto.RegisterMapType((map[string]int32)(nil), "grpc.v1.GetFortuneRequest.SiblingAgesEntry")
	proto.RegisterType((*GetFortuneRequest_Car)(nil), "grpc.v1.GetFortuneRequest.Car")
	proto.RegisterType((*GetFortuneResponse)(nil), "grpc.v1.GetFortuneResponse")
}

func init() { proto.RegisterFile("grpcv1/fortune_teller_api.proto", fileDescriptor_88c3798fade0bb30) }

var fileDescriptor_88c3798fade0bb30 = []byte{
	// 569 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0x7c, 0x53, 0xdd, 0x6a, 0xdb, 0x4c,
	0x10, 0x8d, 0x24, 0xcb, 0x26, 0x23, 0xc7, 0x9f, 0xb2, 0x5f, 0x0b, 0xc2, 0x85, 0xd6, 0x38, 0x14,
	0x0c, 0xa5, 0x2a, 0x76, 0x6f, 0x4a, 0x29, 0x05, 0xc5, 0x71, 0x12, 0x53, 0x47, 0x09, 0x4a, 0x48,
	0x93, 0x50, 0x58, 0xd6, 0xca, 0xc4, 0x59, 0xac, 0x1f, 0x77, 0x25, 0x1b, 0x9c, 0x87, 0xe8, 0x43,
	0xf4, 0xb2, 0x8f, 0xd2, 0xbb, 0xbe, 0x51, 0xd1, 0xae, 0xdc, 0x98, 0xfe, 0xe4, 0xee, 0x9c, 0xb3,
	0x67, 0xcf, 0xce, 0x0c, 0x3b, 0xf0, 0x6c, 0x22, 0x66, 0xe1, 0xa2, 0xfb, 0xea, 0x26, 0x15, 0xf9,
	0x3c, 0x41, 0x9a, 0x63, 0x14, 0xa1, 0xa0, 0x6c, 0xc6, 0xdd, 0x99, 0x48, 0xf3, 0x94, 0xd4, 0x0a,
	0x83, 0xbb, 0xe8, 0xb6, 0x7f, 0x18, 0xb0, 0x7d, 0x80, 0xf9, 0xbe, 0x32, 0x06, 0xf8, 0x79, 0x8e,
	0x59, 0x4e, 0x08, 0x54, 0x12, 0x16, 0xa3, 0xa3, 0xb5, 0xb4, 0xce, 0x66, 0x20, 0x31, 0xf1, 0xa0,
	0x9e, 0xce, 0x72, 0x9e, 0x26, 0x2c, 0xa2, 0x21, 0x13, 0x8e, 0xd1, 0xd2, 0x3a, 0x56, 0xef, 0xa9,
	0x5b, 0x26, 0xb9, 0x7f, 0xa4, 0xb8, 0x7d, 0x26, 0x02, 0x6b, 0x75, 0xa7, 0xcf, 0x04, 0xd9, 0x81,
	0x7a, 0xc8, 0x04, 0x4d, 0x78, 0x38, 0x95, 0xf1, 0x95, 0x22, 0xfe, 0x70, 0x23, 0xb0, 0x42, 0x26,
	0xfc, 0x52, 0x24, 0x2f, 0x81, 0x8c, 0xf9, 0x14, 0xe9, 0x8d, 0x60, 0x31, 0xd2, 0x8c, 0xdf, 0x21,
	0x0d, 0x63, 0xc7, 0x6c, 0x69, 0x1d, 0xf3, 0x70, 0x23, 0xf8, 0xaf, 0x38, 0xdb, 0x2f, 0x8e, 0x4e,
	0xf9, 0x1d, 0xf6, 0x63, 0xf2, 0x1c, 0x1a, 0x37, 0x3c, 0x99, 0xa0, 0xa0, 0x11, 0x26, 0x93, 0xfc,
	0x36, 0x73, 0xaa, 0x2d, 0xa3, 0x63, 0x06, 0x5b, 0x4a, 0x1d, 0x29, 0x91, 0xf8, 0x50, 0xcf, 0xf8,
	0x38, 0xe2, 0xc9, 0x84, 0xb2, 0x09, 0x66, 0x4e, 0xad, 0x65, 0x74, 0xac, 0xde, 0x8b, 0x07, 0xaa,
	0x3f, 0x55, 0x76, 0x6f, 0x82, 0xd9, 0x20, 0xc9, 0xc5, 0x32, 0xb0, 0xb2, 0x7b, 0xa5, 0xd9, 0x07,
	0xa3, 0xe8, 0x88, 0x40, 0x25, 0x66, 0xd3, 0x5f, 0x83, 0x2a, 0x30, 0x79, 0x04, 0x66, 0x9c, 0x5e,
	0x63, 0xe4, 0xe8, 0x52, 0x54, 0xa4, 0x70, 0x2e, 0xb1, 0x1c, 0x9b, 0x19, 0x48, 0xdc, 0x7c, 0x0f,
	0xf6, 0xef, 0xaf, 0x10, 0x1b, 0x8c, 0x29, 0x2e, 0xcb, 0xc0, 0x02, 0x16, 0x79, 0x0b, 0x16, 0xcd,
	0x51, 0xe6, 0x99, 0x81, 0x22, 0x6f, 0xf5, 0x37, 0xda, 0xee, 0x63, 0xf8, 0x7f, 0x81, 0xb7, 0x3c,
	0x8c, 0x90, 0x5e, 0x63, 0x16, 0x0a, 0x2e, 0x67, 0xdd, 0xfe, 0xa2, 0x03, 0x59, 0xef, 0x27, 0x9b,
	0xa5, 0x49, 0x86, 0xc4, 0x81, 0x5a, 0xf9, 0x1f, 0xca, 0xf4, 0x15, 0x25, 0x3b, 0xb0, 0x15, 0xcd,
	0xc3, 0xe9, 0x92, 0x26, 0xf3, 0x78, 0x8c, 0x22, 0x73, 0x74, 0x39, 0xc2, 0xba, 0x14, 0x7d, 0xa5,
	0x91, 0x01, 0x28, 0x4e, 0x59, 0xc2, 0x63, 0x16, 0xc9, 0x46, 0x1a, 0xbd, 0xf6, 0x5f, 0x27, 0xa8,
	0x5e, 0x74, 0x3d, 0xe9, 0x0c, 0x2c, 0x79, 0x4f, 0x91, 0xb6, 0x80, 0xaa, 0x42, 0x84, 0x40, 0xc3,
	0xf3, 0x87, 0x47, 0xde, 0x88, 0x0e, 0xfd, 0x73, 0x6f, 0x34, 0xdc, 0xb3, 0x37, 0xc8, 0x36, 0x6c,
	0x95, 0xda, 0xd1, 0xb1, 0xff, 0x61, 0x70, 0x69, 0x6b, 0xa4, 0x01, 0x50, 0x4a, 0xc7, 0x1f, 0x47,
	0xb6, 0xbe, 0xc6, 0x3d, 0xff, 0xcc, 0x36, 0xd6, 0xae, 0x8c, 0x86, 0x57, 0x5e, 0xb0, 0x67, 0x57,
	0xd6, 0x2c, 0x7d, 0xef, 0xcc, 0x36, 0x7b, 0x97, 0x60, 0x97, 0xa5, 0x9d, 0xc9, 0x45, 0xf0, 0x4e,
	0x86, 0x64, 0x00, 0x70, 0x5f, 0x31, 0x69, 0xfe, 0xfb, 0x23, 0x34, 0x9f, 0x3c, 0xd0, 0xe2, 0xee,
	0x3b, 0xb0, 0xc2, 0x34, 0x5e, 0x39, 0x76, 0x37, 0x0f, 0xc4, 0x2c, 0x3c, 0x29, 0x56, 0xec, 0x44,
	0xbb, 0xaa, 0xaa, 0x2d, 0xfc, 0xaa, 0x1b, 0x07, 0x17, 0x17, 0xdf, 0xf4, 0x5a, 0x71, 0xe6, 0x9e,
	0x77, 0xbf, 0x2b, 0xf4, 0xe9, 0xbc, 0x3b, 0xae, 0xca, 0x6d, 0x7c, 0xfd, 0x33, 0x00, 0x00, 0xff,
	0xff, 0xfa, 0x78, 0x3b, 0xfa, 0xb0, 0x03, 0x00, 0x00,
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// FortuneTellerAPIClient is the client API for FortuneTellerAPI service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type FortuneTellerAPIClient interface {
	GetFortune(ctx context.Context, in *GetFortuneRequest, opts ...grpc.CallOption) (*GetFortuneResponse, error)
}

type fortuneTellerAPIClient struct {
	cc *grpc.ClientConn
}

func NewFortuneTellerAPIClient(cc *grpc.ClientConn) FortuneTellerAPIClient {
	return &fortuneTellerAPIClient{cc}
}

func (c *fortuneTellerAPIClient) GetFortune(ctx context.Context, in *GetFortuneRequest, opts ...grpc.CallOption) (*GetFortuneResponse, error) {
	out := new(GetFortuneResponse)
	err := c.cc.Invoke(ctx, "/grpc.v1.FortuneTellerAPI/GetFortune", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// FortuneTellerAPIServer is the server API for FortuneTellerAPI service.
type FortuneTellerAPIServer interface {
	GetFortune(context.Context, *GetFortuneRequest) (*GetFortuneResponse, error)
}

// UnimplementedFortuneTellerAPIServer can be embedded to have forward compatible implementations.
type UnimplementedFortuneTellerAPIServer struct {
}

func (*UnimplementedFortuneTellerAPIServer) GetFortune(ctx context.Context, req *GetFortuneRequest) (*GetFortuneResponse, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetFortune not implemented")
}

func RegisterFortuneTellerAPIServer(s *grpc.Server, srv FortuneTellerAPIServer) {
	s.RegisterService(&_FortuneTellerAPI_serviceDesc, srv)
}

func _FortuneTellerAPI_GetFortune_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetFortuneRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(FortuneTellerAPIServer).GetFortune(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/grpc.v1.FortuneTellerAPI/GetFortune",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(FortuneTellerAPIServer).GetFortune(ctx, req.(*GetFortuneRequest))
	}
	return interceptor(ctx, in, info, handler)
}

var _FortuneTellerAPI_serviceDesc = grpc.ServiceDesc{
	ServiceName: "grpc.v1.FortuneTellerAPI",
	HandlerType: (*FortuneTellerAPIServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "GetFortune",
			Handler:    _FortuneTellerAPI_GetFortune_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "grpcv1/fortune_teller_api.proto",
}