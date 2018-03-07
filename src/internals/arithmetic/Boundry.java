package internals.arithmetic;

import java.io.Serializable;

public class Boundry implements Serializable {
    public int lower;
    public int upper;

    public Boundry(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        if (lower >= upper) {
            throw new IllegalArgumentException("Lower bound is greater or equal to the upper bound");
        }
    }
}
