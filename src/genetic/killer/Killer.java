package genetic.killer;
import genetic.Species;

import java.util.List;
public abstract class Killer {
    public abstract List<Species> choose(List<Species> speciesList);
}
