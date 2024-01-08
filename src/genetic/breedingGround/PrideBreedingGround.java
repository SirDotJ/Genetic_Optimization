package genetic.breedingGround;

import common.RandomSelector;
import genetic.Species;

import java.util.*;

/* Реализация выбирает самого приспособленного члена из группы и скрещивает его случайным образом со всеми остальными */
public class PrideBreedingGround extends BreedingGround {
    public PrideBreedingGround(int populationSize) {
        super(populationSize);
    }

    @Override
    public <TS extends Species> List<TS> reproduce(List<TS> parents) {
        List<TS> sortedList = new ArrayList<>(parents);
        Collections.sort(sortedList);

        Species alpha = sortedList.get(sortedList.size() - 1);
        List<TS> availableMates = sortedList.subList(0, sortedList.size() - 1);

        List<TS> newGeneration = new ArrayList<>();
        RandomSelector mateSelector = new RandomSelector(availableMates);

        while (newGeneration.size() < this.populationSize) {
            Species chosenMate = (Species) mateSelector.get();
            newGeneration.add((TS) alpha.reproduce(chosenMate));
        }

        return newGeneration;
    }
    @Override
    public String toString() {
        return "PrideBreedingGround(" + this.populationSize + ")";
    }
}
