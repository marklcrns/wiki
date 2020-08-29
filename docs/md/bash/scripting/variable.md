---
title: Bash Scripting Variable
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with variables
---


# Variable

## Increment or Decrement an Integer Variable

**With Arithmetic Expansion**

```bash
var=$((var+1))
((var=var+1))
((var+=1))
((var++))
```

**With `let`**

```bash
let "var=var+1"
let "var+=1"
let "var++"
```

**Incrementing variable with another variable**

```bash
total=$(( ${var1_count} + ${var2_count} ))
# or
total=$(expr ${var1_count} + ${var2_count})
```

**Finding best performing variable increment operation**

Test Code

```bash
# To focus exclusively on the performance of each type of increment
# statement, we should exclude bash performing while loops from the
# performance measure. So, let's time individual scripts that
# increment $i in their own unique way.

# Declare i as an integer for tests 12 and 13.
echo > t12 'declare -i i; i=i+1'
echo > t13 'declare -i i; i+=1'
# Set i for test 14.
echo > t14 'i=0; i=$(expr $i + 1)'

x=100000
while ((x--)); do
    echo >> t0 'i=$((i+1))'
    echo >> t1 'i=$((i++))'
    echo >> t2 '((i=i+1))'
    echo >> t3 '((i+=1))'
    echo >> t4 '((i++))'
    echo >> t5 '((++i))'
    echo >> t6 'let "i=i+1"'
    echo >> t7 'let "i+=1"'
    echo >> t8 'let "i++"'
    echo >> t9 'let i=i+1'
    echo >> t10 'let i+=1'
    echo >> t11 'let i++'
    echo >> t12 'i=i+1'
    echo >> t13 'i+=1'
    echo >> t14 'i=$(expr $i + 1)'
done

for script in t0 t1 t2 t3 t4 t5 t6 t7 t8 t9 t10 t11 t12 t13 t14; do
    line1="$(head -1 "$script")"
    printf "%-24s" "$line1"
    { time bash "$script"; } |& grep user
    # Since stderr is being piped to grep above, this will confirm
    # there are no errors from running the command:
    eval "$line1"
    rm "$script"
done
```

Output
```
i=$((i+1))              user    0m0.992s
i=$((i++))              user    0m0.964s
((i=i+1))               user    0m0.760s
((i+=1))                user    0m0.700s
((i++))                 user    0m0.644s
((++i))                 user    0m0.556s
let "i=i+1"             user    0m1.116s
let "i+=1"              user    0m1.100s
let "i++"               user    0m1.008s
let i=i+1               user    0m0.952s
let i+=1                user    0m1.040s
let i++                 user    0m0.820s
declare -i i; i=i+1     user    0m0.528s
declare -i i; i+=1      user    0m0.492s
i=0; i=$(expr $i + 1)   user    0m5.464s
```

> **NOTE:** Decrementing integer variable need just switch `+` sign to `-`

Ref:

- [🌎 How to Increment and Decrement Variable in Bash (Counter)](https://linuxize.com/post/bash-increment-decrement-variable/)
- [🌎 Shell Script to Add Two Integers](https://tecadmin.net/tutorial/bash/examples/add-to-numbers/)
- [🌎 How to increment a variable in bash?](https://askubuntu.com/questions/385528/how-to-increment-a-variable-in-bash)
- [🌎 Various options to increment by 1, and performance analysis](https://askubuntu.com/questions/385528/how-to-increment-a-variable-in-bash)


## Get Script Paths and Name

```bash
# Script absolute path
SCRIPTPATH="$(realpath -s $0)"
# Script name
SCRIPTNAME="$(basename ${0})"
# Script directory
SCRIPTDIR="$(dirname ${SCRIPTPATH})"
SCRIPTDIR="$( cd "$( dirname "$0" )" && pwd )"
SCRIPTDIR="$( cd "$(dirname "${BASH_SOURCE[0]}")" >/dev/null 2>&1 ; pwd -P )"
```

Ref:

- [🌎 Reliable way for a Bash script to get the full path to itself](https://stackoverflow.com/a/4774063/11850077)
- [🌎 How to get the source directory of a Bash script from within the script itself?](https://stackoverflow.com/a/246128/11850077)
- [🌎 Get script name in shell script](https://www.golinuxcloud.com/get-script-name-get-script-path-shell-script/)


<br>

# Resources

- [🌎 How to Increment and Decrement Variable in Bash (Counter)](https://linuxize.com/post/bash-increment-decrement-variable/)
- [🌎 Shell Script to Add Two Integers](https://tecadmin.net/tutorial/bash/examples/add-to-numbers/)
- [🌎 How to increment a variable in bash?](https://askubuntu.com/questions/385528/how-to-increment-a-variable-in-bash)
- [🌎 Various options to increment by 1, and performance analysis](https://askubuntu.com/questions/385528/how-to-increment-a-variable-in-bash)
- [🌎 Reliable way for a Bash script to get the full path to itself](https://stackoverflow.com/a/4774063/11850077)
- [🌎 How to get the source directory of a Bash script from within the script itself?](https://stackoverflow.com/a/246128/11850077)
- [🌎 Get script name in shell script](https://www.golinuxcloud.com/get-script-name-get-script-path-shell-script/)

