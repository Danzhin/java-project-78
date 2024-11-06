package hexlet.code.schemas;

public class StringSchema {

    private boolean requiredFilling = false;

    private boolean hasMinLength = false;
    private int minLength;

    private boolean hasRequiredSubstring = false;
    private String requiredSubstring;

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

    public boolean isValid(String string) {
        if (requiredFilling) {
            if (string == null || string.isEmpty()) {
                return false;
            }
        }
        if (hasMinLength) {
            if (string.length() < minLength) {
                return false;
            }
        }
        if (hasRequiredSubstring) {
            return string.contains(requiredSubstring);
        }
        return true;
    }

}
