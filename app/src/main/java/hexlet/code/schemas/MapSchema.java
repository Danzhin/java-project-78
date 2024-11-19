package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        addCheck("required", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck("sizeof", map -> map.size() == size);
        return this;
    }


}
