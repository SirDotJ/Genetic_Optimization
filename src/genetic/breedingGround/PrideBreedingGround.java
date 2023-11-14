package genetic.breedingGround;

import common.RandomSelector;
import genetic.Species;

import java.util.*;

/* Реализация выбирает самого приспособленного члена из группы и скрещивает его случайным образом со всеми остальными */
public class PrideBreedingGround extends BreedingGround {
    protected PrideBreedingGround(int populationSize) {
        super(populationSize);
    }

    @Override
    public List<Species> reproduce(List<Species> parents) {
        List<Species> sortedList = new ArrayList<>(parents);
        Collections.sort(sortedList);

        Species alpha = sortedList.get(sortedList.size() - 1);
        List<Species> availableMates = sortedList.subList(0, sortedList.size() - 1);

        List<Species> newGeneration = new ArrayList<>();
        RandomSelector mateSelector = new RandomSelector(Collections.singletonList(availableMates));

        while (newGeneration.size() < this.populationSize) {
            newGeneration.add(alpha.reproduce((Species) mateSelector.get()));
        }

        return newGeneration;
    }
}
