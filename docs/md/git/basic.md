---
title: Basic Git Commands
author: Mark Lucernas
date: 2020-07-29
summary: Basic Git Commands
---


# Basic Git Commands

## Init and Cloning

**Initialize local git repository**

  - `git init`


**Cloning remote repository**

  - `git clone https://github.com/SomeUsername/UserRepository.git [cloned-repo-name]`


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

  - [Git 50/72 Rule](https://www.midori-global.com/blog/2018/04/02/git-50-72-rule)


## Branching

  - [`Git Branch, Checkout Commands Tutorial](https://www.youtube.com/watch?v=S7SKhR9NVBk)
  - [How to Delete a Git Branch Both Locally and Remotely](https://www.freecodecamp.org/news/how-to-delete-a-git-branch-both-locally-and-remotely/)


**Display all local branches**

  - `git branch`


**Display all local and remote branches**

  - `git branch -a`


**Switching local repo to different branch**

  - `git checkout <branch-name>`


**Creating new branch**

  - `git branch <new-branch>`
  - `git checkout -b <new-branch>` -- Creates new branch and checkout.


**Delete existing branch (Only locally)**

  - `git branch -d <branch-name>` -- Wont work if theres unmerged changes
  - `git branch -D <branch-name>` -- Force delete while theres still unmerged
    changes


**Delete existing branch from remote**

  - `git push origin --delete <remote-branch-name>`


**Using `checkout` command to dispose changes (replacing local changes with
server copy). <br>WARNING: This cannot be undone.**

  - `git checkout <filename>`
  - `git checkout .` -- Will dispose all changes in current directory


### Branch Merging

  - [`Merging Branches Tutorial](https://www.youtube.com/watch?v=XX-Kct0PfFc)

**Merging branch to _master_ branch**

```bash
git checkout master
git merge <branch-name>
```


## Stash

Changes that are not ready to be committed but wants to revert back to previous
commits without loosing those changes can be _stashed_. It will be saved in a
temporary space and can be accessed and applied at anytime and any branch or
commit history.

  - [`Git Tutorial: Using the Stash Command](https://www.youtube.com/watch?v=KLEDKgMmbBI)
  - [Git Stash Docs](https://git-scm.com/docs/git-stash)


**Stashing current changes**

  - `git stash`
  - `git stash save "<message>"` -- With stash message


> **NOTE**: Stashing changes will be kept until "unstashed" applied. `git status` or
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


> **NOTE**: Applying stash does not delete the stash.

**Drops (delete) a stash**

  - `git stash drop` -- Drop the first stash on the `git stash list`
  - `git stash drop stash@{<stash-number>}` -- Drop specific stash from `git stash
    list`
  - `git stash clear` -- Drops all stash


**Apply and drop (delete) stash**

  - `git stash pop` -- Apply and drop the first stash on the `git stash list`
  - `git stash pop stash@{<stash-number>}` -- Apply and drop specific stash from
    `git stash list`


<br>

# Resources

  - [Git 50/72 Rule](https://www.midori-global.com/blog/2018/04/02/git-50-72-rule)
  - [`Git Branch, Checkout Commands Tutorial](https://www.youtube.com/watch?v=S7SKhR9NVBk)
  - [How to Delete a Git Branch Both Locally and Remotely](https://www.freecodecamp.org/news/how-to-delete-a-git-branch-both-locally-and-remotely/)
  - [`Merging Branches Tutorial](https://www.youtube.com/watch?v=XX-Kct0PfFc)
  - [`Git Tutorial: Using the Stash Command](https://www.youtube.com/watch?v=KLEDKgMmbBI)
  - [Git Stash Docs](https://git-scm.com/docs/git-stash)

