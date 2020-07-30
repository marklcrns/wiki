---
title: Advanced Git Commands
author: Mark Lucernas
date: 2020-07-29
summary: Advanced Git Commands
---


# Advanced Git Commands

## Branching

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

> **NOTE**: Both this method only removes merged branch and does not remove
unmerged branch that exists in local but not from remote.

**Remove tracking branches no longer on remote (Method 2)**

```bash
git fetch -p && for branch in $(git branch -vv | grep ': gone]' | awk '{print $1}'); do git branch -D $branch; done
# Much safer way
git fetch -p && for branch in $(git for-each-ref --format '%(refname) %(upstream:track)' refs/heads | awk '$2 == "[gone]" {sub("refs/heads/", "", $1); print $1}'); do git branch -D $branch; done
```

> **NOTE**: This removes both merge and unmerged branch. To only remove merged
branch, replace `git branch -D` with `git branch -d`


## Fetching

  - [Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)

**Log all new fetched remote changes**

```bash
# First make sure to
git fetch origin
# Then
git log origin/master ^master # Replace master with <branch-name> for other branch
```


<br>

# Resources

  - [How to fetch all Git branches](https://intellipaat.com/community/3649/git-fetch-all-branches-how-to-fetch-all-git-branches)
  - [Remove tracking branches no longer on remote](https://stackoverflow.com/questions/7726949/remove-tracking-branches-no-longer-on-remote)
  - [Where to find chances due to git fetch](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch)

