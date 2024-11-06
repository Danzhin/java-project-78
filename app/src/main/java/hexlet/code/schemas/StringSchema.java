package hexlet.code.schemas;

class StringSchema {

    private boolean isRequired = false;
    private int minLength = 0;
    private String substring = "";

    public StringSchema required() {
        isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.substring = substring;
        return this;
    }

    public boolean isValid(String value) {

        if (isRequired) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }

        if (minLength != 0) {
            if (value.length() < minLength) {
                return false;
            }
        }

        if (!value.isEmpty()) {
            return value.contains(substring);
        }

        return true;
    }
}
