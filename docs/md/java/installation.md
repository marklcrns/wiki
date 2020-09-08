---
title: Java Installation
subtitle: Java JDK and JRE Installation
author: Mark Lucernas
date: Aug 08, 2020
---


# Installation

## OpenJDK

### Linux

#### Ubuntu

Update apt repository

```sh
sudo apt update
```

Install default Java JDK and JRE

```sh
sudo apt install default-jdk
sudo apt install default-jre
```

or install specific JDK or JRE version

```sh
sudo apt install openjdk-11-jdk
sudo apt install openjdk-11-jre
```

Setting default Java version

```sh
sudo update-alternatives --config java
```

Ref:

- [🌎 How to install Java (JDK and JRE) on Ubuntu 20.04 LTS](https://vitux.com/how-to-install-java-on-ubuntu-20-04/)


## Oracle

Oracle Java SE downloads links

- [🌎 Eclipse Java SE Recommended Downloads](https://download.eclipse.org/oomph/jre/?vm=1_1_8_0_64_0&pn=Eclipse%20Installer&pu=http://wiki.eclipse.org/Eclipse_Installer&pi=http://download.eclipse.org/oomph/jre/128x128.png)
- [🌎 Oracle Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)

### Windows

**Oracle JDK 8**

Downloads both Java SE 8 JDK and JRE for Windows (make sure to download `.exe`)

> **NOTE:** Java SE JDK 8 automatically installs JRE along with it.

- [🌎 Java SE JDK 8 Downloads](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [🌎 Java SE JRE 8 Downloads](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)

Then watch this video for installation. **Skip the path variable configuration for
a better way of adding default Java JDK version below**.

- [🎬 Java JDK 8 Windows Installation](https://www.youtube.com/watch?v=ClcHrcNXP9g)

Finally, set the JAVA_HOME and JRE_HOME system environment variables

- [🌎 Setting the JAVA_HOME Variable in Windows](https://confluence.atlassian.com/conf59/setting-the-java_home-variable-in-windows-792499849.html)

Better way of adding default JDK version to Windows system variables

- [🌎 How to switch Java versions in Windows](https://www.happycoders.eu/java/how-to-switch-multiple-java-versions-windows/)

### Linux

#### Ubuntu

**Oracle JDK 8**

First, download latest Java SE 8 **Linux Debian Package** or Linux x64
Compressed Archive

- [🌎 Java SE JDK 8 Downloads](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)

Then run the following

NOTE:

- The `108` at the end of `update-aternatives --install` is the priority. You
  can change the value however you like

```sh
sudo mkdir -p /usr/lib/jvm/
sudo tar xfv jdk-8u261-linux-x64.tar.gz -C /usr/lib/jvm/
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk1.8.0_261/bin/java 108
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk1.8.0_261/bin/javac 108
```

> To remove the path to change priority, use `--remove` flag then reinstall
path

Verify Update Alternatives

```sh
sudo update-alternatives --display java
```

To change alternative mode

```sh
sudo update-alternatives --config java
```

Setup `JAVA_HOME` and `JRE_HOME`

```sh
sudo  nano /etc/environment

# Then paste the following

JAVA_HOME=/usr/lib/jvm/jdk1.8.0_251
JRE_HOME=/usr/lib/jvm/jdk1.8.0_251/jre

# Source environment
source /etc/environment

# Update and delete tar.gz
sudo apt-get update
rm jdk-8u251-linux-x64.tar.gz
```

Ref:

- [🌎 How to Install Oracle JAVA 8 on Ubuntu 20.04 LTS](https://www.fosstechnix.com/install-oracle-java-8-on-ubuntu-20-04/)

**Oracle JDK 11 and Higher**

First, download the latest Java SE **Linux Debian Package** Linux x64 Compressed
Archive

- [🌎 Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)

Then run the following command.

NOTE:

- Make sure too set the correct downloaded jdk version and replace `.X.X's`
  from the command below
- The `111` at the end of `update-aternatives --install` is the
  priority. You can change the value however you like

> to remove the path to change priority, use `--remove` flag then reinstall
path.

```sh
sudo dpkg -i jdk-11.X.X_linux-x64_bin.deb
sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-11.X.X/bin/java 111
sudo update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/jdk-11.X.X/bin/javac 111
```

Verify Update Alternatives

```sh
sudo update-alternatives --display java
```

To change alternative mode

```sh
sudo update-alternatives --config java
```

Setup `JAVA_HOME` and `JRE_HOME`

```sh
sudo  nano /etc/environment

# Then paste the following

JAVA_HOME=/usr/lib/jvm/jdk-11.0.7
JRE_HOME=/usr/lib/jvm/jdk-11.0.7/jre

# Source environment
source /etc/environment
```

Ref:

- [🌎 Oracle Java installation on Ubuntu 20.04 Focal Fossa Linux ](https://linuxconfig.org/oracle-java-installation-on-ubuntu-20-04-focal-fossa-linux)


<br>

# Resources

- [🌎 How to install Java (JDK and JRE) on Ubuntu 20.04 LTS](https://vitux.com/how-to-install-java-on-ubuntu-20-04/)
- [🌎 Eclipse Java SE Recommended Downloads](https://download.eclipse.org/oomph/jre/?vm=1_1_8_0_64_0&pn=Eclipse%20Installer&pu=http://wiki.eclipse.org/Eclipse_Installer&pi=http://download.eclipse.org/oomph/jre/128x128.png)
- [🌎 Oracle Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)
- [🌎 Java SE JRE 8 Downloads](https://www.oracle.com/java/technologies/javase-jre8-downloads.html)
- [🎬 Java JDK 8 Windows Installation](https://www.youtube.com/watch?v=ClcHrcNXP9g)
- [🌎 Setting the JAVA_HOME Variable in Windows](https://confluence.atlassian.com/conf59/setting-the-java_home-variable-in-windows-792499849.html)
- [🌎 Java SE JDK 8 Downloads](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [🌎 How to Install Oracle JAVA 8 on Ubuntu 20.04 LTS](https://www.fosstechnix.com/install-oracle-java-8-on-ubuntu-20-04/)
- [🌎 Java SE Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)
- [🌎 Oracle Java installation on Ubuntu 20.04 Focal Fossa Linux ](https://linuxconfig.org/oracle-java-installation-on-ubuntu-20-04-focal-fossa-linux)

