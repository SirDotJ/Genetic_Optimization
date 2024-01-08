package genetic.killer;

import genetic.Species;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WeakestKiller implements Killer {
    public int reduceAmount;
    public WeakestKiller(){
        reduceAmount = 1;
    }
    public WeakestKiller(int X){
        reduceAmount = X;
    }
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        List<T> sortedList = new ArrayList<>(speciesList);

        Collections.sort(sortedList);

        return sortedList.subList(0, this.reduceAmount);
    }

    @Override
    public String toString() {
        return "WeakestKiller(" + this.reduceAmount + ")";
    }
}
