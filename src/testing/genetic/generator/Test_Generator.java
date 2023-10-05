package testing.genetic.generator;

import genetic.Specimen;
import genetic.generator.Generator;

import java.util.List;

public class Test_Generator {
    public static void main(String[] args) {
        try {
            Generator specimenGenerator = new Generator(Specimen.class) {
                @Override
                public List<Object> generate() {
                    return null;
                }
            };
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
            return;
        }
        System.out.println("Objects made successfully!");
    }
}
