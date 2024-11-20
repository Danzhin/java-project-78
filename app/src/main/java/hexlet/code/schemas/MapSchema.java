package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<String, Object>> {

    public MapSchema required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Object>> schemes) {
        addChecks(map -> schemes.entrySet().stream()
                .allMatch(entry -> map.containsKey(entry.getKey())
                        && entry.getValue().isValid(map.get(entry.getKey()))));
        return this;
    }

}
