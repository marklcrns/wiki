---
title: Bash Scripting Flags
author: Mark Lucernas
date: 2020-08-13
summary: Bash scripting with flags
---


# Flags

## Setting Flag Options

**Setting flags with `case` and `shift`**

```bash
while test $# -gt 0; do
  case "$1" in
    -h|--help)
      echo "$package - attempt to capture frames"
      echo " "
      echo "$package [options] application [arguments]"
      echo " "
      echo "options:"
      echo "-h, --help                show brief help"
      echo "-a, --action=ACTION       specify an action to use"
      echo "-o, --output-dir=DIR      specify a directory to store output in"
      exit 0
      ;;
    -a)
      shift
      if test $# -gt 0; then
        export PROCESS=$1
      else
        echo "no process specified"
        exit 1
      fi
      shift
      ;;
    --action*)
      export PROCESS=`echo $1 | sed -e 's/^[^=]*=//g'`
      shift
      ;;
    -o)
      shift
      if test $# -gt 0; then
        export OUTPUT=$1
      else
        echo "no output dir specified"
        exit 1
      fi
      shift
      ;;
    --output-dir*)
      export OUTPUT=`echo $1 | sed -e 's/^[^=]*=//g'`
      shift
      ;;
    *)
      break
      ;;
  esac
done
```

**Setting flags with `getopts`**

```bash
a_flag=''
b_flag=''
files=''
verbose='false'

print_usage() {
  printf "Usage: ..."
}

while getopts 'abf:v' flag; do
  case "${flag}" in
    a) a_flag='true' ;;
    b) b_flag='true' ;;
    f) files="${OPTARG}" ;;
    v) verbose='true' ;;
    *) print_usage
       exit 1 ;;
  esac
done
```

My personal use case...

```bash
while getopts "dl:svVyh" opt; do
  case "$opt" in
    d) [[ -n "$DEBUG"           ]] && unset DEBUG                      || DEBUG=true;;
    l) [[ -n "$IS_REPO_LIST"    ]] && unset IS_REPO_LIST               || IS_REPO_LIST=true; REPO_LIST=${OPTARG};;
    s) [[ -n "$IS_SILENT"       ]] && unset IS_SILENT                  || IS_SILENT=true;;
    v) [[ -n "$IS_VERBOSE"      ]] && unset IS_VERBOSE                 || IS_VERBOSE=true;;
    V) [[ -n "$IS_VERY_VERBOSE" ]] && unset IS_VERBOSE IS_VERY_VERBOSE || IS_VERBOSE=true; IS_VERY_VERBOSE=true;;
    y) [[ -n "$SKIP_CONFIRM"    ]] && unset SKIP_CONFIRM               || SKIP_CONFIRM=true;;
    h) usage && exit 0;;
    *) usage && echo -e "${SCRIPTPATH}:\n${RED}ERROR: Invalid flag.${NC}"
      exit 1
  esac
done 2>/dev/null
shift "$((OPTIND-1))"
```

> **NOTE:** `OPTARG` takes in optional argument if `:` is presented after the
flag option. e.g `getopts "l:"` will expect to take an optional flag argument
like so `command -l "Optional argument"`. Also, `getopts` does not support
verbose flab options such as `--help`.

> WARNING: `OPTARG` at the end of a command may be considered a part of command
line arguments even after `shift "$((OPTIND-1))"`.

- [🌎 How to get arguments with flags in Bash](https://stackoverflow.com/questions/7069682/how-to-get-arguments-with-flags-in-bash/21128172)
- [🌎 Explain the shell command: shift $(($optind - 1))](https://unix.stackexchange.com/a/214151)


<br>

# Resources

- [🌎 How to get arguments with flags in Bash](https://stackoverflow.com/questions/7069682/how-to-get-arguments-with-flags-in-bash/21128172)
- [🌎 Explain the shell command: shift $(($optind - 1))](https://unix.stackexchange.com/a/214151)

