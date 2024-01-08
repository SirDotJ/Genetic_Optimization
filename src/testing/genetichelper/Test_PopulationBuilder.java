package testing.genetichelper;

import genetic.Population;
import genetic.Species;
import genetic.Specimen;
import genetic.breeder.Breeder;
import genetic.breeder.TournamentBreeder;
import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.PrideBreedingGround;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;
import genetic.killer.Killer;
import genetic.killer.WeakestKiller;
import genetic.mutation.Mutation;
import genetic.mutation.RandomOffsetMutation;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;
import genetichelper.PopulationBuilder;

public class Test_PopulationBuilder {
	private final static PopulationBuilder BUILDER = new PopulationBuilder();

	public static void main(String[] args) {
		int populationSize = 1000;
		int killCount = 400;
		int mutationCount = 200;
		double mutationPower = 0.8d;
		int mutationGeneCount = 5;

		Class<? extends Species> speciesClass = Specimen.class;
		Generator generator = new GroupGenerator(speciesClass, populationSize);
		Breeder breeder = new TournamentBreeder(10, 5);
		BreedingGround breedingGround = new PrideBreedingGround(populationSize);
		Killer killer = new WeakestKiller(killCount);
		Mutator mutator = new EqualChanceMutator(mutationCount);
		Mutation mutation = new RandomOffsetMutation(mutationPower, mutationGeneCount);

		Population population = BUILDER.setSpeciesClass(speciesClass)
										.setGenerator(generator)
										.setBreeder(breeder)
										.setBreedingGround(breedingGround)
										.setKiller(killer)
										.setMutator(mutator)
										.setMutation(mutation)
										.build();

		for (int i = 0; i < 1000; i++) {
			population.nextEvolutionStep();
			System.out.println(population.getBestCreature());
		}
	}
}
