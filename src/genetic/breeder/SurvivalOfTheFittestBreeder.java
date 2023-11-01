package genetic.breeder;

import genetic.Species;
import java.util.*;

//противоположность weakest
public class SurvivalOfTheFittestBreeder implements Breeder{
    public int breedAmount;
    public SurvivalOfTheFittestBreeder(){
        breedAmount = 1;
    }
    public SurvivalOfTheFittestBreeder(int X){
        breedAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {

        List<Species> breedList = new ArrayList<>();
        List<Species> LostList = speciesList; //исходный список, из которого выбираем самых сильных
        int breedIndex = -1; //индекс самого сильного
        double maxAdaptedness = Double.MIN_VALUE; //приспособленность самого сильного

        for (int j = 0; j < breedAmount; j++) { //нужно выбрать breedAmount особей

            for (int i = 0; i < LostList.size(); i++) { //ищем самого сильного
                if (LostList.get(i).adaptedness() > maxAdaptedness) {
                    maxAdaptedness = LostList.get(i).adaptedness();
                    breedIndex = i;
                }
            }
            breedList.add(LostList.get(breedIndex)); //добавляем в список для редукции
            LostList.remove(breedIndex); //удаляем из списка выживших и продолжаем отбор
        }
        return breedList; //список для редукции
    }
}
