package genetic;

import common.LabParameters;

import java.util.List;

// Подвид Genome, для которого определен класс LabParameters в качестве класса параметров (с 10-ю переменными)
public class SpecimenGenome extends Genome {
    public SpecimenGenome(List<Double> values) throws IllegalArgumentException {
        this.geneValues = new LabParameters(values);
    }
    @Override
    public void setGeneValue(int index, double value) {
        this.geneValues.set(index, value);
    }
}
