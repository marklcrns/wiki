---
title: GNUpg Usage
author: Mark Lucernas
date: Oct 09, 2020
---


# Usage

## Help

```bash
gpg --help
```

## Generating New Private Key

```bash
gpg --gen-key
```

## Key Management

### List all keys

```bash
# List public keys you have stored (yours and other people's keys)
gpg --list-keys

# List private keys (generally only your own)
gpg --list-secret-keys
```

### Editing existing key

```bash
gpg --edit-key <USER_ID>
```

> Type `help` when gpg interactive prompt appears to view basic commands

### Exporting Private Keys

```bash
# Find the ID of your key first
# The ID is the hexadecimal number
# Second column, after the slash, e.g. "ABC12345"
# If you have a "sub" entry, you can ignore it
gpg --list-secret-keys

# This is your private key keep it secret!
# Replace XXXXXXXX with your hexadecimal key ID
gpg --export-secret-keys --armor XXXXXXXX > ./my-priv-gpg-key.asc
# or
gpg --export-secret-keys XXXXXXXX > ./private.key

# Omitting the --armor flag will give you binary output instead of ASCII
# which would result in a slightly smaller file but the ASCII
# formatted (armored) can be printed physically, is human readable,
# and transfered digitally easier.
# Both formats can be imported back in to GPG later
```

### Importing a Key

```bash
# This works the same for binary or ASCII (armored) versions of keys
# This is also the same for private and public keys
gpg --import ./my-priv-gpg-key.asc
# or
gpg --import ./private.key

# You can also directly import a key from a server
# For example, import the DevDungeon/NanoDano public GPG key from MIT
gpg --keyserver pgp.mit.edu  --recv C104CDF0EDA54C82
```

### Push Public Key to Key Server

```bash
# There are many public key servers out there, not just MIT
# Replace XXXXXXXX with your key id from --list-keys
gpg --keyserver hkp://pgp.mit.edu --send-keys XXXXXXXX
```

### Deleting a Key

```bash
# Private keys
# Use the ID listed with --list-secret-keys
gpg --delete-secret-keys XXXXXXXX

# Public keys
# Use the ID listed with --list-keys
gpg --delete-keys XXXXXXXX
```

## Encryption

### Encrypt with a Passphrase (Symmetric)

```bash
gpg --symmetric message.txt
# Prompts you for a passphrase
# Creates message.txt.gpg (binary)

gpg --armor --symmetric message.txt
# Same, but ASCII format output instead of binary
# Creates message.txt.asc (ASCII)

# Specify the encryption algorithm
gpg --symmetric --cipher-algo AES256

# Get the list of cipher algorithms
gpg --version
# E.g. 3DES, BLOWFISH, AES256, TWOFISH

# Specify output file
gpg --output message.txt.gpg --symmeteric message.txt

# Encrypt and sign (all in the single output file)
gpg --sign --symmetric message.txt
```

### Encrypt for a Single Recipient (Assymetric)

```bash
# This will prompt and ask the recipient's email address
# and you will have to enter the ID or email
gpg --encrypt message.txt

# or specify the recipient as the -r argument
gpg  --recipient nanodano@devdungeon.com --encrypt message.txt
# Encrypted output will be in message.txt.gpg

# Encrypt and store in ASCII format (message.txt.asc)
# Both binary and ASCII versions decrypt the same
gpg  --armor --recipient nanodano@devdungeon.com --encrypt message.txt

# Encrypt and sign at the same time
gpg --encrypt --sign --recipient nanodano@devdungeon.com message.txt

# Specify output file
gpg --output message.txt.gpg 
```

### Decrypt a Message

```bash
# Decrypt and print message to screen
# Will automatically verify signature if there was one
# Will automatically detect if symmetric or asymmetric
# Will automatically use the appropriate private key if available
# Will automatically prompt for passphrase if symmetric
gpg -d message.txt.gpg

# Decrypt and put output in decrypted.txt
gpg --decrypt message.txt.gpg > decrypted.txt
```

## Signatures

You can sign files that were encrypted using asymmetric or symmetric methods.
The benefit of providing a signature is to let everyone prove that you were the
author of the file, or at least, you confirmed the contents of the file at the
time of your signature. You can also just sign files without encrypting them at
all.

### Sign a Message

```bash
gpg --clearsign message.txt
# Outputs message.txt.asc in plain text, suitable
# for pasting in an email or posting online

gpg --sign message.txt
# Outputs message.txt.gpg a binary file

# Both of these can be verified with --decrypt
# but they are not _actually_ encrypted.
gpg --decrypt message.txt.gpg
gpg --decrypt message.txt.asc
# This will print out the message along with the signature info
```

### Encrypt and Signk

```bash
# Symmetric encrypt with signature
gpg --sign --symmetric message.txt

# Asymmetric encrypt with signature
gpg --sign --encrypt --recipient nanodano@devdungeon.com message.txt
```

### Verify Signatures

```bash
# When you decrypt the message it will verify the signature
gpg --decrypt message.txt.asc

# Verify a signed message that included a signature
gpg --verify message.txt.asc
# Verify and extract original document
gpg --output message.txt message.txt.asc
```

### Detached Signatures

```bash
# Create a separate signature file
gpg --detach-sign message.txt
# Will create message.txt.sig

# This verify will automatically check the signature
# against a file named "message.txt"
gpg --verify message.txt.sig

# Specify the file to check it against
gpg --verify some_signature.sig ./message.txt
```

Ref:

- [📄 GPG Tutorial](https://www.devdungeon.com/content/gpg-tutorial)


<br>

# Resources

- [📄 GPG Tutorial](https://www.devdungeon.com/content/gpg-tutorial)

