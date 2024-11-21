package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<String, T>> {

    public MapSchema<T> required() {
        addCheck(Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(int size) {
        addCheck(map -> map != null && map.size() == size);
        return this;
    }

    public MapSchema<T> shape(Map<String, BaseSchema<T>> schemes) {
        addCheck(map -> schemes.entrySet().stream()
                .allMatch(entry -> map.containsKey(entry.getKey())
                        && entry.getValue().isValid(map.get(entry.getKey()))));
        return this;
    }

}
