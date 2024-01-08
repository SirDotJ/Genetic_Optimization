package genetichelper;

import common.NumberRange;
import genetic.Species;
import genetic.generator.AdamEveGenerator;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomGenerator {
	private static final int POPULATION_LOWER_BOUND = 2;
	private static final int POPULATION_UPPER_BOUND = 1000;
	private static final NumberRange POPULATION_RANGE = new NumberRange(POPULATION_LOWER_BOUND, POPULATION_UPPER_BOUND);
	private static final List<Class<? extends Generator>> GENERATORS = new ArrayList<>(Arrays.asList(
		AdamEveGenerator.class,
		GroupGenerator.class
	));
	public static Generator get(Class<? extends Species> species) {

		int chosenGeneratorIndex = (int) (Math.random() * GENERATORS.size());
		Class<? extends Generator> generatorClass = GENERATORS.get(chosenGeneratorIndex);
		if (generatorClass.equals(AdamEveGenerator.class)) {
			return new AdamEveGenerator(species);
		} else {
			int populationSize = (int) POPULATION_RANGE.getRandomNumber();
			return new GroupGenerator(species, populationSize);
		}
	}
}
