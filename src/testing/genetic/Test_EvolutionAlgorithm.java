package testing.genetic;

import genetic.EvolutionAlgorithm;

public class Test_EvolutionAlgorithm {
	public static void main(String[] args) {
		EvolutionAlgorithm algorithm = new EvolutionAlgorithm(100);
		algorithm.optimize();
		System.out.println("Best genome: " + algorithm.getBestGenome());
		System.out.println("Best genome population: " + algorithm.getBestGenomePopulation());
		System.out.println("Best adaptibility: " + algorithm.getBestAdaptibility());
		System.out.println("Best overall adaptibility population: " + algorithm.getBestOverallPopulation());
		System.out.println("Best overall adaptibility: " + algorithm.getBestOverallAdaptibility());
	}
}
