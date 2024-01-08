package genetichelper;

import genetic.Specimen;
import genetic.generator.Generator;
import genetic.mutation.Mutation;
import genetic.mutation.RandomOffsetMutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomMutation {
	private static final List<Class<? extends Mutation>> MUTATIONS = new ArrayList<>(Arrays.asList(
		RandomOffsetMutation.class
	));

	public static Mutation get(Generator generator) {
		int populationSize = generator.getCount();

		int chosenMutationIndex = (int) (Math.random() * MUTATIONS.size());
		Class<? extends Mutation> mutationClass = MUTATIONS.get(chosenMutationIndex);
		if (mutationClass.equals(RandomOffsetMutation.class)) {
			int geneCount = (int) (Math.random() * (Specimen.getGeneCount() - 1) + 1); // At least one should be changed
			double power = -5d + Math.random() * 5d;
			return new RandomOffsetMutation(power, geneCount);
		} else { // ???
			throw new IllegalStateException("Unknown error when choosing mutation");
		}
	}
}
