# FizzBuzz

[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)

This is a simple variation on the well known http://codingdojo.org/kata/FizzBuzz/ kata exercise.

# The interview exercise
According to the instructions, the exercise have been developed in an iterative way, so the branch ``main`` contains only the specification ``Step 1``. 

The most part of the exercise is in the branch ``alfresco`` that contains all the remaining steps.

The installation instruction will make reference to the more complete branch ``alfresco``.

# Installation
## Requirement

To build, test and launch FizzBuzz the following software are required:

- A JDK 11+ distribution
- Docker 20.10.3
- Docker Compose 1.28.3

NOTE: Using the GraalVM (https://www.graalvm.org/), it will be possible to generate native versions of the FizzBuzz applicaton
NOTE: The docker and docker compose version indicated are the ones used to develop and test the application. It is expected that the application works also with previous versions.

## Build the Java Application

Clone the repository and switch to the branch ``alfresco``:
```shell
...$ git clone https://github.com/gicappa/alfresco-interview.git
...$ git checkout -b alfresco
```
It is possible to build the code using the maven wrapper ``./mvnw`` or a preexisting maven installation (version 3.6+).

Launch the build with the command:
```shell
...$ ./mvnw clean verify
```

The process starts until all the modules are built successfully, and the terminal shows a message similar to the following one:
```shell
...
[INFO] FizzBuzz ........................................... SUCCESS [  1.482 s]
[INFO] FizzBuzz Domain .................................... SUCCESS [ 11.146 s]
[INFO] FizzBuzz UI ........................................ SUCCESS [ 24.443 s]
[INFO] FizzBuzz API ....................................... SUCCESS [ 31.708 s]
[INFO] FizzBuzz Docs ...................................... SUCCESS [  4.527 s]
[INFO] FizzBuzz CLI ....................................... SUCCESS [ 10.913 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:25 min
[INFO] Finished at: 2021-02-19T00:42:53+01:00
[INFO] ------------------------------------------------------------------------
```
All the necessary jar files are generated.

## Build the Docker images

Once the Java part is successfully built, it is possible to build and package the docker image using docker compose:

```shell
...$ docker-compose build
```

This process can take some time since it needs to download and build the docker image that will contain the final application of the exercise.

# Usage
