---
title: Pandoc
subtitle: Installation
author: Mark Lucernas
date: Sep 16, 2020
---


# Installation

## Linux

### Unbuntu

20.04 Focal Fossa

```sh
sudo apt install pandoc
```

# Extras

```sh
sudo apt install pandoc-data
sudo apt install texlive
```

## R-Pandoc

Dependencies

```sh
# R installation
sudo apt install r-base
# Stack installation
curl -sSL https://get.haskellstack.org/ | sh
```

Installation

```sh
git clone https://github.com/cdupont/R-pandoc.git
cd R-pandoc
stack install
```

Ref:

- [📄 Hackage R-pandoc](https://hackage.haskell.org/package/R-pandoc)

## Diagrams-Pandoc

Dependencies
```
sudo apt install haskell-patform
cabal update
cabal install diagrams
```

Installation
```
cabal install diagrams-pandoc
```

<br>

# Resources

- [📄 Hackage R-pandoc](https://hackage.haskell.org/package/R-pandoc)
