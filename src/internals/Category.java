package internals;

import internals.arithmetic.*;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable {
    public Boundry boundary;
    public NumberType numberType;
    public Set<Operation> opTypes;
    public int argumentCount;
    private Random random = new Random();

    public Category(Boundry boundary, NumberType numberType, Set<Operation> opTypes, int argumentCount) {
        this.boundary = boundary;
        this.numberType = numberType;
        this.opTypes = opTypes;
        if (argumentCount < 2) {
            throw new IllegalArgumentException("The number of argumentCount must be >= 2");
        }
        this.argumentCount = argumentCount;
    }

    public double getNumber() {
        int boundaryInterval = boundary.upper - boundary.lower;

        switch (numberType) {
            case INTEGER:
                return (double) (boundary.lower + random.nextInt(boundaryInterval));
            case DECIMAL:
                return boundary.lower + boundaryInterval * random.nextDouble();
        }

        return 0;
    }
}
