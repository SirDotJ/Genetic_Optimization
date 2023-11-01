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
    public List<Species> choose(List<Species> speciesList) {
        List<Species> availableTargets = List.copyOf(speciesList);
        List<Species> killList = new ArrayList<>();
        for (int i = 0; i < this.reduceAmount; i++) {
            int killIndex = (int) (Math.random() * availableTargets.size());
            killList.add(availableTargets.get(killIndex));
            availableTargets.remove(killIndex);
        }
        return killList;
    }
}
