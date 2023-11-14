package genetic.killer;

import genetic.Species;

import java.util.*;

public class ElementOfTheEliteKiller implements Killer {
    private static final int DEFAULT_ELITE_COUNT = 3;
    private static final int DEFAULT_REDUCE_COUNT = 3;
    private final int eliteCount;
    private final int reduceCount;
    public ElementOfTheEliteKiller(){
        this(DEFAULT_ELITE_COUNT, DEFAULT_REDUCE_COUNT);
    }
    public ElementOfTheEliteKiller(int eliteCount, int reduceCount){
        this.eliteCount = eliteCount;
        this.reduceCount = reduceCount;
    }
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        List<T> sortedList = new ArrayList<>(speciesList);
        Collections.sort(sortedList);

        List<T> lowLives = new ArrayList<>(sortedList.subList(0, sortedList.size() - this.eliteCount));
        Killer killer = new EqualChanceKiller(this.reduceCount);

        return killer.choose(lowLives);
    }
}
