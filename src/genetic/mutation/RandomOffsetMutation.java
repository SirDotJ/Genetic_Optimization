package genetic.mutation;

import common.RandomSelector;
import genetic.Species;

import java.util.ArrayList;
import java.util.List;

// Мутация выбирает случайное количество генов и добавляет к ним случайное положительное/отрицательное число
public class RandomOffsetMutation extends Mutation {
    public RandomOffsetMutation() {
        super();
    }
    public RandomOffsetMutation(double power) {
        super(power);
    }
    public RandomOffsetMutation(double power, int geneCount) {
        super(power, geneCount);
    }
    public RandomOffsetMutation(int geneCount) {
        super(geneCount);
    }
    private final static RandomOffsetMutation instance = new RandomOffsetMutation();
    public static RandomOffsetMutation getInstance() { return instance; }

    @Override
    public void mutate(Species speciesInstance) {
        List<Double> genomeValues = speciesInstance.getGenomeValues();
        int genomeSize = genomeValues.size();
        int changeCount = (int) (Math.random() * genomeSize);

        List<Integer> indexesToChange = getRandomIndexesToChange(genomeSize, changeCount);

        double lowerBound = -Math.abs(this.power);
        double upperBound = Math.abs(this.power);
        int counter = 0;
        int ceiling = 1 + (int) (Math.random() * this.geneCount);

        double initialAcceleration = 1.01; // By how much mutation value changes on failed changes
        long stepCeiling = 100; // Iterations of mutation accelerations to run before increasing/decreasing acceleration
        for (int indexToChange : indexesToChange) {
            if (counter++ >= ceiling)
                break;
            double bigAcceleration = initialAcceleration;
            double smallAcceleration = initialAcceleration;
            long step = 0;
            boolean set = false;
            while (!set) {
                double offsetValue = lowerBound + Math.random() * upperBound;
                try {
                    double newValue = speciesInstance.getGene(indexToChange) + offsetValue;
                    speciesInstance.setGenomeValue(indexToChange, newValue);
                } catch (IllegalArgumentException e) {
                    try {
                        double smallRightOffsetValue = offsetValue + smallAcceleration * step;
                        double newValue = speciesInstance.getGene(indexToChange) + smallRightOffsetValue;
                        speciesInstance.setGenomeValue(indexToChange, newValue);
                    } catch (IllegalArgumentException e1) {
                        try {
                            double smallLeftOffsetValue =  offsetValue - smallAcceleration * step;
                            double newValue = speciesInstance.getGene(indexToChange) + smallLeftOffsetValue;
                            speciesInstance.setGenomeValue(indexToChange, newValue);
                        } catch (IllegalArgumentException e2) {
                            try {
                                double bigRightOffsetValue = offsetValue + bigAcceleration * step;
                                double newValue = speciesInstance.getGene(indexToChange) + bigRightOffsetValue;
                                speciesInstance.setGenomeValue(indexToChange, newValue);
                            } catch (IllegalArgumentException e3) {
                                try {
                                    double bigLeftOffsetValue = offsetValue - bigAcceleration * step;
                                    double newValue = speciesInstance.getGene(indexToChange) + bigLeftOffsetValue;
                                    speciesInstance.setGenomeValue(indexToChange, newValue);
                                } catch (IllegalArgumentException e4) {
                                    if (step == stepCeiling) {
                                        step = 0;
                                        bigAcceleration *= 2;
                                        smallAcceleration /= 2;
                                    }
                                    step++;
                                    continue;
                                }
                            }
                        }
                    }
                }
                set = true;
            }
        }
    }

    private static List<Integer> getRandomIndexesToChange(int size, int amountToChange) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            indexes.add(i);
        }

        RandomSelector selector = new RandomSelector(indexes);

        List<Integer> indexesToChange = new ArrayList<>();
        for (int i = 0; i < amountToChange; i++) {
            indexesToChange.add((Integer) selector.get());
        }

        return indexesToChange;
    }

    @Override
    public String toString() {
        return "RandomOffsetMutation(" + this.power + ", " + this.geneCount + ")";
    }
}
