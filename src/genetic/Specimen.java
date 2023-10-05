package genetic;

import common.LabParameters;
import genetic.birth.AverageGeneBirth;
import genetic.mutation.RandomOffsetMutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Specimen extends Species {
    private static ArrayList<Object> build() {
        int finalFieldsSize = BUILD_INDEXES.values().length;
        ArrayList<Object> finalFields = new ArrayList<>(Arrays.asList(new Object[finalFieldsSize]));

        finalFields.set(BUILD_INDEXES.BIRTH.ordinal(), AverageGeneBirth.getInstance());
        finalFields.set(BUILD_INDEXES.MUTATION.ordinal(), RandomOffsetMutation.getInstance());

        return finalFields;
    }
    public Specimen() {
        this(generateRandomGenome());
    }
    public Specimen(List<Double> genomeValues) {
        super(build());
        this.genome = new SpecimenGenome(genomeValues);
    }

    @Override
    public Specimen reproduce(Species partner) {
        return new Specimen(this.birthMethod.reproduction(this, partner));
    }

    @Override
    public void mutate() {
        this.mutationMethod.mutate(this);
    }

    // TODO: temporary random genome generator - redo it once limitations for Omega are in place
    static private List<Double> generateRandomGenome() {
        int genomeSize = LabParameters.PARAMETER_COUNT;
        List<Double> genome = new ArrayList<>();

        for (int i = 0; i < genomeSize; i++) {
            double randomValue = -4 + Math.random() * 4;
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
}
