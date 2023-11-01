package genetic.breeder;

import genetic.Species;

import java.util.List;

public interface Breeder {
    public abstract List<Species> choose(List<Species> speciesList);
}
