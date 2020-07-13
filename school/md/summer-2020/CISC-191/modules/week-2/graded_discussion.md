---
title: Week 2 Graded Discussion
author: Mark Lucernas
date: 2020-07-12
summary: Week 2 Graded Discussion entry
---


# Week 2 Graded Discussion

## Part 1

**Q: What are similarities and differences between abstract classes and
interfaces? Does Java allow multiple inheritance? What are the default modifiers
of their methods and variables? What are allowed modifiers of their methods and
variables? Please discuss one example use case of each.**

Abstract classes are similar to interfaces in terms of requiring subclasses to
implement (or override) abstract methods, except interfaces implicitly treat all
methods as abstract without explicitly using the keyword `abstract`. Also,
abstract classes cannot be instantiated because the methods are not implemented,
the same goes for interfaces.

The main difference between abstract classes and interfaces is that abstract
classes may define default variables (class member fields) which can be
inherited by its subclasses, while interfaces are like blueprints of all the
methods required to be implemented.

**The default access modifiers for Interfaces**

  - Variables = public static final
  - Methods = public

***Allowed modifiers for Interfaces***

  - Variables = Variables not allowed in interfaces
  - Methods = public, protected, abstract (optional)

**The default access modifiers for Abstract classes**

  - Variables = static final
  - Methods = public

**Allowed modifiers for Abstract classes**

  - Variables = private, public protected
  - Methods =  protected, public, abstract


## Part 2

**Q: Having read about Polymorphism, come up with a unique example use case of
Polymorphism, overriding at least 1 method in the extending class and implement
at least 1 unique method per child class, and share it with the class. For
example, Shape->Circle, getArea(), and getCircumference(). Please post full java
code using the Preformatted style, including the main class that illustrates the
use case.**

```java
package test;

public class Athlete {
  private String name = "Unnamed";
  private int age = -1;

  /** No-args constructor */
  public Athlete() {}

  /**
   * Constructor that creates instance of an Athletes with name and age
   * @param name Athlete's name
   * @param age Athlete's age
   * @param sports Athlete's sports
   */
  public Athlete(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // ============== Getters and Setters =============== //

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

  /**
   * Prints Athlete's information
   */
  public void printInfo() {
    System.out.println("Athlete Stats:");
    System.out.println("  Name: " + name);
    System.out.println("  Age: " + age);
  }
}
```

```java
package test;

public class Boxer extends Athlete {
  private String name = "Unnamed";
  private int age = -1;
  private String sports = "default";
  private String division;

  /** No-args constructor */
  public Boxer() {}

  /**
   * Constructor that creates instance of a Boxers with name, age, sports, and
   * division.
   * @param name Athlete's name
   * @param age Athlete's age
   * @param sports Athlete's sports
   */
  public Boxer(String name, int age, String sports, String division) {
    super(name, age);
    this.sports = sports;
    this.division = division;
  }

  // ============== Getters and Setters =============== //

  public String getDivision() {
    return division;
  }

  public void setDivision(String division) {
    this.division = division;
  }

  /**
   * Prints Boxers's information
   */
  @Override
  public void printInfo() {
    super.printInfo();
    System.out.println("  Sports: " + sports);
    System.out.println("  Division: " + division);
  }
}
```

```java
package test;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Athlete athlete = new Athlete();
    Boxer boxer = new Boxer("Pacman", 43, "boxing", "Welterweight");
    ArrayList<Athlete> players = new ArrayList<Athlete>();

    // Add all athletes
    players.add(athlete);
    players.add(boxer);

    // Loop over array list of Athletes
    for (Athlete player : players) {
      player.printInfo();
    }
  }
}
```

Output

```
Athlete Stats:
  Name: Unamed
  Age: -1

Athlete Stats:
  Name: Pacman
  Age: 43
  Sports: boxing
  Division: Welterweight
```


## Part 3

**Q: Having read about Interfaces, come up with a unique example use case of an
Interface, with at least one interface method overriden by the implementing
Class.. For example, Animal->Fox, playSound(). Please post full java code using
the Preformatted style, including the main class that illustrates the use
case.**

```java
package test;

public interface Instrument {
  public void playSound();
  public void printInfo();
}
```

```java
package test;

public class KeyboardInstrument implements Instrument {
  private String name = "Piano";

  public KeyboardInstrument() {}

  public KeyboardInstrument(String name) {
    this.name = name;
  }

  // ================ Getters and Setters ================= //

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void playSound() {
    System.out.println("Tene-ne-na nena");
    System.out.println("Tene-ne-na nena niw");
  }

  @Override
  public void printInfo() {
    System.out.println("====================");
    System.out.println("Type: KeyboardInstrument Instrument");
    System.out.println("Name: " + name);
    System.out.println("Sounds like:");
    playSound();
    System.out.println("====================");
  }
}
```

```java
package test;

public class StringInstrument implements Instrument {
  private String name = "Guitar";

  public StringInstrument() {}

  public StringInstrument(String name) {
    this.name = name;
  }

  // ================ Getters and Setters ================= //

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void playSound() {
    System.out.println("Tiw Tiw Tiw...");
    System.out.println("Struum-da-ra-ruuuuuuum");
  }

  @Override
  public void printInfo() {
    System.out.println("====================");
    System.out.println("Type: String Instrument");
    System.out.println("Name: " + name);
    System.out.println("Sounds like:");
    playSound();
    System.out.println("====================");
  }

}
```

```java
package test;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    KeyboardInstrument piano = new KeyboardInstrument("Piano");
    StringInstrument ukelele = new StringInstrument("Ukelele");
    ArrayList<Instrument> instruments = new ArrayList<Instrument>();

    instruments.add(piano);
    instruments.add(ukelele);

    for (Instrument instrument : instruments) {
      instrument.printInfo();
    }
  }
}
```

Output

```
====================
Type: KeyboardInstrument Instrument
Name: Piano
Sounds like:
Tene-ne-na nena
Tene-ne-na nena niw
====================
====================
Type: String Instrument
Name: Ukelele
Sounds like:
Tiw Tiw Tiw...
Struum-da-ra-ruuuuuuum
====================
```

