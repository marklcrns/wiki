---
title: Employee Records Generics Sample Code
author: Mark Lucernas
date: 2020-07-10
summary: Sorting an ArrayList of employee records
---


# Sorting an ArrayList of employee records

EmployeeData.java

```java
public class EmployeeData implements Comparable<EmployeeData> {
   private String firstName; // First Name
   private String lastName;  // Last Name
   private Integer emplID;   // Employee ID
   private Integer deptNum;  // Department Number

   EmployeeData(String firstName, String lastName, Integer emplID, Integer deptNum) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.emplID = emplID;
      this.deptNum = deptNum;
   }

   @Override
   public int compareTo(EmployeeData otherEmpl) {
      String fullName;           // Full name, this employee
      String otherFullName;      // Full name, comparison employee
      int comparisonVal;         // Outcome of comparison

      // Compare based on department number first
      comparisonVal = deptNum.compareTo(otherEmpl.deptNum);

      // If in same organization, use name
      if (comparisonVal == 0) {
         fullName = lastName + firstName;
         otherFullName = otherEmpl.lastName + otherEmpl.firstName;
         comparisonVal = fullName.compareTo(otherFullName);
      }

      return comparisonVal;
   }

   @Override
   public String toString() {
      return lastName + " " + firstName +
             "       \tID: " + emplID +
             "\t\tDept. #: " + deptNum;
   }
}
```

EmployeeRecords.java

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class EmployeeRecords {

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<EmployeeData> emplList = new ArrayList<EmployeeData>(); // Stores all employee data
      EmployeeData emplData;                                            // Stores info for one employee
      String userCommand;                                               // User defined add/print/quit command
      String emplFirstName;                                             // User defined employee first name
      String emplLastName;                                              // User defined employee last name
      Integer emplID;                                                   // User defined employee ID
      Integer deptNum;                                                  // User defined employee Dept
      int i;                                                            // Loop counter

      do {
         // Prompt user for input
         System.out.println("Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): ");
         userCommand = scnr.next();

         // Add new employee entry
         if (userCommand.equals("a")) {
            System.out.print("First Name: ");
            emplFirstName = scnr.next();
            System.out.print("Last Name: ");
            emplLastName = scnr.next();
            System.out.print("ID: ");
            emplID = scnr.nextInt();
            System.out.print("Department Number: ");
            deptNum = scnr.nextInt();
            emplData = new EmployeeData(emplFirstName, emplLastName, emplID, deptNum);
            emplList.add(emplData);
         }
         // Print all entries
         else if (userCommand.equals("p")) {

            // Sort employees by department number first
            // and name second
            Collections.sort(emplList);

            System.out.println("");
            System.out.println("Employees: ");
            // Access employee records
            for (i = 0; i < emplList.size(); ++i) {
               System.out.println(emplList.get(i).toString());
            }
            System.out.println("");
         }
      } while (!userCommand.equals("q"));
   }
}
```

Output

```
Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
a
First Name: Michael
Last Name: Faraday
ID: 124
Department Number: 1
Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
a
First Name: Ada
Last Name: Lovelace
ID: 203
Department Number: 2
Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
a
First Name: James
Last Name: Maxwell
ID: 123
Department Number: 1
Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
a
First Name: Alan
Last Name: Turing
ID: 201
Department Number: 2
Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
p

Employees: 
Faraday Michael          ID: 124           Dept. #: 1
Maxwell James            ID: 123           Dept. #: 1
Lovelace Ada             ID: 203           Dept. #: 2
Turing Alan              ID: 201           Dept. #: 2

Enter command ('a' to add new employee, 'p' to print all employees, 'q' to quit): 
q
```


<br>

# Resources

- [📄 Andrew Huang CISC 191: Intermediate Java Programming - zyBooks](https://www.zybooks.com/)
    - Chapter 13 Generics
