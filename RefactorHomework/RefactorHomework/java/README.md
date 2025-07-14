# Refactor Homework

## IntelliJ Setup
1. Ensure you have the latest version of IntelliJ. Older versions are not compatible with the newest Java releases.
2. Select File->New->Project from existing sources
3. In the import modal, check the `Import from external model` radio button and select `Maven`
4. Go to File->Project Structure.
    1. If you do not see a Java 10+ SDK in the `project` tab, click the dropdown and install it.
    2. Select a language level of 10 or higher.
    3. Navigate to the `Modules` tab.
        1. Ensure the `/src/main/java` directory is marked as `Sources`
        2. Ensure the `/src/test/java` directory is marked as `Test`
        3. Ensure the `/src/test/resources` directory is marked as `Resources`
    3. Click apply and close the project structure modal.
5. Open the `Processor` java file. If `Integer` is highlighted in red, use the context menu to add `java.lang` to the compiler options.
6. Run the tests by right-clicking on the `src/test/java` directory in the project explorer and select `Run 'All Tests'`

## Manual Setup
1. Install the Java 10+ JDK. If you already have an older java version installed, we recommend using one of the following version managers.
    * MacOS/Linux: [jEnv](https://www.jenv.be/)
    * Windows: [jabba](https://github.com/shyiko/jabba)
2. Install [Maven](https://maven.apache.org/install.html)
3. Compile the sources in a new terminal window `mvn clean install -DskipTests`.
4. Run the tests. `mvn clean install`. The tests should pass

## Homework Overview
You are a software contractor and have been approached by a relatively small startup for work maintaining one of their internal utility applications. The company collects data on the productivity of its employees yearly. The company is organized into branches, where each branch has multiple employees. They want you to refactor a specific piece of code to make it more readable and maintainable without changing the way the code is used.

## Details
* You have been provided with a program written in Java 10+ using Maven for dependency management.
* You are to rewrite the `getBestProductivityForEmployee` method located in the `Processor` class. The method is too deeply nested, making it difficult to read. There are a variety of ways to solve this, the specifics are up to you.
* No other prior-existing files will be modified. However, you are allowed to create new tests if you wish.
* The method signature of `getBestProductivityForEmployee` must not change, but the method body is free game. Creating new helper methods is also allowed, as long as they remain private.
* You cannot rely on the integrity of the supplied analytics data. Values can be null, empty, or otherwise invalid.
* There is no documentation on the specifics of which edge cases are properly handled and how. You will need to determine the requirements using only the source code provided.
* You have been provided a unit test file and a sample JSON file. The test cases in this file are far from complete, only checking a handful of employees. When refactoring the method, make sure to pay attention to null safety and any other validation steps included, as they are not checked in the provided tests.
* The client has been reading up on the [Functional Programming Paradigm](https://www.geeksforgeeks.org/functional-programming-paradigm/#:~:text=Functional%20programming%20is%20a%20programming,is%20%E2%80%9Chow%20to%20solve%E2%80%9D.). Usage of this paradigm in your refactor is welcome, but not required.  (Hint, think [Optionals](https://www.geeksforgeeks.org/java-8-optional-class/) and [Streams](https://www.geeksforgeeks.org/stream-in-java/))
* To simulate a production environment, you will be graded based on how your program performs against a test suite you have not been provided with.
* The original implementation of the `getBestProductivityForEmployee` method passes these hidden tests, so as long as your refactored code stays consistent with the original API contract, they will as well.
## Deliverables
Your project files in a zip archive. Assuming all Maven and Java are already installed, your submission should be ready to compile and run immediately after unzipping. Files specific to your IDE are not needed. (files like .idea, .vscode, etc)
