package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addCheck(checkID++, Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addCheck(checkID++, num -> num > 0);
        return this;
    }

    public NumberSchema range(int inputMinValue, int inputMaxValue) {
        addCheck(checkID++, num -> num >= inputMinValue && inputMaxValue <= num);
        return this;
    }

}
