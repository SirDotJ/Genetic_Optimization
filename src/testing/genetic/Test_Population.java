package testing.genetic;

import genetic.Population;

public class Test_Population {
    public static int evolutionSteps = 100;
    public static void main(String[] args) {
        try {
            Population population = new Population();
            for (int i = 0; i < evolutionSteps; i++) {
                System.out.println("Step №" + i + ":");
                System.out.println("\tBest creature: " + population.getBestCreature());
                System.out.println("\tBest genome: " + population.getBestGenome());
                population.nextEvolutionStep();
            }
        } catch (Exception e) {
            System.out.println("Error! Exception occured: " + e);
        }
    }
}
