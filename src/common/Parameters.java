package common;

import java.util.List;

public class Parameters {
    protected List<Double> parameterValues;
    protected final int parameterCount;
    protected final ParameterRestrictions parameterRestrictions;
    protected Parameters(List<Double> parameterValues) {
        this(parameterValues, new ParameterRestrictions());
    }
    protected Parameters(List<Double> parameterValues, ParameterRestrictions parameterRestrictions) {
        this.parameterCount = parameterValues.size();
        this.parameterRestrictions = parameterRestrictions;
        this.set(parameterValues);
    }
    public List<Double> getParameterValues() {
        return this.parameterValues;
    }

    public ParameterRestrictions getParameterRestrictions() {
        return parameterRestrictions;
    }

    public double get(int index) throws IllegalStateException, IllegalArgumentException {
        if (parameterValues == null || parameterValues.isEmpty())
            throw new IllegalStateException("Current parameters don't exist or are empty");
        if (index < 0 || index >= this.parameterValues.size())
            throw new IllegalArgumentException("Provided index is not in range");

        return this.parameterValues.get(index);
    }
    public void set(int index, double value) throws IllegalArgumentException {
        if (index < 0 || index >= this.parameterValues.size())
            throw new IllegalArgumentException("Provided index is not in range");
        if (!this.parameterRestrictions.check(index, value))
            throw new IllegalArgumentException("New value is invalid and lie outside of set restrictions");

        this.parameterValues.set(index, value);
    }
    public void set(List<Double> parameterValues) throws IllegalArgumentException {
        if(parameterValues == null || parameterValues.isEmpty())
            throw new IllegalArgumentException("No passed parameters");
        if (parameterValues.size() != this.getParameterCount())
            throw new IllegalArgumentException("Invalid amount of passed parameters");
        if (!this.parameterRestrictions.check(parameterValues))
            throw new IllegalArgumentException("Passed values are invalid and lie outside of set restrictions");

        this.parameterValues = parameterValues;
    }
    public int getParameterCount() {
        return this.parameterCount;
    }
}
