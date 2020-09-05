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
file configuration for `WizardGame`.

```xml
<!-- Sample pom.xml -->

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>edu.sdccd.cisc191.wizardGame</groupId>
  <artifactId>labs</artifactId>
  <version>0.0.1-SNAPSHOT</version>

  <properties>
    <!-- Project Globals -->
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>

      <!-- Dependency Versions -->
    <junit.version>5.6.2</junit.version>

      <!-- Plugin Versions -->
    <maven-compiler-plugin.version>3.8.1</maven-compiler-plugin.version>
    <maven-deploy-plugin.version>3.0.0-M1</maven-deploy-plugin.version>
    <compile.java.version>1.8</compile.java.version>
    <maven-surefire-plugin.version>3.0.0-M4</maven-surefire-plugin.version>
    <maven-source-plugin.version>3.2.1</maven-source-plugin.version>
    <maven-javadoc-plugin.version>3.2.0</maven-javadoc-plugin.version>
    <maven-shade-plugin.version>3.2.2</maven-shade-plugin.version>
    <maven-site-plugin.version>3.9.0</maven-site-plugin.version>
    <jgitflow-maven-plugin.version>1.0-m5.1</jgitflow-maven-plugin.version>
    <maven-jar-plugin.version>3.2.0</maven-jar-plugin.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>${junit.version}</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>${maven-compiler-plugin.version}</version>
        <configuration>
          <source>${compile.java.version}</source>
          <target>${compile.java.version}</target>
        </configuration>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>${maven-deploy-plugin.version}</version>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>${maven-surefire-plugin.version}</version>
        <configuration>
          <forkMode>once</forkMode>
          <reuseForks>false</reuseForks>
          <forkCount>1</forkCount>
          <workingDirectory>target</workingDirectory>
        </configuration>
      </plugin>
      <!-- Add source to jar manifest -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-source-plugin</artifactId>
        <version>${maven-source-plugin.version}</version>
        <executions>
          <execution>
            <id>attach-sources</id>
            <goals>
              <goal>jar</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-javadoc-plugin</artifactId>
        <version>${maven-javadoc-plugin.version}</version>
        <configuration>
          <quiet>true</quiet>
        </configuration>
        <executions>
          <execution>
            <id>attach-javadocs</id>
            <goals>
              <goal>jar</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <!-- Add versioning to jar manifest -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-jar-plugin</artifactId>
        <version>${maven-jar-plugin.version}</version>
        <configuration>
          <archive>
            <manifest>
              <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
            </manifest>
          </archive>
        </configuration>
      </plugin>
      <!-- Skip site plugin http://veithen.blogspot.com/2013/05/maven-patterns-skipping-site-generation.html -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-site-plugin</artifactId>
        <version>${maven-site-plugin.version}</version>
        <executions>
          <execution>
            <id>default-site</id>
            <phase>site</phase>
            <goals>
              <goal>site</goal>
            </goals>
            <configuration>
              <skip>true</skip>
            </configuration>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>${maven-shade-plugin.version}</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>edu.sdccd.cisc191.Lab1</mainClass>
                </transformer>
              </transformers>
              <filters>
                <filter>
                  <artifact>*:*</artifact>
                  <excludes>
                    <exclude>META-INF/*.SF</exclude>
                    <exclude>META-INF/*.DSA</exclude>
                    <exclude>META-INF/*.RSA</exclude>
                  </excludes>
                </filter>
              </filters>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

  <!-- Distribute to internal repo -->
  <distributionManagement>
    <repository>
      <id>cisc191</id>
      <name>CISC191 Maven Repo</name>
      <url>https://maven.pkg.github.com/MiramarCISC/CISC191</url>
    </repository>
  </distributionManagement>
</project>
```

With the `pom.xml` at the root directory and Apache Maven already installed in
the system, run the following to compile and install all dependencies

```sh
mvn install
```

Executing `.jar` file to run project

```sh
java -jar target/WizardGame-0.0.1-SNAPSHOT.jar
```

To run specific class. (replace `<class>` with path to java file starting from
`edu.sdccd.cisc191.wizardGame` directory, using `.` as path separator).

```sh
# Template
mvn exec:java -Dexec.mainClass="edu.sdccd.cisc191.wizardGame.<class>"

# Running Game class
mvn exec:java -Dexec.mainClass="edu.sdccd.cisc191.wizardGame.Game"
```

To recompile project

```sh
mvn compile
```

To package project into a JAR file

```sh
mvn package
```

To run test suite

```sh
mvn clean test
# -e to run tests with full stack trace on failures
mvn clean test -e
```

To clean and remove maven build from project

```sh
mvn clean
```

> **NOTE:** If unit tests fail after new changes that prevents from building the
`.jar` file, although not recommended, simply skip unit testing from build by
running

```sh
mvn clean install -Dmaven.test.skip
```

or to just compile and package into a JAR file without reinstalling dependencies

```sh
mvn package -Dmaven.test.skip
```

<br>

# Resources


