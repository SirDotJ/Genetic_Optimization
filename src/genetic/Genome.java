package genetic;

import common.Parameters;

import java.util.List;

abstract public class Genome {
    protected Parameters geneValues;
    public Parameters getGeneValues() {
        return geneValues;
    }
    public double get(int index) throws IllegalStateException, IllegalArgumentException {
        return this.geneValues.get(index);
    }
    public int getSize() {
        return this.geneValues.getParameterCount();
    }
    abstract public void setGeneValues(List<Double> values);

    @Override
    public String toString() {
        return "Genome{" +
                "geneValues=" + geneValues +
                '}';
    }
}
