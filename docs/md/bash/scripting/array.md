---
title: Bash Scripting Array
author: Mark Lucernas
date: 2020-08-09
summary: Bash scripting with arrays
---


# Array

## Basics

**Declaring bash array**

- `declare -a array_name`


**Initializing bash array**

- `array_name=( element_1 element_2 element_n ) `


**Access an individual element**

- `echo "${array[0]}"` -- Access the first index of an array
- `echo "${array[-1]}"'` -- Access the last index of an array


**Iterate over the elements of an array**

```bash
for element in "${array[@]}"; do
  echo "$element"
done
```

With index and value

```bash
for index in "${!array[@]}"; do
  echo "$index ${array[index]}"
done
```

**Deleting values of an index**

- `unset "array[1]"`


**Adding values to an index**

- `array[42]="Some string"` -- Bash arrays are not contiguous and can add
    elements in an arbitrary index


**Get length of an array**

- `echo "${#array[@]}"`


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

- [Bash Array – Declare, Initialize and Access – Examples](https://www.tutorialkart.com/bash-shell-scripting/bash-array/)
- [Bash append to array](https://linuxhint.com/bash_append_array/)


## Split String Into Array

Method 1:

```bash
string="Paris, France, Europe"

# Split string into array delimited by ', '
IFS=', ' read -r -a array <<< "$string"

# Iterate over the elements
for element in "${array[@]}"; do
  echo "$element"
done
```

Method 2: (recommended)

```bash
# 'arr' as the variable for the array
readarray -td '' arr < <(awk '{ gsub(/, /,"\0"); print; }' <<<"$string, "); unset 'arr[-1]'; declare -p arr;
```

> **NOTE:** Must read [this](https://stackoverflow.com/a/45201229/11850077) to
understand the comparison about `read` and `readarray` when splitting string
into array.

Ref:

- [Split string into an array in Bash: Method 1](https://stackoverflow.com/a/10586169/11850077)
- [Split string into an array in Bash: Method 2](https://stackoverflow.com/a/45201229/11850077)


## Detecting if Variable is an Array


```bash
if declare -p ARRAY 2> /dev/null | grep -q '^declare \-a'; then
  echo "$ARRAY is an array"
else
  echo "$ARRAY is not an array"
fi
```

Ref:

- [How do I check if variable is an array?](https://stackoverflow.com/a/14525326/11850077)


<br>

# Resources

- [Bash Array – Declare, Initialize and Access – Examples](https://www.tutorialkart.com/bash-shell-scripting/bash-array/)
- [Bash append to array](https://linuxhint.com/bash_append_array/)
- [Split string into an array in Bash: Method 1](https://stackoverflow.com/a/10586169/11850077)
- [Split string into an array in Bash: Method 2](https://stackoverflow.com/a/45201229/11850077)
- [How do I check if variable is an array?](https://stackoverflow.com/a/14525326/11850077)

