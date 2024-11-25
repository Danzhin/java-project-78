package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addNonNullCheck();
        addCheck("notEmpty", str -> !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addNonNullCheck();
        addCheck("minLength", str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addNonNullCheck();
        addCheck("contains", str -> str.contains(substring));
        return this;
    }

}
