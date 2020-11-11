---
title: Chapter 4 Discussion
subtitle: (INSERT SUBTITLE)
author: Mark Lucernas
date: Nov 11, 2020
---


# Discussion

1. If the time is between 09:00 to 10:59 and 12:00 to 17:59 , I will reply "I'm
   busy!". Else, if the time is between 00:00 to 05:59 and 23:00 to 24:59, I
   will reply "Zzz..." Otherwise, I will reply "I'm NOT busy".

2.

```cpp
#include <iostream>
#include <ctime>
using namespace std;

bool isWorking() {
  time_t t = std::time(0);   // get time now
  tm* now = std::localtime(&t);
  if (now -> tm_hour >= 9 and now -> tm_hour <= 10)      { return true; }
  else if(now -> tm_hour >= 12 and now -> tm_hour <= 17) { return true; }
  return false;
}

bool isSleeping() {
  time_t t = std::time(0);   // get time now
  tm* now = std::localtime(&t);
  if (now -> tm_hour >= 22 and now -> tm_hour <= 5) { return true; }
  return false;
}

void busy() {
  cout << "I'm busy!" << endl;
}

void notBusy() {
  cout << "I'm NOT busy" << endl;
}

void sleep() { cout << "Zzz..." << endl; }

int main() {
  if (isSleeping())     { sleep(); }
  else if (isWorking()) { busy(); }
  else                  { notBusy(); }

  return 0;
}
```

3.

```cpp
time_t t = std::time(0);   // get time now
tm* now = std::localtime(&t);

switch(now -> tm_hour) {
  case 0:  sleep();   break;
  case 1:  sleep();   break;
  case 2:  sleep();   break;
  case 3:  sleep();   break;
  case 4:  sleep();   break;
  case 5:  sleep();   break;
  case 6:  notBusy(); break;
  case 7:  notBusy(); break;
  case 8:  notBusy(); break;
  case 9:  busy();    break;
  case 10: busy();    break;
  case 11: notBusy(); break;
  case 12: busy();    break;
  case 13: busy();    break;
  case 14: busy();    break;
  case 15: busy();    break;
  case 16: busy();    break;
  case 17: notBusy(); break;
  case 18: notBusy(); break;
  case 19: notBusy(); break;
  case 20: notBusy(); break;
  case 21: notBusy(); break;
  case 22: notBusy(); break;
  case 23: sleep();   break;
  case 24: sleep();   break;
}
```

4.

```cpp
isSleeping() ? sleep() : isWorking() ? busy() : notBusy();
```

5. In terms of readability, the switch statement seems to be a more
   straightforward approach than the other two approach, but is the least
   efficient. Next is the if/else statement and conditional operator being the
   least.

   If/else  statement and the conditional operator, in my opinion, are equal in
   portability and the switch statement being the least.

   Finally, performance wise, I am not sure about the time and space complexity
   of the if/else statement and conditional operator but it seems to me that
   they are both linear, while the switch statement as a bit faster since its
   constant time?

   Overall, for this case, I would settle for the if/else statement for the
   readability and portability.

