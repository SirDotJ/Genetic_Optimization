package genetic.mutation;

import genetic.Species;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Мутация выбирает случайнок количество генов и добавляет к ним случайное положительное/отрицательное число
public class RandomOffsetMutation extends Mutation {
    private RandomOffsetMutation() {}
    private final static RandomOffsetMutation instance = new RandomOffsetMutation();
    public static RandomOffsetMutation getInstance() { return instance; }

    @Override
    public void mutate(Species speciesInstance) {
        List<Double> genomeValues = speciesInstance.getGenomeValues();
        int genomeSize = genomeValues.size();
        int changeCount = (int) (Math.random() * genomeSize);

        ArrayList<Integer> indexesToChange = getRandomIndexesToChange(genomeSize, changeCount);

        // TODO: replace with Omega bounds for genome in mind later
        double lowerBound = -4d;
        double upperBound = 4d;
        indexesToChange.forEach((index) -> {
            double offsetValue = lowerBound + Math.random() * upperBound;
            genomeValues.set(index, genomeValues.get(index) + offsetValue);
        });

        speciesInstance.setGenomeValues(genomeValues);
    }

    private static ArrayList<Integer> getRandomIndexesToChange(int size, int amountToChange) {
        ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(new Integer[size]));
        for (int i = 0; i < size; i++) indexes.set(i, i);

        Random rand = new Random();
        ArrayList<Integer> indexesToChange = new ArrayList<>();
        for (int i = 0; i < amountToChange; i++) {
            int randomIndex = rand.nextInt(indexes.size());
            indexesToChange.add(randomIndex);
            indexesToChange.remove(randomIndex);
        }

        return indexesToChange;
    }
}
