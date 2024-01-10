import genetic.EvolutionAlgorithm;

public class Main{
    public static void main(String[] args) {
        EvolutionAlgorithm algorithm;
        if (args.length == 0)
            algorithm = new EvolutionAlgorithm(100);
        else {
            try {
                algorithm = new EvolutionAlgorithm(Integer.parseInt(args[0]));
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter number of populations to generate and try again...");
                return;
            }
        }
        algorithm.optimize();
        System.out.println("Best genome: " + algorithm.getBestGenome());
		System.out.println("Best genome population: " + algorithm.getBestGenomePopulation());
		System.out.println("Best adaptibility: " + algorithm.getBestAdaptibility());
		System.out.println("Best overall adaptibility population: " + algorithm.getBestOverallPopulation());
		System.out.println("Best overall adaptibility: " + algorithm.getBestOverallAdaptibility());
    }
}