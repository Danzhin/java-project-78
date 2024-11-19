package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {

    public final StringSchema required() {
        addChecks(str -> str != null && !str.isEmpty());
        return this;
    }

    public final StringSchema minLength(int length) {
        addChecks(str -> str.length() >= length);
        return this;
    }

    public final StringSchema contains(String substring) {
        addChecks(str -> str.contains(substring));
        return this;
    }

}