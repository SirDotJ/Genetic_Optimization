package common;

import javax.sql.rowset.Predicate;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class Omega {
    public static int n; //переменная для хранения количества значений
    public static double[] values; //массив значений
    public static double[] rangeLimitsLeft; //массив левых границ
    public static double[] rangeLimitsRight; //массив правых границ


    Omega(int valuesAmount,double[] rLimitsLeft,double[] rLimitsRight){
        //valuesAmount - обозначенное количество значений
        //rLimitsLeft и rLimitsRight - массивы границ для проверки
            rangeLimitsLeft = new double[valuesAmount];
            rangeLimitsRight = new double[valuesAmount];
            rangeLimitsLeft = rLimitsLeft;
            rangeLimitsRight = rLimitsRight;
            n = valuesAmount;
    }


    //v - массив проверяемых значений
    public static boolean check(double[] v){
        try {
            if (n != v.length) // если предоставляемое количество значений
                               // не равно обозначенному
                throw new IllegalAccessException("Недопустимое количество значений.");
            else {
                values = new double[n];
                values = v;
            }
            //проверка принадлежности к диапазонам
        for (int i = 0; i<values.length; i++){
            if ((values[i]<rangeLimitsLeft[i])||(values[i]>rangeLimitsRight[i]))
                //если какой-то из элементов вне своего диапазона - возвращаем false
                return false;
        }
        } catch (IllegalAccessException e){
            System.out.print(e);
            return false;
        }
        //если прошли через весь диапазон - возвращаем true
        return true;
    }



    public static int[] findMisfits(double[] v){
        int[] misfitsIndexArray = new int[n];
        values = v;
        for (int i = 0; i<values.length; i++){
            if ((values[i]<rangeLimitsLeft[i])||(values[i]>rangeLimitsRight[i]))
                //если какой-то из элементов вне своего диапазона - возвращаем индекс элемента
                misfitsIndexArray[i] = i;
            else misfitsIndexArray[i] = -1;
        }

        if (Arrays.stream(misfitsIndexArray).allMatch(t -> t == -1)) return null;
        else return misfitsIndexArray;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] misfits = new int[n];
        double[] values = new double[] {1,-2.65,3.5,-2.98,-3.11,2.95,-5.13,2,1.56,-1.22};
        double[] l = new double[]      {-1, -3,  0,   -2,  -4  , 1,  -6.5 ,1, 1,   -2  };
        double[] r = new double[]      { 3,  3,  5,    0,   4  , 8,   0.5 ,3, 2,    2  };
        Omega OOMEGAA = new Omega(n,l,r);
        if (OOMEGAA.check(values)) System.out.print("все значения прошли проверку");
        else {
            misfits = OOMEGAA.findMisfits(values);
            for (int i = 0; i<n; i++) System.out.print(misfits[i]+" ");
        }
    }
}
