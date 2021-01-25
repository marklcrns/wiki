---
title: leetcode-cli Usage
author: Mark Lucernas
date: Jan 03, 2021
---


# Usage

## Quick Start

```sh
# Basics
leetcode help                               # Read help first
leetcode user -l                            # Login with your leetcode account
leetcode list                               # Browse all questions
leetcode show 1 -g -l cpp                   # Choose one question

# Coding
leetcode test ./two-sum.cpp -t '[3,2,4]\n7' # Run test(s) with test inputs
leetcode submit ./two-sum.cpp               # Submit final solution!
```

Ref:

- [📄 leetcode-cli Commands](https://skygragon.github.io/leetcode-cli/commands)

## Plugins

Plugins installation

```sh
# Install plugin
leetcode plugin -i <plugin-name>
# Remove plugin
leetcode plugin -D <plugin-name>
```

- [📄 leetcode-cli-plugins](https://github.com/skygragon/leetcode-cli-plugins)

## Issues

- [📄 ERROR invalid password? #153](https://github.com/skygragon/leetcode-cli/issues/153#issuecomment-590818198)

> **NOTE:** Install `cookie.firefox` plugin if having problems installing
`cookie.chrome`


<br>

# Resources

- [📄 leetcode-cli Commands](https://skygragon.github.io/leetcode-cli/commands)
- [📄 leetcode-cli-plugins](https://github.com/skygragon/leetcode-cli-plugins)
- [📄 ERROR invalid password? #153](https://github.com/skygragon/leetcode-cli/issues/153#issuecomment-590818198)
