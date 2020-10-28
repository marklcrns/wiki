---
title: Git-lfs Installation
author: Mark Lucernas
date: 2020-08-08
summary: Git-lfs installation
---


# Git-lfs Installation

## Linux

### Debian and Ubuntu

For Ubuntu 18.04, Debian 10, and newer versions.

```sh
curl -s https://packagecloud.io/install/repositories/github/git-lfs/script.deb.sh | sudo bash
sudo apt-get install git-lfs

# For global installation
git lfs install

# For existing repository installation only
git lfs install --local
```

> **NOTE:** An additional `--skip-smudge` can be added to skip automatic
downloading of objects on `clone` or `pull`. Conversely, it would require a
manual `git lfs pull` every time a new commit is checked out on your repository.
This is more useful for cases where you don't always want to download/checkout
every large file.

### Uninstall

```sh
# For global uninstall
git lfs uninstall

# For local uninstall
git lfs uninstall --local
```

Ref:

- [📄 Git-lfs Wiki Installation](https://github.com/git-lfs/git-lfs/wiki/Installation)


<br>

# Resources

- [📄 Git-lfs Wiki Installation](https://github.com/git-lfs/git-lfs/wiki/Installation)

