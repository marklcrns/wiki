---
title: Cron
subtitle: Daemon to execute scheduled commands (Vixie Cron)
author: Mark Lucernas
date: Jul 16, 2021
---


# Cron

## Cron Daemon

Run:

```
pgrep cron
```

If you see no number (i.e cron's main PID), then cron is not running.

For Ubuntu/Mint/Debian based distro

```bash
/etc/init.d/cron start

## or using service utility
sudo service cron start

## or using systemctl in modern Linux
sudo systemctl start cron
```


For RHEL/Fedora/CentOS/Scientific/Rocky/Alma distro

```bash
/etc/init.d/crond start

## or using service utility
service crond start

## or using systemctl in modern Linux
systemctl start crond.service
```

> To stop cron daemon, replace `start` with `stop`. Same applies for `restart`

Ref:

- [📄 Why crontab scripts are not working?](https://askubuntu.com/a/23469)
- [📄 Linux Start Restart and Stop The Cron or Crond Service](https://www.cyberciti.biz/faq/howto-linux-unix-start-restart-cron)

## Crontab

- [↪ Crontab](crontab/index)

## Logs

To enable cron logs

Open the file `/etc/rsyslog.d/50-default.conf`

Find the line that starts with:

```
#cron.*
```

uncomment the line and restart rsyslog:

```bash
sudo service rsyslog restart
```

You should now see cron log file in `/var/log/cron.log` and in `/var/log/syslog`

---

To print all cron jobs

```bash
cat /var/log/cron.log
# or
grep CRON /var/log/syslog
```

For continuous monitoring:

```bash
tail -f /var/log/syslog | grep CRON
```

Ref:

- [📄 Where is the cron / crontab log?](https://askubuntu.com/questions/56683/where-is-the-cron-crontab-log)


<br>

# Resources

- [📄 Why crontab scripts are not working?](https://askubuntu.com/a/23469)
- [📄 Where is the cron / crontab log?](https://askubuntu.com/questions/56683/where-is-the-cron-crontab-log)

