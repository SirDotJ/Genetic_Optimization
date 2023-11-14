package common;

import java.io.InvalidClassException;

import static java.lang.Math.*;
import static java.lang.Math.pow;

// Класс определяет используемую в лабораторной работе функцию для оптимизации
public class LabFormula extends Formula {
    private static final Function LAB_FUNCTION = (parameters) -> {
        if (parameters == null)
            throw new IllegalArgumentException("No passed parameters");
        if (!(parameters instanceof LabParameters)) {
            throw new InvalidClassException("Passed class is not LabParameters");
        }

        double x1 = parameters.get(0);
        double x2 = parameters.get(1);
        double x3 = parameters.get(2);
        double x4 = parameters.get(3);
        double x5 = parameters.get(4);
        double x6 = parameters.get(5);
        double x7 = parameters.get(6);
        double x8 = parameters.get(7);
        double x9 = parameters.get(8);
        double x10 = parameters.get(9);

        // Формула из постановки лабораторной работы
        return (((x1 * x2) - (x3 * sin(3 * x4) * exp(pow(x5, 2))) + pow(x6, 3) - 12.5 * x7) /
                                 (x4 * cos(4 * x8) - log(x8 * x1) + tan(pow(x9, 4)) - pow(2, (x10 * x5))));
    };
    public LabFormula() {
        super(LAB_FUNCTION);
    }
}
