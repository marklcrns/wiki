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

- [📄 How to prevent direct bash script execution and allow only usage from other script?](https://stackoverflow.com/questions/22962591/how-to-prevent-direct-bash-script-execution-and-allow-only-usage-from-other-scri)


<br>

# Resources

- [📄 How to prevent direct bash script execution and allow only usage from other script?](https://stackoverflow.com/questions/22962591/how-to-prevent-direct-bash-script-execution-and-allow-only-usage-from-other-scri)

