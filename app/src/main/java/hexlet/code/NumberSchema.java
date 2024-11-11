package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {

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

    public NumberSchema range(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public boolean isValid(Integer number) {
        if (requiredFilling && number == null) {
            return false;
        }
        if (isPositive && number <= 0) {
            return false;
        }
        return minValue == null || (number >= minValue) && (number <= maxValue);
    }

}
