package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<T, T>> {

    public MapSchema<T> required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    public MapSchema<T> shape(Map<T, BaseSchema<T>> schemes) {
        addChecks(map -> schemes.entrySet().stream()
                .allMatch(entry -> map.containsKey(entry.getKey())
                        && entry.getValue().isValid(map.get(entry.getKey()))));
        return this;
    }

}
