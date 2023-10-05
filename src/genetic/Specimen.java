package genetic;

import genetic.birth.AverageGeneBirth;
import genetic.mutation.RandomOffsetMutation;
import genetic.mutation.SpecimenGenome;

import java.util.ArrayList;
import java.util.List;

public class Specimen extends Species {
    private static ArrayList<Object> build() {
        ArrayList<Object> finalFields = new ArrayList<>(BUILD_INDEXES.values().length);

        finalFields.set(BUILD_INDEXES.BIRTH.ordinal(), AverageGeneBirth.getInstance());
        finalFields.set(BUILD_INDEXES.MUTATION.ordinal(), RandomOffsetMutation.getInstance());

        return finalFields;
    }
    private Specimen() {
        super(build());
    }
    public Specimen(List<Double> genomeValues) {
        this();
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
}
