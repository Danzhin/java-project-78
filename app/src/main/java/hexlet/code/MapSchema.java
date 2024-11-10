package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {

    private boolean requiredFilling = false;
    private Integer minSize = null;
    private Map<Object, BaseSchema> shapeSchemas = null;

    public MapSchema required() {
        requiredFilling = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        minSize = size;
        return this;
    }

    public MapSchema shape(Map<Object, BaseSchema> shapeSchemas) {
        this.shapeSchemas = shapeSchemas;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        Map<?, ?> map = (Map<?, ?>) value;
        if (requiredFilling && map == null) {
            return false;
        }
        if (shapeSchemas != null) {
            for (Map.Entry<Object, BaseSchema> entry : shapeSchemas.entrySet()) {
                Object property = entry.getKey();
                BaseSchema shapeSchema = entry.getValue();
                if (!shapeSchema.isValid(map.get(property))) {
                    return false;
                }
            }
        }
        return minSize == null || map.size() >= minSize;
    }

}
