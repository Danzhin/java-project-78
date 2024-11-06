package hexlet.code.schemas;

import java.util.Map;

public class MapSchema {

    private boolean requiredFilling = false;

    private boolean hasMinSize = false;
    private int minSize;

    public MapSchema required() {
        requiredFilling = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        hasMinSize = true;
        minSize = size;
        return this;
    }

    public boolean isValid(Map map) {
        if (requiredFilling) {
            if (map == null) {
                return false;
            }
        }
        if (hasMinSize) {
            return map.size() >= minSize;
        }
        return true;
    }

}
