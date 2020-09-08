---
title: Java Database Programming
author: Mark Lucernas
date: 2020-07-20
summary: Java Database Programming
---


# Java Database Programming

- [⬇ Database Programming](file:../../../../../../../files/summer-2020/CISC-191/week-6/database.ppt)
- [🌎 SimpleJdbc.java](https://liveexample.pearsoncmg.com/html/SimpleJdbc.html)
- [🌎 FindGrade.java](https://liveexample.pearsoncmg.com/html/FindGrade.html)
- [🌎 FindGradeUsingPreparedStatement.java](https://liveexample.pearsoncmg.com/html/FindGradeUsingPreparedStatement.html)
- [🎬 MySQL Database and Connection Pooling](https://www.youtube.com/watch?v=756JDbYaVzE)


## Database System

### Rational Database and Relational Data Model

Most of today's database systems are relational database systems, based on the
relational data model. A relational data model has three key A relational data
model has three key components: structure, integrity and languages.

- _Structure_ defines the representation of the data.
- _Integrity_ imposes constraints on the data.
- _Language_ provides the means for accessing and manipulating data.

### Relational Structure

A relational database consists of a set of relations. A relation has two things
in one: a _schema_ and an _instance_ of the schema. The schema defines the
relation and an instance is the content of the relation at a given time. An
instance of a relation is nothing more than a table with rows and named columns.
For convenience with no confusion, we refer instances of relations as just
relations or tables.

### Integrity Constraints

An integrity constraint imposes a condition that all legal instances of the
relations must satisfy.  In general, there are three types of constraints:
_domain constraint_, _primary key constraint_, and _foreign key constraint_.
Domain constraints and primary key constraints are known as _intra-relational
constraints_, meaning that a constraint involves only one relation. The foreign
key constraint is known as _inter-relational_, meaning that a constraint
involves more than one relation.

### Domain Constraints

_Domain constraints_ specify the permissible values for an attribute. Domains
can be specified using standard data types such as integers, floating-point
numbers, fixed-length strings, and variant-length strings. The standard data
type specifies a broad range of values. Additional constraints can be specified
to narrow the ranges. You can also specify whether an attribute can be null.

Domain Constraints Example

```sql
create table Course (
  courseId char(5),
  subjectId char(4) not null,
  courseNumber integer,
  title varchar(50) not null,
  numOfCredits integer,
  constraint greaterThanOne
       check (numOfCredits >= 1));
```

### Superkey

A _superkey_ is an attribute or a set of attributes that uniquely identify the
relation. That is, no two tuples have the same values on the superkey. By
definition, a relation consists of a set of distinct tuples. The set of all
attributes in the relation forms a superkey.

### Key and Candidate Key

A _key_ K is a minimal superkey, meaning that any proper subset of K is not a
superkey. It is possible that a relation has several keys. In this case, each of
the keys is called a _candidate_ key.

### Primary Key

The primary key is one of the candidate keys designated by the database
designer. The primary key is often used to identify tuples in a relation.

Primary Key Example

```sql
create table Course(
  subjectCode char(4),
  courseNumber int,
  title varchar(50), numOfCredits int
    constraint greaterThanOne check (numOfCredits >= 1),
  primary key (subjectCode, courseNumber));
```

### Primary key Constraints

The _primary_ key constraint specifies that the primary key value of a tuple
cannot be null and no two tuples in the relation can have the same value on the
primary key. The DBMS enforces the primary key constraint. For example, if you
attempt to insert a record with the same primary key as an existing record in
the table, the DBMS would report an error and reject the operation.

### Foreign Key Constraints

In a relational database, data are related. Tuples in a relation are related and
tuples in different relations are related through their common attributes.
Informally speaking, the common attributes are foreign keys. The _foreign key
constraints_ define the relationships among relations.

Formally, a set of attributes _FK_ is a foreign key in a relation _R_ that
references relation _T_ if it satisfies the following two rules:

- The attributes in _FK_ have the same domain as the primary key in _T_.
- A non-null value on _FK_ in _R_ must match a primary key value in _T_.

Foreign Key Constraints Example

```sql
create table Enrollment (
  ssn char(9),
  courseId char(5),
  dateRegistered date,
  grade char(1),
  primary key (ssn, courseId),
  foreign key (ssn) references Student,
  foreign key (courseId) references Course
);
```


## SQL

Structured Query Language, pronounced S-Q-L, or Sequel

To access or write applications for database systems, you need to use the
Structured Query Language (SQL). SQL is the universal language for accessing
relational database systems. Application programs may allow users to access
database without directly using SQL, but these applications themselves must use
SQL to access the database.


<br>

# Resources

- [⬇ Database Programming](file:../../../../../../../files/summer-2020/CISC-191/week-6/database.ppt)
- [🌎 SimpleJdbc.java](https://liveexample.pearsoncmg.com/html/SimpleJdbc.html)
- [🌎 FindGrade.java](https://liveexample.pearsoncmg.com/html/FindGrade.html)
- [🌎 FindGradeUsingPreparedStatement.java](https://liveexample.pearsoncmg.com/html/FindGradeUsingPreparedStatement.html)
- [🎬 MySQL Database and Connection Pooling](https://www.youtube.com/watch?v=756JDbYaVzE)

