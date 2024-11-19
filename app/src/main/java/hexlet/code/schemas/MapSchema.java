package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T1, T2> extends BaseSchema<Map<T1, T2>> {

    public MapSchema<T1, T2> required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema<T1, T2> sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    public MapSchema<T1, T2> shape(Map<T1, BaseSchema<T2>> schemes) {
        addChecks(map -> {
            if (map == null || schemes == null) {
                return true;
            }
            for (Map.Entry<T1, BaseSchema<T2>> entry : schemes.entrySet()) {
                T1 key = entry.getKey();
                BaseSchema<T2> schema = entry.getValue();

                if (!map.containsKey(key) || !schema.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }

}
