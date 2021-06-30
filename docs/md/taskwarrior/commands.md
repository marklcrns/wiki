---
title: TaskWarrior Commands
author: Mark Lucernas
date: 2020-05-06
summary: Taskwarrior Commands
---


# Task Commands

Command Line Syntax

```sh
task [<filter>] [<command>] [<modification>] [<miscellaneous>]
```

## Adding Tasks

- `task add <task-description> proj:<prof name or task group>`
  * Adds and group with other tasks.
- `task add <task-description> proj:<prof name or task group> wait:someday`
  * Adds a task and put off far into the future.
  Adds a task and put off far into the future.
  * `later` can also be used in place of `someday`

## Finishing Tasks

- `task done <ID>`

## Deleting Tasks

- `task delete <ID>`
- `task $(task uuids completed) delete`
  * delete all completed tasks

## Recurring Tasks

### Adding Recurring Tasks

- `task add <description> proj:<project-name> recur:<duration>`

Adding a task every weekdays

- `task add "Read a book" proj:Todo recur:weekdays due:eod`

Adding task every monday at 16:00 for two hours with `weekly` tag

- `task add "Do Monday chores @ 4pm" proj:Chores recur:weekly sched:monday+16h due:sched+2h +weekly`

### Ending Recurring Tasks

```bash
# View all recurring tasks
task recurring
# Select the ID of recurring task
task <ID> modify until:now
```

Ref:

- [📄 Taskwarrior Recurrence](https://taskwarrior.org/docs/design/recurrence.html)
- [📄 Taskwarrior Durations](https://taskwarrior.org/docs/durations.html)
- [📄 Ending recurring task](https://github.com/GothenburgBitFactory/taskwarrior/issues/2150#issuecomment-488920517)

## All Commands

- `add`         = Add a new task
- `annotate`    = Add an annotation to a task
- `append`      = Append words to a task description
- `calc`        = Expression calculator
- `config`      = Modify configuration settings
- `context`     = Manage contexts
- `count`       = Count the tasks matching a filter
- `delete`      = Mark a task as deleted
- `denotate`    = Remove an annotation from a task
- `done`        = Complete a task
- `duplicate`   = Clone an existing task
- `edit`        = Launch your text editor to modify a task
- `execute`     = Execute an external command
- `export`      = Export tasks in JSON format
- `help`        = Show high-level help, a cheat-sheet
- `import`      = Import tasks in JSON form
- `log`         = Record an already-completed task
- `logo`        = Show the Taskwarrior logo
- `modify`      = Modify one or more tasks
- `prepend`     = Prepend words to a task description
- `purge`       = Completely removes tasks, rather than change status to deleted
- `start`       = Start working on a task, make active
- `stop`        = Stop working on a task, no longer active
- `synchronize` = Syncs tasks with Taskserver
- `undo`        = Revert last change
- `version`     = Version details and copyright


## Customizable Reports

- `active`    = Started tasks
- `all`       = Pending, completed and deleted tasks
- `blocked`   = Tasks that are blocked by other tasks
- `blocking`  = Tasks that block other tasks
- `completed` = Tasks that have been completed
- `list`      = Pending tasks
- `long`      = Pending tasks, long form
- `ls`        = Pending tasks, short form
- `minimal`   = Pending tasks, minimal form
- `newest`    = Most recent pending tasks
- `next`      = Most urgent tasks
- `oldest`    = Oldest pending tasks
- `overdue`   = Overdue tasks
- `ready`     = Pending, unblocked, scheduled tasks
- `recurring` = Pending recurring tasks
- `unblocked` = Tasks that are not blocked
- `waiting`   = Hidden, waiting tasks


## Fixed Reports

- `burndown.daily`   = Burndown chart, by day
- `burndown.monthly` = Burndown chart, by month
- `burndown.weekly`  = Burndown chart, by week
- `calendar`         = Calendar and holidays
- `colors`           = Demonstrates all supported colors
- `columns`          = List of report columns and supported formats
- `commands`         = List of commands, with their behaviors
- `diagnostics`      = Show diagnostics, for troubleshooting
- `ghistory.annual`  = History graph, by year
- `ghistory.monthly` = History graph, by month
- `ghistory.weekly`  = History graph, by week
- `ghistory.daily`   = History graph, by day
- `history.annual`   = History report, by year
- `history.monthly`  = History report, by month
- `history.weekly`   = History report, by week
- `history.daily`    = History report, by day
- `ids`              = Filtered list of task IDs
- `information`      = All attributes shown
- `projects`         = Filtered list of projects, with task counts
- `reports`          = List of available reports
- `show`             = Filtered list of configuration settings
- `stats`            = Filtered statistics
- `summary`          = Filtered project summary
- `tags`             = Filtered list of tags
- `timesheet`        = Weekly timesheet report
- `udas`             = Details of all defined UDAs
- `uuids`            = Filtered list of UUIDs


## Helper Commands

- `_aliases`       = List of active aliases
- `_columns`       = List of supported columns
- `_commands`      = List of supported commands
- `_config`        = List of confguration setting names
- `_context`       = List of defined context names
- `_get`           = DOM accessor
- `_ids`           = Filtered list of task IDs
- `_projects`      = Filtered list of project names
- `_show`          = List of name=value configuration settings
- `_tags`          = Filtered list of tags in use
- `_udas`          = List of configured UDA names
- `_unique`        = List of unique values for the specified attribute
- `_urgency`       = Filtered list of task urgencies
- `_uuids`         = Filtered list of pending UUIDs
- `_version`       = Task version (and optional git commit)
- `_zshattributes` = Zsh formatted task attribute list
- `_zshcommands`   = Zsh formatted command list
- `_zshids`        = Zsh formatted ID list
- `_zshuuids`      = Zsh formatted UUID list

Ref:

- [📄 Taskwarrior Commands](https://taskwarrior.org/docs/commands/)
- [📄 Taskwarrior Tags & Virtual tags](https://taskwarrior.org/docs/tags.html)

<br>

# Resources

- [📄 Taskwarrior Recurrence](https://taskwarrior.org/docs/design/recurrence.html)
- [📄 Taskwarrior Durations](https://taskwarrior.org/docs/durations.html)
- [📄 Ending recurring task](https://github.com/GothenburgBitFactory/taskwarrior/issues/2150#issuecomment-488920517)
- [📄 Taskwarrior Commands](https://taskwarrior.org/docs/commands/)
- [📄 Taskwarrior Tags & Virtual tags](https://taskwarrior.org/docs/tags.html)

