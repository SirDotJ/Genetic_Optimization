package genetic.killer;
import genetic.Species;

import java.util.List;
// Интерфейс определяет функцию выборки особей для редукции из предоставленного набора
public interface Killer {
    <T extends Species> List<T> choose(List<T> speciesList);
    int getCount();
}
