# Refactor Homework

## Project Setup

1. Ensure you have [VSCode](https://code.visualstudio.com) installed
2. Ensure you have [Nodejs](https://nodejs.org/en/) and [Yarn](https://classic.yarnpkg.com/lang/en/docs/install/#mac-stable) installed
3. Open this project in VSCode
4. Install dependencies by running `yarn install`
5. Run the tests by running the command `yarn test`

## Homework Overview

You are a software contractor and have been approached by a relatively small startup for work maintaining one of their internal utility applications. The company collects data on the productivity of its employees yearly. The company is organized into branches, where each branch has multiple employees. They want you to refactor a specific piece of code to make it more readable and maintainable without changing the way the code is used.

## Details

- You have been provided with a program written in Typescript with Yarn as a package manager.
- You are to rewrite the `getBestProductivityForEmployee` method located in the `processor.ts` file. The method is too deeply nested, making it difficult to read. There are a variety of ways to solve this, the specifics are up to you.
- No other prior-existing files will be modified. However, you are allowed to create new tests if you wish.
- The method signature of `getBestProductivityForEmployee` must not change, but the method body is free game. Creating new helper methods is also allowed, as long as they remain private.
- You cannot rely on the integrity of the supplied analytics data. Values can be null, empty, or otherwise invalid.
- There is no documentation on the specifics of which edge cases are properly handled and how. You will need to determine the requirements using only the source code provided.
- You have been provided a unit test file and a sample JSON file. The test cases in this file are far from complete, only checking a handful of employees. When refactoring the method, make sure to pay attention to null safety and any other validation steps included, as they are not checked in the provided tests.
- The client has been reading up on the [Functional Programming Paradigm](https://www.geeksforgeeks.org/functional-programming-paradigm/#:~:text=Functional%20programming%20is%20a%20programming,is%20%E2%80%9Chow%20to%20solve%E2%80%9D.). Usage of this paradigm in your refactor is welcome, but not required.
- To simulate a production environment, you will be graded based on how your program performs against a test suite you have not been provided with.
- The original implementation of the `getBestProductivityForEmployee` method passes these hidden tests, so as long as your refactored code stays consistent with the original API contract, they will as well.

## Deliverables

Your project files in a zip archive. Your submission should be ready to run immediately after unzipping. Files specific to your IDE are not needed. (files like .idea, .vscode, etc)
