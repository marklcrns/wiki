---
title: Bash Scripting Function
author: Mark Lucernas
date: 2020-08-09
summary: Bash Scripting with functions
---


# Function

## Returning Values from Bash Function

Method 1: Simplest

```sh
function myfunc()
{
    myresult='some value'
}

myfunc
echo $myresult
```

Method 2: Better approach

```sh
function myfunc()
{
    local  myresult='some value'
    echo "$myresult"
}

result=$(myfunc)   # or result=`myfunc`
echo $result
```

Method 3: Accepts variable

```sh
function myfunc()
{
    local  __resultvar=$1
    local  myresult='some value'
    eval $__resultvar="'$myresult'"
}

myfunc result
echo $result
```

> **NOTE:** Make sure to use variable names inside the function that are not
likely to be used as parameter variable. e.g. `__resultvar`.

Method 4: More flexibility

```sh
function myfunc()
{
    local  __resultvar=$1
    local  myresult='some value'
    if [[ "$__resultvar" ]]; then
        eval $__resultvar="'$myresult'"
    else
        echo "$myresult"
    fi
}

myfunc result
echo $result
result2=$(myfunc)
echo $result2
```

Ref:

- [📄 Returning Values from Bash Functions](https://www.linuxjournal.com/content/return-values-bash-functions#:~:text=The%20simplest%20way%20to%20return%20a%20value%20from,the%20global%20variable%20myresult%20to%20the%20function%20result.)
- [📄 How to return a string value from a Bash function](https://stackoverflow.com/a/3243034)

<br>

# Resources

- [📄 Returning Values from Bash Functions](https://www.linuxjournal.com/content/return-values-bash-functions#:~:text=The%20simplest%20way%20to%20return%20a%20value%20from,the%20global%20variable%20myresult%20to%20the%20function%20result.)
- [📄 How to return a string value from a Bash function](https://stackoverflow.com/a/3243034)

