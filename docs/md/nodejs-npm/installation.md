---
title: Node.js & npm Installation
subtitle: Node.js installation w/o Node package manager
author: Mark Lucernas
date: Dec 30, 2020
---


# Installation

npm strongly recommend using a Node version manager like `nvm` to install
Node.js and npm

```
We strongly recommend using a Node version manager like nvm to install Node.js
and npm. We do not recommend using a Node installer, since the Node installation
process installs npm in a directory with local permissions and can cause
permissions errors when you run npm packages globally.
```

> **NOTE:** `npm` comes with Node installation.

## Linux

### Ubuntu or Debian Based System

#### Using NVM (Recommended)

```bash
# NVM/NodeJS
if curl -o- https://raw.githubusercontent.com/creationix/nvm/master/install.sh | bash; then
  # source bashrc or zshrc
  if [[ -n ${BASH_VERSION} ]]; then
    source ~/.bashrc
  elif [[ -n ${ZSH_VERSION} ]]; then
    source ~/.zshrc
  fi

  # Source nvm script
  source $NVM_DIR/nvm.sh

  # Install latest node version and set as default
  nvm install node
  nvm use node
  nvm alias default node

  # Alternative: Install LTS node version. Does not set to default as --lts does
  # not work as a command
  nvm install --lts
  nvm use --lts
fi
```

##### Uninstall

```bash
nvm uninstall <version>
nvm uninstall node  # Uninstall latest
nvm uninstall --lts # Uninstall LTS
```

#### Without NVM

```bash
# Automatically installes npm
sudo apt install nodejs

# Update npm to latest version
npm install -g npm@latest
```

##### Issues

Permission errors npm has warned about when installing Node without package
manager.

- [📄 Workaround for 'Missing write access to /usr/local/lib error'](https://docs.npmjs.com/resolving-eacces-permissions-errors-when-installing-packages-globally)

```bash
mkdir ${HOME}/.npm-global
npm config set prefix "${HOME}/.npm-global"
```

> **NOTE:** `globalconfig` and/or `prefix` is not compatible with `nvm`

##### Uninstall

```bash
sudo apt remove nodejs npm
```

Ref:

- [📄 Uninstall Node.js and install Node Version Manager (NVM)](https://ajaykarwal.com/uninstall-node-and-install-nvm)
- [📄 How to Install Node.js and npm on Ubuntu 18.04](https://linuxize.com/post/how-to-install-node-js-on-ubuntu-18.04/)

<br>

# Resources

- [📄 Workaround for 'Missing write access to /usr/local/lib error'](https://docs.npmjs.com/resolving-eacces-permissions-errors-when-installing-packages-globally)
- [📄 Uninstall Node.js and install Node Version Manager (NVM)](https://ajaykarwal.com/uninstall-node-and-install-nvm)
- [📄 How to Install Node.js and npm on Ubuntu 18.04](https://linuxize.com/post/how-to-install-node-js-on-ubuntu-18.04/)
