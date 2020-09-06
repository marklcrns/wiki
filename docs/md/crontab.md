---
title: Crontab
subtitle: Crontab Wiki
summary: Schedule cron jobs to run on a time interval for the current user.
author: Mark Lucernas
date: Sep 09, 2020
---


# Crontab

## Usage

- `crontab -l` -- List all cron jobs for current user
- `crontab -e` -- Edit cron jobs for current user
- `crontab -r` -- Remove all cron jobs for current user

```
# ┌───────────── minute (0 - 59)
# │ ┌───────────── hour (0 - 23)
# │ │ ┌───────────── day of month (1 - 31)
# │ │ │ ┌───────────── month (1 - 12)
# │ │ │ │ ┌───────────── day of week (0 - 6) (Sunday to Saturday;
# │ │ │ │ │                                       7 is also Sunday on some systems)
# │ │ │ │ │
# │ │ │ │ │
# * * * * *  command_to_execute


###### Sample crontab ######

# Empty temp folder every Friday at 5pm
0 5 * * 5 rm -rf /tmp/*

# Backup images to Google Drive every night at midnight
0 0 * * * rsync -a ~/Pictures/ ~/Google\ Drive/Pictures/
```

Ref:

- [🎬 Linux/Mac Tutorial: Cron Jobs - How to Schedule Commands with crontab](https://www.youtube.com/watch?v=QZJ1drMQz1A)
- [🌎 Cron-Tasks snippets](https://github.com/CoreyMSchafer/code_snippets/blob/master/Cron-Tasks/snippets.txt)

Other resources

- [🌎 Crontab.guru](https://crontab.guru/)


<br>

# Resources

- [🎬 Linux/Mac Tutorial: Cron Jobs - How to Schedule Commands with crontab](https://www.youtube.com/watch?v=QZJ1drMQz1A)
- [🌎 Cron-Tasks snippets](https://github.com/CoreyMSchafer/code_snippets/blob/master/Cron-Tasks/snippets.txt)
- [🌎 Crontab.guru](https://crontab.guru/)

