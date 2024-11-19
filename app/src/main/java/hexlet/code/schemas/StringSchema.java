package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck("required", str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int inputMinLength) {
        addCheck("minLength", str -> str.length() >= inputMinLength);
        return this;
    }

    public StringSchema contains(String inputSubstring) {
        addCheck("contains", str -> str.contains(inputSubstring));
        return this;
    }

}
