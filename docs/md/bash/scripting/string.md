---
title: Bash Scripting String
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with strings
---


# String

## ANSI String Colors

```bash
RED="\e[0;91m"
BLUE="\e[0;94m"
GREEN="\e[0;92m"
YELLOW='\033[1;33m'
WHITE="\e[0;97m"
EXPAND_BG="\e[K"
RED_BG="\e[0;101m${expand_bg}"
BLUE_BG="\e[0;104m${expand_bg}"
GREEN_BG="\e[0;102m${expand_bg}"
YELLOW_BG="\e[0;103m${expand_bg}"
BOLD="\e[1m"
ULINE="\e[4m"
NC="\e[0m" # No/reset color
```

Sample

  - `printf "${RED}ERROR: File does not exists${NC}"` -- Prints red colored
    string.
  - `echo -e "${RED}ERROR: File does not exists${NC}"` -- Echo variation.
    Requires `-e` flag to enable '\' interpretation in `echo` command.


> **NOTE:** Using ANSI color codes will change all the string onwards. So
resetting the string colors with `\e[0m` at the end of each message is a must.

Ref:

  - [Colors in Bash Scripts](https://techstop.github.io/bash-script-colors/)


<br>

# Resources

  - [Colors in Bash Scripts](https://techstop.github.io/bash-script-colors/)

