---
title: Bash Scripting String
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with strings
---


# String

## ANSI String Color Codes

**Most Commonly Used**

```bash
RED="\e[0;31m"
GREEN="\e[0;32m"
BLUE="\e[0;34m"
YELLOW="\e[0;33m"
WHITE="\e[0;37m"
BG_RED="\e[0;101m${expand_bg}"
BG_GREEN="\e[0;102m${expand_bg}"
BG_BLUE="\e[0;104m${expand_bg}"
BG_YELLOW="\e[0;103m${expand_bg}"
BG_EXPAND="\e[K" # Expand any background color horizontally
BO_NC="\e[1m" # No color bold output
UL_NC="\e[4m" # No color underlined output
NC="\e[0m" # Reset to default output color
```

Sample

  - `printf "${RED}ERROR: File does not exists${NC}"` -- Prints red colored
    string.
  - `echo -e "${RED}ERROR: File does not exists${NC}"` -- Echo variation.
    Requires `-e` flag to enable '\' interpretation in `echo` command.


### More ANSI Color Codes

**Regular Colors**

```bash
BLACK="\e[0;30m"
RED="\e[0;31m"
GREEN="\e[0;32m"
YELLOW="\e[0;33m"
BLUE="\e[0;34m"
PURPLE="\e[0;35m"
CYAN="\e[0;36m"
WHITE="\e[0;37m"
```

**Bold**

```bash
BO_BLACK="\e[1;30m"
BO_RED="\e[1;31m"
BO_GREEN="\e[1;32m"
BO_YELLOW="\e[1;33m"
BO_BLUE="\e[1;34m"
BO_PURPLE="\e[1;35m"
BO_CYAN="\e[1;36m"
BO_WHITE="\e[1;37m"
BO_NC="\e[1m" # Bold default color
```

**Underline**

```bash
UL_BLACK="\e[4;30m"
UL_RED="\e[4;31m"
UL_GREEN="\e[4;32m"
UL_YELLOW="\e[4;33m"
UL_BLUE="\e[4;34m"
UL_PURPLE="\e[4;35m"
UL_CYAN="\e[4;36m"
UL_WHITE="\e[4;37m"
UL_NC="\e[4m" # Underlined default color
```

**Background**

```bash
BG_BLACK="\e[40m"
BG_RED="\e[41m"
BG_GREEN="\e[42m"
BG_YELLOW="\e[43m"
BG_BLUE="\e[44m"
BG_PURPLE="\e[45m"
BG_CYAN="\e[46m"
BG_WHITE="\e[47m"
BG_EXPAND="\e[K" # Expand any background color horizontally
```

**High Intensty**

```bash
HI_BLACK="\e[0;90m"
HI_RED="\e[0;91m"
HI_GREEN="\e[0;92m"
HI_YELLOW="\e[0;93m"
HI_BLUE="\e[0;94m"
HI_PURPLE="\e[0;95m"
HI_CYAN="\e[0;96m"
HI_WHITE="\e[0;97m"
```

**Bold High Intensty**

```bash
BO_HI_BLACK="\e[1;90m"
BO_HI_RED="\e[1;91m"
BO_HI_GREEN="\e[1;92m"
BO_HI_YELLOW="\e[1;93m"
BO_HI_BLUE="\e[1;94m"
BO_HI_PURPLE="\e[1;95m"
BO_HI_CYAN="\e[1;96m"
BO_HI_WHITE="\e[1;97m"
```

**High Intensty backgrounds**

```bash
BG_HI_BLACK="\e[0;100m"
BG_HI_RED="\e[0;101m"
BG_HI_GREEN="\e[0;102m"
BG_HI_YELLOW="\e[0;103m"
BG_HI_BLUE="\e[0;104m"
BG_HI_PURPLE="\e[0;105m"
BG_HI_CYAN="\e[0;106m"
BG_HI_WHITE="\e[0;107m"
```

**Reset to Default**

```bash
NC="\e[0m"
```

> **NOTE:** Using ANSI color codes will change all the string onwards. So
resetting the string colors with `\e[0m` at the end of each message is a must.

Ref:

- [🌎 Colors in Bash Scripts](https://techstop.github.io/bash-script-colors/)


## Comparing Strings

**Comparing two strings if equal**

```bash
if [[ "$STRING1" == "$STRING2" ]]; then
    echo "Strings are equal."
else
    echo "Strings are not equal."
fi

if [ "$STRING1" = "$STRING2" ]; then
    echo "Strings are equal."
else
    echo "Strings are not equal."
fi
```

**Comparing if a string contains a substring**

```bash
VAR='GNU/Linux is an operating system'
if [[ $VAR == *"Linux"* ]]; then
  echo "It's there."
fi

# With regex operator `=~`
VAR='GNU/Linux is an operating system'
if [[ $VAR =~ .*Linux.* ]]; then
  echo "It's there."
fi
```

> **NOTE:** Using regex operator `=~` pattern should not be within quotes (') or
double quotes (")

**Check if string is empty**

```bash
VAR=''
if [[ -z $VAR ]]; then
  echo "String is empty."
fi

VAR='Linuxize'
if [[ ! -n $VAR ]]; then
  echo "String is empty."
fi
```

> **NOTE:** Type `man test` for more variable checks

**Check if string is empty, newline or spaces**

```bash
if [[ -n "#(echo "$VARIABLE" | tr -d '\n')" ]]; then
  # Do something if not empty or has new line
fi

#or

if [[ -n "${param// }" ]]; then
  # Do something if not empty or has spaces
fi
```

Ref:

- [🌎 How to Compare Strings in Bash](https://linuxize.com/post/how-to-compare-strings-in-bash/)
- [🌎 Shell script Bash, Check if string starts and ends with single quotes](https://stackoverflow.com/a/40322497/11850077)
- [🌎 How to check a variable for empty and a newline](https://www.unix.com/shell-programming-and-scripting/129086-how-check-variable-empty-newline.html)
- [🌎 How can I test if a variable is empty or contains only spaces?](https://unix.stackexchange.com/a/146945)
- [🌎 Shell Parameter Expansion](https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#Shell-Parameter-Expansion)


## String Manipulation

**Strip single trailing backslash**

```bash
VALUE=/looks/like/a/path/

echo ${VALUE%/}
```

**Strip all trailing backslashes '/'**

```bash
VALUE=/looks/like/a/path///
TRIMMED=$(echo $VALUE | sed 's,/*$,,')

echo $VALUE $TRIMMED
```

Ref:

- [🌎 What is the simplest way to remove a trailing slash from each parameter?](https://stackoverflow.com/questions/9018723/what-is-the-simplest-way-to-remove-a-trailing-slash-from-each-parameter)


<br>

# Resources

- [🌎 Colors in Bash Scripts](https://techstop.github.io/bash-script-colors/)
- [🌎 How to Compare Strings in Bash](https://linuxize.com/post/how-to-compare-strings-in-bash/)
- [🌎 Shell script Bash, Check if string starts and ends with single quotes](https://stackoverflow.com/a/40322497/11850077)
- [🌎 How to check a variable for empty and a newline](https://www.unix.com/shell-programming-and-scripting/129086-how-check-variable-empty-newline.html)
- [🌎 How can I test if a variable is empty or contains only spaces?](https://unix.stackexchange.com/a/146945)
- [🌎 Shell Parameter Expansion](https://www.gnu.org/savannah-checkouts/gnu/bash/manual/bash.html#Shell-Parameter-Expansion)
- [🌎 What is the simplest way to remove a trailing slash from each parameter?](https://stackoverflow.com/questions/9018723/what-is-the-simplest-way-to-remove-a-trailing-slash-from-each-parameter)

