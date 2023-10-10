package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabParameters extends Parameters {
    // Ограничения для параметров уравнения формулы лабораторной работы (Omega) обозначено в документации
    public static final List<NumberRange> LAB_PARAMETER_RANGES = new ArrayList<>(Arrays.asList(
            new NumberRange(5, 13), // x1
            new NumberRange(0, 11), // x2
            new NumberRange(-10, 0), // x3
            new NumberRange(3, 6), // x4
            new NumberRange(0, 2), // x5
            new NumberRange(-6, 3), // x6
            new NumberRange(1, 4), // x7
            new NumberRange(1, 7), // x8
            new NumberRange(-2, 2), // x9
            new NumberRange(-3, 3) // x10
    )); // ВАЖНО!!!: x1 * x8 должно быть положительным числом из-за натурального логорифма в формуле
    public static final int PARAMETER_COUNT = 10; // количество переменных в формуле
    // Кастыль ниже с проверкой на размер необходим
    // для проверки передаваемого значения до передачи в super конструктор
    // Без кастыля конструктор необходимо будет заново прописывать и копировать из Parameters
    // что плохо поддерживается
    public LabParameters(List<Double> parameterValues) throws IllegalArgumentException {
        super(parameterValues.size() == PARAMETER_COUNT ? parameterValues : throwInvalidValuesSize(),
              new ParameterRestrictions(LAB_PARAMETER_RANGES));
    }
    private static List<Double> throwInvalidValuesSize() throws IllegalArgumentException {
        throw new IllegalArgumentException("Provided values have to be of size " + PARAMETER_COUNT);
    }
}
