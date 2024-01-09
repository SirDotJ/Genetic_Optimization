package genetic;

public class EvolutionAlgorithm {
    private double bestAdaptibility = Double.MIN_VALUE;
    private Genome bestGenome = null;
    private Population bestGenomePopulation = null;
    private double bestOverallAdaptibility = Double.MIN_VALUE;
    private Population bestOverallPopulation = null;
    private PopulationGroup currentGroup;

    public EvolutionAlgorithm(int populationCount) {
        this(populationCount, 0);
    }

    public EvolutionAlgorithm(int populationCount, int stepCount) {
		while (true) { // Used to avoid random StackOverflow errors
			try {
				this.currentGroup = new PopulationGroup(populationCount);
			} catch (StackOverflowError ignore) {
				continue;
			}
			break;
		}

        for (int i = 0; i < stepCount; i++) {
            this.nextStep();
        }
    }

    public Genome getBestGenome() {
        return this.bestGenome;
    }
    public Population getBestGenomePopulation() { return this.bestGenomePopulation; }
    public double getBestAdaptibility() { return this.bestAdaptibility; }
    public Population getBestOverallPopulation() { return this.bestOverallPopulation; }
    public double getBestOverallAdaptibility() { return this.bestOverallAdaptibility; }
    public void nextStep() {
        do { // Used to avoid random errors
            try {
                this.currentGroup.nextEvolutionStep();
            } catch (StackOverflowError error) {
                continue;
            }
            break;
        } while (true);

        double newBestAdaptibility = this.currentGroup.getBestSpecimen().adaptedness();
        if (newBestAdaptibility > this.bestAdaptibility) {
            this.bestGenome = this.currentGroup.getBestSpecimen().getGenome();
            this.bestAdaptibility = newBestAdaptibility;
            this.bestGenomePopulation = this.currentGroup.getPopulationWithBestSpecimen();
        }
        Population newBestOverallAdaptednessPopulation = this.currentGroup.getPopulationWithBestOverallAdaptedness();
        if (newBestOverallAdaptednessPopulation.getOverallAdaptedness() > this.bestOverallAdaptibility) {
            this.bestOverallAdaptibility = newBestOverallAdaptednessPopulation.getOverallAdaptedness();
            this.bestOverallPopulation = newBestOverallAdaptednessPopulation;
        }
    }
    public void optimize() {
        this.optimize(20);
    }
    public void optimize(int noChangeCeiling) {
        long stepCounter = 1;
        int noChangeCounter = 0;
        do {
            System.out.println("Running step №" + stepCounter++ + "...");
            Genome previousBest = this.getBestGenome();
            this.nextStep();
            Genome newBest = this.getBestGenome();

            if (previousBest != null && previousBest.equals(newBest)) {
                noChangeCounter++;
            }
            System.out.println("\tCurrent adaptibility: " + this.getBestAdaptibility());
        } while (noChangeCounter < noChangeCeiling);
    }
    public void runEvolution(int stepCount) {
        for (int i = 0; i < stepCount; i++) {
            this.nextStep();
        }
    }
}
