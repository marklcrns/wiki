---
title: Bash Scripting Extras
author: Mark Lucernas
date: 2020-08-13
summary: Miscellaneous bash scripting techniques
---


# Extras

## Prevent Bash Script From Being Executed

Method 1: Remove file executable property with `chmod`

```sh
chmod -x /path/to/script
```

Method 2: With actual script

```sh
if [ ${0##*/} == ${BASH_SOURCE[0]##*/} ]; then
  echo "WARNING"
  echo "This script is not meant to be executed directly!"
  echo "Use this script only by sourcing it."
  echo
  exit 1
fi
```

Ref:

- [📄 How to prevent direct bash script execution and allow only usage from other script?](https://stackoverflow.com/questions/22962591/how-to-prevent-direct-bash-script-execution-and-allow-only-usage-from-other-scri)


## Get Script Paths and Name

```sh
# Script absolute path
SCRIPT_PATH="$(realpath -s $0)"
# Script name
SCRIPT_NAME="$(basename ${0})"
# Script directory
SCRIPT_DIR="$( cd "$( dirname "$0" )" && pwd )"
SCRIPT_DIR="$(dirname ${SCRIPT_PATH})"
```

Better solution. Also resolves when script is symlink.

```sh
SCRIPT_PATH="${BASH_SOURCE[0]}"
while [ -h "$SCRIPT_PATH" ]; do
  SCRIPT_DIR="$(cd -P "$(dirname "$SCRIPT_PATH")" >/dev/null 2>&1 && pwd)"
  SCRIPT_PATH="$(readlink "$SCRIPT_PATH")"
  [[ $SCRIPT_PATH != /* ]] && SCRIPT_PATH="$SCRIPT_DIR/$SCRIPT_PATH"
done
SCRIPT_DIR="$(cd -P "$(dirname "$SCRIPT_PATH")" >/dev/null 2>&1 && pwd)"

readonly SCRIPT_PATH
readonly SCRIPT_DIR
```

Ref:

- [📄 How can I get the source directory of a Bash script from within the script itself?](https://stackoverflow.com/a/246128)


## Best Practices

- [📄 Defensive BASH Programming](https://kfirlavi.herokuapp.com/blog/2012/11/14/defensive-bash-programming/)
- [📄 10 Useful Tips for Writing Effective Bash Scripts in Linux](https://www.tecmint.com/useful-tips-for-writing-bash-scripts-in-linux/)
- [📄 Shell Style Guide](https://google.github.io/styleguide/shellguide.html)


<br>

# Resources

- [📄 How to prevent direct bash script execution and allow only usage from other script?](https://stackoverflow.com/questions/22962591/how-to-prevent-direct-bash-script-execution-and-allow-only-usage-from-other-scri)
- [📄 How can I get the source directory of a Bash script from within the script itself?](https://stackoverflow.com/a/246128)
- [📄 Defensive BASH Programming](https://kfirlavi.herokuapp.com/blog/2012/11/14/defensive-bash-programming/)
- [📄 10 Useful Tips for Writing Effective Bash Scripts in Linux](https://www.tecmint.com/useful-tips-for-writing-bash-scripts-in-linux/)
- [📄 Shell Style Guide](https://google.github.io/styleguide/shellguide.html)

