package genetic.killer;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

public class WeakestKiller extends Killer{
    public int reduceAmount;
    public WeakestKiller(){
        reduceAmount = 1;
    }
    public WeakestKiller(int X){
        reduceAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {

        List<Species> killList = new ArrayList<>();
        List<Species> survivorsList = speciesList; //исходный список, из которого выбираем самых слабых
        int killIndex = -1; //индекс самого слабого
        double minAdaptedness = 99999; //приспособленность самого слабого

        for (int j = 0;j<reduceAmount;j++) { //нужно выбрать reduceAmount особей

            for (int i = 0; i < survivorsList.size(); i++) { //ищем самого слабого
                if (survivorsList.get(i).adaptedness() < minAdaptedness) {
                    minAdaptedness = survivorsList.get(i).adaptedness();
                    killIndex = i;
                }
            }
            killList.add(survivorsList.get(killIndex)); //добавляем в список для редукции
            survivorsList.remove(killIndex); //удаляем из списка выживших и продолжаем отбор
        }
        return killList; //список для редукции
    }
}
