package genetic.birth;

import genetic.Species;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AverageGeneBirth extends Birth {
    private AverageGeneBirth() {}
    private final static AverageGeneBirth instance = new AverageGeneBirth();
    public static AverageGeneBirth getInstance() { return instance; }
    @Override
    public List<Double> reproduction(Species mom, Species dad) throws IllegalArgumentException {
        AverageGeneBirth.super.reproduction(mom, dad); // проверка на одинаковый класс

        List<Double> momGenomeValues = mom.getGenomeValues();
        List<Double> dadGenomeValues = dad.getGenomeValues();
        List<Double> childGenomeValues = new ArrayList<>(Arrays.asList(new Double[momGenomeValues.size()]));

        for (int i = 0; i < momGenomeValues.size(); i++) {
            double newGeneValue = (momGenomeValues.get(i) + dadGenomeValues.get(i)) * 0.5;
            childGenomeValues.set(i, newGeneValue);
        }

        return childGenomeValues;
    }
}
