---
title: Eclipse Installation
subtitle: Ubuntu
author: Mark Lucernas
date: Sep 24, 2020
---


# Eclipse

Download latest Eclipse for **Java** tar.gz file [🌎 Eclipse Downloads](https://www.eclipse.org/downloads/packages/)

Extract the package into the `/opt` directory:

```sh
sudo tar xfv eclipse-java-2020-06-R-linux-gtk-x86_64.tar.gz -C /opt
```

Create symlink of the executable to `/usr/local/bin`

```sh
sudo ln -s /opt/eclipse/eclipse /usr/local/bin/
```

Create Eclipse Launcher Icon

```sh
sudo vim /usr/share/applications/eclipse.desktop
```

Then paste

```sh
[Desktop Entry]
Encoding=UTF-8
Name=Eclipse IDE
Comment=Eclipse IDE
Exec=/usr/local/bin/eclipse
Icon=/opt/eclipse/icon.xpm
Terminal=false
Type=Application
StartupNotify=false
```

Ref:

- [🌎 Eclipse IDE for C/C++ Developers installation on Ubuntu 20.04 ](https://linuxconfig.org/eclipse-ide-for-c-c-developers-installation-on-ubuntu-20-04)
- [🌎 How To Install Eclipse IDE on Ubuntu 20.04](https://www.itzgeek.com/post/how-to-install-eclipse-ide-on-ubuntu-20-04/)


## Issues

```
Access restriction: The type 'Application' is not API (restriction on required
library jfxrt.jar)
```

Solution:

- [🌎 Access restriction: The type 'Application' is not API (restriction on required library rt.jar)](https://stackoverflow.com/a/46513651/11850077)


## e(fx)clipse JavaFX


To install, go to `Help -> Eclipse Marketplace` then search `fx` and install the
`e(fx)clipse`

NOTE: Make sure before creating new JavaFX project, proper JRE execution
environment has properly been setup.

  - Go to `Window -> Preference -> Java -> Installed JREs` then add installed
    jre in your machine
  - Then, Under `Installed JREs` go to `Execution Environments` and pick the
    `[perfect match]` for the selected Installed JRE

Ref:

- [🌎 JavaFX Tutorial for Beginners - Setting up Eclipse Tooling and Runtime for JavaFX](https://www.youtube.com/watch?v=Y9ykVgSZ7kA)


## Maven JavaFX


Create a new maven project, making sure `Create a simple project (skip archetype
selection)` option is **unchecked**, then `Add Archetype` and enter the
following:

```
Archetype Group Id: org.openjfx
Archetype Artifact Id: javafx.archetype.fxml or javafx.archetype.simple
Archetype Version: 0.0.1
```

Then on the `Filter` textbox, type `org.openjfx` and pick the desired archetype
from the search result and hit `Next`

Under `Properties available from archetype:` change `javafx-version` value to
match your desired jdk version.

Ref:

- [🌎 Getting Started with JavaFX](https://openjfx.io/openjfx-docs)

<br>

# Resources

- [🌎 Eclipse Downloads](https://www.eclipse.org/downloads/packages/)
- [🌎 Eclipse IDE for C/C++ Developers installation on Ubuntu 20.04 ](https://linuxconfig.org/eclipse-ide-for-c-c-developers-installation-on-ubuntu-20-04)
- [🌎 How To Install Eclipse IDE on Ubuntu 20.04](https://www.itzgeek.com/post/how-to-install-eclipse-ide-on-ubuntu-20-04/)
- [🌎 Access restriction: The type 'Application' is not API (restriction on required library rt.jar)](https://stackoverflow.com/a/46513651/11850077)
- [🌎 JavaFX Tutorial for Beginners - Setting up Eclipse Tooling and Runtime for JavaFX](https://www.youtube.com/watch?v=Y9ykVgSZ7kA)
- [🌎 Getting Started with JavaFX](https://openjfx.io/openjfx-docs)

