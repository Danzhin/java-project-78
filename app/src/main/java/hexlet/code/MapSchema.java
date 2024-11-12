package hexlet.code;

import java.util.Map;

public class MapSchema<T1, T2> extends BaseSchema<Map<T1, T2>> {

    private boolean requiredFilling = false;
    private Integer minSize = null;
    private Map<T1, BaseSchema<T2>> shapeSchemes = null;

    public MapSchema<T1, T2> required() {
        requiredFilling = true;
        return this;
    }

    public MapSchema<T1, T2> sizeof(int size) {
        minSize = size;
        return this;
    }

    public MapSchema<T1, T2> shape(Map<T1, BaseSchema<T2>> schemes) {
        shapeSchemes = schemes;
        return this;
    }

    public boolean checkShape(Map<T1, T2> map) {
        for (T1 property : shapeSchemes.keySet()) {
            BaseSchema<T2> schema = shapeSchemes.get(property);
            if (!schema.isValid(map.get(property))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(Map<T1, T2> map) {
        return (!requiredFilling || map != null)
                && (minSize == null || map.size() >= minSize)
                && (shapeSchemes == null || checkShape(map));
    }

}
