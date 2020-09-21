---
title: Bash Scripting
subtitle: Output streams
author: Mark Lucernas
date: Aug 09, 2020
---


# Output Streams

## Redirecting Standard Output to a File

**Redirect stdout replacing existing file***

- `command 1> /path/to/file`
- `command > /path/to/file` -- `1` can be omitted


**Redirect stdout appending the output if file exists, else create new**

- `command >> /path/to/file`


**Print output normally and redirect to a file**

- `command | tee /path/to/file`


**Print output normally and redirect to a file appending if existing, else
create new**

- `command | tee -a /path/to/file`


Ref:

- [🌎 How to Save the Output of a Command to a File in Bash](https://www.howtogeek.com/299219/how-to-save-the-output-of-a-command-to-a-file-in-bash-aka-the-linux-and-macos-terminal/)


## Redirecting Standard Output and Standard Error to a File

**Redirect stdout to one file and stderr to another file**

- `command > out 2>error`


> **NOTE:** `out` and `error` are the path to files

**Redirect stdout to a file `> file`, and then redirect stderr to stdout `2>&1`**

- `command > file 2>&1`
- `command > /dev/null 2>&1` -- redirect to `/dev/null` to silence output


**Redirect both stdout and stderr to a file (shorthand)**

- `command &> file`
- `command &> /dev/null` -- redirect to `/dev/null` to silence output


**Redirect stdout and stderr to a bash function**

Method 1:

```sh
LogMsg()
{
  read IN # This reads a string from stdin and stores it in a variable called IN
  DateTime=`date "+%Y/%m/%d %H:%M:%S"`
  echo '*****'$DateTime' ('$QMAKESPEC'): '$IN >> "$LogFile"
  echo $DateTime' ('$QMAKESPEC'): '$IN
}

# Use with pipe
make 2>&1 | LogMsg
```

Method 2:

```sh
LogMsg()
{
  if [ -n "$1" ]
  then
      IN="$1"
  else
      read IN # This reads a string from stdin and stores it in a variable called IN
  fi

  DateTime=`date "+%Y/%m/%d %H:%M:%S"`
  echo '*****'$DateTime' ('$QMAKESPEC'): '$IN >> "$LogFile"
  echo $DateTime' ('$QMAKESPEC'): '$IN
}

# Use with pipe
make 2>&1 | LogMsg

# Use without pipe
LogMsg "Message"
```

> **NOTE:** This makes `LogMsg` take in an argument if not used with pipe

Ref:

- [🌎 How to redirect stderr to a file](https://askubuntu.com/questions/625224/how-to-redirect-stderr-to-a-file)
- [🌎 Redirect stdout and stderr to Function](https://stackoverflow.com/questions/11904907/redirect-stdout-and-stderr-to-function)
- [🌎 Silencing the Output of a Bash Command](https://www.baeldung.com/linux/silencing-bash-output)


<br>

# Resources

- [🌎 How to Save the Output of a Command to a File in Bash](https://www.howtogeek.com/299219/how-to-save-the-output-of-a-command-to-a-file-in-bash-aka-the-linux-and-macos-terminal/)
- [🌎 How to redirect stderr to a file](https://askubuntu.com/questions/625224/how-to-redirect-stderr-to-a-file)
- [🌎 Redirect stdout and stderr to Function](https://stackoverflow.com/questions/11904907/redirect-stdout-and-stderr-to-function)

