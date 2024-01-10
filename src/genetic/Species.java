package genetic;

import genetic.birth.Birth;

import java.util.List;

public abstract class Species implements Comparable<Species> {
    // Метод определяет используемые параметры для класса (вид скрещивания, мутации)
    protected enum BUILD_INDEXES {
        BIRTH
    }

    protected final Birth birthMethod;
    protected Species(List<Object> parameters) {
        this.birthMethod = (Birth) parameters.get(BUILD_INDEXES.BIRTH.ordinal());
    }
    protected Genome genome;
    public double getGene(int index) {
        return this.genome.get(index);
    }
    public Genome getGenome() {
        return genome;
    }
    public abstract double adaptedness();
    public List<Double> getGenomeValues() {
        return this.genome.getGeneValues().getParameterValues();
    }
    public void setGenomeValues(List<Double> newValues) throws IllegalArgumentException {
        for (int i = 0; i < newValues.size(); i++) {
            double value = newValues.get(i);
            try {
                this.setGenomeValue(i, value);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Provided values are not correct: value " + i + " is out of range");
            }
        }
    }
    public void setGenomeValue(int index, double value) throws IllegalArgumentException {
        if (!this.genome.checkGenomeValue(index, value))
            throw new IllegalArgumentException("Provided value is out of range for Genome");
        this.genome.setGeneValue(index, value);
    }
    abstract public Species reproduce(Species partner);
    static public List<Species> parseListObjectToSpecies(List<Object> providedList) throws IllegalArgumentException {
        List<Species> parsedValue;
        try {
            parsedValue = (List<Species>) (Object) providedList; // При ошибке будет поймана при помощи catch
        } catch (Exception e) {
            throw new IllegalArgumentException("Passed List<Object> cannot be case to List<Specimen>: " + e.toString());
        }
        return (parsedValue);
    }

    @Override
    public int compareTo(Species o) {
        double adaptednessThis = this.adaptedness();
        double adaptednessO = o.adaptedness();
        return Double.compare(adaptednessThis, adaptednessO);
    }
}
