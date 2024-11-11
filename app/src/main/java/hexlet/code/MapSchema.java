package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, Object>> {

    private boolean requiredFilling = false;
    private Integer minSize = null;
    private Map<String, BaseSchema<Object>> shapeSchemas = null;

    public MapSchema required() {
        requiredFilling = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        minSize = size;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Object>> shapeSchemas) {
        this.shapeSchemas = shapeSchemas;
        return this;
    }

    @Override
    public boolean isValid(Map<String, Object> map) {
        if (requiredFilling && map == null) {
            return false;
        }
        if (shapeSchemas != null) {
            for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String property = entry.getKey();
                BaseSchema<?> shapeSchema = entry.getValue();
                if (!shapeSchema.isValid(map.get(property))) {
                    return false;
                }
            }
        }
        return minSize == null || map.size() >= minSize;
    }

}
