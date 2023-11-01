package genetic.breeder;

import genetic.Species;

import java.util.ArrayList;
import java.util.List;

//рандом на основе softmax
//чем больше приспособленность, тем вероятнее что его выберут
public class RouletteBreeder implements Breeder{
    public int breedAmount;
    public RouletteBreeder(){
        breedAmount = 1;
    }
    public RouletteBreeder(int X){
        breedAmount = X;
    }
    @Override
    public List<Species> choose(List<Species> speciesList) {

        List<Species> breedList = new ArrayList<>();
        List<Species> LostList = speciesList; //исходный список

        //создаем массив softmax приспособленностей
        double[] softmaxAdaptedness = new double[LostList.size()];
        double sum = 0;
        for (int i = 0; i < LostList.size(); i++) { //сумма всех приспособленностей
            sum+=LostList.get(i).adaptedness();
        }
        for (int i = 0; i < LostList.size(); i++) {
            softmaxAdaptedness[i]=LostList.get(i).adaptedness()/sum;
        }

        //создаем массив диапазонов
        double[] rangeArray = new double[LostList.size()];
        rangeArray[0]=softmaxAdaptedness[0];
        for (int i = 1; i < LostList.size(); i++) {
            rangeArray[i]=rangeArray[i-1]+softmaxAdaptedness[i];
        }
        int j = 0;
        while (j < breedAmount) { //нужно выбрать reduceAmount особей

            double breedNumber = Math.random(); //генерируем число от 0 до 1
            int breedIndex = -1;

            for (int i = 0; i < rangeArray.length-1; i++) { //проверяем сгенерированное число на принадлежность диапазонам

                if (breedNumber<rangeArray[0]){ //если между 0 и первой границей
                    breedIndex = 0;
                    break;
                }
                if (breedNumber>rangeArray[rangeArray.length]) { //если между последней границей и 1
                    breedIndex = rangeArray.length;
                    break;
                }
                if ((breedNumber>rangeArray[i])&&(breedNumber<rangeArray[i+1])){
                    breedIndex = i;
                    break;
                }
            }
            if (breedList.contains(LostList.get(breedIndex))){
                //если элемент уже выпадал, пробуем еще раз
                continue;
            } else {
                breedList.add(LostList.get(breedIndex)); //добавляем в список для редукции
                j++;
            }
        }
        return breedList;
    }
}
