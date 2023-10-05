package genetic.birth;

import genetic.Species;

import java.util.List;

// Интерфейс описывает получение нового объекта класса Species из двух других объектов класса Species
public abstract class Birth {
    // Определения по умолчанию определяет проверку на совместимость предложенных объектов класса
    public List<Double> reproduction(Species mom, Species dad) throws IllegalArgumentException {
        if (!mom.getClass().equals(dad.getClass()))
            throw new IllegalArgumentException("Provided Species objects are not of the same class");

        return null;
    }
}
