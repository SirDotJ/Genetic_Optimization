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
    public List<Species> choose(List<Species> speciesList) {
        List<Species> speciesListCopy = List.copyOf(speciesList);
        List<Species> breederList = new ArrayList<>();
        for (int i = 0; i < this.breedAmount; i++) {
            int breederIndex = (int) (Math.random() * speciesListCopy.size());
            breederList.add(speciesListCopy.get(breederIndex));
            speciesListCopy.remove(breederIndex);
        }
        return breederList;
    }
}
