package testing.genetic;

import genetic.Species;
import genetic.Specimen;
import genetic.breeder.*;
import genetic.generator.Generator;
import genetic.generator.GroupGenerator;
import genetic.killer.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_Specimen {
    public static int populationSize = 10;
    public static int breederChooseSize = 5;
    public static int killerChooseSize = 5;
    public static Generator speciesGenerator = new GroupGenerator(Specimen.class, populationSize);

    public static void main(String[] args) {
        List<Specimen> specimenList = Specimen.parseListObjectToSpecimen(speciesGenerator.generate());
        List<Specimen> sortedList = new ArrayList<>(specimenList);
        Collections.sort(sortedList);
        System.out.println("Starting population: ");
        sortedList.forEach(System.out::println);

        /* Testing breeders */
        EqualChanceBreeder equalChanceBreeder = new EqualChanceBreeder(breederChooseSize);
        PrideBreeder prideBreeder = new PrideBreeder(breederChooseSize);
        RouletteBreeder rouletteBreeder = new RouletteBreeder(breederChooseSize);
        SurvivalOfTheFittestBreeder survivalOfTheFittestBreeder = new SurvivalOfTheFittestBreeder(breederChooseSize);
        TournamentBreeder tournamentBreeder = new TournamentBreeder(7, breederChooseSize);

        testBreeder(specimenList, equalChanceBreeder);
        testBreeder(specimenList, prideBreeder);
        System.out.println("RouletteBreeder: Goes into infinite loop!");
        /* testBreeder(specimenList, rouletteBreeder); */ // Входит в бесконечный цикл
        testBreeder(specimenList, survivalOfTheFittestBreeder);
        testBreeder(specimenList, tournamentBreeder);

        /* Testing killers */
        ElementOfTheEliteKiller elementOfTheEliteKiller = new ElementOfTheEliteKiller(3, killerChooseSize);
        EqualChanceKiller equalChanceKiller = new EqualChanceKiller(killerChooseSize);
        RouletteKiller rouletteKiller = new RouletteKiller(killerChooseSize);
        WeakestKiller weakestKiller = new WeakestKiller(killerChooseSize);

        testKiller(specimenList, elementOfTheEliteKiller);
        testKiller(specimenList, equalChanceKiller);
        System.out.println("RouletteKiller: Goes into infinite loop!");
        /* testKiller(specimenList, rouletteKiller); */ // Входит в бесконечный цикл
        testKiller(specimenList, weakestKiller);
    }

    public static <TS extends Species,
                   TB extends Breeder>
    void testBreeder(List<TS> population, TB breeder) {
        List<TS> result = breeder.choose(population);
        System.out.println(breeder.getClass().getName() + " result:");
        result.forEach((guy) -> System.out.println("\t" + guy));
    }
    public static <TS extends Species,
                   TK extends Killer>
    void testKiller(List<TS> population, TK killer) {
        List<TS> result = killer.choose(population);
        System.out.println(killer.getClass().getName() + " result:");
        result.forEach((guy) -> System.out.println("\t" + guy));
    }
}