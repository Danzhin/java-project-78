package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck(str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck(str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(str -> str.contains(substring));
        return this;
    }

}
