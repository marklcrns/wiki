---
title: Advanced Git Commands
author: Mark Lucernas
date: 2020-07-29
summary: Advanced Git Commands
---


# Advanced Git Commands

## Reset

  - [What's the difference between git reset --mixed, --soft, and --hard?](https://stackoverflow.com/questions/3528245/whats-the-difference-between-git-reset-mixed-soft-and-hard)
  - [Git reset docs](https://git-scm.com/docs/git-reset)


**Discarding changes from commit history**

  - `git reset --hard HEAD^` -- discard last commit of local repo
  - `git reset --hard HEAD~2` -- discard last 2 commit of local repo. the `2`
    can be changed to how far to remove commits.


> **NOTE:** `--hard` reset cannot be reversed and all the changes will be
**permanently deleted**.

**Uncommitting changes from commit history**

  - `git reset --soft HEAD^` -- uncommit last commit of local repo


**Uncommit and unstage changes from commit history**

  - `git reset --mixed HEAD^` -- uncommit and unstage last commit of local repo

## Branch

  - [How to fetch all Git branches](https://intellipaat.com/community/3649/git-fetch-all-branches-how-to-fetch-all-git-branches)
  - [Remove tracking branches no longer on remote](https://stackoverflow.com/questions/7726949/remove-tracking-branches-no-longer-on-remote)


**Fetching all Git branches**

```bash
for remote in `git branch -r`; do git branch --track ${remote#origin/} $remote; done
git fetch --all
git pull --all
```

**Remove tracking branches no longer on remote (Method 1)**

```bash
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

```bash
git fetch -p && for branch in $(git branch -vv | grep ': gone]' | awk '{print $1}'); do git branch -D $branch; done
# Much safer way
git fetch -p && for branch in $(git for-each-ref --format '%(refname) %(upstream:track)' refs/heads | awk '$2 == "[gone]" {sub("refs/heads/", "", $1); print $1}'); do git branch -D $branch; done
```

> **NOTE:** This removes both merge and unmerged branch. To only remove merged
branch, replace `git branch -D` with `git branch -d`


## Fetch

  - [Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)

**Log all new fetched remote changes**

```bash
# First make sure to
git fetch origin
# Then
git log origin/master ^master # Replace master with <branch-name> for other branch
```


## Remote/Upstream

  - [Common problems with GIT](https://ducmanhphan.github.io/2019-02-17-Common-problems-with-git/)

**Reconfigure URL of git in local repository**

  - `git remote set-url origin https://github.com/<repo-owner>/<repository>.git`


**There is no tracking information for the current branch**

Solution 1:

  - `git pull origin master`


Solution 2: Set it up so that local master branch tracks github master branch as
an upstream:

```bash
git branch --set-upstream-to=origin/master <current-branch>
git pull
```


<br>

# Resources

  - [What's the difference between git reset --mixed, --soft, and --hard?](https://stackoverflow.com/questions/3528245/whats-the-difference-between-git-reset-mixed-soft-and-hard)
  - [How to fetch all Git branches](https://intellipaat.com/community/3649/git-fetch-all-branches-how-to-fetch-all-git-branches)
  - [Remove tracking branches no longer on remote](https://stackoverflow.com/questions/7726949/remove-tracking-branches-no-longer-on-remote)
  - [Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)
  - [Common problems with GIT](https://ducmanhphan.github.io/2019-02-17-Common-problems-with-git/)

