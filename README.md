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
    - [Module 7: Best Practices for Writing Effective Tests](#module-7-best-practices-for-writing-effective-tests)
    - [Module 8: Understanding Mocking and Independent Test Execution](#module-8-understanding-mocking-and-independent-test-execution)
    - [Module 9: Avoiding Tautologies in Tests](#module-9-avoiding-tautologies-in-tests)
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
   - Testing different examples of the same logical principle, such as validating multiple ISBNs to ensure they all return true.
- **Handling Assertions**: When multiple assertions are used, it’s useful to add descriptive messages to indicate which specific assertion failed. This helps in debugging by clearly identifying the problem area.

### Module 7: Best Practices for Writing Effective Tests

When writing tests, it's essential to follow best practices to ensure that the tests are effective, reliable, and maintainable.
Here are some key practices to keep in mind:

1. **Test Business Logic, Not Methods**:
    - Focus on validating the business logic rather than checking individual methods.
    - Ensure tests assess the correctness of overall functionality rather than specific implementation details.

2. **Keep Tests Simple and Focused**:
    - Each test should cover a single piece of functionality.
    - Typically, a test method should have only one assertion. Multiple assertions are acceptable only if they test different examples of the same logic or validate multiple related values.

3. **Ensure Repeatability**:
    - Tests should always produce the same result given the same input.
    - Avoid tests that depend on changing conditions or external states to maintain consistency.

4. **Thorough Testing**:
    - Cover all possible scenarios, including valid and invalid cases, edge cases, and error conditions.
    - For complex functionality, create comprehensive test cases to ensure that all aspects are thoroughly validated.

5. **Iterative Development**:
    - Follow the TDD cycle: write a failing test, write the minimum code to pass the test, and then refactor.
    - This approach helps in incrementally building functionality and improving code quality.

By adhering to these practices, you can ensure that your tests are effective, reliable, and provide meaningful validation of your code's functionality.

### Module 8: Understanding Mocking and Independent Test Execution

In this module, we will explore the concept of mocking and how independent test execution ensures accurate and reliable test results.

#### Independent Test Execution

Each test method in a test class is executed independently even when sharing a class-level setup(variables, objects, etc.). This means that the state and behavior of mocks are reset before each test method runs, ensuring that tests do not interfere with each other.

**Example**:
Consider the following test class `StockManagementTests`:

```java
import com.java.tdd.locator.Book;
import com.java.tdd.locator.ExternalISBNDataService;
import com.java.tdd.locator.StockManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class StockManagementTests {

    private String isbn = "0140177396";

    private ExternalISBNDataService webService = mock(ExternalISBNDataService.class);
    private ExternalISBNDataService databaseService = mock(ExternalISBNDataService.class);
    private StockManager stockManager = new StockManager(databaseService, webService);

    @Test
    public void canGetACorrectLocatorCode() {
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        String locatorCode = stockManager.getLocatorCode(isbn);
        assertEquals("7396J4", locatorCode);
    }

    @Test
    public void databaseIsUsedIfDataIsPresent() {
        when(databaseService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, never()).lookup(anyString());
    }

    @Test
    public void webServiceIsUsedIfDataIsNotPresentInDatabase() {
        when(webService.lookup(isbn)).thenReturn(new Book(isbn, "Of Mice And Men", "J. Steinbeck"));

        stockManager.getLocatorCode(isbn);

        verify(databaseService, times(1)).lookup(isbn);
        verify(webService, times(1)).lookup(isbn);
    }
}
```

**Explanation**:
- **Independent Execution**: Each test method (`canGetACorrectLocatorCode`, `databaseIsUsedIfDataIsPresent`, and `webServiceIsUsedIfDataIsNotPresentInDatabase`) runs independently. The mock objects (`databaseService` and `webService`) are reset before each test method runs.
- **Verification of Calls**: The number of calls to the `lookup` method is verified separately within each test method. The calls do not accumulate across tests, ensuring accurate verification for each scenario.

By understanding and applying these concepts, you can write effective unit tests that accurately validate your code's functionality.

### Module 9: Avoiding Tautologies in Tests

In this module, we discuss the concept of tautologies in tests and how to avoid them. A tautology occurs when the logic in your test is the same as the logic in your implementation, which can lead to false positives in your tests.

#### Understanding Tautologies

A tautology in testing means that the test code repeats the logic of the code being tested. This can mask errors because if both the test and the implementation have the same mistake, the test will still pass.

**Example**:
Consider a `NumberValidator` class with a method `isPrime` to check if a number is prime, and a test class `NumberValidatorTests` with a method `checkPrimeNumbers` to test it.

```java
public class NumberValidator {
    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberValidatorTests {
    @Test
    public void checkPrimeNumbers() {
        int[] numbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        var validator = new NumberVlidator();
       boolean isPrime;
        for (int number : numbers) {
            if (number <= 1) {
                isPrime = false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                }
            }
            isPrime = true;
            
            assertEquals(isPrime, validator.isPrime(number));
        }
    }
}
```

In this example, if the logic in `isPrime` is incorrect, the test might still pass if the same logic is used in the test.

#### Avoiding Tautologies

To avoid tautologies, follow these guidelines:
1. **Separate Logic from Tests**: Tests should be based on known examples and expected outcomes, not on calculations or logic.
2. **Split Tests**: Separate tests for different scenarios (e.g., prime and non-prime numbers).
3. **Use Assertions**: Directly assert expected outcomes without recalculating them in the test.

**Refactored Example**:

```java
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberValidatorTests {
    private static NumberValidator numberValidator;

    @BeforeAll
    public static void setUp() {
        numberValidator = new NumberValidator();
    }

    @Test
    public void checkPrimeNumbers() {
        int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        for (int primeNumber : primeNumbers) {
            assertTrue(numberValidator.isPrime(primeNumber), primeNumber + " is not a prime number");
        }
    }

    @Test
    public void checkNonPrimeNumbers() {
        int[] nonPrimeNumbers = {1, 4, 8, 9, 15, 25, 60, 63, 207};
        for (int nonPrimeNumber : nonPrimeNumbers) {
            assertFalse(numberValidator.isPrime(nonPrimeNumber), nonPrimeNumber + " is a prime number");
        }
    }
}
```

In this refactored example, the tests are split into two methods: one for prime numbers and one for non-prime numbers. Each test directly asserts the expected outcome without recalculating it, avoiding tautologies.

By following these practices, you can ensure that your tests are reliable and accurately validate your code's functionality.

