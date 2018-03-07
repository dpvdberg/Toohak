package internals.arithmetic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Operation  implements Serializable {
    SUBTRACT(3),
    ADD(2),
    DIVISION(1),
    MULTIPLY(0);

    // Lower is higher priority
    private final int priority;

    Operation(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public double applyOperation(double firstArg, double secondArg) {
        switch (this) {
            case ADD:
                return firstArg + secondArg;
            case SUBTRACT:
                return firstArg - secondArg;
            case MULTIPLY:
                return firstArg * secondArg;
            case DIVISION:
                return firstArg / secondArg;
            default:
                throw new IllegalArgumentException("Unknown operation type");
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case ADD:
                return "+";
            case SUBTRACT:
                return "-";
            case MULTIPLY:
                return "*";
            case DIVISION:
                return "/";
            default:
                throw new IllegalArgumentException("Unknown operation type");
        }
    }
}
