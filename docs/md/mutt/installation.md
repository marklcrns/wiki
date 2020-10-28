---
title: Mutt Installation
author: Mark Lucernas
date: Oct 09, 2020
---


# Installation

## Linux

### Ubuntu or Debian Based System 

```bash
sudo apt update -y
sudo apt install mutt -y
```

Then create Mutt directories:

```bash
mkdir -p ~/.mutt/cache/headers mkdir ~/.mutt/cache/bodies touch ~/.mutt/certificates
```

Finally, add these to your `.muttrc`

```muttrc
set header_cache = "~/.mutt/cache/headers"
set message_cachedir = "~/.mutt/cache/bodies"
set certificate_file = "~/.mutt/certificates"
```

**NOTE:** Mutt configuration resides in `~/.muttrc` or `~/.mutt/.muttrc`

Ref:

- [📄 Mutt – A Command Line Email Client to Send Mails from Terminal](https://www.tecmint.com/send-mail-from-command-line-using-mutt-command/)
- [📄 How to Use the Fast and Powerful Mutt Email Client with Gmail](https://lifehacker.com/how-to-use-the-fast-and-powerful-mutt-email-client-with-5574557)
- [📄 jtdaugherty/mutt-tutorial](https://github.com/jtdaugherty/mutt-tutorial)

<br>

# Resources

- [📄 Mutt – A Command Line Email Client to Send Mails from Terminal](https://www.tecmint.com/send-mail-from-command-line-using-mutt-command/)
- [📄 How to Use the Fast and Powerful Mutt Email Client with Gmail](https://lifehacker.com/how-to-use-the-fast-and-powerful-mutt-email-client-with-5574557)
- [📄 jtdaugherty/mutt-tutorial](https://github.com/jtdaugherty/mutt-tutorial)

