package testing.genetichelper;

import genetic.Specimen;
import genetic.generator.Generator;
import genetic.mutator.Mutator;
import genetichelper.RandomGenerator;
import genetichelper.RandomMutator;

public class Test_RandomMutator {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			Mutator mutator = RandomMutator.get(generator);
			System.out.println(generator + ": " + mutator);
		}
	}
}
