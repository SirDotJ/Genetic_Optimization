package genetic;

import genetic.birth.Birth;
import genetic.mutation.Mutation;

import java.util.List;

public abstract class Species {
    // Метод определяет используемые параметры для класса (вид скрещивания, мутации)
    protected enum BUILD_INDEXES {
        BIRTH,
        MUTATION
    }
    protected final Birth birthMethod;
    protected final Mutation mutationMethod;
    protected Species(List<Object> parameters) {
        this.birthMethod = (Birth) parameters.get(BUILD_INDEXES.BIRTH.ordinal());
        this.mutationMethod = (Mutation) parameters.get(BUILD_INDEXES.MUTATION.ordinal());
    }
    protected Genome genome;
    public double getGene(int index) {
        return this.genome.get(index);
    }
    public Genome getGenome() {
        return genome;
    }
    public double adaptedness() {return 0;} //метод для вычисления приспособленности
    public List<Double> getGenomeValues() {
        return this.genome.getGeneValues().getParameterValues();
    }
    public void setGenomeValues(List<Double> newValues) { this.genome.setGeneValues(newValues); }
    abstract public Species reproduce(Species partner);
    abstract public void mutate();
    static public List<Species> parseListObjectToSpecies(List<Object> providedList) throws IllegalArgumentException {
        List<Species> parsedValue;
        try {
            parsedValue = (List<Species>) (Object) providedList; // При ошибке будет поймана при помощи catch
        } catch (Exception e) {
            throw new IllegalArgumentException("Passed List<Object> cannot be case to List<Specimen>: " + e.toString());
        }
        return (parsedValue);
    }
}
