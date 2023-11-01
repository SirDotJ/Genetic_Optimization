package genetic.killer;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

public class RouletteKiller implements Killer {
    public int reduceAmount;
    public RouletteKiller(){
        reduceAmount = 1;
    }
    public RouletteKiller(int X){
        reduceAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {

        List<Species> killList = new ArrayList<>();
        List<Species> survivorsList = speciesList; //исходный список

        //создаем массив softmax приспособленностей
        double[] softmaxAdaptedness = new double[survivorsList.size()];
        double sum = 0;
        for (int i = 0; i < survivorsList.size(); i++) { //сумма всех приспособленностей
            sum+=survivorsList.get(i).adaptedness();
        }
        for (int i = 0; i < survivorsList.size(); i++) {
            softmaxAdaptedness[i]=survivorsList.get(i).adaptedness()/sum;
        }

        //создаем массив диапазонов
        double[] rangeArray = new double[survivorsList.size()];
        rangeArray[0]=softmaxAdaptedness[0];
        for (int i = 1; i < survivorsList.size(); i++) {
            rangeArray[i]=rangeArray[i-1]+softmaxAdaptedness[i];
        }
        int j = 0;
        while (j<reduceAmount) { //нужно выбрать reduceAmount особей

            double killNumber = Math.random(); //генерируем число от 0 до 1
            int killIndex = -1;

            for (int i = 0; i < rangeArray.length-1; i++) { //проверяем сгенерированное число на принадлежность диапазонам

                if (killNumber<rangeArray[0]){ //если между 0 и первой границей
                    killIndex = 0;
                    break;
                }
                if (killNumber>rangeArray[rangeArray.length]) { //если между последней границей и 1
                    killIndex = rangeArray.length;
                    break;
                }
                if ((killNumber>rangeArray[i])&&(killNumber<rangeArray[i+1])){
                    killIndex = i;
                    break;
                }
            }
            if (killList.contains(survivorsList.get(killIndex))){
                //если элемент уже выпадал, пробуем еще раз
                continue;
            } else {
                killList.add(survivorsList.get(killIndex)); //добавляем в список для редукции
                j++;
            }
        }
        return killList;
    }
}
