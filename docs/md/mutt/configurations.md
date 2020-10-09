---
title: Mutt Email Configurations
author: Mark Lucernas
date: Oct 09, 2020
---


# Email Configurations

## Setting up with Gmail Account

First, create an _App Password_ for Mutt.

- [🌎 Create a Gmail App Password](https://support.google.com/accounts/answer/185833?hl=en)

Then edit your `.muttrc` with these basic configurations

```muttrc
# User Info
set from = "user@gmail.com"
set realname = "User Name"

# Receive options
set imap_user = "user@gmail.com"
set imap_pass = "Gmail App Password for mutt"
set folder = "imaps://imap.gmail.com:993"
set spoolfile = "imaps://imap.gmail.com/INBOX"
set postponed ="+[Gmail]/Drafts"

set header_cache =~/.mutt/cache/headers
set message_cachedir =~/.mutt/cache/bodies
set certificate_file =~/.mutt/certificates

# Send optionns
set smtp_url = "smtps://user@gmail.com@smtp.gmail.com:465/"
set smtp_pass = "Gmail App Password for mutt"
set move = no
set imap_keepalive = 900
```

- [🌎 Neomutt sample_neomuttrc](https://git.mobley.ne02ptzero.me/~louis/neomutt/tree/master/contrib/sample.neomuttrc)
- [🌎 Mutt-wizard](https://github.com/LukeSmithxyz/mutt-wizard)

Ref:

- [🌎 Check Gmail through other email platforms](https://support.google.com/mail/answer/7126229?hl=en)
- [🌎 How to install/setup mutt with Gmail on CentOS and Ubuntu?](https://unix.stackexchange.com/a/525948)
- [🎬 Email on the terminal with mutt](https://www.youtube.com/watch?v=2jMInHnpNfQ)

## Encrypting Passwords

### GNUpg

For Debian based: `sudo apt-get install gnupg gnupg-agent`
For RPM based : `sudo yum install gnupg gnupg-agent`

Generate encryption key. Enter name, email and passphrase.

```bash
gpg --gen-key
```

Create a new file `~/.mutt/.pass` containing the password(s) in this format:

```
GMail: <password_goes_here>
```

Encrypt `.pass`

```bash
cd ~/.mutt
gpg --encrypt .pass
```

Then set imap and smtp password in your `muttrc`

```muttrc
set imap_pass = `gpg -d ~/.mutt/.pass.gpg | awk '/GMail:/ {print $2}'`
set smpt_pass = `gpg -d ~/.mutt/.pass.gpg | awk '/GMail:/ {print $2}'`
```

Delete your password footprint

```bash
shred ~/.mutt/.pass
rm ~/.mutt/.pass
```

Done!

- [↪ More on gpg encryption](../gpg/usage)
- [🌎 Another way of encrypting IMAP/SMPT Passwords](https://pthree.org/2012/01/07/encrypted-mutt-imap-smtp-passwords/)

Ref:

- [🌎 MUTT - encrypting password with GNUpg](https://vigasdeep.com/2012/06/08/mutt-encrypting-password-with-gnupg/)


<br>

# Resources

- [🌎 Create a Gmail App Password](https://support.google.com/accounts/answer/185833?hl=en)
- [🌎 Neomutt sample_neomuttrc](https://git.mobley.ne02ptzero.me/~louis/neomutt/tree/master/contrib/sample.neomuttrc)
- [🌎 Mutt-wizard](https://github.com/LukeSmithxyz/mutt-wizard)
- [🌎 Check Gmail through other email platforms](https://support.google.com/mail/answer/7126229?hl=en)
- [🌎 How to install/setup mutt with Gmail on CentOS and Ubuntu?](https://unix.stackexchange.com/a/525948)
- [🎬 Email on the terminal with mutt](https://www.youtube.com/watch?v=2jMInHnpNfQ)
- [🌎 Another way of encrypting IMAP/SMPT Passwords](https://pthree.org/2012/01/07/encrypted-mutt-imap-smtp-passwords/)
- [🌎 MUTT - encrypting password with GNUpg](https://vigasdeep.com/2012/06/08/mutt-encrypting-password-with-gnupg/)

