package genetic;

import java.util.List;

public class PopulationGroup {
    private List<Population> populations;
    PopulationGroup() {
        // инициализировать все популяции
    }

    public List<Population> getPopulations() {
        return populations;
    }
    public Population getPopulationAt(int index) {
        return this.populations.get(index);
    }
}
