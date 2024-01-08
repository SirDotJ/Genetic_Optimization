package genetic.generator;

import genetic.Species;

import java.lang.reflect.Constructor;
import java.util.List;

public abstract class Generator {
    // Пример объекта класса для генерации
    protected final Class<? extends Species> objectClass;
    protected final Constructor<?> objectConstructor;

    protected Generator(Class<? extends Species> objectClass) throws IllegalArgumentException {
        this.objectClass = objectClass;
        try {
            this.objectConstructor = this.objectClass.getConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Provided object has no defined constructors");
        }
    }
    public Class<? extends Species> getObjectClass() {
        return this.objectClass;
    }
    // Метод по созданию набора существ из примера объекта класса
    abstract public List<Object> generate();
    abstract public int getCount();
}
