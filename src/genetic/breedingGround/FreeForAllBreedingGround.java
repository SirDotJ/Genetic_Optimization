package genetic.breedingGround;

import common.RandomSelector;
import genetic.Species;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FreeForAllBreedingGround extends BreedingGround {
    public FreeForAllBreedingGround(int populationSize) {
        super(populationSize);
    }
    @Override
    public <TS extends Species> List<TS> reproduce(List<TS> parents) {
        List<TS> newGeneration = new ArrayList<>();
        RandomSelector selector = new RandomSelector(Arrays.asList(parents.toArray()));
        while (newGeneration.size() < this.populationSize) {
            TS mom = (TS) selector.get();
            TS dad = (TS) selector.get();
            newGeneration.add((TS) mom.reproduce(dad));
        }
        return newGeneration;
    }
}
