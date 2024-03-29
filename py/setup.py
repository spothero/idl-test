from setuptools import setup

setup(
    name='sh_idl_test',
    version='0.1.0',
    long_description=__doc__,
    packages=['grpcv1', 'sh_idl_test'],
    install_requires=[
        'grpcio==1.24.1',
        'grpcio-tools==1.24.1',
        'leftpad==0.1.2',
        'thrift==0.11.0'
    ],
    entry_points={
        'console_scripts': [
            'grpc-test=sh_idl_test.grpc:main',
            'thrift-test=sh_idl_test.thrift:main',
        ],
    },
)
