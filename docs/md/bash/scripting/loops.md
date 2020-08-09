---
title: Bash Scripting Loops
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with loops
---


# Loops

## Looping Over Filtered File Path Returned by Find

Method 1:

```bash
find . -name '*.txt' - print0 |
  while IFS= read -r -d '' file; do
    # do something with "$file"
  done
```

> **NOTE:** _Each command of a pipeline is executed in a separate subshell_. So
variables outside of the loop that are modified inside of the subshell will not
change the value of the variables outside.

Method 2: (Recommended)

```bash
while IFS= read -r -d '' file; do
  # do something with "$file"
done < <(find . -name '*.txt' - print0)
```

> This method allows for variable modification outside of the loop. See _process
substitution_.

Ref:

  - [How to loop through file names returned by find?: Method 1 reference](https://stackoverflow.com/a/9612232/11850077)
  - [How to loop through file names returned by find?: Method 2 reference](https://stackoverflow.com/a/37210472/11850077)
  - [Variables disappearing after loop in a pipeline terminates](http://mywiki.wooledge.org/BashFAQ/024)

<br>

# Resources

  - [How to loop through file names returned by find?: Method 1 reference](https://stackoverflow.com/a/9612232/11850077)
  - [How to loop through file names returned by find?: Method 2 reference](https://stackoverflow.com/a/37210472/11850077)

