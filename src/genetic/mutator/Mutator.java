package genetic.mutator;

import genetic.Species;

import java.util.List;

public abstract class Mutator {
    protected int count;
    protected Mutator() {
        this.count = 2;
    }
    protected Mutator(int count) {
        this.count = count;
    }
    abstract public
        <TS extends Species>
    List<TS> choose(List<TS> population);
}
