package genetic.mutation;

import common.LabParameters;
import genetic.Genome;

import java.util.List;

// Подвид Genome, для которого определен класс LabParameters в качестве класса параметров (с 10-ю переменными)
public class SpecimenGenome extends Genome {
    public SpecimenGenome(List<Double> values) throws IllegalArgumentException {
        this.geneValues = new LabParameters(values);
    }
    @Override
    public void setGeneValues(List<Double> values) {
        this.geneValues.set(values);
    }
}
