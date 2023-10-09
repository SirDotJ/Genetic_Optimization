package common;

import java.io.InvalidClassException;

@FunctionalInterface
public interface Function {
    double calculate(Parameters parameters) throws IllegalArgumentException, InvalidClassException;
}
