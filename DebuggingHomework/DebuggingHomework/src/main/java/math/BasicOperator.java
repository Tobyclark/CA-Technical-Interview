package math;

public enum BasicOperator implements MathOperator {
    ADD(Double::sum),
    SUBTRACT((v1, v2) -> v1 - v2),
    MULTIPLY((v1, v2) -> v1 * v2),
    DIVIDE((v1, v2) -> v1 / v2);

    private final MathOperator operator;
    BasicOperator(MathOperator operator) {
        this.operator = operator;
    }

    @Override
    public double operate(double v1, double v2) {
        return operator.operate(v1, v2);
    }
}
