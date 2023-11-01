package genetic.breeder;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

//прайд размножение(один большой чувак, куча женщин)(выбрать одного самого можного остальные случайные)
public class PrideBreeder implements Breeder{

    public int partnerAmount;
    public PrideBreeder(){
        partnerAmount = 1;
    }
    public PrideBreeder(int X){
        partnerAmount = X;
    }

    @Override
    public List<Species> choose(List<Species> speciesList) {
        List<Species> breedList = new ArrayList<>();
        List<Species> LostList = List.copyOf(speciesList); //исходный список, из которого выбираем самых сильных
        breedList.add(new SurvivalOfTheFittestBreeder(1).choose(LostList).get(0));
        LostList.remove(breedList.get(0));
        breedList.addAll(new EqualChanceBreeder(partnerAmount).choose(LostList));
        return breedList;
    }
}
