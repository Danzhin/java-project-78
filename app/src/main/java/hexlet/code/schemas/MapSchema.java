package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema<T> extends BaseSchema<Map<?, ?>> {

    private boolean requiredFilling = false;
    private Integer minSize = null;
    private Map<T, BaseSchema<T>> shapeSchemes = null;

    public MapSchema<T> required() {
        requiredFilling = true;
        return this;
    }

    public MapSchema<T> sizeof(int size) {
        minSize = size;
        return this;
    }

    public MapSchema<T> shape(Map<T, BaseSchema<T>> schemes) {
        shapeSchemes = schemes;
        return this;
    }

    public boolean checkShape(Map<T, T> map) {
        for (T property : shapeSchemes.keySet()) {
            BaseSchema<T> schema = shapeSchemes.get(property);
            if (!schema.isValid(map.get(property))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Map<?, ?> map) {
        return (!requiredFilling || map != null)
                && (minSize == null || map.size() >= minSize)
                && (shapeSchemes == null || checkShape((Map<T, T>) map));
    }

}
