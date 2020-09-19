---
title: Find
subtitle: Usage
author: Mark Lucernas
date: Sep 18, 2020
---


# Usage

Basic usage

```sh
find <directory> -name "pattern"
```

Match files with pattern

```sh
# Search for all .png files starting from current directory recursively
find . -name "*.png"
```

Match all files

```sh
find . -type f
```

Match all directories

```sh
find . -type d
```

Match all files excluding specific directory

```sh
# Excludes .git directory
find . -type f -not -path "*.git*" -name "*.png"
# or
find . \( -type d -name ".git" -prune \) -o -type f -name "*.png"
```

Do something to all matched files or directory

```sh
# chmod 644 all matched .png files recursively
find . -name "*.png" -print0 | xargs -0 chmod 644
# or
find . -name "*.png" -exec chmod 644 {} +
```

Do something to all matched files only

```sh
# chmod 644 all matched .png files recursively
find . -name "*.png" -type f -print0 | xargs -0 chmod 644
# or
find . -name "*.png" -type f -exec chmod 644 {} +
```

Do something to all matched files excluding directory

```sh
# chmod 644 all files recursively. Excludes .git directory
find . -type f -not -path "*.git*" -print0 | xargs -0 chmod 644
# or
find . \( -type d -name ".git" -prune \) -o -type f -print0 | xargs -0 chmod 644
```

Ref:

- [🌎 How to exclude a directory in find . command](https://stackoverflow.com/a/4210072/11850077)
- [🌎 If prune doesn't work](https://stackoverflow.com/a/15736463/11850077)
- [🌎 How to pipe list of files returned by find command to cat to view all the files](https://stackoverflow.com/a/864330/11850077)

<br>

# Resources

- [🌎 How to exclude a directory in find . command](https://stackoverflow.com/a/4210072/11850077)
- [🌎 If prune doesn't work](https://stackoverflow.com/a/15736463/11850077)
- [🌎 How to pipe list of files returned by find command to cat to view all the files](https://stackoverflow.com/a/864330/11850077)

