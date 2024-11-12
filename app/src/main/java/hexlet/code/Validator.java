package hexlet.code;

public class Validator {

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }

    public <T1, T2> MapSchema<T1, T2> map() {
        return new MapSchema<>();
    }

}
