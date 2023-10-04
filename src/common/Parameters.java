package common;

import java.util.List;

public abstract class Parameters {
    protected List<Double> parameterValues;
    public List<Double> getParameterValues() {
        return parameterValues;
    }
    public void set(int index, double value) throws IllegalStateException, IllegalArgumentException {
        if (parameterValues == null || parameterValues.isEmpty())
            throw new IllegalStateException("Current parameters don't exist or are empty");
        if (index < 0 || index >= this.parameterValues.size())
            throw new IllegalArgumentException("Provided index is not in range");

        this.parameterValues.set(index, value);
    }
    public double get(int index) throws IllegalStateException, IllegalArgumentException {
        if (parameterValues == null || parameterValues.isEmpty())
            throw new IllegalStateException("Current parameters don't exist or are empty");
        if (index < 0 || index >= this.parameterValues.size())
            throw new IllegalArgumentException("Provided index is not in range");

        return this.parameterValues.get(index);
    }

    public abstract int getParameterCount();
    public abstract void set(List<Double> parameterValues);
}
