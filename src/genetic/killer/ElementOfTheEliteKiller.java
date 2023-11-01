package genetic.killer;

import genetic.Species;
import javafx.util.Pair;

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
    public List<Species> choose(List<Species> speciesList) {
        List<Pair<Double, Species>> scoreBoard = new ArrayList<>();
        List<Species> elites = new ArrayList<>();
        List<Species> lowLives = new ArrayList<>();
        List<Species> killList = new ArrayList<>();

        int bestIndex = -1; //индекс самого сильного
        double maxAdaptedness = Double.MIN_VALUE; //приспособленность самого сильного

        for (Species creature : speciesList) {
            scoreBoard.add(new Pair<>(creature.adaptedness(), creature));
        }
        Arrays.sort((Pair<Double, Species>[]) scoreBoard.toArray(), new Comparator<Pair<Double, Species>>() {
            @Override
            public int compare(Pair<Double, Species> o1, Pair<Double, Species> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });


        // TODO: Добавить обратно из сохраненных сообщений Telegram

        return killList; //список для редукции
    }
}
