package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<Object, Object>> {

    public MapSchema required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Object>> schemas) {
        addChecks(value -> schemas.entrySet().stream().allMatch(e -> e.getValue().isValid(value.get(e.getKey()))));
        return this;
    }

}
