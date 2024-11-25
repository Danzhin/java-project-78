package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addNonNullCheck();
        return this;
    }

    public MapSchema sizeof(int size) {
        addNonNullCheck();
        addCheck("sizeof", map -> map.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemes) {
        addNonNullCheck();
        addCheck("shape", map -> schemes.entrySet().stream()
                .allMatch(entry -> entry.getValue().isValid((String) map.get(entry.getKey()))));
        return this;
    }

}
