package testing.genetichelper;

import genetic.Specimen;
import genetic.breedingGround.BreedingGround;
import genetic.generator.Generator;
import genetichelper.RandomBreedingGround;
import genetichelper.RandomGenerator;

public class Test_RandomBreedingGround {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			BreedingGround breedingGround = RandomBreedingGround.get(generator);
			System.out.println(generator + ": " + breedingGround);
		}
	}
}
