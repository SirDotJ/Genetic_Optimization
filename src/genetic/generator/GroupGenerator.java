package genetic.generator;


import genetic.Species;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GroupGenerator extends Generator {
    private final static int DEFAULT_GROUP_SIZE = 10;
    private final int groupSize;
    public GroupGenerator(Class<? extends Species> objectClass) {
        this(objectClass, DEFAULT_GROUP_SIZE);
    }
    public GroupGenerator(Class<? extends Species> objectClass, int groupSize) {
        super(objectClass);
        this.groupSize = groupSize;
    }
    public int getGroupSize() {
        return groupSize;
    }
    @Override
    public List<Object> generate() {
        return this.generate(this.groupSize);
    }

    @Override
    public int getCount() {
        return this.groupSize;
    }

    private List<Object> generate(int amount) {
        List<Object> group = new ArrayList<>();
        try {
            for (int i = 0; i < amount; i++)
                group.add(this.objectConstructor.newInstance());
        } catch (InstantiationException e) {
            throw new IllegalStateException("Current set class is an abstract class");
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Current set class's default constructor cannot be accessed in this context");
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Current set class does not have a default constructor set");
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("Current set class's constructor threw an exception: " + e);
        }

        return group;
    }

    @Override
    public String toString() {
        return "GroupGenerator(" + this.groupSize + ")";
    }
}
