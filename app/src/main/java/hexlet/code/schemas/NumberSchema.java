package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addChecks(num -> num > 0);
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        addChecks(num -> minValue <= num && num <= maxValue);
        return this;
    }
}