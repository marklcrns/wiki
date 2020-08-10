---
title: Bash Scripting If Else Statements
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with if else statements
---


# If Else Statements

## Basics

```bash
if <condition>; then
  # Commands if condition is true
fi

if <condition>; then
  # Commands if condition is true
else
  # Commands if condition is false
fi

if [[ <condition> ]]; then
  # Commands if condition is true
else
  # Commands if condition is false
fi

[[ <condition> ]] && # Command is true

[[ <condition> ]] && # Command if true || # Command if false
```

> **NOTE:** type `man test` to see some possible checks that can be used for
if-else conditions.

## Checks

**Check if command exists or installed**

  - `command -v <command-to-check>` -- Method 1
  - `hash <command-to-check>` -- Method 2
  - `type <command-to-check>` -- Method 3
  - `which <command-to-check>` -- Not recommended


Samples

```bash
command -v tmux >/dev/null 2>&1

# or

if ! command -v tmux &> /dev/null
then
  echo "Tmux could not be found"
  exit
fi
```


<br>

# Resources

