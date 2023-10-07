package genetic;

import genetic.breeder.Breeder;
import genetic.breeder.PrideBreeder;
import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.FreeForAllBreedingGround;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;
import genetic.killer.ElementOfTheEliteKiller;
import genetic.killer.Killer;
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
        MUTATOR
    }
    protected final Class<Species> speciesClass;
    protected final Generator generator;
    protected final Breeder breeder;
    protected final BreedingGround breedingGround;
    protected final Killer killer;
    protected final Mutator mutator;
    private static List<Object> build() {
        int finalFieldsSize = BUILD_INDEXES.values().length;
        ArrayList<Object> finalFields = new ArrayList<>(Arrays.asList(new Object[finalFieldsSize]));

        finalFields.set(BUILD_INDEXES.SPECIES.ordinal(), Specimen.class);
        finalFields.set(BUILD_INDEXES.GENERATOR.ordinal(), new GroupGenerator(Specimen.class));
        finalFields.set(BUILD_INDEXES.BREEDER.ordinal(), new PrideBreeder());
        finalFields.set(BUILD_INDEXES.BREEDING_GROUND.ordinal(), new FreeForAllBreedingGround(POPULATION_SIZE));
        finalFields.set(BUILD_INDEXES.KILLER.ordinal(), new ElementOfTheEliteKiller());
        finalFields.set(BUILD_INDEXES.MUTATOR.ordinal(), new EqualChanceMutator());

        return finalFields;
    }
    public Population() {
        this(build());
    }
    // TODO: public конструкторы для произвольных параметров Population
    private Population(List<Object> parameters) throws IllegalArgumentException {
        try {
            this.speciesClass = (Class<Species>) parameters.get(BUILD_INDEXES.SPECIES.ordinal());
            this.generator = (Generator) parameters.get(BUILD_INDEXES.GENERATOR.ordinal());
            this.breeder = (Breeder) parameters.get(BUILD_INDEXES.BREEDER.ordinal());
            this.breedingGround = (BreedingGround) parameters.get(BUILD_INDEXES.BREEDING_GROUND.ordinal());
            this.killer = (Killer) parameters.get(BUILD_INDEXES.KILLER.ordinal());
            this.mutator = (Mutator) parameters.get(BUILD_INDEXES.MUTATOR.ordinal());
        } catch (Exception e) {
            throw new IllegalArgumentException("Provided list of parameters is invalid: " + e);
        }
        this.currentCreatures = Species.parseListObjectToSpecies(this.generator.generate());
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
        List<Species> chosenBreeders = null; // TODO: after Violette implements breeders, set chosenBreeders and pass it for new generation
        List<Species> newGeneration = this.breedingGround.reproduce(this.currentCreatures);
        this.currentCreatures = newGeneration;
        // TODO: Kill for all in population based on killer
        System.out.println("Killing not implemented");
        // TODO: Mutator for all in population based on mutator
        System.out.println("Mutating not implemented");
    }
    private Species findCurrentBestCreature() {
        // TODO: find best creature based on their survivability
        return null;
    }
}
