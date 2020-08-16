---
title: Docker
author: Mark Lucernas
date: 2020-08-15
summary: Docker wiki
---


# Docker

## Installation

### Linux

#### Ubuntu

Uninstall old versions

```bash
sudo apt-get remove docker docker-engine docker.io containerd runc
```

##### Install Using the Repository

Set up the repository

```bash
sudo apt-get update

sudo apt-get install \
  apt-transport-https \
  ca-certificates \
  curl \
  gnupg-agent \
  software-properties-common
```

Add Docker's official GPG key

```bash
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
```

Verify that you now have the key with the fingerprint `9DC8 5822 9FC7 DD38 854A
E2D8 8D81 803C 0EBF CD88`

```bash
sudo apt-key fingerprint 0EBFCD88
```

Add repository

```bash
sudo add-apt-repository \
  "deb [arch=amd64] https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) \
  stable"
```

Ref:

- [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/)


### Windows

#### WSL/WSL2

- [+WSL 2 Docker](wsl/docker)


## Usage

- [Docker For Beginners: From Docker Desktop to Deployment](https://www.youtube.com/watch?v=i7ABlHngi1Q)


<br>

# Resources

- [Install Docker Engine on Ubuntu](https://docs.docker.com/engine/install/ubuntu/)
- [Docker For Beginners: From Docker Desktop to Deployment](https://www.youtube.com/watch?v=i7ABlHngi1Q)

