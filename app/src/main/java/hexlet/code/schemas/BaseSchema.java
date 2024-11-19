package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema <T> {

    private final Map<String, Predicate<T>> checks = new HashMap<>();

    protected final void addCheck(String checkName, Predicate<T> predicate) {
        checks.put(checkName, predicate);
    }

    public final boolean isValid(T value) {
        for (Map.Entry<String, Predicate<T>> item : checks.entrySet()) {
            if (!item.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }

}
