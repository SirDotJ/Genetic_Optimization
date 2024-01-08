package genetic.killer;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

public class EqualChanceKiller implements Killer {
    private static final int DEFAULT_REDUCE_COUNT = 3;
    int reduceAmount;
    public EqualChanceKiller() {
        this(DEFAULT_REDUCE_COUNT);
    }
    public EqualChanceKiller(int reduceAmount){
        this.reduceAmount = reduceAmount;
    }
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        List<T> availableTargets = new ArrayList<>(speciesList);
        List<T> killList = new ArrayList<>();
        for (int i = 0; i < this.reduceAmount; i++) {
            int killIndex = (int) (Math.random() * availableTargets.size());
            killList.add(availableTargets.get(killIndex));
            availableTargets.remove(killIndex);
        }
        return killList;
    }

    @Override
    public String toString() {
        return "EqualChanceKiller(" + this.reduceAmount + ")";
    }
}
