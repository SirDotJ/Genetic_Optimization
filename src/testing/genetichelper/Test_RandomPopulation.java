package testing.genetichelper;

import genetic.Population;
import genetic.Specimen;
import genetichelper.RandomPopulation;

public class Test_RandomPopulation {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Population population = RandomPopulation.get(Specimen.class);
			System.out.println(population);
		}
	}
}
