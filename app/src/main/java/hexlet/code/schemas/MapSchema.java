package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", map -> map != null && map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemes) {
        addCheck("shape", map -> schemes.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid((String) map.get(entry.getKey()))));
        return this;
    }

}
