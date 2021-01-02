---
title: Java Usage
author: Mark Lucernas
date: Dec 09, 2020
---


# Usage

## Building and Compiling Projects

Dependencies:

- `javac` matching the version as `java` installed.

## Tl;dr

```sh
mkdir -p build
alias javarun='javac -Xlint -sourcepath src -d build src/main/**/*.java; find .  -name "*.java" -not -path "*/test/*" > source.txt; java -cp build path.to.main.driver.Class'
javarun
```

## Building and Running

From root project directory. Create `build` directory.

```sh
mkdir -p build
```

Then run the following to compile `.java` into `build` directory as classpath

```sh
javac -Xlint -sourcepath src -d build src/main/**/*.java
find . -name "*.java" -not -path "*/test/*" > source.txt
```

Then copy all resource files into `build` directory

```sh
cp src/main/resources/*.png src/main/resources/*.jpg build
```

Then run main driver class

```sh
java -cp build path.to.main.driver.Class
```

#### Recompiling

```sh
javac -Xlint -sourcepath src -d build src/main/**/*.java
find . -name "*.java" -not -path "*/test/*" > source.txt
java -cp build path.to.main.driver.Class
```

#### Simple Shortcut

Assign an alias to recompile with just one command

```sh
alias javarun='javac -Xlint -sourcepath src -d build src/main/**/*.java; find . -name "*.java" -not -path "*/test/*" > source.txt; java -cp build path.to.main.driver.Class'
```

Then simply run

```sh
javarun
```

#### Cleaning Up

```sh
rm -r build source.txt
```

