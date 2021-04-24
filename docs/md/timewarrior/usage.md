---
title: Timewarrior
subtitle: Usage
author: Mark Lucernas
date: Sep 17, 2020
---


# Usage

## Basics

Show currently running time tracking. Also creates new database for first time
run.

- `timew`

Start anonymous stopwatch

- `timew start`

Stop active time tracking

- `timew stop`

Restart previous time tracking

- `timew continue`

Display summary report

- `timew summary`

Display `timew` commands

- `timew help`


Ref:

- [📄 Timewarrior Tutorial](https://timewarrior.net/docs/tutorial.html)

## Corrections

Get summary report with ID

- `timew summary :ids`

Remove extra tags

- `timew untag @1 Prepare Talk`

Add missing tag

- `timew tag @1 'Prepare Talk'`

Add time to a closed interval

- `timew lengthen @1 20mins`

Remove time from a closed interval

- `timew shorten @1 PT5M30S`

Move any interval to a new start time

- `timew move @1 8:30am`

Split an interval in two

- `timew split @1`

Join two intervals together

- `timew join @1 @2`

Ref:

- [📄 Timewarrior Corrections](https://timewarrior.net/docs/corrections/)


<br>

# Resources

- [📄 Timewarrior Tutorial](https://timewarrior.net/docs/tutorial.html)
- [📄 Timewarrior Corrections](https://timewarrior.net/docs/corrections/)

