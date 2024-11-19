package hexlet.code.schemas;

import java.util.Objects;

public class NumberSchema extends BaseSchema<Integer> {

    public final NumberSchema required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public final NumberSchema positive() {
        addChecks(num -> num > 0);
        return this;
    }

    public final NumberSchema range(int minValue, int maxValue) {
        addChecks(num -> minValue <= num && num <= maxValue);
        return this;
    }
}