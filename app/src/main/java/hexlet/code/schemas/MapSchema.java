package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<? extends T, ? extends T>> {

    public MapSchema<T> required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    public MapSchema<T> shape(Map<Object, BaseSchema<Object>> schemes) {
        addChecks(map -> {
            if (map == null || schemes == null) {
                return true;
            }
            for (Map.Entry<Object, BaseSchema<Object>> entry : schemes.entrySet()) {
                Object key = entry.getKey();
                BaseSchema<Object> schema = entry.getValue();

                if (!map.containsKey(key) || !schema.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
