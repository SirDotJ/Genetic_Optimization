package genetic.killer;

import genetic.Species;

import java.util.*;

public class ElementOfTheEliteKiller extends Killer{
    public int eliteAmount;
    public int reduceAmount;
    public ElementOfTheEliteKiller(){
        eliteAmount = 1;
        reduceAmount = 1;
    }
    public ElementOfTheEliteKiller(int Y,int X){
        eliteAmount = Y;
        reduceAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {
        List<Species> eliteList = new ArrayList<>(); //список элит
        List<Species> otherList = new ArrayList<>(); //список плебеев
        List<Species> killList = new ArrayList<>(); //список на редукцию
        List<Species> survivorsList = speciesList; //исходный список, из которого выбираем элиту

        int bestIndex = -1; //индекс самого сильного
        double maxAdaptedness = -99999; //приспособленность самого сильного

        for (int j = 0;j<eliteAmount;j++) { //нужно выбрать eliteAmount особей

            for (int i = 0; i < survivorsList.size(); i++) { //ищем самого сильного
                if (survivorsList.get(i).adaptedness() > maxAdaptedness) {
                    maxAdaptedness = survivorsList.get(i).adaptedness();
                    bestIndex = i;
                }
            }
            eliteList.add(survivorsList.get(bestIndex)); //добавляем в список элиты
            survivorsList.remove(bestIndex); //удаляем из общего списка и продолжаем отбор
        }

        otherList = survivorsList; //остаются все кроме элиты

        for (int i = 0; i<reduceAmount; i++){
            int killIndex = (int) (Math.random() * otherList.size()); //получаем случайный индекс от 0 до длины списка для удаления
            killList.add(otherList.get(killIndex));
            otherList.remove(killIndex); //удаляем случайно выбранный элемент
        }
        return killList; //список для редукции
    }
}
