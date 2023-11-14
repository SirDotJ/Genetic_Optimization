package testing.genetic.breedingground;

import genetic.Species;
import genetic.Specimen;
import genetic.breeder.EqualChanceBreeder;
import genetic.breedingGround.BreedingGround;
import genetic.breedingGround.FreeForAllBreedingGround;
import genetic.breedingGround.PrideBreedingGround;
import genetic.generator.GroupGenerator;

import java.util.List;

public class Test_BreedingGround {
    public static int populationSize = 10;
    public static int mateSize = 5;
    public static void main(String[] args) {
        List<Species> initialPopulation = Specimen.parseListObjectToSpecies(new GroupGenerator(Specimen.class, populationSize).generate());

        System.out.println("Initial population: ");
        initialPopulation.forEach((guy) -> System.out.println("\t" + guy));

        EqualChanceBreeder breeder = new EqualChanceBreeder(mateSize);
        List<Species> mates = breeder.choose(initialPopulation);

        System.out.println("Mates: ");
        mates.forEach((guy) -> System.out.println("\t" + guy));

        FreeForAllBreedingGround freeForAllBreedingGround = new FreeForAllBreedingGround(populationSize);
        PrideBreedingGround prideBreedingGround = new PrideBreedingGround(populationSize);

        testBreedingGround(mates, freeForAllBreedingGround);
        testBreedingGround(mates, prideBreedingGround);
    }

    public static
        <TS extends Species,
         TBG extends BreedingGround>
    void testBreedingGround(List<TS> mates, TBG ground) {
        List<TS> newPopulation = ground.reproduce(mates);
        System.out.println(ground.getClass().getName() + ": New Population: ");
        newPopulation.forEach((guy) -> System.out.println("\t" + guy));
    }
}
