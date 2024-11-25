package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addCheck("minLength", str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck("contains", str -> str.contains(substring));
        return this;
    }

}
