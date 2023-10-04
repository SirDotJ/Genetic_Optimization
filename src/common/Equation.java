package common;

import java.util.List;

// Класс определяет интерфейс функций от нескольких переменных
public class Equation {
    @FunctionalInterface
    public interface Formula {
        double calculate(List<Double> parameters);
    }
}
