---
title: itchyny/calendar.vim
author: Mark Lucernas
date: 2020-02-24
---

# Vim Plugin Wiki: itchyny/calendar.vim

[Git Repo](https://github.com/itchyny/calendar.vim)

## Default Mappings

While inside Calendar buffer:

  - `E` = Event
  - `T` = Task
  - `d` = Delete
  - `D` = Delete line
  - `Q` = Quit Calendar
  - `<` = Change calendar view more general
  - `>` = Change calendar view more specific
  - `t` = Go to today's date
  - `(` = Go to first line
  - `[` = Go to first line
  - `)` = Go to last line
  - `]` = Go to last line

  ## Events and Tasks

  ```
  Calendar:
  Day event:
  EVENT: [event-title]

  Few hours event:
  EVENT: HH:MM - HH:MM [event-title]
  EVENT: HH:MM:ss - HH:MM:ss [event-title]

  Example:
  EVENT: 12:00 - 14:00 [event-title]
  EVENT: 12:00:30 - 14:00:20 [event-title]

  Few days event:
  EVENT: mm/dd - mm/dd [event-title]
  EVENT: yyyy/mm/dd - yyyy/mm/dd [event-title] (big endian)
  EVENT: mm/dd/yyyy - mm/dd/yyyy [event-title] (middle endian)
  EVENT: dd/mm/yyyy - dd/mm/yyyy [event-title] (little endian)
  EVENT: yyyy-mm-dd - yyyy-mm-dd [event-title] (big endian, "-" separator)

  Example:
  EVENT: 10/10 - 10/12 [event-title]
  EVENT: 2014/10/10 - 2014/10/12 [event-title] (big endian)
  EVENT: 10/10/2014 - 10/12/2014 [event-title] (middle endian)
  EVENT: 10/10/2014 - 12/10/2014 [event-title] (little endian)
  EVENT: 2014-10-10 - 2014-10-12 [event-title] (big endian, "-" separator)

  Days and hours event:
  EVENT: mm/dd HH:MM - mm/dd HH:MM [event-title]
  EVENT: yyyy/mm/dd HH:MM - yyyy/mm/dd HH:MM [event-title]
  EVENT: dd/mm/yyyy HH:MM - dd/mm/yyyy HH:MM [event-title] (little endian)
  EVENT: dd-mm-yyyy HH:MM - dd-mm-yyyy HH:MM [event-title] (little endian, "-" separator)

  Example:
  EVENT: 10/10 19:00 - 10/11 21:00 [event-title]
  EVENT: 2014/10/10 19:00 - 2014/10/11 21:00 [event-title]
  EVENT: 10-10-2014 10:00 - 12-10-2014 21:00 [event-title] (little endian, "-" separator)

  Task:
  Simple task:
  TASK: [task-title]

  Task with note:
  TASK: [task-title] note: [task-note]

  Task with due date:
  TASK: mm/dd [task-title]
  TASK: mm-dd [task-title]
  TASK: yyyy/mm/dd [task-title]
  TASK: yyyy-mm-dd [task-title]

  Example:
  TASK: 10/30 [task-title]
  TASK: 10-30 [task-title]
  TASK: 2014/10/30 [task-title]
  TASK: 2014-10-30 [task-title]

  Task with due date and note:
  TASK: yyyy/mm/dd [task-title] note: [task-note]
  TASK: yyyy-mm-dd [task-title] note: [task-note]

  Example:
  TASK: 2014/10/30 [task-title] note: [task-note]
  TASK: 2014-10-30 [task-title] note: [task-note]
  ```

References
=====

  - [Git Repo](https://github.com/itchyny/calendar.vim)
