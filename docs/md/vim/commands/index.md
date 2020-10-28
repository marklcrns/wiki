---
title: Vim Command Line Commands
subtitle: Useful Vim command line commands
author: Mark Lucernas
date: 2020-03-24
---


# Vim Command Line Commands

## Search and Replace

### Search and Replace Multiple Files

- [📄 Multiple files search and replace](https://gabri.me/blog/multiple-files-search-and-replace-in-vim)

Using `:args`, search all files from current directory recursively with `I hate
Vim` characters and load all to Vim buffer.

```vim
:args `grep --recursive --files-with-matches 'I hate vim' .`
```

Shorter version

```vim
:args `grep -r -l 'I hate vim' .`
```

Using `:argdo`, replace all files loaded into buffer with `I love vim`

```vim
:argdo %s/I hate vim/I love vim/g | update
```

<br>

# Resources

- [📄 Search and Replace multiple files at once](https://gabri.me/blog/multiple-files-search-and-replace-in-vim)


