---
title: Chapter 7 Discussion
author: Mark Lucernas
date: Nov 11, 2020
---


# Discussion

**Piece.h**

```cpp
#include <string>
using namespace std;

class Piece {
  private:
    string rank;
    string alliance;

  public:
    // Constructor
    Piece(const string &, const string &);
    // Setter
    void setRank(const string);
    void setAlliance(const string);
    // Getter
    string getRank();
    string getAlliance();
};
```

**Piece.cpp**

```cpp
#include <string>
using namespace std;

#include "Piece.h"

Piece::Piece(const string &r, const string &a) : rank(r), alliance(a) {}

void Piece::setRank(const string r) {
  rank = r;
}

void Piece::setAlliance(const string a) {
  alliance = a;
}

string Piece::getRank() {
  return rank;
}

string Piece::getAlliance() {
  return alliance;
}
```

**main.cpp**

```cpp
#include <iostream>
#include <string>
using namespace std;

#include "Piece.cpp"

// Prototype
string createChessBoard(Piece[16], Piece[16]);

// Const
const int ROW_COUNT = 8;
const int COL_COUNT = 8;
const int TOTAL_BOARD_TILES = ROW_COUNT * COL_COUNT;

int main() {
  Piece whitePieces[16] = {
    {"rook1", "white"},
    {"horse1", "white"},
    {"bishop1", "white"},
    {"queen", "white"},
    {"king", "white"},
    {"bishop2", "white"},
    {"horse2", "white"},
    {"rook2", "white"},
    {"pawn1", "white"},
    {"pawn2", "white"},
    {"pawn3", "white"},
    {"pawn4", "white"},
    {"pawn5", "white"},
    {"pawn6", "white"},
    {"pawn7", "white"},
    {"pawn8", "white"},
  };

  Piece blackPieces[16] = {
    {"pawn8", "black"},
    {"pawn7", "black"},
    {"pawn6", "black"},
    {"pawn5", "black"},
    {"pawn4", "black"},
    {"pawn3", "black"},
    {"pawn2", "black"},
    {"pawn1", "black"},
    {"rook2", "black"},
    {"horse2", "black"},
    {"bishop2", "black"},
    {"king", "black"},
    {"queen", "black"},
    {"bishop1", "black"},
    {"horse1", "black"},
    {"rook1", "black"},
  };

  cout << createChessBoard(whitePieces, blackPieces);
}

string createChessBoard(Piece whitePieces[16], Piece blackPieces[16]) {
  string chessBoard = "Chess Board\n\n";
  chessBoard += "    a b c d e f g h\n";
  chessBoard += "    _______________\n";

  // Iteratve over rows
  for (int i = 0; i <= ROW_COUNT / 2 - 1; i++) {
    // Print board coordinate guides
    if (i < 10)
      chessBoard += " " + to_string(i + 1) + " |";
    else
      chessBoard += to_string(i + 1) + " |";

    // Iterate over column
    for (int j = i * COL_COUNT; j < (i + 1) * COL_COUNT; j++) {
      // Print pieces for first two rows
      if (j < ROW_COUNT * 2)
        chessBoard += whitePieces[j].getRank().substr(0, 1);
      else
        chessBoard += "-";
      // Piece inbetween spacings
      chessBoard += " ";
    }
    // Next line
    chessBoard += "\n";
  }

  // Mid board separator
  chessBoard += "   |---------------\n";

  // Iteratve over rows
  for (int i = ROW_COUNT / 2; i < ROW_COUNT; i++) {
    // Print board coordinate guides
    if (i < 10)
      chessBoard += " " + to_string(i + 1) + " |";
    else
      chessBoard += to_string(i + 1) + " |";

    // Iterate over column
    for (int j = (i - 4) * COL_COUNT; j < (i - 3) * COL_COUNT; j++) {
      // Print black pieces into last two rows
      if (j >= ROW_COUNT * 2)
        chessBoard += blackPieces[j - ROW_COUNT * 2].getRank().substr(0, 1);
      else
        chessBoard += "-";
      // Piece inbetween spacings
      chessBoard += " ";
    }
    // Next line
    chessBoard += "\n";
  }

  return chessBoard;
}
```

**OUTPUT**

```
Chess Board

    a b c d e f g h
    _______________
 1 |r h b q k b h r
 2 |p p p p p p p p
 3 |- - - - - - - -
 4 |- - - - - - - -
   |---------------
 5 |- - - - - - - -
 6 |- - - - - - - -
 7 |p p p p p p p p
 8 |r h b k q b h r
```

