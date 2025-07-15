__The Problem__  
The issue with the provided code is that the MathProcessor class is a singleton and we are performing many operations from each thread that must be performed on their respective initial values in order using a list, because each thread modifies the same list and initial value throughout, the program does not work as expected.  
The program contains many concurrency issues because of this, one of which is a race condition in which if the start method is called on any thread (call it thread 1) after the for loop in the calculate method has started executing on any other thread (call this thread 2). This results in the operations list being empty while the loop bounds calculated using the size of the operations list on thread 2 will still be set at however many operations were previously in the operation list prior to thread 1 calling start, leading ultimately to an out of bounds access to the operations list.  
__The Solution__  
The simplest solution is to have an instance of MathProcessor exist on every thread (simply done by removing the singleton pattern in Mathprocessor and instantiating a new instance in the getInstance method), this allows for reads and writes to be done on a seperate list for each thread, resulting in the desired behaviour.  
The drawback of this solution is that there is a memory cost associated with having many instances of the MathProcessor class.  
Instead, we could simply make the value and operations members in MathProcessor ThreadLocal(as has been done here) instead of creating a new instance of the entire MathProcessor class on every thread. This results in less memory cost than the solution of creating an instance of MathProcessor on every thread(it removes the cost associated with the object header for the MathProcessor class on every thread but the main thread.)  
__The Process__  
First I ran '''mvn clean install''' to verify the problem was occuring. Then I ran '''mvn clean install -e''' in order to get the full stacktrace. I also read and stepped through the code starting in the testcase that was failing.  
The output showed an out of bounds error is happening in the calculate method.  
It became clear to me that having a singleton MathProcessor with operations being performed by each thread on the same list was problematic.  
I tried commenting out the clear method in start first, which fixed the specific bug described previously but the test did not pass as it did nothing to solve the underlying issue.  
I then tried removing the concurrency from calculate using synchronized and using a threadsafe data structure instead of a list, this too does not solve the underlying issue.  
I concluded that all operations must be done using their own list and initial value.  
in order to achieve this I removed the singleton pattern, resulting in the desired behavior.  
I thought about how to optimize this solution and ended on making each of the member variables threadlocal to reduce memory footprint.  