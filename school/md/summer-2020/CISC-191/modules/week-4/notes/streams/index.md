---
title: Streams and IOStreams
author: Mark Lucernas
date: 2020-07-09
summary: CISC 191 Week 4 Streams and IOStreams notes
---


# Streams and IOStreams

- [⬇ Textt I/O](file:../../../../../../../files/summer-2020/CISC-191/week-4/text_io.ppt)
- [🎬 Java 8 Lambda Expressions & Streams](https://www.youtube.com/watch?v=8pDm_kH4YKY)
- [🎬 Java Streams: Beyond The Basics](https://www.youtube.com/watch?v=TCJdc9SYwlQ)


## Output and Input Streams

### OutputStream and System.out

Programs need a way to output data to a screen, file, or elsewhere. An
OutputStream is a class that supports output. OutputStream provides several
overloaded methods for writing a sequence of bytes to a destination. That
sequence is normally placed into a buffer, and the system then outputs the
buffer at various times.

The `print()` and `println()` methods are overloaded in order to support the
various standard data types, such as int, boolean, float, etc., each method
converting that data type to a sequence of characters. These methods also
provide support for reference types. When a programmer invokes either method
with a reference type argument the method prints a string representation of the
object consisting of the object's class name followed by the "@" character and
the hexadecimal value of the object's hash code. A hash code typically
represents the object's address in memory, although this is not guaranteed by
the Java specification.

**System.out** is a predefined OutputStream object reference that is associated with
a system's standard output, usually a computer screen. The System class' out
variable is a reference derived from OutputStream called a **PrintStream** (declared
as PrintStream out; in the System class). The PrintStream class extends the base
functionality of the OutputStream class and provides the `print()` and
`println()` methods for converting different types of data into a sequence of
characters.  Note that because the System class is predefined, a programmer is
not required to import the System class in order to use the output stream
System.out.

```java
System.out.print("Age");
System.out.print(ageYears);
```

### InputStream and System.in

Programs need to receive input data, whether from a keyboard, touchscreen, or
elsewhere. An **InputStream** is a class for achieving such input. InputStream
provides several overloaded `read()` methods that allow a programmer to extract
bytes from a particular source.

**System.in** is a predefined input stream object reference that is associated
with a system's standard input, which is usually a keyboard. A programmer is not
required to import the System class in order to use System.in because the System
class is a predefined class.

The System.in input stream automatically reads the standard input from a memory
region, known as a buffer, that the operating system fills with the input data.

```java
import java.io.IOException;

public class InputStreamReader {
   public static void main (String[] args)
   throws IOException {
      int usrInput;

      // Read 1st byte
      usrInput = System.in.read();
      // Read 2nd byte
      usrInput = System.in.read();
      // Read 3rd byte
      usrInput = System.in.read();
      // Read 4th byte
      usrInput = System.in.read();
      // Read 5th byte (empty buffer)
      usrInput = System.in.read();
   }
}
```

### Byte stream, throws clause, and Scanner

<a name="byte-stream-term">**Byte stream**</a>

  - is used by programs to input or output 8-bits (a byte). System.in is an
    input byte stream, and thus the read() method reads the first 8-bit ASCII
    value available from the operating system's buffer.
  - Each 8-bit value read from the input stream is returned as an int (instead
    of byte) in order to allow the programmer to determine if data is no longer
    available, which is indicated by a return value of -1.

When using an InputStream, a programmer must append the clause throws
IOException to the definition of main(), as seen in the above animation. A
**throws clause** tells the Java virtual machine that the corresponding method may
exit unexpectedly due to an **exception**, which is an event that disrupts a
program's execution. In this case, the throws clause indicates that the program
may terminate due to an input/output exception (IOException). A program can
throw an IOException when it encounters certain errors as it is trying to read
from an input stream. Exceptions and how to handle them are discussed in more
detail elsewhere.

As seen from previous examples, a programmer often needs a way to extract
strings or integers from an input stream. Instead of directly reading bytes from
System.in, a program typically uses the Scanner class as a wrapper that augments
System.in by automatically scanning a sequence of bytes and converting those
bytes to the desired data type. To initialize a Scanner object, a programmer can
pass an InputStream, such as System.in, as an argument to the constructor as in
Scanner `scnr = new Scanner(System.in);`. Basic use of the Scanner object is
discussed in earlier sections.

```java
import java.util.Scanner;

public class Salary {
   public static void main(String [] args) {
      int wage;

      Scanner scnr = new Scanner(System.in);
      wage = scnr.nextInt();

      System.out.print("Salary is ");
      System.out.println(wage * 40 * 50);
   }
}
```

## Output Formatting

## printf() and format() methods

A programmer can adjust the way that a program's output appears, a task known as
**output formatting**. The standard output stream System.out provides the methods
`printf()` and `format()` for output formatting. Both methods are equivalent, so
this discussion only refers to `printf().`

The first argument of the `printf()` method, the **format string**, specifies
the format of the text to print along with any number of placeholders for
printing numeric values. The placeholders are known as format specifiers. A
**format specifier** specifies the type of value to print in its place. A format
specifier begins with the % character followed by another character that
indicates the value type to be printed. Ex: %d indicates an integer type, and %s
indicates a string type.

```java
String account = "Prime";
double total = 210.35;
int years = 5;

System.out.printf("The %s account saved you $%f over %d years\n",
    account, total, years);
```

| Format specifier | Data type(s)           | Notes                                                  |
|------------------|------------------------|--------------------------------------------------------|
| `%c`             | char                   | Prints a single Unicode character                      |
| `%d`             | int, long, short       | Prints a decimal integer value.                        |
| `%o`             | int, long, short       | Prints an octal integer value.                         |
| `%h`             | int, char, long, short | Prints a hexadecimal integer value.                    |
| `%f`             | float, double          | Prints a floating-point value.                         |
| `%e`             | float, double          | Prints a floating-point value in scientific notation.  |
| `%s`             | String                 | Prints the characters in a String variable or literal. |
| `%%`             |                        | Prints the "%" character.                              |
| `%n`             |                        | Prints the platform-specific new-line character.       |

### Floating-point values

Formatting floating-point output is commonly done using **sub-specifiers**. A
sub-specifier provides formatting options for a format specifier and are
included between the % and format specifier character. Ex: The .1 sub-specifier
in `printf("%.1f", myFloat);` causes the floating-point variable myFloat to be
output with only 1 digit after the decimal point; if myFloat is 12.34, the
output would be 12.3. Format specifiers and sub-specifiers use the following
form:

> Format Specifiers and Sub-specifiers

```java
%(flags)(width)(.precision)specifier
```

width

  - Specifies the minimum number of characters to print. If the formatted value
    has more characters than the width, the value will not be truncated. If the
    formatted value has fewer characters than the width, the output will be
    padded with spaces (or 0's if the '0' flag is specified).


```java
printf("Value: %7.2f", myFloat);
Value:   12.34
```

.precision

  - Specifies the number of digits to print following the decimal point. If the
    precision is not specified, a default precision of 6 is used.


```java
printf("%.4f", myFloat);
12.3400

printf("%3.4e", myFloat);
1.2340e+01
```

flags

  - `-` Left aligns the output given the specified width, padding the output
    with spaces.
  - `+` Prints a preceding + sign for positive values. Negative numbers are
    always printed with the - sign.  0: Pads the output with 0's when the
    formatted value has fewer characters than the width.  space: Prints a
    preceding space for positive value.


```java
printf("%+f", myFloat);
+12.340000

printf("%08.2f", myFloat);
00012.34
```

> Example output formatting for floating-point numbers.

```java
import java.util.Scanner;

public class FlyDrive {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double miles;          // User defined distance
      double hoursFly;       // Time to fly distance
      double hoursDrive;     // Time to drive distance

      // Prompt user for distance
      System.out.print("Enter a distance in miles: ");
      miles = scnr.nextDouble();
      // Calculate the correspond time to fly/drive distance

      hoursFly = miles / 500.0;
      hoursDrive = miles / 60.0;

      // Output resulting values
      System.out.printf("%.2f miles would take:\n", miles);
      System.out.printf("%.2f hours to fly\n", hoursFly);
      System.out.printf("%.2f hours to drive\n", hoursDrive);
   }
}
```

Output

```
Enter a distance in miles: 10.3
10.30 miles would take:
0.02 hours to fly
0.17 hours to drive
```

### Integer values

Formatting of integer values is also done using sub-specifiers. The integer
sub-specifiers are similar to the floating-point sub-specifiers except no
.precision exists. For the table below, assume myInt is 301.

> Integer formatting.

width

  - Specifies the minimum number of characters to print. If the formatted value
    has more characters than the width, the value will not be truncated. If the
    formatted value has fewer characters than the width, the output will be
    padded with spaces (or 0's if the '0' flag is specified).


```java
printf("Value: %7d", myInt);
Value:     301
```

flags

  - `-` Left aligns the output given the specified width, padding the output
    with spaces.
  - `+` Print a preceding + sign for positive values. Negative numbers are
    always printed with the - sign.  0: Pads the output with 0's when the
    formatted value has fewer characters than the width.  space: Prints a
    preceding space for positive value.


```java
printf("%+d", myInt);
+301

printf("%08d", myInt);
00000301

printf("%+08d", myInt);
+0000301
```

> Output formatting for integers.

```java
public class CelestialBodyDist {
   public static void main(String[] args) {
      final long KM_EARTH_TO_SUN = 149598000;    // Dist from Earth to sun
      final long KM_SATURN_TO_SUN = 1433449370;  // Dist from Saturn to sun

      // Output distances with min number of characters
      System.out.printf("Earth is %12d", KM_EARTH_TO_SUN);
      System.out.printf(" kilometers from the sun.\n");
      System.out.printf("Saturn is %11d", KM_SATURN_TO_SUN);
      System.out.printf(" kilometers from the sun.\n");
   }
}
```

Output

```
Earth is    149598000 kilometers from the sun.
Saturn is  1433449370 kilometers from the sun.
```

### Strings

> String formatting.

width

  - Specifies the minimum number of characters to print. If the string has more
    characters than the width, the value will not be truncated. If the
    formatted value has fewer characters than the width, the output will be
    padded with spaces.


```java
printf("%20s String", myString);
          Formatting String
```

.precision

  - Specifies the maximum number of characters to print. If the string has more
    characters than the precision, the string will be truncated.


```java
printf("%.6s", myString);
Format
```

flags

  - `-` Left aligns the output given the specified width, padding the output
    with spaces.


```java
printf("%-20s String", myString);
Formatting           String
```

> Example output formatting for Strings.

```java
public class DogAge {
   public static void main(String[] args) {

      System.out.printf("Dog age in human years (dogyears.com)\n\n");
      System.out.printf("-------------------------\n");

         // set num char for each column, left aligned
      System.out.printf("%-10s | %-12s\n", "Dog age", "Human age");
      System.out.printf("-------------------------\n");

      // set num char for each column, first col left aligned
      System.out.printf("%-10s | %12s\n", "2 months", "14 months");
      System.out.printf("%-10s | %12s\n", "6 months", "5 years");
      System.out.printf("%-10s | %12s\n", "8 months", "9 years");
      System.out.printf("%-10s | %12s\n", "1 year", "15 years");
      System.out.printf("-------------------------\n");
   }
}
```

Output

```
Dog age in human years (dogyears.com)

-------------------------
Dog age    | Human age
-------------------------
2 months   |    14 months
6 months   |      5 years
8 months   |      9 years
1 year     |     15 years
-------------------------
```

### Flushing output

Printing characters from the buffer to the output device (e.g., screen)
requires a time-consuming reservation of processor resources. Once the
resources are reserved, moving characters is fast, whether there is 1 character
or 50 characters to print.

To preserve resources, the system may wait until the buffer is full, or at
least has a certain number of characters before moving them to the output
device. Or, with fewer characters in the buffer, the system may wait until the
resources are not busy. Sometimes a programmer does not want the system to
wait. Ex: In a very processor-intensive program, waiting could cause delayed
and/or jittery output.

The PrintStream method `flush()` flushes the stream's buffer contents. Ex: The
statement `System.out.flush();` writes the contents of the buffer for
System.out to the computer screen. Most Java implementations make System.out
flush when a newline character is output or `println()` method is called.

## Streams Using Strings

Sometimes a programmer wishes to read input data from a string rather than from
the keyboard (standard input). A programmer can associate a Scanner object with
a String rather than with the keyboard (standard input). Such an object can be
used just like a Scanner object associated with the System.in stream. A Scanner
object initialized from a String is often referred to as an **input string
stream**. The following program illustrates.

> Reading from a String using a Scanner object.

```java
import java.util.Scanner;

public class StringInputStream {
   public static void main(String[] args) {
      Scanner inSS = null;              // Input string stream
      String userInfo;                  // Input string
      String firstName;                 // First name
      String lastName;                  // Last name
      int userAge;                      // Age

      userInfo = "Amy Smith 19";

      // Init scanner object with string
      inSS = new Scanner(userInfo);

      // Parse name and age values from string
      firstName = inSS.next();
      lastName = inSS.next();
      userAge = inSS.nextInt();

      // Output parsed values
      System.out.println("First name: " + firstName);
      System.out.println("Last name: " + lastName);
      System.out.println("Age: " + userAge);
   }
}
```

Output

```
First name: Amy
Last name: Smith
Age: 19
```

> Using a string stream to process a line of input text.

```java
import java.util.Scanner;

public class ProcessInputText {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in); // Input stream for standard input
      Scanner inSS = null;                   // Input string stream
      String lineString;                     // Holds line of text
      String firstName;                      // First name
      String lastName;                       // Last name
      int userAge;                           // Age
      boolean inputDone;                     // Flag to indicate next iteration

      inputDone = false;

      // Prompt user for input
      System.out.println("Enter \"firstname lastname age\" on each line");
      System.out.println("(\"Exit\" as firstname exits).\n");

      // Grab data as long as "Exit" is not entered
      while (!inputDone) {

         // Entire line into lineString
         lineString = scnr.nextLine();

         // Create new input string stream
         inSS = new Scanner(lineString);

         // Now process the line
         firstName = inSS.next();

         // Output parsed values
         if (firstName.equals("Exit")) {
            System.out.println("   Exiting.");

            inputDone = true;
         }
         else {
            lastName = inSS.next();
            userAge = inSS.nextInt();

            System.out.println("   First name: " + firstName);
            System.out.println("   Last name: " + lastName);
            System.out.println("   Age: " + userAge);
            System.out.println();
         }
      }
   }
}
```

Output

```
Enter "firstname lastname age" on each line
("Exit" as firstname exits).

Mary Jones 22
   First name: Mary
   Last name: Jones
   Age: 22

Mike Smith 24
   First name: Mike
   Last name: Smith
   Age: 24

Exit
   Exiting.
```

The `StringWriter` class provides a character stream that allows a programmer
to output characters. The PrintWriter class is a wrapper class that augments
character streams, such as StringWriter, with `print()` and `println()` methods
that allow a programmer to output various data types (e.g., int, double,
String, etc.) to the underlying character stream in a manner similar to
System.out.

To create a PrintWriter object, the program must first create a StringWriter,
passing the StringWriter object to the constructor for the PrintWriter. Once
the PrintWriter object is created, a program can insert characters into that
stream using `print()` and `println().` The program can then use the
StringWriter's `toString()` method to copy that buffer to a String.

> Creating a String using streams.

```java
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.StringWriter;

public class StringOutputStream {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Basic character stream for fullname
      StringWriter fullnameCharStream = new StringWriter();
      // Augments character stream (fullname) with print()
      PrintWriter fullnameOSS = new PrintWriter(fullnameCharStream);
      // Basic character stream for age
      StringWriter ageCharStream = new StringWriter();
      // Augments character stream (age) with print()
      PrintWriter ageOSS = new PrintWriter(ageCharStream);

      String firstName;      // First name
      String lastName;       // Last name
      String fullName;       // Full name (first and last)
      String ageStr;         // Age (string)
      int userAge;           // Age

      // Prompt user for input
      System.out.print("Enter \"firstname lastname age\": \n   ");
      firstName = scnr.next();
      lastName = scnr.next();
      userAge = scnr.nextInt();

      // Writes formatted string to buffer, copies from underlying char buffer
      fullnameOSS.print(lastName + ", " + firstName);
      fullName = fullnameCharStream.toString();

      // Output parsed input
      System.out.println("\n   Full name: " + fullName);

      // Writes int age as characters to buffer
      ageOSS.print(userAge);

      // Appends (minor) to object if less than 21, then
      // copies buffer into string
      if (userAge < 21) {
         ageOSS.print(" (minor)");
      }

      ageStr = ageCharStream.toString();

      // Output string
      System.out.println("   Age: " + ageStr);
   }
}
```

Output

```
Enter "firstname lastname age":
   Mary Jones 22

   Full name: Jones, Mary
   Age: 22

...

Enter "firstname lastname age":
   Sally Smith 14

   Full name: Smith, Sally
   Age: 14 (minor)
```


## File Input

### Opening and reading from a file

Sometimes a program should get input from a file rather than from a user typing
on a keyboard. To read file input, a programmer can create a new input stream
that comes from a file, rather than the predefined input stream System.in that
comes from the standard input (keyboard). An input stream can then be used just
like the familiar Scanner and System.in combination.

The statement `fileByteStream = new FileInputStream(str);` creates a file input
stream and opens the file denoted by a String variable, str, for reading.
FileInputStream's constructor also allows a programmer to pass the filename as a
String literal. Ex: fileByteStream = new FileInputStream("numFile.txt");

> Input from a file.

```java
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadNums {
   public static void main (String[] args) throws IOException {
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      int fileNum1;                          // Data value from file
      int fileNum2;                          // Data value from file

      // Try to open file
      System.out.println("Opening file numFile.txt.");
      fileByteStream = new FileInputStream("numFile.txt");
      inFS = new Scanner(fileByteStream);

      // File is open and valid if we got this far
      // (otherwise exception thrown)
      // numFile.txt should contain two integers, else problems
      System.out.println("Reading two integers.");
      fileNum1 = inFS.nextInt();
      fileNum2 = inFS.nextInt();

      // Output values read from file
      System.out.println("num1: " + fileNum1);
      System.out.println("num2: " + fileNum2);
      System.out.println("num1+num2: " + (fileNum1 + fileNum2));

      // Done with file, so try to close it
      System.out.println("Closing file myfile.txt.");
      fileByteStream.close(); // close() may throw IOException if fails
   }
}
```

### Reading until the end of the file

A program can read varying amounts of data in a file by using a loop that reads
until valid data is unavailable or the end of the file has been reached. The
`hasNextInt()` method returns true if an integer is available for reading. If
the next item in the file is not an integer or if the previous stream operation
reached the end of the file, the method returns false. The Scanner class offers
multiple `hasNext()` methods for various data types such as int, double, String,
etc.

> Reading a varying amount of data from a file.

```java
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReadVaryingAmount {
   public static void main(String[] args) throws IOException {
      FileInputStream fileByteStream = null; // File input stream
      Scanner inFS = null;                   // Scanner object
      int fileNum;                           // Data value from file

      // Try to open file
      System.out.println("Opening file myfile.txt.");
      fileByteStream = new FileInputStream("myfile.txt");
      inFS = new Scanner(fileByteStream);

      // File is open and valid if we got this far (otherwise exception thrown)
      System.out.println("Reading and printing numbers.");

      while (inFS.hasNextInt()) {
         fileNum = inFS.nextInt();
         System.out.println("num: " + fileNum);
      }

      // Done with file, so try to close it
      System.out.println("Closing file myfile.txt.");
      fileByteStream.close(); // close() may throw IOException if fails
   }
}
```

myFile.txt

```txt
111
222
333
444
555
```

Output

```
Opening file myfile.txt.
Reading and printing numbers.
num: 111
num: 222
num: 333
num: 444
num: 555
Closing file myfile.txt.
```


## File Output

### Opening and writing to a file

A FileOutputStream is a class that supports writing to a file. The
FileOutputStream class inherits from OutputStream.

After declaring a variable of type FileOutputStream, a file is opened using the
FileOutputStream's constructor, which can take a file name string as an
argument. The constructor throws an exception if the file cannot be opened for
writing.

FileOutputStream only contains methods for writing bytes. To write strings and
other common data types, a PrintWriter is commonly used. A PrintWriter has
methods such as print() and println() and can be constructed from any
OutputStream.

> Basic steps for opening and writing a file.

```java
FileOutputStream fileStream = new FileOutputStream("helloWorld.txt");
PrintWriter outFS = new PrintWriter(fileStream);
outFS.println("Hello World!");
fileStream.close();
```

> Writing to an output text file.

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileWriteSample {
   public static void main(String[] args) throws IOException {
      FileOutputStream fileStream = null;
      PrintWriter outFS = null;

      // Try to open file
      fileStream = new FileOutputStream("myoutfile.txt");
      outFS = new PrintWriter(fileStream);

      // Arriving here implies that the file can now be written
      // to, otherwise an exception would have been thrown.
      outFS.println("Hello");
      outFS.println("1 2 3");
      outFS.flush();

      // Done with file, so try to close
      // Note that close() may throw an IOException on failure
      fileStream.close();
   }
}
```

> Writing simple html to a file and to the console.

```java
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HTMLFileWriteSample {
   static void writeHTMLFile(PrintWriter printer, String innerHTML) {
      printer.println("<!DOCTYPE html>");
      printer.println("<html>");
      printer.println("  <body>");
      printer.println("    <p>" + innerHTML + "</p>");
      printer.println("  </body>");
      printer.println("</html>");
   }
   public static void main(String[] args) throws IOException {
      // Open an output file stream and create a PrintWriter
      FileOutputStream fileStream = new FileOutputStream("simple.html");
      PrintWriter filePrinter = new PrintWriter(fileStream);

      // Write the HTML file, then close filePrinter
      writeHTMLFile(filePrinter, "Hello <b>HTML</b> world!");
      filePrinter.close();

      // Use the same function, writeHTMLFile, to write to the console
      PrintWriter systemOutPrinter = new PrintWriter(System.out);
      writeHTMLFile(systemOutPrinter, "Hello <b>HTML</b> world!");
   }
}
```

Console

```md
<!DOCTYPE html>
<html>
<body>
 <p>Hello <b>HTML</b> world!</p>
</body>
</html>
```

simple.html file contents

```html
<!DOCTYPE html>
<html>
<body>
 <p>Hello <b>HTML</b> world!</p>
</body>
</html>
```


<br>

# Resources

- [⬇ Textt I/O](file:../../../../../../../files/summer-2020/CISC-191/week-4/text_io.ppt)
- [🎬 Java 8 Lambda Expressions & Streams](https://www.youtube.com/watch?v=8pDm_kH4YKY)
- [🎬 Java Streams: Beyond The Basics](https://www.youtube.com/watch?v=TCJdc9SYwlQ)


Textbook

+ [🌎 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 9 Input / Output

