---
title: Basic Git Commands
author: Mark Lucernas
date: 2020-07-29
summary: Basic Git Commands
---


# Basic Git Commands

## Init

Initialize local git repository.

**Create new local git repo**

  - `git init`


## Clone

Clone or download remote repository.

**Cloning remote repository**

  - `git clone https://github.com/<repo-owner>/<repository>.git [cloned-repo-name]`


> `[cloned-repo-name]` is optional to name the repository directory other than
the original name from the remote.

## Status, Add, Commit and Log

**Check git local repo status**

  - `git status`


**Stage new changes for commit**

  - `git add <filename>`
  - `git add .` -- Adds all from the current directory (including subdirectories)


**Commit staged changes**

  - `git commit` -- Default CLI editor will open commit message
  - `git commit -m "Add helpful commit message here"`


**Display commit history**

  - `git log`


> 50/72 rule suggest to compose not more than 50 characters (72 MAX) commit
message for cleaner commit history.

Ref:

  - [Git 50/72 Rule](https://www.midori-global.com/blog/2018/04/02/git-50-72-rule)


## Push

**Pushing commits to remote branch**

  - `git push` -- push all commits to remote branch
  - `git push --force` -- forcefully push all commits to remote branch. This
    will rewrite commit history of remote branch if local branch diverged.


## Pull

Updates local branch of new changes from remote branch

**Pull new changes from remote branch**

  - `git pull`
  - `git pull --all` -- update all local branches


## Fetch

Fetch new changes from remote branch without applying those changes yet.

**Fetch new changes from remote branch**

  - `git fetch`
  - `git fetch --all` -- fetch all local branches


**Log new changes from remote branch after fetching**

  - `git log origin/<branch-name> ^<branch-name>`


**Diff local branch agains new changes from remote branch after fetching**

  - `git diff <branch-name> origin/<branch-name>`


**Checking out latest commits from remote branch after fetching**

```bash
git fetch
git checkout <branch-name> origin/<branch-name>
```

Ref:

  - [Where to find changes due to `git fetch`](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch/10685691)


## Branch

Branch other than the master branch to work on the code base without affecting
the remote main branch (master). Use `merge` or `rebase` to apply changes from
one branch to another.

**Display all local branches**

  - `git branch`


**Display all local and remote branches**

  - `git branch -a`


**Renaming current branch**

```java
git branch -m <new-branch-name>
git push origin -u <new-branch-name>
git push origin --delete <old-branch-name>
```

**Switching local repo to different branch**

  - `git checkout <branch-name>`


**Creating new branch**

  - `git branch <new-branch>`
  - `git checkout -b <new-branch>` -- Creates new branch and checkout.


**Pushing newly created local branch into remote repository**

  - `git push -u origin <branch-name>`


**Delete existing branch (Only locally)**

  - `git branch -d <branch-name>` -- Wont work if theres unmerged changes
  - `git branch -D <branch-name>` -- Force delete while theres still unmerged
    changes


**Delete existing branch from remote after local deletion**

  - `git push origin --delete <remote-branch-name>`


**Using `checkout` command to dispose changes (replacing local changes with
server copy). <br>WARNING: This cannot be undone.**

  - `git checkout <filename>`
  - `git checkout .` -- Will dispose all changes in current directory


Ref:

  - [`Git Branch, Checkout Commands Tutorial](https://www.youtube.com/watch?v=S7SKhR9NVBk)
  - [How to Delete a Git Branch Both Locally and Remotely](https://www.freecodecamp.org/news/how-to-delete-a-git-branch-both-locally-and-remotely/)
  - [How can I tell a local branch to track a remote branch?](https://www.git-tower.com/learn/git/faq/track-remote-upstream-branch)
  - [Rename a Local and Remotee Git Branch](https://linuxize.com/post/how-to-rename-local-and-remote-git-branch/)


## Checkout

**Checking out to previous commits**

  - `git checkout <commit-sha>` -- Checkout to previous commit. `<commit-sha>`
    is the unique commit SHA digits of the commit. Can be found in `git log`
  - `git checkout <branch-name>` -- Going back to latest commit in branch


> NOTE: `git reflog` can also be a checkout reference point.

**Checkout back to last checkout point**

  - `git checkout -`


Ref:

  - [How to get back to the latest commit after checking out a previous commit?](https://stackoverflow.com/a/2427389)


## Merge

Merge changes of one branch to another branch.

**Merging branch to _master_ branch**

```bash
git checkout master
git merge <branch-name>
```

**Merging _master_ branch to another branch**

```bash
git checkout <branch-name>
git merge master
```

Ref:

  - [`Merging Branches Tutorial](https://www.youtube.com/watch?v=XX-Kct0PfFc)


## Rebase

Rebase (re-anchor) current branch commit history against another branch to
latest changes.

**Rebase a branch against master branch**

```bash
git checkout <branch-name>
git rebase master
```

**Rebase master branch against another branch**

```bash
git checkout master
git rebase <branch-name>
```

**Undoing rebase**

  - `git reflog` -- Logs all reference point to reset into
  - `git reset --hard HEAD@{<ref-log-number>}` -- Reset back to specific
    references
  - Sample: `git reset --hard HEAD@{5}` will reset 5 reference point back


Ref:

  - [`A Better Git Workflow with Rebase](https://www.youtube.com/watch?v=f1wnYdLEpgI)
  - [`Git MERGE vs REBASE](https://www.youtube.com/watch?v=CRlGDDprdOQ)
  - [`Undoing a git rebase](https://stackoverflow.com/a/135614)


## Stash

Changes that are not ready to be committed but wants to revert back to previous
commits without loosing those changes can be _stashed_. It will be saved in a
temporary space and can be accessed and applied at anytime and any branch or
commit history.

**Stashing current changes**

  - `git stash`
  - `git stash save "<message>"` -- With stash message

> **NOTE:** You can add the `-p` flag to interactively select hunks from diff or
changes.


> **NOTE:** Stashing changes will be kept until "unstashed" applied. `git status` or
`git diff` will not show the changes that has been stashed.

**Listing all stashed changes**

  - `git stash list`


**Show all stashed changes**

  - `git stash show` -- Show changes from the first stash on the `git stash
    list`
  - `git stash show stash@{<stash-number>}` -- Show changes of specific stash on
    the `git stash list`


**Applying stashed changes**

  - `git stash apply` -- Applies the first stash on the `git stash list`
  - `git stash apply stash@{<stash-number>}` -- Apply specific stash from
    `git stash list`


> **NOTE:** Applying stash does not delete the stash.

**Drops (delete) a stash**

  - `git stash drop` -- Drop the first stash on the `git stash list`
  - `git stash drop stash@{<stash-number>}` -- Drop specific stash from `git stash
    list`
  - `git stash clear` -- Drops all stash


**Apply and drop (delete) stash**

  - `git stash pop` -- Apply and drop the first stash on the `git stash list`
  - `git stash pop stash@{<stash-number>}` -- Apply and drop specific stash from
    `git stash list`


Ref:

  - [`Git Tutorial: Using the Stash Command](https://www.youtube.com/watch?v=KLEDKgMmbBI)
  - [Git stash official docs](https://git-scm.com/docs/git-stash)


## Clean

Cleans the working tree by recursively removing files that are not under version
control, starting from the current directory.

> `[path]` is optional

  - `git clean [path]` -- Clean working tree directory (non-recursive)
  - `git clean -d [path]` -- Clean working tree recursively
  - `git clean -i [path]` -- Clean working tree interactively
  - `git clean -f [path]` -- Clean working tree forcefully
  - `git clean -n [path]` -- Dry-run clean working tree


Ref:

  - [Git clean official docs](https://git-scm.com/docs/git-clean)


## Forking Repos

Make a copy of someone else's repository and make it as your own. You can make
**pull requests** to propose updates from your fork to the original repository,
once approved by the original owner, will merge all commits in forked repo from
when the pull request was made.

**Updating your Fork**

```bash
# add the original repository as remote repository called "upstream"
git remote add upstream https://github.com/<original-owner>/<repository>.git

# fetch all changes from the upstream repository
git fetch upstream

# switch to the master branch of your fork
git checkout master

# merge changes from the upstream repository into your fork
git merge upstream/master
```

Ref:

  - [Github's Fork & Pull Workflow for Git Beginners](https://reflectoring.io/github-fork-and-pull/)


<br>

# Resources

  - [Git 50/72 Rule](https://www.midori-global.com/blog/2018/04/02/git-50-72-rule)
  - [Where to find changes due to `git fetch`](https://stackoverflow.com/questions/10678495/where-to-find-changes-due-to-git-fetch/10685691)
  - [`Git Branch, Checkout Commands Tutorial](https://www.youtube.com/watch?v=S7SKhR9NVBk)
  - [How to Delete a Git Branch Both Locally and Remotely](https://www.freecodecamp.org/news/how-to-delete-a-git-branch-both-locally-and-remotely/)
  - [How can I tell a local branch to track a remote branch?](https://www.git-tower.com/learn/git/faq/track-remote-upstream-branch)
  - [Rename a Local and Remotee Git Branch](https://linuxize.com/post/how-to-rename-local-and-remote-git-branch/)
  - [How to get back to the latest commit after checking out a previous commit?](https://stackoverflow.com/a/2427389)
  - [`Merging Branches Tutorial](https://www.youtube.com/watch?v=XX-Kct0PfFc)
  - [`A Better Git Workflow with Rebase](https://www.youtube.com/watch?v=f1wnYdLEpgI)
  - [`Git MERGE vs REBASE](https://www.youtube.com/watch?v=CRlGDDprdOQ)
  - [`Undoing a git rebase](https://stackoverflow.com/a/135614)
  - [`Git Tutorial: Using the Stash Command](https://www.youtube.com/watch?v=KLEDKgMmbBI)
  - [Git stash official docs](https://git-scm.com/docs/git-stash)
  - [Git clean official docs](https://git-scm.com/docs/git-clean)
  - [Github's Fork & Pull Workflow for Git Beginners](https://reflectoring.io/github-fork-and-pull/)

