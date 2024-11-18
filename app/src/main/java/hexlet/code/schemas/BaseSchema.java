package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema <T> {

    protected int checkID = 0;

    private final Map<Integer, Predicate<T>> checks = new HashMap<>();

    protected final void addCheck(Integer checkID, Predicate<T> predicate) {
        this.checks.put(checkID, predicate);
    }

    public final boolean isValid(T value) {
        for (Map.Entry<Integer, Predicate<T>> item : checks.entrySet()) {
            if (!item.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }

}
