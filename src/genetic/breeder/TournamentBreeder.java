package genetic.breeder;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

//выбирается случайный набор и из них выбирается самый сильный
public class TournamentBreeder implements Breeder{
    int countAmount;
    int breedAmount;
    public TournamentBreeder(){
        countAmount = 3;
        breedAmount = 2;
    }
    public TournamentBreeder(int countAmount, int breedAmount){
        this.countAmount = countAmount;
        this.breedAmount = breedAmount;
    }

    @Override
    public <T extends Species> List<T> choose(List<T> speciesList) {
        return new ArrayList<>(
                new SurvivalOfTheFittestBreeder(breedAmount)
                .choose(
                new EqualChanceBreeder(countAmount)
                .choose(speciesList)));
    }
    @Override
    public String toString() {
        return "TournamentBreeder(" + this.countAmount + ", " + this.breedAmount + ")";
    }
}
