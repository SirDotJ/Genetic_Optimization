package testing.genetic;

import genetic.Population;
import genetic.PopulationGroup;
import genetic.Species;

public class Test_PopulationGroup {
	public static void main(String[] args) {
		PopulationGroup group;
		while (true) {
			try {
				group = new PopulationGroup(100);
			} catch (StackOverflowError ignore) {
				continue;
			}
			break;
		}
		double bestAdaptedness = Double.MIN_VALUE;
		int noChangeCounter = 0;
		int noChangeCeiling = 20;
		Species bestCreature = group.getBestSpecimen();

		Population bestOverallPopulation = null;
		double bestOverallAdaptedness = Double.MIN_VALUE;
		for (int i = 0; i < 1000; i++) {
			group.nextEvolutionStep();
			bestCreature = group.getBestSpecimen();
			if (bestAdaptedness < bestCreature.adaptedness()) {
				bestAdaptedness = bestCreature.adaptedness();
				noChangeCounter = 0;
			}
			System.out.println("Step №" + i + ": " + bestCreature);
			if (noChangeCounter++ > noChangeCeiling)
				break;

			Population currentBestOverallPopulation = group.getPopulationWithBestOverallAdaptedness();
			if (currentBestOverallPopulation.getOverallAdaptedness() > bestOverallAdaptedness) {
				bestOverallAdaptedness = currentBestOverallPopulation.getOverallAdaptedness();
				bestOverallPopulation = currentBestOverallPopulation;
			}
		}
		System.out.println("Result: highest found value: " + bestAdaptedness);
		System.out.println("Parameters to get said value: " + bestCreature.getGenome());
		System.out.println("Population with the best creature: " + group.getPopulationWithBestSpecimen());
		System.out.println("Population with best overall adaptedness currently: " + group.getPopulationWithBestOverallAdaptedness());
		System.out.println("Historical population with best overall adaptedness: " + bestOverallPopulation);
	}
}
