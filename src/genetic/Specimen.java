package genetic;

import common.Formula;
import common.LabFormula;
import common.LabParameters;
import common.ParameterRestrictions;
import genetic.birth.AverageGeneBirth;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Specimen extends Species {
    private static final Formula adaptednessFormula = new LabFormula();
    private static ArrayList<Object> build() {
        int finalFieldsSize = BUILD_INDEXES.values().length;
        ArrayList<Object> finalFields = new ArrayList<>(Arrays.asList(new Object[finalFieldsSize]));

        finalFields.set(BUILD_INDEXES.BIRTH.ordinal(), AverageGeneBirth.getInstance());

        return finalFields;
    }
    public Specimen() { // TODO: looks ugly, replace later
        this(generateRandomGenome(new ParameterRestrictions(LabParameters.LAB_PARAMETER_RANGES)));
    }
    public Specimen(List<Double> genomeValues) {
        super(build());
        this.genome = new SpecimenGenome(genomeValues);
    }

    @Override
    public double adaptedness() {
        try {
            return Specimen.adaptednessFormula.get(this.genome.geneValues);
        } catch (InvalidClassException e) {
            System.out.println("Error: Gene is invalid: " + e);
            return Double.MIN_VALUE;
        }
    }

    @Override
    public Specimen reproduce(Species partner) {
        return new Specimen(this.birthMethod.reproduction(this, partner));
    }

    static private List<Double> generateRandomGenome(ParameterRestrictions restrictions) {
        int genomeSize = LabParameters.PARAMETER_COUNT;
        List<Double> genome = new ArrayList<>();

        for (int i = 0; i < genomeSize; i++) {
            double lowerBound = restrictions.getParameterRanges().get(i).getLowerBound();
            double upperBound = restrictions.getParameterRanges().get(i).getUpperBound();
            double randomValue = lowerBound + Math.random() * (upperBound - lowerBound);
            genome.add(randomValue);
        }

        return genome;
    }
    static public List<Specimen> parseListObjectToSpecimen(List<Object> providedList) throws IllegalArgumentException {
        List<Specimen> parsedValue;
        try {
            parsedValue = (List<Specimen>) (Object) providedList; // При ошибке будет поймана при помощи catch
        } catch (Exception e) {
            throw new IllegalArgumentException("Passed List<Object> cannot be case to List<Specimen>: " + e.toString());
        }
        return (parsedValue);
    }

    static public int getGeneCount() {
        return LabParameters.PARAMETER_COUNT;
    }

    @Override
    public String toString() {
        return "Specimen: adaptedness: " + this.adaptedness();
    }
}
