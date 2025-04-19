# Student-Data-Entry


This repository contains a Java application for managing student records. It provides CRUD operations (Create, Read, Update, Delete) via a console-based menu, with robust input validation and custom exception handling.

---

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Package `studentdata`](#package-studentdata)
  - [`Student`](#class-student)
  - [`StudentManager`](#class-studentmanager)
  - [`Main`](#class-main)
- [Package `studentdata.exceptions`](#package-studentdataexceptions)
  - [`StudentDataException`](#class-studentdataexception)
  - [`InvalidDataException`](#class-invaliddataexception)
  - [`DataNotFoundException`](#class-datanotfoundexception)
  - [`OperationFailedException`](#class-operationfailedexception)
- [How to Run](#how-to-run)
- [Contributing](#contributing)

---

## Overview

The Student Data Entry System lets you:

1. **Add** a new student with PRN, name, date of birth, and marks.
2. **Display** all existing student records.
3. **Search** for a student by PRN.
4. **Update** a student’s information by PRN.
5. **Delete** a student’s record by PRN.

Custom exceptions ensure invalid input and operational errors are reported clearly.

---

## Prerequisites

- Java 11 or higher
- Maven or any Java build tool
- Git for version control

---

## Project Structure

```
src/
└── studentdata/
    ├── Student.java
    ├── StudentManager.java
    ├── Main.java
    └── exceptions/
        ├── StudentDataException.java
        ├── InvalidDataException.java
        ├── DataNotFoundException.java
        └── OperationFailedException.java
README.md
```  

---

## Package `studentdata`

### Class `Student`

- **Constructor** `(String prn, String name, String dobStr, double[] marks)`
  - Validates PRN, name, DOB (YYYY-MM-DD), and marks array
  - Throws `InvalidDataException` on invalid input
- **Methods**
  - `String getPrn()`
  - `String getName()`
  - `LocalDate getDob()`
  - `double[] getMarks()`
  - `double getTotalMarks()` — sums marks
  - `String toString()` — formatted student info

### Class `StudentManager`

- **Fields**
  - `List<Student> students` — in-memory store

- **Methods**
  - `void addStudent(Student student)`
    - Throws `InvalidDataException` for null/duplicate
    - Throws `OperationFailedException` on add failure
  - `void displayAllStudents()`
    - Throws `DataNotFoundException` if list empty
    - Prints each student via `toString()`
  - `Student searchByPRN(String prn)`
    - Throws `InvalidDataException` for bad input
    - Throws `DataNotFoundException` if not found
  - `void updateStudentByPRN(String prn, Student newData)`
    - Throws `InvalidDataException` for null newData
    - Throws `DataNotFoundException` if not found
    - Throws `OperationFailedException` on set failure
  - `void deleteStudentByPRN(String prn)`
    - Throws `InvalidDataException` for bad input
    - Throws `DataNotFoundException` if removal fails

### Class `Main`

- **`main(String[] args)`**
  - Displays console menu with options 1–6
  - Reads user input, invokes `StudentManager` methods
  - Catches `StudentDataException` and `NumberFormatException`

---

## Package `studentdata.exceptions`

### Class `StudentDataException`

Base exception for all student-data errors.

```java
public class StudentDataException extends Exception { ... }
```

### Class `InvalidDataException`

Thrown on invalid inputs (null/empty, format errors).

```java
public class InvalidDataException extends StudentDataException { ... }
```

### Class `DataNotFoundException`

Thrown when a lookup, display, or delete finds no records.

```java
public class DataNotFoundException extends StudentDataException { ... }
```

### Class `OperationFailedException`

Thrown when an internal operation (add/update) fails unexpectedly.

```java
public class OperationFailedException extends StudentDataException { ... }
```



