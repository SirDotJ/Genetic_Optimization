package testing.genetic;

import genetic.Population;
import genetic.Species;

import java.util.List;

public class Test_Population {
    public static void main(String[] args) {
        try {
            Population population = new Population();
            List<Species> generatedCreatures = population.getCurrentCreatures();
            generatedCreatures.forEach((creature) -> System.out.println("Creature: " + creature.getGenomeValues()));
            population.nextEvolutionStep();
        } catch (Exception e) {
            System.out.println("Error! Exception occured: " + e);
        }
    }
}
