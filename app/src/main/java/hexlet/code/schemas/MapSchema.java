package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(map -> map != null && map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Object>> schemes) {
        addCheck(map -> schemes.entrySet().stream()
                .allMatch(entry -> map.containsKey(entry.getKey())
                        && entry.getValue().isValid(map.get(entry.getKey()))));
        return this;
    }

}
