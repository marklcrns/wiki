---
title: Alacritty Installation
subtitle: Installation Instruction
author: Mark Lucernas
date: 2020-08-29
---

# Alacritty Installation

## Linux

### Ubuntu

20.04 Focal Fossa

```sh
# Dependencies
sudo apt install cmake pkg-config libfreetype6-dev libfontconfig1-dev libxcb-xfixes0-dev python3

git clone https://github.com/alacritty/alacritty
cd alacritty
cargo build --release

# Clean up
cd .. && rm -r alacritty
```

Ref:

- [📄 Alacritty Installation Guide](https://github.com/alacritty/alacritty/blob/master/INSTALL.md#linux--windows)
- [📄 install-alacritty-ubuntu.sh](https://gist.github.com/Aaronmacaron/8a4e82ed0033290cb2e12d9df4e77efe)

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

- [📄 Alaritty Windows Installation](https://gist.github.com/AjkayAlan/39a8e53319410b2280667c0f37e0b830#install-and-configure-a-terminal)


<br>

# Resources

- [📄 Alacritty Installation Guide](https://github.com/alacritty/alacritty/blob/master/INSTALL.md#linux--windows)
- [📄 install-alacritty-ubuntu.sh](https://gist.github.com/Aaronmacaron/8a4e82ed0033290cb2e12d9df4e77efe)
- [📄 Alaritty Windows Installation](https://gist.github.com/AjkayAlan/39a8e53319410b2280667c0f37e0b830#install-and-configure-a-terminal)

