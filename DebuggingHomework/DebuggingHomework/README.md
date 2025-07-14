# Debugging Homework

## IntelliJ Setup
1. Ensure you have the latest version of IntelliJ. Older versions are not compatible with the newest Java releases.
2. Select File->New->Project from existing sources
3. In the import modal, check the `Import from external model` radio button and select `Maven`
4. Go to File->Project Structure. 
    1. If you do not see a Java 17 SDK in the `project` tab, click the dropdown and install it. 
    2. Select a language level of 16 or higher
    3. Click apply and close the project structure modal. 
5. Open the `BasicOperator` java file. If `Double` is highlighted in red, use the context menu to add `java.lang` to the compiler options.
6. Run the tests by right-clicking on the `src/test/java` directory in the project explorer and select `Run 'All Tests'`

## Manual Setup
1. Install the Java 17+ JDK. If you already have an older java version installed, we recommend using one of the following version managers.
    * MacOS/Linux: [jEnv](https://www.jenv.be/)
    * Windows: [jabba](https://github.com/shyiko/jabba)
2. Install [Maven](https://maven.apache.org/install.html)
3. Compile the sources in a new terminal window `mvn clean install -DskipTests`. This should succeed as is
4. Run the tests. `mvn clean install`. As written, `math.BasicTest` should succeed, and `math.ConcurrentTest` should fail

## Additional Notes
This project uses some of the newer Java features. Namely, it uses the following:
* [Functional Interfaces](https://www.geeksforgeeks.org/functional-interfaces-java/)
* [Lambda Expressions](https://www.geeksforgeeks.org/lambda-expressions-java-8/)
* [Method References](https://www.geeksforgeeks.org/lambda-expressions-java-8/)
* [Records](https://www.geeksforgeeks.org/what-are-java-records-and-how-to-use-them-alongside-constructors-and-methods/)

If you have not been exposed to these before now, we recommend giving the linked articles a glance.

## Homework Overview
The company you work for maintains an online calculator application. This program services math requests from users. Each user submits a request containing some operators and a starting value. The code processes this request, calculates the result, and returns it. The development of this program went great and all the tests passed easily. However, once the application was deployed it began returning incorrect responses and throwing Exceptions of varying types.

Your job is to find the problem and propose a solution.

## Details
* You have been provided with a program written in Java 17 using Maven for dependency management.
* This program does not work as written. Specifically, the `MathProcessor` class has a problem somewhere within.
* The problem is logical in nature, not syntaxual.
* The problem only appears when multiple threads are used to compute results at once.
* The Exception thrown by `ConcurrentTest` class varies. It is even possible for it to complete successfully, although this is unlikely.
* The problem has been reproduced in the `ConcurrentTest` class. Simpler examples of the usage of `MathProcessor` can be found in the `BasicTest` class, which pass as provided.
* This program can be fixed without modifying any files other than the `MathProcessor` class, do not modify the tests or other classes as part of your solution.

## Deliverables
A short paragraph describing the problem with the program, the solution, and the process you used to discover the issue.