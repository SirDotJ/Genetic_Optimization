package testing.genetichelper;

import genetic.Specimen;
import genetic.generator.Generator;
import genetic.killer.Killer;
import genetichelper.RandomGenerator;
import genetichelper.RandomKiller;

public class Test_RandomKiller {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Generator generator = RandomGenerator.get(Specimen.class);
			Killer killer = RandomKiller.get(generator);
			System.out.println(generator + ": " + killer);
		}
	}
}
