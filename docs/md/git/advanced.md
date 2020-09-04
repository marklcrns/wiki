---
title: Advanced Git Commands
author: Mark Lucernas
date: 2020-07-29
summary: Advanced Git Commands
---


# Advanced Git Commands

## Reset

**Discarding recent changes in working tree or in current branch**

  - `git reset HEAD`

**Discarding changes from commit history**

  - `git reset --hard HEAD` -- discard all resent changes
  - `git reset --hard HEAD^` -- discard all changes up to last commit of local
    branch
  - `git reset --hard HEAD~2` -- discard all changes up to last 2 commit of
    local branch. the `2` can be changed to how far to remove changes and
    commits.


> **NOTE:** `--hard` reset cannot be reversed and all the changes will be
**permanently deleted**.

**Uncommitting changes from commit history**

  - `git reset --soft HEAD^` -- uncommit last commit of local repo


**Uncommit and unstage changes from commit history**

  - `git reset --mixed HEAD^` -- uncommit and unstage last commit of local repo


Ref:

- [🌎 What's the difference between git reset --mixed, --soft, and --hard?](https://stackoverflow.com/questions/3528245/whats-the-difference-between-git-reset-mixed-soft-and-hard)
- [🌎 Git reset docs](https://git-scm.com/docs/git-reset)


## Branch

**Fetching all Git branches**

```sh
for remote in `git branch -r`; do git branch --track ${remote#origin/} $remote; done
git fetch --all
git pull --all
```

**Remove tracking branches no longer on remote (Method 1)**

```sh
git checkout master
git remote prune origin
# List all branches merged into the current branch into vim buffer.
# Once loaded in vim, delete branches you want to exclude from branch deletion.
git branch --merged >/tmp/merged-branches && \
  vim /tmp/merged-branches && xargs git branch -d </tmp/merged-branches
```

> **NOTE:** Both this method only removes merged branch and does not remove
unmerged branch that exists in local but not from remote.

**Remove tracking branches no longer on remote (Method 2)**

```sh
git fetch -p && for branch in $(git branch -vv | grep ': gone]' | awk '{print $1}'); do git branch -D $branch; done
# Much safer way
git fetch -p && for branch in $(git for-each-ref --format '%(refname) %(upstream:track)' refs/heads | awk '$2 == "[gone]" {sub("refs/heads/", "", $1); print $1}'); do git branch -D $branch; done
```

> **NOTE:** This removes both merge and unmerged branch. To only remove merged
branch, replace `git branch -D` with `git branch -d`

Ref:

- [🌎 How to fetch all Git branches](https://intellipaat.com/community/3649/git-fetch-all-branches-how-to-fetch-all-git-branches)
- [🌎 Remove tracking branches no longer on remote](https://stackoverflow.com/questions/7726949/remove-tracking-branches-no-longer-on-remote)


## Fetch

**Log all new fetched remote changes**

```sh
# First make sure to
git fetch origin
# Then
git log origin/master ^master # Replace master with <branch-name> for other branch
```

Ref:

- [🌎 Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)


## Remote/Upstream

**Reconfigure URL of git in local repository**

  - `git remote set-url origin https://github.com/<repo-owner>/<repository>.git`


**There is no tracking information for the current branch**

Solution 1:

  - `git pull origin master`


Solution 2: Set it up so that local master branch tracks github master branch as
an upstream:

```sh
git branch --set-upstream-to=origin/master <current-branch>
git pull
```

Ref:

- [🌎 Common problems with GIT](https://ducmanhphan.github.io/2019-02-17-Common-problems-with-git/)


## Merge

**Manual interactive merging (with `git add --interactive`)**

```java
git merge --no-commit --no-ff <branch-to merge> # Merges with branch without committing
git reset HEAD                                  # Unstage all merge changes
git add --interactive                           # Add pieces interactively
```

**Manual interactive merging (with `git mergetool`)**

```java
git merge --no-commit --no-ff <branch-to-merge> # Merges with branch without committing
git mergetool                                   # Resolve conflict manually with graphics
```

**Other very manual way of merging**

```java
# Merges with branch without committing
git merge --no-commit --no-ff <branch-to-merge>

# Then you'll ask git for the file as it appeared in the two branches:
git show HEAD:filename >filename.HEAD
git show branch-to-merge:filename >filename.branch

# and their merge base,
git show `git merge-base HEAD <branch-to-merge>`:filename  >filename.base

# You'll merge them using whatever tool you want (e.g.)
meld filename.{HEAD,branch,base} # meld can be replaced by other diff tools
```

Ref:

- [🌎 Interactive merging with git add --interactive](https://stackoverflow.com/a/22392289)
- [🌎 Interactive merging with git mergetool](https://stackoverflow.com/a/17754621)
- [🌎 Other very manual way of merging with git show](https://stackoverflow.com/a/10935340)


## Difftool

**Use difftool to manually merge two branches with default terminal editor
(preferably Vim or Neovim)**

  - `git difftool <branch-name>`


> While in Vim or Neovim with difftool, use `dp` for diffput or applying changes
from current buffer to the next and `do` for diffget or getting the changes from
the other buffer to the current buffer. `]c` and `[c` to jump to next or
previous diff conflict.

Ref:

- [🌎 How do I prevent an automerge using Git?](https://stackoverflow.com/a/20256067)


## Extras

**Refering to previous commit in commit messages**

Examples:

  - `SHA: be6a8cc1c1ecfe9489fb51e4869af15a13fc2cd2`
  - `User@SHA ref: mojombo@be6a8cc1c1ecfe9489fb51e4869af15a13fc2cd2`
  - `User/Project@SHA: mojombo/god@be6a8cc1c1ecfe9489fb51e4869af15a13fc2cd2`
  - `#Num: #1`
  - `User/#Num: mojombo#1`
  - `User/Project#Num: mojombo/god#1`

Ref:

- [🌎 How to refer to a previous commit in git commit message](https://stackoverflow.com/a/13577344)


<br>

# Resources

- [🌎 What's the difference between git reset --mixed, --soft, and --hard?](https://stackoverflow.com/questions/3528245/whats-the-difference-between-git-reset-mixed-soft-and-hard)
- [🌎 Git reset docs](https://git-scm.com/docs/git-reset)
- [🌎 How to fetch all Git branches](https://intellipaat.com/community/3649/git-fetch-all-branches-how-to-fetch-all-git-branches)
- [🌎 Remove tracking branches no longer on remote](https://stackoverflow.com/questions/7726949/remove-tracking-branches-no-longer-on-remote)
- [🌎 Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)
- [🌎 Common problems with GIT](https://ducmanhphan.github.io/2019-02-17-Common-problems-with-git/)
- [🌎 Interactive merging with git add --interactive](https://stackoverflow.com/a/22392289)
- [🌎 Interactive merging with git mergetool](https://stackoverflow.com/a/17754621)
- [🌎 Other very manual way of merging with git show](https://stackoverflow.com/a/10935340)
- [🌎 How do I prevent an automerge using Git?](https://stackoverflow.com/a/20256067)
- [🌎 How to refer to a previous commit in git commit message](https://stackoverflow.com/a/13577344)

