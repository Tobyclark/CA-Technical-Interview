package math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

public class ConcurrentTest {
    private final Random RND = new Random();

    @Test
    public void mathProcessor_multithreadedOps() throws Exception {
        //Create a thread pool to submit jobs to
        ExecutorService threadService = Executors.newFixedThreadPool(10);

        //Assemble test cases. Each will takes the index, multiplies by 10, then subtracts 5. We will check the results later
        List<Callable<Double>> testCases = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            final int index = i;
            testCases.add(() -> {
                //Sleep a random interval to simulate varying request rates
                Thread.sleep(RND.nextLong(20));
                return MathProcessor.getInstance()
                        .start(index)
                        .addOperator(10, BasicOperator.MULTIPLY)
                        .addOperator(5, BasicOperator.SUBTRACT)
                        .calculate();
            });
        }

        //Invoke all our test cases, getting a list Futures we can wait on
        List<Future<Double>> jobs = threadService.invokeAll(testCases);

        //Get the results of our job and pack them into a list
        List<Double> results = new ArrayList<>();
        for(Future<Double> job : jobs) {
          results.add(job.get());
        }

        //We have our results. Each result should be i * 10 - 5 if everything worked correctly.
        for(int i = 0; i < results.size(); i++) {
            double expected = (double) i * 10 - 5;
            System.out.printf("Comparing %f with %f\n", expected, results.get(i));
            assertEquals(expected, results.get(i), 0.000001);
        }
    }
}
