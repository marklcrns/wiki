---
title: LibGDX Usage
author: Mark Lucernas
date: Oct 17, 2020
---


# Usage

## Using `gradlew` or `gradle`

More on [📑 gradle usage](../../tools/gradle/usage.md#usage)

### Basic Usage

- `gradlew clean` -- clean gradle project
- `gradlew build` -- build gradle project
- `gradlew desktop:run` -- run desktop application


## Adding Libraries Manually

- [📄 LibGDX - Adding Libraries Manually (Gradle)](https://www.youtube.com/watch?v=3qKb11EYlU4)


## Adding JUnit 5 for Testing

In the root `build.gradle`, add the following lines:

> Note 

```gradle
allprojects {
    ...

    ext {
        ...

        junitJupiterVersion = '5.7.0'

        ...
    }


project(":core") {
    ...

    dependencies {
        ...

        testImplementation "org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion"
        testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion"

        ...
    }

    test {
        useJUnitPlatform()
        testLogging {
            showStandardStreams = true
            events "passed", "skipped", "failed"
        }

        // Optional
        testLogging {
            showStandardStreams = true
            events "standardOut", "passed", "skipped", "failed"
            exceptionFormat = 'full'
        }
    }
}
```

Update your **core** module source directory and create test folder

```
mkdir core/src/main/java core/src/test/java core/src/test/res
```

Then, edit your **core** `build.gradle` source and test path

```gradle
// From 
sourceSets.main.java.srcDirs = [ "src/" ]

// To
sourceSets.main.java.srcDirs = [ "src/main/java/" ]
sourceSets.test.java.srcDirs = [ "src/test/java/" ]
sourceSets.test.resources.srcDirs = [ "src/test/res/" ]
```

Running unit tests from root directory with

```bash
gradlew test
```

Ref:

- [📄 Setting up Kotlin, JUnit, Mockito, and Gitlab CI for Libgdx Projects](https://blog.noynoy.org/setting-up-kotlin-junit-mockito-gitlab-ci-for-libgdx-projects/)
- [📄 Adding JUnit to your Libgdx Project](https://neutroniogames.wordpress.com/2017/05/18/adding-junit-to-your-libgdx-project/)
- [📄 JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

<br>

# Resources

- [📄 LibGDX - Adding Libraries Manually (Gradle)](https://www.youtube.com/watch?v=3qKb11EYlU4)
- [📄 Setting up Kotlin, JUnit, Mockito, and Gitlab CI for Libgdx Projects](https://blog.noynoy.org/setting-up-kotlin-junit-mockito-gitlab-ci-for-libgdx-projects/)
- [📄 Adding JUnit to your Libgdx Project](https://neutroniogames.wordpress.com/2017/05/18/adding-junit-to-your-libgdx-project/)
- [📄 JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

