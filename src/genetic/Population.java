package genetic;

import genetic.breeder.Breeder;
import genetic.breeder.PrideBreeder;
import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.PrideBreedingGround;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;
import genetic.killer.ElementOfTheEliteKiller;
import genetic.killer.Killer;
import genetic.mutation.Mutation;
import genetic.mutation.RandomOffsetMutation;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;

import java.util.*;

public class Population {
    private static final int POPULATION_SIZE = 10;
    protected enum BUILD_INDEXES {
        SPECIES,
        GENERATOR,
        BREEDER,
        BREEDING_GROUND,
        KILLER,
        MUTATOR,
        MUTATION
    }
    protected final Class<Species> speciesClass;
    protected final Generator generator;
    protected final Breeder breeder;
    protected final BreedingGround breedingGround;
    protected final Killer killer;
    protected final Mutator mutator;
    protected final Mutation mutation;
    private static List<Object> build() {
        int finalFieldsSize = BUILD_INDEXES.values().length;
        ArrayList<Object> finalFields = new ArrayList<>(Arrays.asList(new Object[finalFieldsSize]));

        finalFields.set(BUILD_INDEXES.SPECIES.ordinal(), Specimen.class);
        finalFields.set(BUILD_INDEXES.GENERATOR.ordinal(), new GroupGenerator(Specimen.class));
        finalFields.set(BUILD_INDEXES.BREEDER.ordinal(), new PrideBreeder(5));
        finalFields.set(BUILD_INDEXES.BREEDING_GROUND.ordinal(), new PrideBreedingGround(POPULATION_SIZE));
        finalFields.set(BUILD_INDEXES.KILLER.ordinal(), new ElementOfTheEliteKiller());
        finalFields.set(BUILD_INDEXES.MUTATOR.ordinal(), new EqualChanceMutator());
        finalFields.set(BUILD_INDEXES.MUTATION.ordinal(), new RandomOffsetMutation());

        return finalFields;
    }
    public Population() {
        this(build());
    }
    public Population(List<Object> parameters) throws IllegalArgumentException {
        try {
            this.speciesClass = (Class<Species>) parameters.get(BUILD_INDEXES.SPECIES.ordinal());
            this.generator = (Generator) parameters.get(BUILD_INDEXES.GENERATOR.ordinal());
            this.breeder = (Breeder) parameters.get(BUILD_INDEXES.BREEDER.ordinal());
            this.breedingGround = (BreedingGround) parameters.get(BUILD_INDEXES.BREEDING_GROUND.ordinal());
            this.killer = (Killer) parameters.get(BUILD_INDEXES.KILLER.ordinal());
            this.mutator = (Mutator) parameters.get(BUILD_INDEXES.MUTATOR.ordinal());
            this.mutation = (Mutation) parameters.get(BUILD_INDEXES.MUTATION.ordinal());
        } catch (Exception e) {
            throw new IllegalArgumentException("Provided list of parameters is invalid: " + e);
        }
        this.currentCreatures = Species.parseListObjectToSpecies(this.generator.generate());
        this.bestCreature = this.findCurrentBestCreature();
    }
    private List<Species> currentCreatures;
    public List<Species> getCurrentCreatures() {
        return currentCreatures;
    }
    private Species bestCreature;
    public Species getBestCreature() {
        return bestCreature;
    }
    public Genome getBestGenome() {
        return bestCreature.genome;
    }
    public void nextEvolutionStep() {
        /* Размножение */
        List<Species> chosenBreeders = this.breeder.choose(this.currentCreatures);
        this.currentCreatures = this.breedingGround.reproduce(chosenBreeders);

        /* Редукция */
        List<Species> chosenDead = this.killer.choose(this.currentCreatures);
        chosenDead.forEach((deadGuy) -> this.currentCreatures.remove(deadGuy));

        /* Мутация */
        List<Species> chosenMutated = this.mutator.choose(this.currentCreatures);
        chosenMutated.forEach(this.mutation::mutate);

        Species newBestCreature = this.findCurrentBestCreature();
        if (this.bestCreature.adaptedness() < newBestCreature.adaptedness())
            this.bestCreature = newBestCreature;
    }
    private Species findCurrentBestCreature() {
        List<Species> ranking = new ArrayList<>(this.currentCreatures);
        Collections.sort(ranking);
        return ranking.get(ranking.size() - 1);
    }

    public double getOverallAdaptedness() {
        double overallAdaptedness = 0;
        for (Species creature : this.currentCreatures) {
            overallAdaptedness += creature.adaptedness();
        }
        return overallAdaptedness;
    }

    @Override
    public String toString() {
        return "Population(\n" +
                "\t" + this.speciesClass + "\n" +
                "\t" + this.generator + "\n" +
                "\t" + this.breeder + "\n" +
                "\t" + this.breedingGround + "\n" +
                "\t" + this.killer + "\n" +
                "\t" + this.mutator + "\n" +
                "\t" + this.mutation + ")\n";
    }
}
