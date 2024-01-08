package genetichelper;

import genetic.breeder.*;
import genetic.generator.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomBreeder {
	private static final List<Class<? extends Breeder>> BREEDERS = new ArrayList<>(Arrays.asList(
		PrideBreeder.class,
		TournamentBreeder.class,
		SurvivalOfTheFittestBreeder.class,
		EqualChanceBreeder.class,
		RouletteBreeder.class
	));

	public static Breeder get(Generator generator) {
		int populationSize = generator.getCount();

		int chosenBreederIndex = (int) (Math.random() * BREEDERS.size());
		Class<? extends Breeder> breederClass = BREEDERS.get(chosenBreederIndex);
		if (breederClass.equals(PrideBreeder.class)) {
			int partnerCount = (int) (Math.random() * (populationSize - 2) + 1); // At least one partner and not everybody
			return new PrideBreeder(partnerCount);
		} else if (breederClass.equals(TournamentBreeder.class)) {
			int tournamentSize = (int) (Math.random() * (populationSize - 3) + 3); // At least three should compete
			int breedCount = (int) (Math.random() * (tournamentSize - 2) + 2); // At least two should breed
			return new TournamentBreeder(tournamentSize, breedCount);
		} else if (breederClass.equals(SurvivalOfTheFittestBreeder.class)) {
			int breedCount = (int) (Math.random() * (populationSize - 2) + 2); // At least two should be chosen
			return new SurvivalOfTheFittestBreeder(breedCount);
		} else if (breederClass.equals(EqualChanceBreeder.class)) {
			int breedCount = (int) (Math.random() * (populationSize - 2) + 2); // At least two should be chosen
			return new EqualChanceBreeder(breedCount);
		} else { // Roulette
			int breedCount = (int) (Math.random() * (populationSize - 2) + 2); // At least two should be chosen
			return new RouletteBreeder(breedCount);
		}
	}
}
