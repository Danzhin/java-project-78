package hexlet.code;

public class StringSchema extends BaseSchema {

    private boolean requiredFilling = false;
    private Integer minLength = null;
    private String requiredSubstring = null;

    public StringSchema required() {
        requiredFilling = true;
        return this;
    }

    public StringSchema minLength(Integer length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        requiredSubstring = substring;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        String string = (String) value;
        if (requiredFilling && (string == null || string.isEmpty())) {
            return false;
        }
        if (minLength != null && string.length() < minLength) {
            return false;
        }
        return requiredSubstring == null || string.contains(requiredSubstring);
    }

}
