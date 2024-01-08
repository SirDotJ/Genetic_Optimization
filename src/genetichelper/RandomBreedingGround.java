package genetichelper;

import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.FreeForAllBreedingGround;
import genetic.breedingGround.PrideBreedingGround;
import genetic.generator.Generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomBreedingGround {
	private static final List<Class<? extends BreedingGround>> BREEDING_GROUNDS = new ArrayList<>(Arrays.asList(
		FreeForAllBreedingGround.class,
		PrideBreedingGround.class
	));
	public static BreedingGround get(Generator generator) {
		int populationSize = generator.getCount();

		int chosenBreedingGroundIndex = (int) (Math.random() * BREEDING_GROUNDS.size());
		Class<? extends BreedingGround> breedingGroundClass = BREEDING_GROUNDS.get(chosenBreedingGroundIndex);
		if (breedingGroundClass.equals(FreeForAllBreedingGround.class)) {
			return new FreeForAllBreedingGround(populationSize);
		} else { // PrideBreedingGround
			return new PrideBreedingGround(populationSize);
		}
	}
}
