package hexlet.code.schemas;

public class NumberSchema {

    private boolean requiredFilling = false;

    private boolean isPositive = false;

    private boolean hasRange = false;
    private int minValue;
    private int maxValue;

    public NumberSchema required() {
        requiredFilling = true;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        hasRange = true;
        this.minValue = minValue;
        this.maxValue = maxValue;
        return this;
    }

    public boolean isValid(Integer number) {
        if (requiredFilling) {
            if (number == null) {
                return false;
            }
        }
        if (isPositive) {
            if (number <= 0) {
                return false;
            }
        }
        if (hasRange) {
            return (number >= minValue) && (number <= maxValue);
        }
        return true;
    }

}
