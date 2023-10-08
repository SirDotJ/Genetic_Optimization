package genetic.killer;

import genetic.Species;

import java.util.List;

public class EqualChanceKiller extends Killer{
    int reduceAmount;
    public EqualChanceKiller(){
        reduceAmount = 1;
    }
    public EqualChanceKiller(int X){
        reduceAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {
        List<Species> killList = speciesList;
        for (int i = 0; i<(speciesList.size()-reduceAmount); i++){
            int killIndex = (int) (Math.random() * killList.size()); //получаем случайный индекс от 0 до длины списка для удаления
            killList.remove(killIndex); //удаляем случайно выбранный элемент
        }
        return killList; //список для редукции
    }
}
