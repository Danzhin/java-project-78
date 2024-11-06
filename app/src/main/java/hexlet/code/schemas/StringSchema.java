package hexlet.code.schemas;

public class StringSchema {

    private boolean requiredFilling = false;
    private boolean hasMinLength = false;
    private boolean hasRequiredSubstring = false;
    private Integer minLength = null;
    private String requiredSubstring = null;

    public StringSchema required() {
        requiredFilling = true;
        return this;
    }

    public StringSchema minLength(int length) {
        hasMinLength = true;
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        hasRequiredSubstring = true;
        requiredSubstring = substring;
        return this;
    }

    public boolean isValid(String value) {
        if (requiredFilling) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }
        if (hasMinLength) {
            if (value.length() < minLength) {
                return false;
            }
        }
        if (hasRequiredSubstring) {
            return value.contains(requiredSubstring);
        }
        return true;
    }

}
