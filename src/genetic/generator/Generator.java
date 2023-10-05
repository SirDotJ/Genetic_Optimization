package genetic.generator;

import java.lang.reflect.Constructor;
import java.util.List;

public abstract class Generator {
    // Пример объекта класса для генерации
    protected final Class<?> objectClass;
    protected final Constructor<?> objectConstructor;

    protected Generator(Class<?> objectClass) throws IllegalArgumentException {
        this.objectClass = objectClass;
        try {
            this.objectConstructor = this.objectClass.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Provided object has no defined constructors");
        }
    }
    // Метод по созданию набора существ из примера объекта класса
    abstract public List<Object> generate();
}
