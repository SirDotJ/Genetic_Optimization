package genetic;

import genetichelper.RandomPopulation;

import java.util.ArrayList;
import java.util.List;

public class PopulationGroup {
    private static final int DEFAULT_POPULATION_AMOUNT = 100;
    private final List<Population> populations;
    public PopulationGroup(int populationAmount) {
        if (populationAmount < 0)
            throw new IllegalArgumentException("Passed population amount is less than zero!");

        this.populations = new ArrayList<>();
        for (int i = 0; i < populationAmount; i++)
            this.populations.add(RandomPopulation.get(Specimen.class));
    }
    public PopulationGroup() {
        this(DEFAULT_POPULATION_AMOUNT);
    }

    public List<Population> getPopulations() {
        return populations;
    }
    public Population getPopulationAt(int index) {
        return this.populations.get(index);
    }
    public Species getBestSpecimen() {
        Species bestSpecimen = null;
        double bestAdaptedness = Double.MIN_VALUE;
        for (Population population : this.populations) {
            if (population.getBestCreature().adaptedness() > bestAdaptedness) {
                bestSpecimen = population.getBestCreature();
                bestAdaptedness = population.getBestCreature().adaptedness();
            }
        }
        if (bestSpecimen == null)
            throw new RuntimeException("No best creature found in population group");
        return bestSpecimen;
    }

    public Population getPopulationWithBestSpecimen() {
        Population populationWithBestSpecimen = null;
        double bestAdaptedness = Double.MIN_VALUE;
        for (Population population : this.populations) {
            if (population.getBestCreature().adaptedness() > bestAdaptedness) {
                populationWithBestSpecimen = population;
                bestAdaptedness = population.getBestCreature().adaptedness();
            }
        }
        if (populationWithBestSpecimen == null)
            throw new RuntimeException("No best creature found in population group");
        return populationWithBestSpecimen;
    }
    public Population getPopulationWithBestOverallAdaptedness() {
        Population bestPopulation = null;
        double bestOverallAdaptedness = Double.MIN_VALUE;
        for (Population population : this.populations) {
            double overallAdaptedness = population.getOverallAdaptedness();
            if (overallAdaptedness > bestOverallAdaptedness) {
                bestOverallAdaptedness = overallAdaptedness;
                bestPopulation = population;
            }
        }
        if (bestPopulation == null)
            throw new RuntimeException("No best creature found in population group");
        return bestPopulation;
    }

    public void nextEvolutionStep() {
        for (Population population : this.populations) {
            population.nextEvolutionStep();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PopulationGroup:\n");
        for (Population population :
                this.populations) {
            builder.append("\t").append(population).append("\n");
        }
        return builder.toString();
    }
}
