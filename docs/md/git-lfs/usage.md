---
title: Git-lfs Usage
author: Mark Lucernas
date: 2020-08-08
summary: Git-lfs usage
---


# Git-lfs Usage

## Init

**Initialize git lfs (provided its already installed)**

```bash
# Global initialization
git lfs install

# Only for local repository
git lfs install --local
```

## Track

**Track files with git lfs**

  - `git lfs track "*.psd"` -- This will track all `.psd` files


> **NOTE:** Make sure `.gitattributes` is tracked

  - `git add .gitattributes`


Then just regularly commit and push to GitHub normally

```bash
git add file.psd
git commit -m "Add design file"
git push origin master
```

Ref:

  - [Git-lfs official docs](https://git-lfs.github.com/)


<br>

# Resources

  - [Git-lfs official docs](https://git-lfs.github.com/)

