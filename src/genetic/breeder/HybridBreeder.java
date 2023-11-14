package genetic.breeder;

import genetic.Species;

import java.util.List;

//скрещивание двух видов
public class HybridBreeder implements Breeder {
    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        return null;
    }
}
