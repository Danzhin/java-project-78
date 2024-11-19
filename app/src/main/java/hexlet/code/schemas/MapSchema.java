package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<?, ?>> {

    public MapSchema<T> required() {
        addChecks(Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(int number) {
        addChecks(map -> map.size() == number);
        return this;
    }

    //public MapSchema<T> shape(Map<T, BaseSchema<T>> schemas) {
        //addChecks(value -> schemas.entrySet().stream().allMatch(e -> e.getValue().isValid(value.get(e.getKey()))));
        //return this;
    //}

}
