from setuptools import setup

setup(
    name='sh_idl_test',
    version='0.1.0',
    long_description=__doc__,
    packages=['sh_idl_test'],
    install_requires=[
        'leftpad==0.1.2',
    ],
    entry_points={
        'console_scripts': [
            'grpc-test=sh_idl_test.grpc:main',
            'thrift-test=sh_idl_test.thrift:main',
        ],
    },
)
