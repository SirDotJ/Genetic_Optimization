package testing.genetichelper;

import genetic.Specimen;
import genetic.generator.Generator;
import genetic.mutation.Mutation;
import genetichelper.RandomGenerator;
import genetichelper.RandomMutation;

public class Test_RandomMutation {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			Mutation mutation = RandomMutation.get(generator);
			System.out.println(generator + ": " + mutation);
		}
	}
}
