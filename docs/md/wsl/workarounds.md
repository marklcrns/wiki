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


## Start Daemon Services Using With Task Scheduler

### Start cron at Startup

1. Create startup script.

```bash
echo "service cron start" | sudo tee /usr/local/bin/cronstart.sh
sudo chmod +x /usr/local/bin/cronstart.sh
```

2. Create a file within `/etc/sudoers.d/` with purpose to allow your `$USER` to
   execute `cronstart` by `sudo` **without password**.

Run and copy the output:

```bash
echo "$USER ALL=(ALL) NOPASSWD: /usr/local/bin/cronstart.sh"
```

Run `sudo visudo -f /etc/sudoers.d/cronstart` then paste the content of the
output. Save the file and exit.

3. Run `cronstart.sh` on Windows startup

**METHOD 1**: Using Task Scheduler (Recommended for administrator accounts)

Run (as admin if current account isn't) _**Task Scheduler**_

Click _**Task Scheduler Library**_ on the left and then _**Create Task...**_ on
the right to create new task.

- **General tab**:
  * **Name**: Anything you want, like `WSL service cron start`
  * Choose the option _**Run whether user is logged or not**_.
  * Mark _**Do not store password**_ and _**Run with highest privileges**_.
  * In the _**Configure for**_ dropdown select `Windows 10`.
  * If you need to setup a task for another user click on the button `Change
  User or Group`
- Triggers tab:
  * Click _**New**_ to add a new trigger for this task.
  * In the _**Begin the task**_ dropdown select _**At startup**_.
  * Within the Advanced settings you can check _**Delay task for**_ `1 minute`.
- Actions tab:
  * Click _**New**_ to add a new action for this task.
  * Pick _**Start a program**_ for the action type and then enter
  `C:\Windows\System32\wsl.exe` as the program to run.
  * At _**Add arguments (optional)**_ set this: `sudo cronstart.sh`.

**METHOD 2**: Using `bat` script in `shell:startup` folder.

Open `Run`, or Windows explorer, and paste `shell:startup` (on the address bar
for Windows explorer).

Then create a file called `cronstart.bat` and paste the following:

```bat
C:\Windows\System32\wsl.exe sudo cronstart.sh
```

**FINALLY**

Reboot system, then open WSL terminal and use `service cron status` to check if
`cron is running`.

Ref:

- [📄 Ubuntu 18.04 on WSL cron daemon not running after reboot](https://askubuntu.com/a/1166012)

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
- [📄 Ubuntu 18.04 on WSL cron daemon not running after reboot](https://askubuntu.com/a/1166012)

