package common;

import java.util.Arrays;
import java.util.List;

public class ParameterRestrictions {
    protected List<NumberRange> parameterRanges;
    public ParameterRestrictions() { // описывает отсутствие ограничений к параметрам
        this(null);
    }
    public ParameterRestrictions(List<NumberRange> parameterRanges) {
        this.parameterRanges = parameterRanges;
    }

    public List<NumberRange> getParameterRanges() {
        return parameterRanges;
    }

    public boolean check(int index, double value) {
        if (this.parameterRanges == null)
            return true;

        return this.parameterRanges.get(index).check(value);
    }
    public boolean check(Parameters parameters) {
        if (this.parameterRanges == null)
            return true;

        return this.check(parameters.getParameterValues());
    }
    public boolean check(List<Double> values) {
        if (this.parameterRanges == null)
            return true;

        try {
            for (int i = 0; i < values.size(); i++) {
                double value = values.get(i);
                if (!this.check(i, value))
                    return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public List<Integer> findMisfits(Parameters parameters){
        if (this.parameterRanges == null)
            return null;

        return this.findMisfits(parameters.getParameterValues());
    }
    public List<Integer> findMisfits(List<Double> values) {
        if (this.parameterRanges == null)
            return null;

        List<Integer> misfitsIndexes = Arrays.asList(new Integer[values.size()]);
        for (int i = 0; i < values.size(); i++) {
            double value = values.get(i);
            NumberRange range = this.parameterRanges.get(i);
            int foundIndex;
            if (!range.check(value))
                foundIndex = 1;
            else
                foundIndex = -1;
            misfitsIndexes.set(i, foundIndex);
        }

        if (misfitsIndexes.stream().allMatch(foundIndex -> foundIndex == -1))
            return null;
        else
            return misfitsIndexes;
    }
}
