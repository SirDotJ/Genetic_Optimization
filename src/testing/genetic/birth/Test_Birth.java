package testing.genetic.birth;

import genetic.Species;
import genetic.Specimen;
import genetic.birth.AverageGeneBirth;
import genetic.birth.Birth;
import genetic.breeder.Breeder;
import genetic.breeder.EqualChanceBreeder;
import genetic.generator.GroupGenerator;

import java.util.List;

public class Test_Birth {
    public static int populationSize = 10;
    public static void main(String[] args) {
        List<Species> initialPopulation = Specimen.parseListObjectToSpecies(new GroupGenerator(Specimen.class, populationSize).generate());

        Breeder breeder = new EqualChanceBreeder(2);
        List<Species> parents = breeder.choose(initialPopulation);
        Species mom = parents.get(0);
        Species dad = parents.get(1);
        System.out.println("Parent 1: " + mom.getGenome());
        System.out.println("Parent 2: " + dad.getGenome());

        AverageGeneBirth averageGeneBirth = AverageGeneBirth.getInstance();
        testBirth(mom, dad, averageGeneBirth);
    }

    public static
        <TS extends Species,
         TB extends Birth>
    void testBirth(TS mom, TS dad, TB birth) {
        Specimen child = new Specimen(birth.reproduction(mom, dad));
        System.out.println(birth.getClass().getName() + " result: Child: " + child.getGenome());
    }
}
