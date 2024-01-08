package genetichelper;

import genetic.Population;
import genetic.Species;
import genetic.Specimen;
import genetic.breeder.Breeder;
import genetic.breeder.PrideBreeder;
import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.FreeForAllBreedingGround;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;
import genetic.killer.ElementOfTheEliteKiller;
import genetic.killer.Killer;
import genetic.mutation.Mutation;
import genetic.mutation.RandomOffsetMutation;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;

import java.util.ArrayList;
import java.util.List;

public class PopulationBuilder {
	/* Default configuration */
	static private final int DEFAULT_POPULATION_SIZE = 10;
	static private final int DEFAULT_KILLER_COUNT = 5;
	static private final int DEFAULT_MUTATION_COUNT = 3;
	static private final int DEFAULT_ELITE_COUNT = 3;
	static private final int DEFAULT_PARTNER_COUNT = 1;
	static private final double DEFAULT_MUTATION_POWER = 0.5d;
	static private final int DEFAULT_MUTATION_GENE_COUNT = 3;

	/* Default parameters */
	static private final Class<? extends Species> DEFAULT_SPECIES_CLASS = Specimen.class;
	static private final Generator DEFAULT_GENERATOR = new GroupGenerator(DEFAULT_SPECIES_CLASS, DEFAULT_POPULATION_SIZE);
	static private final Breeder DEFAULT_BREEDER = new PrideBreeder(DEFAULT_PARTNER_COUNT);
	static private final BreedingGround DEFAULT_BREEDING_GROUND = new FreeForAllBreedingGround(DEFAULT_POPULATION_SIZE);
	static private final Killer DEFAULT_KILLER = new ElementOfTheEliteKiller(DEFAULT_ELITE_COUNT, DEFAULT_KILLER_COUNT);
	static private final Mutator DEFAULT_MUTATOR = new EqualChanceMutator(DEFAULT_MUTATION_COUNT);
	static private final Mutation DEFAULT_MUTATION = new RandomOffsetMutation(DEFAULT_MUTATION_POWER, DEFAULT_MUTATION_GENE_COUNT);

	private Class<? extends Species> speciesClass = DEFAULT_SPECIES_CLASS;
	private Generator generator = DEFAULT_GENERATOR;
	private Breeder breeder = DEFAULT_BREEDER;
	private BreedingGround breedingGround = DEFAULT_BREEDING_GROUND;
	private Killer killer = DEFAULT_KILLER;
	private Mutator mutator = DEFAULT_MUTATOR;
	private Mutation mutation = DEFAULT_MUTATION;

	public Population build() {
		List<Object> parameters = new ArrayList<>();
		/* DO NOT CHANGE ORDER (see Population.BUILD_INDEXES) */
		parameters.add(this.speciesClass);
		parameters.add(this.generator);
		parameters.add(this.breeder);
		parameters.add(this.breedingGround);
		parameters.add(this.killer);
		parameters.add(this.mutator);
		parameters.add(this.mutation);
		return new Population(parameters);
	}
	public PopulationBuilder setSpeciesClass(Class<? extends Species> speciesClass) {
		this.speciesClass = speciesClass;
		return this;
	}
	public PopulationBuilder setGenerator(Generator generator) {
		this.generator = generator;
		return this;
	}
	public PopulationBuilder setBreeder(Breeder breeder) {
		this.breeder = breeder;
		return this;
	}
	public PopulationBuilder setBreedingGround(BreedingGround breedingGround) {
		this.breedingGround = breedingGround;
		return this;
	}
	public PopulationBuilder setKiller(Killer killer) {
		this.killer = killer;
		return this;
	}
	public PopulationBuilder setMutator(Mutator mutator) {
		this.mutator = mutator;
		return this;
	}
	public PopulationBuilder setMutation(Mutation mutation) {
		this.mutation = mutation;
		return this;
	}
}
