#!/usr/bin/env python3

import argparse
import random
import sys
import glob
sys.path.append('gen-py')

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

from fortune import FortuneTeller
from fortune.ttypes import FortuneRequest
from fortune.ttypes import VehicleDescription
from fortune.ttypes import Car
from fortune.ttypes import UnfortunateException

DEFAULT_PORT = 9090

def main():
    """Thrift entry point"""
    parser = argparse.ArgumentParser(
        description='Python Thrift client/server experiment',
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

    request = create_request()

    # Make socket
    transport = TSocket.TSocket('localhost', 9090)

    # Buffering is critical. Raw sockets are very slow
    transport = TTransport.TBufferedTransport(transport)

    # Wrap in a protocol
    protocol = TBinaryProtocol.TBinaryProtocol(transport)

    # Create a client to use the protocol encoder
    client = FortuneTeller.Client(protocol)

    # Connect!
    transport.open()

    try:
        response = client.GetFortune(request)
        print("================================")
        print(response)
    except UnfortunateException:
        print("********************************")
        print("UnfortunateException has occured")

    # And close it...
    transport.close()

def run_server(port):
    print(f'Running server on port {port}')
    raise NotImplementedError("TODO: Thrift server")


def create_request():
    true_or_false = random.choice([True, False])
    if true_or_false:
        finger_lengths = [1, 2, 3, 4, 500]
    else:
        finger_lengths = [1, 2, 3, 4, 5]

    request = FortuneRequest(
        name = 'my fortune request',
        optional_car = Car(
            make = "Trabant",
            model = "601",
            year = 1981
        ),
        vehicle_description = VehicleDescription(
            car_nickname = "Trabi"
        ),
        finger_lengths = finger_lengths,
        sibling_ages = {
            'Paul': 24,
            'Amy': 22,
            'Papa John': 65
        }
    )
    return request
