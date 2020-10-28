---
title: MySQL Usage
author: Mark Lucernas
date: 2020-07-22
summary: MySQL Usage
---


# MySQL Usage

- [📺 MySQL Tutorial](https://www.youtube.com/watch?v=yPu6qV5byu4)
- [📄 MySQL Tutorial Transcript](https://www.newthinktank.com/2014/08/mysql-video-tutorial/)


## CLI Usage

### Logging In

**Logging in with existing user:**

  - `mysql -u <user> -p`


Example:

```sh
mysql -u root -p
# or with sudo privileges
sudo mysql -u root -p
```

### MySQL Basic Commands

#### Database

> **NOTE**: Replace `<databases_name>` with desired database name. Also do not
forget the semicolon `;` at the end of each commands.

**Show databases**

  - `show databases;`


**Creating Database.**

  - `CREATE DATABASE <database_name>;`


**Pick a database to use**

  - `USE <database_name>;`


**Show currently selected database**

  - `SELECT DATABASE();`


**Destroy database**

  - `DROP DATABASE IF EXISTS <database_name>;`


#### Tables

> **NOTE**: Replace `<table_name>` with desired table name as well as other
general variables delimited by `< >`. Also do not forget the semicolon `;` at
the end of each commands.

**Sample basic table definition:**

This sets `ID` as the `PRIMARY KEY`

```mysql
CREATE TABLE EMPLOYEE(
    ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(100) NOT NULL,
    SALARY DECIMAL(15, 2) NOT NULL,
    DATE_CREATED DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(ID)
);
```

> `NOT NULL` means the table field/column will not accept `Null` values.

- [📄 Connect to MySQL with JDBC driver](https://mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/)

**Sample advanced table definition:**

```mysql
CREATE TABLE student(
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(60) NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(40) NOT NULL,
    state CHAR(2) NOT NULL DEFAULT "PA",
    zip MEDIUMINT UNSIGNED NOT NULL,
    phone VARCHAR(20) NOT NULL,
    birth_date DATE NOT NULL,
    sex ENUM('M', 'F') NOT NULL,
    date_entered TIMESTAMP,
    lunch_cost FLOAT NULL,
    student_id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);
```

> `UNSIGNED` means that all the memory dedicated to the variable are only
positive numbers.

**Sample table with combined `PRIMARY KEY` to make it even more unique:**

```mysql
CREATE TABLE score(
  student_id INT UNSIGNED NOT NULL,
  event_id INT  UNSIGNED NOT NULL,
  score INT NOT NULL,
  PRIMARY KEY(event_id, student_id)
);
```

**Showing all existing tables the current database:**

  - `show tables;`


**Describing specific table's value and attributes:**

  - `DESCRIBE <table_name>;`


**Renaming table(s):**

  - `RENAME TABLE <table_name> to <new_table_name>;`
  - `RENAME TABLE <table_name> to <new_table_name>, <table_name> to
    <new_table_name> ...,`


**Insert values into a table:**

  - `INSERT INTO <table_name> VALUE('value1', 'value2', ...);`


**Sample table insertion (from the sample student table above):**

```mysql
INSERT INTO student VALUE(
  'Dale', 'Cooper', 'dcooper@aol.com',
  '123 Main St',
  'Yakima',
  'WA',
  98901,
  '792-223-8901',
  "1959-2-22",
  'M',
  NOW(), # this puts in the current timestamp
  3.50,
  Null
);
```

**For inserting multiple rows in a table:**

```mysql
INSERT INTO <table_name> VALUE
  ('value1', 'value2', ...),
  ('value3', 'value4', ...),
  ('value5', 'value6', ...),
  ('value7', 'value8', ...);
```


**Getting all information from a table:**

  - `SELECT * FROM <table_name>;`


**Getting information from a specific field name(s) in a table:**

  - `SELECT <field_name> FROM <table_name>;`
  - `SELECT <field_name1>, <field_name2>, ... FROM <table_name>;`


> **NOTE**: specifying field names does not have to be in order. However, the order
it was specified will affect the order the table will be presented.

**Getting all information with field value(s) condition:**

  - `SELECT <field_name>, <field_name2> ... FROM <table_name> WHERE
    <field_name>="<field_value_match_condition>";`


Samples:

  - `SELECT first_name FROM studnts WHERE state="WA";`
  - `SELECT first_name, last_name FROM students WHERE YEAR(birth_date) >= 1965;`
  - `SELECT first_name, last_name, birthsdate FROM studentss WHERE
    MONTH(birth_date) = 2 OR state="CA";`
  - `SELECT first_name, last_name, birthsdate FROM studentss WHERE
    DAY(birth_date) = 12 && (state="CA" || state="NV");`
  - `SELECT last_name FROM students WHERE last_name IS NOT NULL;`


> Other possible comparison operators: `AND` or `&&`, `NOT` or `!`, `OR` or
`||`, and `IS`.

**Ordering selection by specific field values:**

  - `SELECT <field_name1>, <field_name2> ... FROM <table_name> ORDER BY
    <field_name>`


Samples:

  - `SELECT first_name, last_name FROM students ORDER BY last_name;`
  - `SELECT first_name, last_name FROM students ORDER BY last_name DESC;`
  - `SELECT first_name, last_name FROM students ORDER BY state DESC, last_name
    ASC;`


> `ASC` for ascending order and `DESC` for descending order.

**Limits result into specific number**

  - `SELECT <field_name1>, <field_name2> ... FROM <table_name> LIMIT
    <limit_value>`


Samples:

  - `SELECT first_name, last_name FROM students LIMIT 5;` (limits to top 5)
  - `SELECT first_name, last_name FROM students LIMIT 5, 10;` (limits to top 5
    through 10)


**Concatenation fields**

  - `SELECT CONCAT(<field_name1>, " ", <field_name2>) AS <concat_field_name>`


Samples

  - `SELECT CONCAT(first_name, " ", last_name) AS 'Name' FROM students;`
  - `SELECT CONCAT(first_name, " ", last_name) AS 'Name', CONCAT(city, " ",
    state) AS 'Hometown' FROM students;`


**Adding new field(s) in an existing table:**

  - `ALTER TABLE <table_name> ADD <new_field> <field_properties> ...;`
  - `ALTER TABLE student ADD favorite_color NOT NULL;`


**Matching values with `LIKE` keyword**

  - `SELECT <field_name> FROM <table_name> LIKE <pattern>;`


Samples:

  - `SELECT last_name, first_name FROM students WHERE first_name LIKE 'D%' OR
    last_name LIKE '%n';`


> This matches all first name starting with letter 'D' `OR` last_name ending
with letter 'n'. **NOTE**: `%` is a pattern for strings that matches all
characters just like the `*` wildcard for matching fields.

  - `SELECT last_name, first_name FROM students WHERE first_name LIKE '___y'
    FROM students;`


> This matches all values with any (`_`) first three characters that ends with
'y' as the fourth letter.

**Getting only unique values (first matches):**

  - `SELECT DISTINCT <field_name> FROM <table_name>;`


Samples:

  - `SELECT DISTINCT state FROM students ORDER BY state;`


**Counting all values:**

  - `SELECT COUNT(<field_name>) FROM <table_name>;`


Samples:

  - `SELECT COUNT(DISTINCT state) FROM students;`
  - `SELECT COUNT(*) FROM students;`
  - `SELECT COUNT(*) FROM students WHERE sex='M';`


**Modifying field(s) in an existing table:**

```mysql
ALTER TABLE <table_name> CHANGE <field_name> <new_field_name> <new_field_properties>;

ALTER TABLE student CHANGE event_id test_id INT UNSIGNED NOT NULL;
```


<br>

# Resources

- [📺 MySQL Tutorial](https://www.youtube.com/watch?v=yPu6qV5byu4)
- [📄 MySQL Tutorial Transcript](https://www.newthinktank.com/2014/08/mysql-video-tutorial/)
- [📄 Connect to MySQL with JDBC driver](https://mkyong.com/jdbc/how-to-connect-to-mysql-with-jdbc-driver-java/)

