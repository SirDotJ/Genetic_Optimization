package testing.genetic.generator;

import genetic.Specimen;
import genetic.generator.AdamEveGenerator;

import java.util.ArrayList;

public class Test_AdamEveGenerator {

    public static void main(String[] args) {
        try {
            AdamEveGenerator generator = new AdamEveGenerator(Specimen.class);
            ArrayList<Specimen> adamAndEve = new ArrayList<>(Specimen.parseListObjectToSpecimen(generator.generate()));
            System.out.println("Adam: " + adamAndEve.get(0).getGenome().getGeneValues().getParameterValues());
            System.out.println("Eve: " + adamAndEve.get(1).getGenome().getGeneValues().getParameterValues());
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
            return;
        }
        System.out.println("Test successful!");
    }
}
