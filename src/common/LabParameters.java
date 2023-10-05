package common;

import java.util.Arrays;
import java.util.List;

public class LabParameters extends Parameters {
    public static final int PARAMETER_COUNT = 10; // количество переменных в формуле
    public LabParameters() {
        this.parameterValues = Arrays.asList(new Double[PARAMETER_COUNT]);
    }
    public LabParameters(List<Double> parameterValues) throws IllegalArgumentException {
        if(parameterValues == null || parameterValues.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameterValues.size() != this.getParameterCount())
            throw new IllegalArgumentException("Invalid amount of passed parameters");

        this.parameterValues = parameterValues;
    }
    @Override
    public int getParameterCount() {
        return PARAMETER_COUNT;
    }

    @Override
    public void set(List<Double> parameterValues) throws IllegalArgumentException {
        if(parameterValues == null || parameterValues.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameterValues.size() != this.getParameterCount())
            throw new IllegalArgumentException("Invalid amount of passed parameters");

        this.parameterValues = parameterValues;
    }
}
