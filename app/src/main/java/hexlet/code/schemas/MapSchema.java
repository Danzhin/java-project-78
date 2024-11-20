package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCheck(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int number) {
        addCheck(map -> map.size() == number);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemes) {
        addCheck(map -> schemes.entrySet().stream()
                .allMatch(entry -> map.containsKey(entry.getKey())
                        && entry.getValue().isValid((T) map.get(entry.getKey()))));
        return this;
    }

}
