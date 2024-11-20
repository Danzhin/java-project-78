package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck(num -> num != null && num > 0);
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        addCheck(num -> num != null && minValue <= num && num <= maxValue);
        return this;
    }

}
