---
title: Bash Scripting Arguments
author: Mark Lucernas
date: 2020-08-13
summary: Bash scripting with arguments
---


# Arguments

## Argument Variables

- `$1` -- First argument
- `$2` -- Second argument
- `$#` -- Number of all command line arguments passed in
- `$@` -- Array of all command line arguments

## Using Shift Command

The `shift` command is one of the Bourne shell built-ins that comes with Bash.
This command takes one argument, a number. The positional parameters are shifted
to the left by this number, _N_. The positional parameters from `N+1` to `$#`
are renamed to variable names from `$1` to `$# - N+1`.

- [📄 The shift built-in](https://tldp.org/LDP/Bash-Beginners-Guide/html/sect_09_07.html)


## Check For Arguments

**Check exit if command line argument was passed in**

```sh
if [[ $# -lt 1 ]]; then
  echo "Must provide argument(s)"
  exit 1
fi
```

## Looping Over Arguments

**Looping over all command line arguments**

```sh
while test ${#} -g 0; do
  echo $1
  shift
done

# or

while (($#)); do
  echo $1
  shift
done"

# or

for i in "${@}"; do
  echo "$i"
done
```

**Looping over command line arguments except first one**

```sh
shift

while test ${#} -g 0; do
  echo $1
  shift
done

# or

for i in "${@:2}"; do
  echo "$i"
done
```

- [📄 Iterate through parameters skipping the first](https://stackoverflow.com/questions/3575793/iterate-through-parameters-skipping-the-first)
- [📄 The shift built-in](https://tldp.org/LDP/Bash-Beginners-Guide/html/sect_09_07.html)


<br>

# Resources

- [📄 Iterate through parameters skipping the first](https://stackoverflow.com/questions/3575793/iterate-through-parameters-skipping-the-first)
- [📄 The shift built-in](https://tldp.org/LDP/Bash-Beginners-Guide/html/sect_09_07.html)

