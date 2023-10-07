package genetic.breedingGround;

import genetic.Species;

import java.util.List;

public abstract class BreedingGround {
    protected final int populationSize;
    protected BreedingGround(int populationSize) {
        this.populationSize = populationSize;
    }
    public abstract List<Species> reproduce(List<Species> parents);
}
