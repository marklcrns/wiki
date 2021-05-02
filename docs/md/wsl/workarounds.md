---
title: WSL/WSL2 Workarounds
author: Mark Lucernas
date: May 01, 2021
---


# WSL/WSL2 Workarounds

## Clipboard

This workaround was inspired by Neovide clipboard issue with WSL/WSL2. Also
works with terminal neovim as long as `clipboard` is set to `unnamedplus`.

```bash
curl -sLo/tmp/win32yank.zip https://github.com/equalsraf/win32yank/releases/download/v0.0.4/win32yank-x64.zip
unzip -p /tmp/win32yank.zip win32yank.exe > /tmp/win32yank.exe
chmod +x /tmp/win32yank.exe
sudo mv /tmp/win32yank.exe /usr/local/bin/
```

> NOTE: it is important that your shell source `win32yank.exe` before other
clipboard tool such as `xclip` for Neovim/Neovide to recognize it as the default
system clipboard. Hence, it should be in `/usr/local/bin` directory.

```vim
set clipboard=unnamedplus
```

Ref:

- [📄 Solved! WSL2 Can't copy-paste to/from System Clipboard (Windows 10) ](https://github.com/Kethku/neovide/issues/544#issuecomment-820519937)
- [📄 equalsraf/win32yank ](https://github.com/equalsraf/win32yank)
- [📄 Kethku/neovide ](https://github.com/Kethku/neovide)


## Audio Fix

1. Paste the following code in `~/.bashrc` or `~/.profile`

```bash
HOST_IP=$(host `hostname` | grep 192. | tail -1 | awk '{ print $NF }' | tr -d '\r')
export DISPLAY=$HOST_IP:0.0
export PULSE_SERVER=tcp:$HOST_IP
export NO_AT_BRIDGE=1
export LIBGL_ALWAYS_INDIRECT=1

# Workaround for WSL/WSL2 X Server not working
if grep -qE "(Microsoft|WSL)" /proc/version &>/dev/null; then
  #WSL1
  export DISPLAY="${DISPLAY:-localhost:0.0}"
  export PULSE_SERVER="${PULSE_SERVER:-tcp:127.0.0.1}"
elif grep -q "microsoft" /proc/version &>/dev/null; then
  # WSL2
  HOST_IP=$(host `hostname` | grep 192. | tail -1 | awk '{ print $NF }' | tr -d '\r')
  export DISPLAY=$HOST_IP:0.0
  export PULSE_SERVER=tcp:$HOST_IP
fi
```

Then run `source ~/.bashrc` or `source ~/.profile`

2. Clean install pulseaudio in WSL

```bash
sudo apt-get remove --purge alsa-base pulseaudio
sudo apt-get install alsa-base pulseaudio
sudo apt-get -f install && sudo apt-get -y autoremove && sudo apt-get autoclean && sudo apt-get clean && sudo sync && echo 3 | sudo tee /proc/sys/vm/drop_caches
```

3. Download
   [pusleaudio-5.0-rev18.zip](http://code.x2go.org/releases/binary-win32/3rd-party/pulse/pulseaudio-5.0-rev18.zip)
   and extract to `C:\wsl\pulse` or to any known path.

4. Create a `config.pa` inside pulse directory `C:\wsl\pulse` and add the
   following lines

```
load-module module-native-protocol-tcp auth-anonymous=1
load-module module-esound-protocol-tcp auth-anonymous=1
load-module module-waveout sink_name=output source_name=input record=0
```

Test this setup by running: `c:\wsl\pulse\pulseaudio.exe -F config.pa` in Windows
terminal or Powershell by administrator.

5. Remove pulseaudio configs

```bash
sudo rm /etc/pulse/client.conf #or just make sure every line is commented by cat /etc/pulse/client.conf

rm -rf ~/.config/pulse/*
pax11publish -e -r
```

6. Create `.bat` script and add the following to automate pulseaudio service.

```bat
:: --- Start Xserver --- ::

:: For Vcxsrv
:: start "" /B "C:\wsl\config.xlaunch"
:: For X410
start /B x410.exe /desktop

:: --- Start pulseaudio --- ::

start "" /B C:\wsl\pulse\pulseaudio.exe -F C:\wsl\pulse\config.pa

:: --- EXTRAS --- ::

:: Hide console after launching script
:: https://www.robvanderwoude.com/battech_hideconsole.php
C:\wsl\ConsoleState /Hide
```

Another option is to create a Windows service to run PulseAudio everytime
Windows start. [📄 Setting up pulseaudio in
windows](https://github.com/microsoft/WSL/issues/5816#issuecomment-682242686)

Now everytime you run the script, it will run your Xserver and pulseaudio
service.

Test if wsl has sounds:

```bash
paplay /usr/share/sounds/freedesktop/stereo/bell.oga
```

If none of these steps work, refer to the resources below. Consider editing
`/etc/pulse/default.pa` as an extra step. Link below.

Ref:

- [📄 Setting up pulseaudio in windows](https://github.com/microsoft/WSL/issues/5816#issuecomment-682242686)
- [📄 Reinstall pulseaudio in wsl2 ubuntu](https://unix.stackexchange.com/a/465734)
- [📄 Setting proper host ip](https://github.com/microsoft/WSL/issues/5816#issuecomment-760613983)
- [📄 Remove pulse configs](https://github.com/microsoft/WSL/issues/5816#issuecomment-755409888)
- [📄 Editing /etc/pulse/default.pa](https://github.com/microsoft/WSL/issues/5816#issuecomment-713702166)
- [📄 Consolestate](https://www.robvanderwoude.com/battech_hideconsole.php)

<br>

# Resources

- [📄 Solved! WSL2 Can't copy-paste to/from System Clipboard (Windows 10) ](https://github.com/Kethku/neovide/issues/544#issuecomment-820519937)
- [📄 equalsraf/win32yank ](https://github.com/equalsraf/win32yank)
- [📄 Kethku/neovide ](https://github.com/Kethku/neovide)
- [📄 Setting up pulseaudio in windows](https://github.com/microsoft/WSL/issues/5816#issuecomment-682242686)
- [📄 Reinstall pulseaudio in wsl2 ubuntu](https://unix.stackexchange.com/a/465734)
- [📄 Setting proper host ip](https://github.com/microsoft/WSL/issues/5816#issuecomment-760613983)
- [📄 Remove pulse configs](https://github.com/microsoft/WSL/issues/5816#issuecomment-755409888)
- [📄 Editing /etc/pulse/default.pa](https://github.com/microsoft/WSL/issues/5816#issuecomment-713702166)
- [📄 Consolestate](https://www.robvanderwoude.com/battech_hideconsole.php)
