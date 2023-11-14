package genetic.breeder;

import genetic.Species;

import java.util.List;

public interface Breeder {
    <T extends Species> List<T> choose(List<T> speciesList);
}
