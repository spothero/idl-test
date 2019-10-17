#!/usr/bin/env python3

from concurrent import futures
import argparse
import random
import sys

import grpc

from grpcv1 import fortune_teller_api_pb2 as fortune_pb
from grpcv1 import fortune_teller_api_pb2_grpc as fortune_grpc


DEFAULT_PORT = 9111

def main():
    """GRPC entry point"""
    parser = argparse.ArgumentParser(
        description='Python GRPC client/server experiment',
    )
    parser.add_argument(
        'mode',
        type=str,
        choices=['client', 'server'],
        help='Program mode',
    )
    parser.add_argument(
        '--port',
        '-p',
        type=int,
        help='TCP port in [1024, 65535]',
        required=False,
        default=DEFAULT_PORT,
    )

    args = parser.parse_args()

    if args.mode == 'client':
        run_client(args.port)
    elif args.mode == 'server':
        run_server(args.port)
    else:
        # this should never happen
        sys.exit(f'Invalid program mode: {args.mode}')


def run_client(port):
    print(f'Running client on port {port}')

    request = fortune_pb.GetFortuneRequest(
        name='Leeroy Jenkins',
        optional_car=fortune_pb.GetFortuneRequest.Car(
            make='Geo',
            model='Metro',
            year=1992,
        ),
        bike_frame_size_cm=55,
        # WARNING: seems like if multiple oneof variants are provided only one
        # is silently selected and it's not clear how the selection is made.
        # car_nickname='batmobile',
        finger_lengths=[1, 2, 3, 4, 500],
        sibling_ages={
            'Greg':   17,
            'Peter':  15,
            'Bobby':  10,
            'Cindy':  10,
            'MARCIA MARCIA MARCIA!': 17,
        },
    )

    channel = grpc.insecure_channel(f'127.0.0.1:{port}')
    stub = fortune_grpc.FortuneTellerAPIStub(channel)

    try:
        response = stub.GetFortune(request)
        print(f'Received response: {response}')
    except grpc.RpcError as exc:
        # for error handling, see: http://avi.im/grpc-errors/#python
        print(f'RPC Error: code: {exc.code()}; details: {exc.details()}')


def run_server(port):
    print(f'Running server on port {port}')

    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    fortune_grpc.add_FortuneTellerAPIServicer_to_server(
        FortuneTellerAPIServer(),
        server,
    )
    server.add_insecure_port(f'127.0.0.1:{port}')
    server.start()

    try:
        server.wait_for_termination()
    except KeyboardInterrupt:
        print('\nBye.')


class FortuneTellerAPIServer(fortune_grpc.FortuneTellerAPIServicer):
    def GetFortune(self, request, context):
        print(f'Received request: {request}')

        if random.choice([True, False]):
            # for error handling, see: http://avi.im/grpc-errors/#python
            context.set_details("Finger too long. Gross.")
            context.set_code(grpc.StatusCode.INVALID_ARGUMENT)
            return fortune_pb.GetFortuneResponse()

        return fortune_pb.GetFortuneResponse(
            fortune='Avoid fights with bears.',
            lucky_numbers=[1, 2, 3, 4, 5],
            lucky_animal=fortune_pb.GetFortuneResponse.Animal.ANIMAL_CAT,
        )
