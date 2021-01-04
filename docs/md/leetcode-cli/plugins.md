---
title: leetcode-cli Plugins
author: Mark Lucernas
date: Jan 03, 2021
---


# Plugins

## Quick Start

```sh
leetcode plugin -i <name>                          # install
leetcode plugin -d <name>                          # disable
leetcode plugin -e <name>                          # enable
leetcode plugin -D <name>                          # delete

leetcode plugin -c <name>                          # show config
leetcode config plugins:<name>                     # show config
leetcode config plugins:<name>:<key> <value>       # set config
leetcode config -d plugins:<name>                  # delete config

# Example

leetcode plugin -i company                         # install compnay
leetcode plugin -D compnay                         # delete company

leetcode plugin -c github                          # show github plugin config
leetcode config plugins:github                     # show github plugin config
leetcode config plugins:github:token 12345678      # set github plugin config
leetcode config -d plugins:github                  # delete github plugin config
```

Ref:

- [📄 skygragon/leetcode-cli-plugins ](https://github.com/skygragon/leetcode-cli-plugins)
- [📄 leetcode-cli plugins](https://skygragon.github.io/leetcode-cli/commands#plugin)

<br>

# Resources

- [📄 skygragon/leetcode-cli-plugins ](https://github.com/skygragon/leetcode-cli-plugins)
- [📄 leetcode-cli plugins](https://skygragon.github.io/leetcode-cli/commands#plugin)
