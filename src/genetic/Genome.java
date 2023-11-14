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
    public void setGeneValues(List<Double> values) {
        for (int i = 0; i < values.size(); i++)
            this.setGeneValue(i, values.get(i));
    }
    abstract public void setGeneValue(int index, double value);
    public boolean checkGenomeValue(int index, double value) {
        return this.geneValues.checkRestriction(index, value);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Genome: ");
        for (int i = 0; i < this.getSize(); i++) {
            double value = this.get(i);
            builder.append("\n\tvalue_").append(i).append(": ").append(value);
        }
        return builder.toString();
    }
}
