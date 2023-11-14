package genetic.breedingGround;

import genetic.Species;

import java.util.List;

public abstract class BreedingGround {
    protected final int populationSize;
    protected BreedingGround(int populationSize) {
        this.populationSize = populationSize;
    }
    public abstract <TS extends Species> List<TS> reproduce(List<TS> parents);
}
