package internals.arithmetic;

import java.io.Serializable;

public class Argument  implements Serializable {
    private double arg;
    private ValuedOperation operation;
    public Argument(double arg) {
        this.arg = arg;
    }

    public Argument(ValuedOperation operation) {
        this.operation = operation;
    }

    public double getArgument() {
        if (operation != null) {
            return operation.getResult();
        }

        return arg;
    }

    @Override
    public String toString() {
        if (operation != null) {
            return operation.toString();
        }

        return Double.toString(arg);
    }
}