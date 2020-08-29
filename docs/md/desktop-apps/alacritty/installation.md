---
title: Alacritty Installation
subtitle: Installation Instruction
author: Mark Lucernas
date: 2020-08-29
---

# Alacritty Installation

## WSL/WSL2

Using `choco` PowerShell package manager

```powershell
choco install alacritty
```

To set WSL terminal as default, go to `%APPDATA%\alacritty\alacritty.yml` and
add the following lines

```yml
shell:
  program: "C:\\Windows\\System32\\wsl.exe"
```

Ref:

- [🌎 Alaritty Windows Installation](https://gist.github.com/AjkayAlan/39a8e53319410b2280667c0f37e0b830#install-and-configure-a-terminal)


<br>

# Resources

- [🌎 Alaritty Windows Installation](https://gist.github.com/AjkayAlan/39a8e53319410b2280667c0f37e0b830#install-and-configure-a-terminal)

