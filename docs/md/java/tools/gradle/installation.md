---
title: Gradle Installation
subtitle: How to install Gradle for Java
author: Mark Lucernas
date: Sep 09, 2020
---


# Installation

## Linux

### Ubuntu

#### 20.04 Focal Fossa

First make sure Java SE 8 or later is installed

```sh
sudo apt update
sudo apt install openjdk-11-jdk
```

Downloading Gradle

```sh
VERSION=6.6.1
wget "https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip" -P /tmp
```

Unzip into `/opt/gradle`

```sh
sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
```

Gradle is regularly updated with security patches and new features. To have more
control over versions and updates, we'll create a symbolic link named latest,
which points to the Gradle installation directory:

```sh
sudo ln -s /opt/gradle/gradle-${VERSION} /opt/gradle/latest
```

Later, when upgrading Gradle, unpack the newer version and change the symlink to
point to it.

Setting up the Environment Variables.

```sh
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}
```

Check if Gradle is installed

```sh
gradle -v
```

Ref:

- [📄 How to Install Gradle on Ubuntu 20.04](https://linuxize.com/post/how-to-install-gradle-on-ubuntu-20-04/)


<br>

# Resources

- [📄 How to Install Gradle on Ubuntu 20.04](https://linuxize.com/post/how-to-install-gradle-on-ubuntu-20-04/)

