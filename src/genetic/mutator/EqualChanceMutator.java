package genetic.mutator;

import common.RandomSelector;
import genetic.Species;

import java.util.ArrayList;
import java.util.List;

public class EqualChanceMutator extends Mutator {
    public EqualChanceMutator() {
        super();
    }
    public EqualChanceMutator(int count) {
        super(count);
    }
    @Override
    public
        <TS extends Species>
    List<TS> choose(List<TS> population) {
        RandomSelector selector = new RandomSelector(population);
        List<TS> chosenToMutate = new ArrayList<>();
        for (int i = 0; i < this.count; i++)
            chosenToMutate.add((TS) selector.get());
        return chosenToMutate;
    }

    @Override
    public String toString() {
        return "EqualChanceMutator(" + this.count + ")";
    }
}
