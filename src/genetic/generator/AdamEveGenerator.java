package genetic.generator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AdamEveGenerator extends Generator {
    public AdamEveGenerator(Class<?> objectClass) {
        super(objectClass);
    }

    @Override
    public List<Object> generate() throws IllegalStateException {
        List<Object> adamAndEve = new ArrayList<>();
        try {
            adamAndEve.add(this.objectConstructor.newInstance()); // Adam
            adamAndEve.add(this.objectConstructor.newInstance()); // Eve
        } catch (InstantiationException e) {
            throw new IllegalStateException("Current set class is an abstract class");
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Current set class's default constructor cannot be accessed in this context");
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Current set class does not have a default constructor set");
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Current set class's constructor threw an exception: " + e);
        }

        return adamAndEve;
    }
}
