package genetic.breeder;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;
//рандомный выбор
public class EqualChanceBreeder implements Breeder{
    private static final int DEFAULT_BREED_COUNT = 3;
    int breedAmount;
    public EqualChanceBreeder(int breedAmount){
        this.breedAmount = breedAmount;
    }
    public EqualChanceBreeder() {
        this(DEFAULT_BREED_COUNT);
    }
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        List<T> speciesListCopy = new ArrayList<>(speciesList);
        List<T> breederList = new ArrayList<>();
        for (int i = 0; i < this.breedAmount; i++) {
            int breederIndex = (int) (Math.random() * speciesListCopy.size());
            breederList.add(speciesListCopy.get(breederIndex));
            speciesListCopy.remove(breederIndex);
        }
        return breederList;
    }

    @Override
    public String toString() {
        return "EqualChanceBreeder(" + this.breedAmount + ")";
    }
}
