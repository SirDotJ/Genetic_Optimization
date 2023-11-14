package genetic.mutation;

import genetic.Species;

public abstract class Mutation {
    private static final int DEFAULT_GENE_COUNT = 1; /* Максимум не взять так как мы не знаем сколько будет генов позже */
    private static final double DEFAULT_POWER = 0.5;
    protected final int geneCount; /* Максимальное количество генов генома для изменения */
    protected final double power; /* Определяет верхний предел изменения */
    protected Mutation() {
        this.geneCount = DEFAULT_GENE_COUNT;
        this.power = DEFAULT_POWER;
    }
    protected Mutation(double power, int geneCount) {
        this.geneCount = geneCount;
        this.power = power;
    }
    protected Mutation(double power) {
        this(power, DEFAULT_GENE_COUNT);
    }
    protected Mutation(int geneCount) {
        this(DEFAULT_POWER, geneCount);
    }
    abstract public void mutate(Species speciesInstance);
}
