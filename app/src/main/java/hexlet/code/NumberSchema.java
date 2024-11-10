package hexlet.code;

public class NumberSchema extends BaseSchema {

    private boolean requiredFilling = false;
    private boolean isPositive = false;
    private Integer minValue = null;
    private Integer maxValue = null;;

    public NumberSchema required() {
        requiredFilling = true;
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        Integer number = (Integer) value;
        if (requiredFilling && number == null) {
            return false;
        }
        if (isPositive && number <= 0) {
            return false;
        }
        return minValue == null || (number >= minValue) && (number <= maxValue);
    }

}
