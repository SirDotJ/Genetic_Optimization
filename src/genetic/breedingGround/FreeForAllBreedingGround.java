package genetic.breedingGround;

import common.RandomSelector;
import genetic.Species;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FreeForAllBreedingGround extends BreedingGround {
    public FreeForAllBreedingGround(int populationSize) {
        super(populationSize);
    }
    @Override
    public List<Species> reproduce(List<Species> parents) {
        List<Species> newGeneration = new ArrayList<>();
        RandomSelector selector = new RandomSelector(Arrays.asList(parents.toArray()));
        while (newGeneration.size() < this.populationSize) {
            Species mom = (Species) selector.get();
            Species dad = (Species) selector.get();
            newGeneration.add(mom.reproduce(dad));
        }
        return newGeneration;
    }
}
