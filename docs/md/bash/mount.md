---
title: Bash Mounting Drive
author: Mark Lucernas
date: 2020-08-07
summary: Mounting drive and other commands
---


# Mounting Drive

## Mounting flash drive

```bash
sudo fdisk -l               # Check for available drive to mount
sudo mount /dev/sda1 /mnt   # Example: Mount '/dev/sda1' drive into '/mnt'
```

### Unmounting Drive

```bash
sudo unmount <drive>
```

Ref:

  - [How to mount usb drive in a linux system](https://www.tutorialspoint.com/how-to-mount-usb-drive-in-a-linux-system)


## Formatting Drive

### Format to vFat FileSystem

  - `sudo mkfs.vfat <drive>`


### Format to EXT44 FileSystem

  - `sudo mkfs.ext4 <drive>`


Ref:

  - [How to mount usb drive in a linux system](https://www.tutorialspoint.com/how-to-mount-usb-drive-in-a-linux-system)

<br>

# Resources

  - [How to mount usb drive in a linux system](https://www.tutorialspoint.com/how-to-mount-usb-drive-in-a-linux-system)

