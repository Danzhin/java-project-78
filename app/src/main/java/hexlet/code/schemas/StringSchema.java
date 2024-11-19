package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addChecks(str -> str != null && !str.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addChecks(str -> str.length() >= length);
        return this;
    }

    public StringSchema contains(String substring) {
        addChecks(str -> str.contains(substring));
        return this;
    }

}