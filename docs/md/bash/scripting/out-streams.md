---
title: Bash Scripting Output Stream
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting output streams
---


# Output Streams

## Redirecting Standard Output to a File

**Redirect stdout replacing existing file***

  - `command > /path/to/file`


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

**Redirect stdout to a file `>out`, and then redirect stderr to stdout `2>&1`**

  - `command >out 2>&1`


**Redirect both to a file:**

  - `command &> out`


**Redirect stdout and stderr to a bash function**

Method 1:

```bash
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

```bash
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


<br>

# Resources

- [🌎 How to Save the Output of a Command to a File in Bash](https://www.howtogeek.com/299219/how-to-save-the-output-of-a-command-to-a-file-in-bash-aka-the-linux-and-macos-terminal/)
- [🌎 How to redirect stderr to a file](https://askubuntu.com/questions/625224/how-to-redirect-stderr-to-a-file)
- [🌎 Redirect stdout and stderr to Function](https://stackoverflow.com/questions/11904907/redirect-stdout-and-stderr-to-function)

