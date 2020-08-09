---
title: Bash Scripting Array
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with arrays
---


# Array

## Appending to Array

**Appending array element by using shorthand operator**

```bash
# Declare a string array
arrVar=("element 1" "element 2" "element 3" "element 4")

# Add new element at the end of the array
arrVar+=("element 5")

# Iterate the loop to read and print each array element
for value in "${arrVar[@]}"; do
  echo $value
done
```

**Appending array element by defining the last index**

```bash
# Declare a string array
arrVar=("element 1" "element 2" "element 3" "element 4")

# Add new element at the end of the array
arrVar[${#arrVar[@]}]="element 5"

# Iterate the loop to read and print each array element
for value in "${arrVar[@]}"; do
  echo $value
done
```

**Appending array element by using bracket**

```bash
# Declare a string array
arrVar=("element 1" "element 2" "element 3" "element 4")

# Add new element at the end of the array
arrVar=(${#arrVar[@]} "element 5")

# Iterate the loop to read and print each array element
for value in "${arrVar[@]}"; do
  echo $value
done
```

**Append multiple elements at the end of the array**

```bash
# Declare a string array
arrVar1=("element 1" "element 2" "element 3")
arrVar2=("element 4" "element 5" "element 6")

# Add new element at the end of the array
arrVar=(${#arrVar1[@]} ${#arrVar2[@]})

# Iterate the loop to read and print each array element
for value in "${arrVar[@]}"; do
  echo $value
done
```

Ref:

  - [Bash append to array](https://linuxhint.com/bash_append_array/)


<br>

# Resources

  - [Bash append to array](https://linuxhint.com/bash_append_array/)

