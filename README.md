# Practical Test Driven Development for Java Programmers

## Course Overview

This repository contains exercises, notes, and code examples from Matt Greencroft's course *Practical Test Driven Development for Java Programmers*. The course covers essential TDD principles, aiming to help developers write cleaner, more maintainable code.

## Table of Contents

1. [Introduction](#introduction)
2. [Setup](#setup)
3. [Course Progress](#course-progress)
    - [Module 1: Introduction to Test Driven Development (TDD)](#module-1-introduction-to-tdd)
    - [Module 2: Writing Effective Unit Tests](#module-2-writing-effective-unit-tests)

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



