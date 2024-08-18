# Practical Test Driven Development for Java Programmers

## Course Overview

This repository contains exercises, notes, and code examples from Matt Greencroft's course *Practical Test Driven Development for Java Programmers*. The course covers essential TDD principles, aiming to help developers write cleaner, more maintainable code.

## Table of Contents

1. [Introduction](#introduction)
2. [Setup](#setup)
3. [Course Progress](#course-progress)
    - [Module 1: Introduction to Test Driven Development (TDD)](#module-1-introduction-to-tdd)
    - [Module 2: Writing Effective Unit Tests](#module-2-writing-effective-unit-tests)
    - [Module 3: Project I Introduction and Setup](#module-3-project-i-introduction-and-setup)
    - [Module 4: Writing the First Test](#module-4-writing-the-first-test)
    - [Module 5: Implementing and Refactoring Code](#module-5-implementing-and-refactoring-code)
    - [Module 6: One assertion per test](#module-6-one-assertion-per-test)
## Introduction

This course introduces Test Driven Development (TDD) and its benefits for Java programmers.
The exercises in this repository are designed to reinforce the concepts taught in the course.

## Setup

To run the examples in this repository, ensure you have the following tools installed:

- **Java Development Kit (JDK)** version 8 or higher
- **JUnit** for testing
- **Maven** or **Gradle** for project management (optional)

## Course Progress
### Module 1: Introduction to Test Driven Development (TDD)

Test Driven Development (TDD) is a programming practice that involves writing tests before writing the actual code.
It's a method that has been around since 2003 and is closely associated with Agile development.

TDD follows a simple workflow known as Red, Green, Refactor:

1. **Red**: Write a test for the business logic, expecting it to fail since the code hasn't been written yet.
2. **Green**: Write the minimum code necessary to pass the test.
3. **Refactor**: Clean up the code and tests to make them more efficient and maintainable.

TDD is designed to help developers write clean, functional code. Although it's ideal for new projects,
the course will also cover how to apply TDD to existing codebases where TDD wasn't originally used.

### Module 2: Writing Effective Unit Tests

Test Driven Development (TDD) involves a detailed process where each of the three main steps—Red, Green, and Refactor—follows specific rules and mini-steps. It's important to start by writing tests before writing any code. This iterative process ensures that each piece of functionality is thoroughly tested, often requiring multiple tests to cover all scenarios.

**Unit Testing** is the primary focus in TDD. The goal is to write tests that check a single, identifiable piece of logic or behavior in isolation. These tests are not meant to verify entire end-to-end processes, which would be the domain of integration tests, not TDD.

For each piece of logic, create multiple tests to cover different scenarios. This ensures that all likely combinations of logic are tested. By doing so, the suite of tests will comprehensively validate the application's functionality.

### Module 3: Project I Introduction and Setup

In this section, we start working on a new project to apply the principles of Test Driven Development (TDD) in a practical way. The project involves writing business logic to validate an ISBN (International Standard Book Number), a unique identifier found on the barcode of books.

**Project Overview**:
- **Objective**: Write code to verify whether a given ISBN number is valid.
- **ISBN Validation**: ISBN numbers include a check digit, which can be calculated from the other digits in the number. If any digit in the ISBN is incorrect, the check digit will not match, indicating that the ISBN is invalid.

The project will involve writing code that accepts a full ISBN number, including the check digit, and determines whether it is valid. The logic for validating an ISBN will be explained in detail as we progress through the project.

### Module 4: Writing the First Test

The initial step is to write a test for a known valid 10-digit ISBN number, using real-world examples such as those found on book retailer websites.

**Key Concepts**:
- **Test-First Approach**: Begin by writing a test that defines the expected outcome for a specific example, such as validating a known ISBN number.
- **Focus on Outcomes**: When writing tests, the primary focus should be on the expected outcomes rather than the underlying logic or code structure.
- **Incremental Testing**: Start with a simple test for a valid ISBN and gradually build more tests to cover additional scenarios and logic.

### Module 5: Implementing and Refactoring Code

The focus in this module is on applying the rules of Test Driven Development (TDD) to write and refine code.

**Key Rules of TDD**:
1. **Test the Expected Outcome**: Start by writing tests that define the expected outcomes for given examples.
2. **Avoid Pre-Judging Design**: Let the tests drive the design and implementation of the code.
3. **Write Minimum Code**: Implement only the minimal code required to make the tests pass.

**TDD Process Overview**:
- **Red**: Write the test that defines the expected outcome for a specific piece of functionality. This initial test will fail because the required code hasn't been written yet.
- **Green**: Implement the minimal code necessary to make the test pass. At this stage, focus solely on passing the test, even if it involves placeholder or simplistic code.
- **Refactor**: Improve the code’s structure and clarity without changing its behavior. This step involves making refinements, such as renaming variables, and ensuring that the code remains efficient and maintainable.

This cycle—Red, Green, Refactor—will be repeated as you continue to write new tests and enhance the code,
leading to a more robust and well-structured implementation.

### Module 6: One assertion per test

- **Single Responsibility of Tests**: Each test should ideally check one specific piece of logic. However, multiple assertions can be used within a single test method when:
   - Testing multiple values to verify that various parts of a method or functionality work correctly.
   - Testing different examples of the same logical principle, such as validating multiple ISBN numbers to ensure they all return true.
- **Handling Assertions**: When multiple assertions are used, it’s useful to add descriptive messages to indicate which specific assertion failed. This helps in debugging by clearly identifying the problem area.

