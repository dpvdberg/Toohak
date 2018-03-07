package internals.arithmetic;


import java.io.Serializable;

public class ValuedOperation  implements Serializable {
    private Operation operation;
    private Argument arg0;
    private Argument arg1;

    public ValuedOperation(Operation operation, Argument arg0, Argument arg1) {
        this.operation = operation;
        this.arg0 = arg0;
        this.arg1 = arg1;
    }

    public double getResult() {
        return operation.applyOperation(arg0.getArgument(), arg1.getArgument());
    }

    @Override
    public String toString() {
        return String.format("( %s %s %s )", arg0, operation, arg1);
    }
}
