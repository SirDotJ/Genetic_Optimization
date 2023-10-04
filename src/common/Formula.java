package common;

import java.util.List;

public abstract class Formula {
    protected List<Double> parameters;
    public List<Double> getParameters() {
        return parameters;
    }

    abstract public int getParameterCount();
    abstract public void setParameters(List<Double> parameters);
    abstract public double get();
}
