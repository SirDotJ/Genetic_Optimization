package common;

import java.util.List;

import static java.lang.Math.*;

// Класс определяет используемую в лабораторной работе функцию для оптимизации
public class LabFormula extends Formula {
    private final LabParameters parameters;
    @Override
    public int getParameterCount() {
        return this.parameters.getParameterCount();
    }
    private final Equation.Formula formula = (parameters) -> {
        if (parameters == null || parameters.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameters.size() != this.getParameterCount())
            throw new IllegalArgumentException("Invalid amount of passed parameters");

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

        return ((x1 * x2) - (x3 * sin(3 * x4)) * exp(pow(x5, 2)) + pow(x6, x3) - 12.5 * x7) /
                (x4 * cos(4 * x8) - log(x8 * x1) + tan(pow(x9, 4)) - pow(2, x10 * x5));
    };
    @Override
    public void setParameters(List<Double> parameters) throws IllegalArgumentException {
        if (parameters == null || parameters.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameters.size() != LabParameters.PARAMETER_COUNT)
            throw new IllegalArgumentException("Invalid amount of passed parameters");

        this.parameters.set(parameters);
    }
    public LabFormula() {
        this.parameters = new LabParameters();
    }
    public LabFormula(List<Double> parameters) throws IllegalArgumentException {
        if (parameters == null || parameters.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameters.size() != LabParameters.PARAMETER_COUNT)
            throw new IllegalArgumentException("Invalid amount of passed parameters");

        this.parameters = new LabParameters(parameters);
    }
    @Override
    public double get() throws IllegalStateException, IllegalArgumentException {
        if (this.parameters == null || this.parameters.parameterValues.isEmpty())
            throw new IllegalStateException("Current parameters are null or empty");

        return formula.calculate(this.parameters.getParameterValues());
    }
}
