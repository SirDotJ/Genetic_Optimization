package testing.genetic.mutation;

import genetic.Species;
import genetic.Specimen;
import genetic.generator.GroupGenerator;
import genetic.mutation.Mutation;
import genetic.mutation.RandomOffsetMutation;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;

import java.util.List;

public class Test_Mutation {
    public static int populationSize = 4;
    public static int mutationCount = 1;
    public static double mutationPower = 1;
    public static int geneCeiling = 4;
    public static void main(String[] args) {
        List<Species> initialPopulation = Specimen.parseListObjectToSpecies(new GroupGenerator(Specimen.class, populationSize).generate());
        System.out.println("Initial population: ");
        initialPopulation.forEach((guy) -> System.out.println("\t" + guy + "\n\t\t" + guy.getGenome()));

        EqualChanceMutator equalChanceMutator = new EqualChanceMutator(mutationCount);
        List<Species> chosen = testMutator(initialPopulation, equalChanceMutator);

        RandomOffsetMutation randomOffsetMutation = new RandomOffsetMutation(mutationPower, geneCeiling);
        testMutation(chosen, randomOffsetMutation);

        System.out.println("Population after mutation: ");
        initialPopulation.forEach((guy) -> System.out.println("\t" + guy + "\n\t\t" + guy.getGenome()));
    }

    public static
    <TS extends Species,
     TM extends Mutation>
    void testMutation(List<TS> chosen, TM mutationMethod) {
        chosen.forEach(mutationMethod::mutate);
        System.out.println(mutationMethod.getClass().getName() + " result:");
        chosen.forEach((guy) -> System.out.println("\t" + guy + "\n\t\t" + guy.getGenome()));
    }

    public static
    <TS extends Species,
     TM extends Mutator>
    List<TS> testMutator(List<TS> population, TM mutator) {
        List<TS> guysToMutate = mutator.choose(population);
        System.out.println(mutator.getClass().getName() + " result:");
        guysToMutate.forEach((guy) -> System.out.println("\t" + guy + "\n\t\t" + guy.getGenome()));
        return guysToMutate;
    }
}
