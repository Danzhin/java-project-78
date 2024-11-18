package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {

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

    public NumberSchema range(int value1, int value2) {
        minValue = value1;
        maxValue = value2;
        return this;
    }

    @Override
    public boolean isValid(Integer number) {
        return (!requiredFilling || number != null)
                && ((!isPositive || number > 0)
                && (minValue == null || (number >= minValue) && (number <= maxValue)));
    }

}
