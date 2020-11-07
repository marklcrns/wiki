---
title: Git Configurations
subtitle: How to configure git
author: Mark Lucernas
date: Aug 08, 2020
---


# `.gitignore`

## Ignoring Committed Files

From the root directory

```bash
git rm -r --cached . &&  git add .
```

## Global

Creating global gitignore

```bash
git config --global core.excludesfile ~/.gitignore_global
```

Ref:

- [📄 Ignoring files](https://docs.github.com/en/github/using-git/ignoring-files)

<br>

# Resources

- [📄 Ignoring files](https://docs.github.com/en/github/using-git/ignoring-files)

