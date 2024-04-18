package common;

import java.util.List;
import java.util.Map.Entry;

public class NumberRange {
    private final double lowerBound;
    private final double upperBound;

    public NumberRange(double value1, double value2) {
        this.lowerBound = Math.min(value1, value2);
        this.upperBound = Math.max(value1, value2);
    }

    public NumberRange(Entry<Double, Double> values) {
        this(values.getKey(), values.getValue());
    }

    public NumberRange(double[] values) {
        this(values[0], values[1]);
    }

    public NumberRange(List<Double> values) throws IllegalArgumentException {
        this(new double[] {values.get(0), values.get(1)});
    }
    public boolean check(double value) {
        return (value >= this.lowerBound && value <= this.upperBound);
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }
    public double getRandomNumber() {
        return Math.random() * (this.upperBound - this.lowerBound) + this.lowerBound;
    }
}
