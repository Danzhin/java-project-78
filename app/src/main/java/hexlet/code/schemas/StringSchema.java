package hexlet.code.schemas;

public class StringSchema {

    private boolean requiredFilling = false;
    private Integer minLength = null;
    private String requiredSubstring = null;

    public StringSchema required() {
        requiredFilling = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        requiredSubstring = substring;
        return this;
    }

    public boolean isValid(String value) {
        if (requiredFilling) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }
        if (minLength != null) {
            if (value.length() < minLength) {
                return false;
            }
        }
        if (requiredSubstring != null) {
            return value.contains(requiredSubstring);
        }
        return true;
    }
}
