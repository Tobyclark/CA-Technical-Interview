package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class BasicTest {
    
    public void mathProcessor_simpleOperations() {

        //Addition must work
        System.out.println("Starting addition test");
        double result = MathProcessor.getInstance()
                .start(5)
                .addOperator(5, BasicOperator.ADD)
                .calculate();
        System.out.printf("Comparing %f with %f\n", 10f, result);
        assertEquals(10, result, 0.000001);

        //Subtraction must work
        System.out.println("Starting subtraction test");
        result = MathProcessor.getInstance()
                .start(75)
                .addOperator(50, BasicOperator.SUBTRACT)
                .calculate();
        System.out.printf("Comparing %f with %f\n", 25f, result);
        assertEquals(25, result, 0.000001);

        //Multiplication
        System.out.println("Starting multiplication test");
        result = MathProcessor.getInstance()
                .start(6)
                .addOperator(10, BasicOperator.MULTIPLY)
                .calculate();
        System.out.printf("Comparing %f with %f\n", 60f, result);
        assertEquals(60, result, 0.000001);

        //Division
        System.out.println("Starting division test");
        result = MathProcessor.getInstance()
                .start(125)
                .addOperator(25, BasicOperator.DIVIDE)
                .calculate();
        System.out.printf("Comparing %f with %f\n", 5f, result);
        assertEquals(5, result, 0.000001);
    }

    @Test
    public void mathProcessor_complexCalculations() {
        System.out.println("Starting complex test 1");
        //(5 + 5 - 10) * 100 = 0
        double result = MathProcessor.getInstance()
                .start(5)
                .addOperator(5, BasicOperator.ADD)
                .addOperator(10, BasicOperator.SUBTRACT)
                .addOperator(100, BasicOperator.MULTIPLY)
                .calculate();
        assertEquals(0, result, 0.000001);

        System.out.println("Starting complex test 2");
        //(100/5 + (-100)) * -1 = 80
        result = MathProcessor.getInstance()
                .start(100)
                .addOperator(5, BasicOperator.DIVIDE)
                .addOperator(-100, BasicOperator.ADD)
                .addOperator(-1, BasicOperator.MULTIPLY)
                .calculate();
        assertEquals(80, result, 0.000001);
    }
}