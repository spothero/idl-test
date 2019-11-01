##
## setup.py.tpl
## ============
## Template for setup.py for Python packages containing GRPC service stubs.
##
import os

import sys

from setuptools import find_packages, setup

GRPCIO_VERSION = "1.24"
GRPCIO_TOOLS_VERSION = "1.24"

setup(
    name="{{PACKAGE_NAME}}",
    version="{{VERSION}}",
    author="SpotHero",
    url="{{PACKAGE_URL}}",
    long_description=__doc__,
    packages=find_packages(include=["{{ROOT_PACKAGE_NAME}}*",]),
    install_requires=[
        "grpcio=={}".format(GRPCIO_VERSION),
        "grpcio-tools=={}".format(GRPCIO_TOOLS_VERSION),
    ],
)
