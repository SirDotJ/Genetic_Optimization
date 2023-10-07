package testing.genetic;

import genetic.Population;
import genetic.Species;

import java.util.List;

public class Test_Population {
    public static void main(String[] args) {
        try {
            Population population = new Population();
            List<Species> firstGeneration = population.getCurrentCreatures();
            System.out.println("First generation:");
            firstGeneration.forEach((creature) -> System.out.println("\tCreature: " + creature.getGenomeValues()));
            population.nextEvolutionStep();
            List<Species> secondGeneration = population.getCurrentCreatures();
            System.out.println("Second generation:");
            secondGeneration.forEach((creature) -> System.out.println("\tCreature: " + creature.getGenomeValues()));
        } catch (Exception e) {
            System.out.println("Error! Exception occured: " + e);
        }
    }
}
