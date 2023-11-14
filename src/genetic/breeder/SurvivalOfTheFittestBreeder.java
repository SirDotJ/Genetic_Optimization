package genetic.breeder;

import genetic.Species;
import java.util.*;

//противоположность weakest
public class SurvivalOfTheFittestBreeder implements Breeder{
    public int breedAmount;
    public SurvivalOfTheFittestBreeder(){
        breedAmount = 1;
    }
    public SurvivalOfTheFittestBreeder(int X){
        breedAmount = X;
    }
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        List<T> sortedList = new ArrayList<>(speciesList);

        Collections.sort(sortedList);
        Collections.reverse(sortedList);

        return sortedList.subList(0, this.breedAmount);
    }
}
