package common;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

// Класс берёт на вход набор элементов и возвращает случайный из них без повторений, при отборе всех, начинает заново выбор
public class RandomSelector {
    private final List<Object> objects;
    private Set<Object> availableObjects;
    public RandomSelector(List<Object> objects) {
        this.objects = objects;
        this.availableObjects = new HashSet<>(this.objects);
    }
    public Object get() {
        if (this.availableObjects == null || this.availableObjects.isEmpty()) {
            this.availableObjects = new HashSet<>(this.objects);
            return this.get();
        }

        Object[] arrayFromAvailableSet = this.availableObjects.toArray();
        Random random = new Random();
        int randomIndex = random.nextInt(this.availableObjects.size());
        Object chosenObject = arrayFromAvailableSet[randomIndex];
        this.availableObjects.remove(chosenObject);
        return chosenObject;
    }
}
