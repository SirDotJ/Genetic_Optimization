package genetic.killer;
import genetic.Species;

import java.util.List;
// Интерфейс определяет функцию выборки особей для редукции из предоставленного набора
public interface Killer {
    public List<Species> choose(List<Species> speciesList);
}
