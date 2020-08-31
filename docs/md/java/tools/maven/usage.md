---
title: Apache Maven Usage
subtitle: How to use Apache Maven for Java
author: Mark Lucernas
date: Aug 08, 2020
---


# Usage

First, Make sure you are in the project root directory.

> **NOTE:** As an example, assume `WizardGame` is the project name with
`src/edu/sdccd/cisc191/wizardGame/` project structure.

then create a `pom.xml` as the main Maven configuration file. Heres a sample pom
file.

- [⬇ sample_pom.xml](vfile:sample_pom.xml)

With the `pom.xml` repo and Apache Maven already installed in the system, run
the following to compile and install all dependencies

```bash
mvn install
```

Executing `.jar` file to run project

```bash
java -jar target/WizardGame-0.0.1-SNAPSHOT.jar
```

To run specific class. (replace `<class>` with path to java file starting from
`edu.sdccd.cisc191.wizardGame` directory, using `.` as path separator).

```bash
# Template
mvn exec:java -Dexec.mainClass="edu.sdccd.cisc191.wizardGame.<class>"

# Running Game class
mvn exec:java -Dexec.mainClass="edu.sdccd.cisc191.wizardGame.Game"
```

To recompile project

```bash
mvn compile
```

To package project into a JAR file

```bash
mvn package
```

To run test suite

```bash
mvn clean test
# -e to run tests with full stack trace on failures
mvn clean test -e
```

To clean and remove maven build from project

```bash
mvn clean
```

> **NOTE:** If unit tests fail after new changes that prevents from building the
`.jar` file, although not recommended, simply skip unit testing from build by
running

```bash
mvn clean install -Dmaven.test.skip
```

or to just compile and package into a JAR file without reinstalling dependencies

```bash
mvn package -Dmaven.test.skip
```

<br>

# Resources

- [⬇ pom.xml](vfile:pom.xml)

