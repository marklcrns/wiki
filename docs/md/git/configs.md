---
title: Git Configurations
subtitle: How to configure git
author: Mark Lucernas
date: Aug 08, 2020
---

# Git Configurations

## Credential Helper

Store Git username and password (will never ask for credentials again)

- `git config --global credential.helper store` -- Stores credentials in
  `~/.git-credentials` (not secure)

Cache credentials for a session

- `git config --global credential.helper cache`

Cache credentials with timeout

- `git config --global credential.helper 'cache --timeout=28800` -- timeout
  takes in integer as seconds, 28800 = 8hrs

Alternative, more secure setup. Update the URL of origin remote using SSH
instead of HTTPS

- `git remote set-url origin git@github.com:username/repo.git`

More on [Connecting to Github with
SSH](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh)

Ref:

- [📄 How to fix Git always asking for user credentials](https://www.freecodecamp.org/news/how-to-fix-git-always-asking-for-user-credentials/)
- [📄 Connecting to Github with SSH](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh)

## `.gitignore`

### Ignoring Committed Files

From the root directory

```sh
git rm -r --cached . &&  git add .
```

### Global

Creating global gitignore

```sh
git config --global core.excludesfile ~/.gitignore_global
```

Ref:

- [📄 Ignoring files](https://docs.github.com/en/github/using-git/ignoring-files)

<br>

# Resources

- [📄 How to fix Git always asking for user credentials](https://www.freecodecamp.org/news/how-to-fix-git-always-asking-for-user-credentials/)
- [📄 Connecting to Github with SSH](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh)
- [📄 Ignoring files](https://docs.github.com/en/github/using-git/ignoring-files)

