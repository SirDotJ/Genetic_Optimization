package testing.genetichelper;

import genetic.Specimen;
import genetic.generator.Generator;
import genetichelper.RandomGenerator;

public class Test_RandomGenerator {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			System.out.println(generator + ", count: " + generator.generate().size());
		}
	}
}
