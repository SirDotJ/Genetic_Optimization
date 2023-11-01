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
    public List<Species> choose(List<Species> speciesList) {
        List<Species> breedList = new ArrayList<>();
        breedList.addAll(new SurvivalOfTheFittestBreeder(breedAmount).choose(new EqualChanceBreeder(countAmount).choose(speciesList)));
        return breedList;
    }
}
