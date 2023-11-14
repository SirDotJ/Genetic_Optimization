package testing.genetic.mutator;

import genetic.Species;
import genetic.Specimen;
import genetic.generator.GroupGenerator;
import genetic.mutator.EqualChanceMutator;
import genetic.mutator.Mutator;

import java.util.List;

public class Test_Mutator {
    public static int populationSize = 10;
    public static int mutationCount = 2;
    public static void main(String[] args) {
        List<Species> initialPopulation = Specimen.parseListObjectToSpecies(new GroupGenerator(Specimen.class, populationSize).generate());
        System.out.println("Initial population: ");
        initialPopulation.forEach((guy) -> System.out.println("\t" + guy));

        EqualChanceMutator equalChanceMutator = new EqualChanceMutator(mutationCount);
        testMutator(initialPopulation, equalChanceMutator);
    }

    public static
        <TS extends Species,
         TM extends Mutator>
    void testMutator(List<TS> population, TM mutator) {
        List<TS> guysToMutate = mutator.choose(population);
        System.out.println(mutator.getClass().getName() + " result:");
        guysToMutate.forEach((guy) -> System.out.println("\t" + guy));
    }
}
