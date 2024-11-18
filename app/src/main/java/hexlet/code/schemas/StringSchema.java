package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addCheck(checkID++, str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int inputMinLength) {
        addCheck(checkID++, str -> str.length() >= inputMinLength);
        return this;
    }

    public StringSchema contains(String inputSubstring) {
        addCheck(checkID++, str -> str.contains(inputSubstring));
        return this;
    }

}
