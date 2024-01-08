package genetichelper;

import genetic.Population;
import genetic.Species;
import genetic.breeder.Breeder;
import genetic.breedingGround.BreedingGround;
import genetic.generator.Generator;
import genetic.killer.Killer;
import genetic.mutation.Mutation;
import genetic.mutator.Mutator;

public class RandomPopulation {
	public static Population get(Class<? extends Species> speciesClass) {
		Generator generator = RandomGenerator.get(speciesClass);
		Breeder breeder = RandomBreeder.get(generator);
		BreedingGround breedingGround = RandomBreedingGround.get(generator);
		Killer killer = RandomKiller.get(generator);
		Mutator mutator = RandomMutator.get(generator);
		Mutation mutation = RandomMutation.get(generator);

		PopulationBuilder builder = new PopulationBuilder();
		return builder.setSpeciesClass(speciesClass)
				.setGenerator(generator)
				.setBreeder(breeder)
				.setBreedingGround(breedingGround)
				.setKiller(killer)
				.setMutator(mutator)
				.setMutation(mutation)
				.build();
	}
}
