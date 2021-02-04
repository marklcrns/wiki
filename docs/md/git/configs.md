---
title: Git Configurations
subtitle: How to configure git
author: Mark Lucernas
date: Aug 08, 2020
---

# Git Configurations

## Setting Global Git Username and Password

```sh
git config --global user.name "Your Name"
git config --global user.email "youremail@yourdomain.com"
```

Ref:

- [📄 How to Configure Git Username and Email Address](https://linuxize.com/post/how-to-configure-git-username-and-email/)

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

### Examples

```.gitignore
# Lines starting with `#` are comments.

# Ignore files called 'file.ext'
file.ext

# Comments can't be on the same line as rules!
# The following line ignores files called 'file.ext # not a comment'
file.ext # not a comment 

# Ignoring files with full path.
# This matches files in the root directory and subdirectories too.
# i.e. otherfile.ext will be ignored anywhere on the tree.
dir/otherdir/file.ext
otherfile.ext

# Ignoring directories
# Both the directory itself and its contents will be ignored.
bin/
gen/

# Glob pattern can also be used here to ignore paths with certain characters.
# For example, the below rule will match both build/ and Build/
[bB]uild/

# Without the trailing slash, the rule will match a file and/or
# a directory, so the following would ignore both a file named `gen`
# and a directory named `gen`, as well as any contents of that directory
bin
gen

# Ignoring files by extension
# All files with these extensions will be ignored in
# this directory and all its sub-directories.
*.apk
*.class

# It's possible to combine both forms to ignore files with certain
# extensions in certain directories. The following rules would be
# redundant with generic rules defined above.
java/*.apk
gen/*.class

# To ignore files only at the top level directory, but not in its
# subdirectories, prefix the rule with a `/`
/*.apk
/*.class

# To ignore any directories named DirectoryA 
# in any depth use ** before DirectoryA
# Do not forget the last /, 
# Otherwise it will ignore all files named DirectoryA, rather than directories
**/DirectoryA/
# This would ignore 
# DirectoryA/
# DirectoryB/DirectoryA/ 
# DirectoryC/DirectoryB/DirectoryA/
# It would not ignore a file named DirectoryA, at any level

# To ignore any directory named DirectoryB within a 
# directory named DirectoryA with any number of 
# directories in between, use ** between the directories
DirectoryA/**/DirectoryB/
# This would ignore 
# DirectoryA/DirectoryB/ 
# DirectoryA/DirectoryQ/DirectoryB/ 
# DirectoryA/DirectoryQ/DirectoryW/DirectoryB/

# To ignore a set of files, wildcards can be used, as can be seen above.
# A sole '*' will ignore everything in your folder, including your .gitignore file.
# To exclude specific files when using wildcards, negate them.
# So they are excluded from the ignore list:
!.gitignore 

# Use the backslash as escape character to ignore files with a hash (#)
# (supported since 1.6.2.1)
\#*#
```

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
- [📄 Ignoring files nad directories with a.gitignore file](https://riptutorial.com/git/example/885/ignoring-files-and-directories-with-a--gitignore-file)

<br>

# Resources

- [📄 How to Configure Git Username and Email Address](https://linuxize.com/post/how-to-configure-git-username-and-email/)
- [📄 How to fix Git always asking for user credentials](https://www.freecodecamp.org/news/how-to-fix-git-always-asking-for-user-credentials/)
- [📄 Connecting to Github with SSH](https://docs.github.com/en/free-pro-team@latest/github/authenticating-to-github/connecting-to-github-with-ssh)
- [📄 Ignoring files](https://docs.github.com/en/github/using-git/ignoring-files)
- [📄 Ignoring files nad directories with a.gitignore file](https://riptutorial.com/git/example/885/ignoring-files-and-directories-with-a--gitignore-file)

