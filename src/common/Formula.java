package common;

import java.io.InvalidClassException;

public abstract class Formula {
    protected final Function function;
    protected Formula(Function function) {
        this.function = function;
    }
    public double get(Parameters parameters) throws IllegalArgumentException, InvalidClassException {
        return this.function.calculate(parameters);
    }
}
