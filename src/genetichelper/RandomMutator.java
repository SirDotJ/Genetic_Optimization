package genetichelper;

import genetic.generator.Generator;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomMutator {
	private static final List<Class<? extends Mutator>> MUTATORS = new ArrayList<>(Arrays.asList(
		EqualChanceMutator.class
	));

	public static Mutator get(Generator generator) {
		int populationSize = generator.getCount();

		int chosenMutatorIndex = (int) (Math.random() * MUTATORS.size());
		Class<? extends Mutator> mutatorClass = MUTATORS.get(chosenMutatorIndex);
		if (mutatorClass.equals(EqualChanceMutator.class)) {
			int mutationCount = (int) (Math.random() * (populationSize)) / 3 + 1; // At least 1 should mutate, and it shouldn't be everybody
			return new EqualChanceMutator(mutationCount);
		} else { // ???
			throw new IllegalStateException("Unknown error when choosing mutator");
		}
	}
}
