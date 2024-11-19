package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck("positive", num -> num > 0);
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        addCheck("range", num -> minValue <= num && num <= maxValue);
        return this;
    }

}
