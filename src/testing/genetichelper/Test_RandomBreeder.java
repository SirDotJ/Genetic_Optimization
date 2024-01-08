package testing.genetichelper;

import genetic.Specimen;
import genetic.breeder.Breeder;
import genetic.generator.Generator;
import genetic.killer.Killer;
import genetichelper.RandomBreeder;
import genetichelper.RandomGenerator;
import genetichelper.RandomKiller;

public class Test_RandomBreeder {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			Killer killer = RandomKiller.get(generator);
			Breeder breeder = RandomBreeder.get(generator, killer);
			System.out.println(generator + ": " + breeder);
		}
	}
}
