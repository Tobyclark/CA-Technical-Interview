package math;

import java.util.ArrayList;
import java.util.List;

public class MathProcessor {
    private static final MathProcessor instance = new MathProcessor();

    private MathProcessor() {
    }

    private record MathOperation(double value, MathOperator operator) {
        private double calculate(double in) {
            return operator.operate(in, this.value);
        }
    }

    private ThreadLocal<Double> value = ThreadLocal.withInitial(() -> 0.0);
    private final ThreadLocal<List<MathOperation>> operations = ThreadLocal.withInitial(ArrayList::new);

    public static MathProcessor getInstance() {
        return instance;
    }

    public MathProcessor start(double value) {
        this.value.set(value);
        this.operations.get().clear();
        return this;
    }

    public MathProcessor addOperator(double value, MathOperator operator) {
        if (operator == null) throw new IllegalArgumentException("Operator cannot be null");

        operations.get().add(new MathOperation(value, operator));
        return this;
    }

    public double calculate() {
        double result = this.value.get();
        for(int i = 0; i < this.operations.get().size(); i++) {
            System.out.printf("Applying operation %d of %d to number %f\n", (i + 1), this.operations.get().size(), result);
            result = operations.get().get(i).calculate(result);
        }
        return result;
    }
}
