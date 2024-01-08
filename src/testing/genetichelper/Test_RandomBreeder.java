package testing.genetichelper;

import genetic.Specimen;
import genetic.breeder.Breeder;
import genetic.generator.Generator;
import genetichelper.RandomBreeder;
import genetichelper.RandomGenerator;

public class Test_RandomBreeder {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			Breeder breeder = RandomBreeder.get(generator);
			System.out.println(generator + ": " + breeder);
		}
	}
}
