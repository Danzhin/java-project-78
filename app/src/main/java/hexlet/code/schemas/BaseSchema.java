package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    public final void addCheck(String checkName, Predicate<T> condition) {
        checks.put(checkName, condition);
    }

    public final boolean isValid(T value) {
        return checks.values().stream().allMatch(condition -> condition.test(value));
    }

}
