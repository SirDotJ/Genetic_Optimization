package testing.genetic.generator;

import genetic.Specimen;
import genetic.generator.GroupGenerator;

import java.util.ArrayList;

public class Test_GroupGenerator {
    public static void main(String[] args) {
        try {
            GroupGenerator generator = new GroupGenerator(Specimen.class, 5);
            ArrayList<Specimen> groupOfSpecimen = new ArrayList<>(Specimen.parseListObject(generator.generate()));
            for (int i = 0; i < generator.getGroupSize(); i++) {
                System.out.println("Object №" + i + ": " + groupOfSpecimen.get(i).getGenome().getGeneValues().getParameterValues());
            }
            System.out.println("Number of generated objects according to generator: " + generator.getGroupSize());
            System.out.println("Real number of objects generated: " + groupOfSpecimen.size());
        } catch (Exception e) {
            System.out.println("Error! Exception occured: " + e);
        }
    }
}
