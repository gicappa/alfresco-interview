# FizzBuzz

[![License](https://img.shields.io/badge/License-BSD%203--Clause-blue.svg)](https://opensource.org/licenses/BSD-3-Clause)

This is a simple variation on the well known http://codingdojo.org/kata/FizzBuzz/ kata exercise.

## The interview exercise
According to the instructions, the exercise have been developed in an iterative way, so the branch ``main`` contains only the specification ``Step 1``. 

The most part of the exercise is in the branch ``alfresco`` that contains all the remaining steps.

The installation instruction will make reference to the more complete branch ``alfresco``.

## Installation
### Requirement

To build, test and launch FizzBuzz the following software are required:

- A JDK 11+ distribution
- Docker 20.10.3
- Docker Compose 1.28.3

NOTE: Using the GraalVM (https://www.graalvm.org/), it will be possible to generate native versions of the FizzBuzz applicaton
NOTE: The docker and docker compose version indicated are the ones used to develop and test the application. It is expected that the application works also with previous versions.

### Build the Java Application

Clone the repository and switch to the branch ``alfresco``:
```shell
$ git clone https://github.com/gicappa/alfresco-interview.git
$ git checkout -b alfresco
```
It is possible to build the code using the maven wrapper ``./mvnw`` or a preexisting maven installation (version 3.6+).

Launch the build with the command:
```shell
$ ./mvnw clean verify
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

### Build the Docker images

Once the Java part is successfully built, it is possible to build and package the docker image using docker compose:

```shell
$ docker-compose build
```

This process can take some time since it needs to download and build the docker image that will contain the final application of the exercise.

### Creating an uber-jar

By default, the Java project will package the application in a ``fast-jar`` format, that allows a quicker startup time for the docker container.

It is also possible to build an ``uber-jar`` that is a jar that contains the application and all its dependencies so to be easier to be installed and launched as a stand alone server.

To build the ``uber-jar`` package:
```shell
$ ./mvnw verify -Dquarkus.package.type=uber-jar
```

## Creating a native executable

You can create a native executable using:
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

### Build Result
At the end of the build process, there eventually are two jars and one docker image and a native executable application available to the user:

- fizzbuzz-cli.jar
- fizzbuzz-api-1.0-SNAPSHOT-runner.jar (the ``uber-jar``)
- alfresco/fizzbuzz-api (docker image)
- fizzbuzz-api-1.0-SNAPSHOT-runner (native)

## Using FizzBuzz

### Launching the CLI application

Executing the following command from the terminal to launch the FizzBuzz application:

```shell
$ java -jar fizzbuzz-cli/target/fizzbuzz-cli.jar                                                            [2:01:58]
usage: java alfresco.FizzBuzzMain [arg]
   arg - (required) number of fizzbuzz words to generate
```
The application take the number of fizzbuzz word to generate as an input parameter. For instance, to obtain 10 fizzbuzz items:

```shell
$ java -jar fizzbuzz-cli/target/fizzbuzz-cli.jar 10
1 2 alfresco 4 buzz fizz 7 8 fizz buzz fizz: 2 buzz: 2 alfresco: 1 integer: 5
```

### Launching the Uber JAR

Executing the following command from the terminal to start up the FizzBuzz server:
```shell
$ java -jar fizzbuzz-api/target/fizzbuzz-api-1.0-SNAPSHOT-runner.jar                                        [1:53:04]
__  ____  __  _____   ___  __ ____  ______
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/
2021-02-19 01:55:30,297 WARN  [io.qua.run.con.ConfigChangeRecorder] (main) Build time property cannot be changed at runtime:
 - quarkus.package.type was 'uber-jar' at build time and is now 'fast-jar'
2021-02-19 01:55:30,527 INFO  [io.quarkus] (main) fizzbuzz-api 1.0-SNAPSHOT on JVM (powered by Quarkus 1.11.2.Final) started in 5.944s. Listening on: http://0.0.0.0:8080
2021-02-19 01:55:30,529 INFO  [io.quarkus] (main) Profile prod activated.
2021-02-19 01:55:30,529 INFO  [io.quarkus] (main) Installed features: [cdi, resteasy, resteasy-jackson, smallrye-openapi, swagger-ui]
```

Once the server has started, access the url: ```http://localhost:8080/```.

### Launching the docker container

Launch the command:
```shell
$ docker-compose up
```
to  launch the docker container. Again, to access the web application browse to the url: ```http://localhost:8080/```. 

### Launching the native application:

Launch the command:
```shell
$ ./fizzbuzz-api/target/fizzbuzz-api-1.0-SNAPSHOT-runner
```
to  launch the docker container. Again, to access the web application browse to the url: ```http://localhost:8080/```

## Copyright

This software has been released under BSD 3-Clause License