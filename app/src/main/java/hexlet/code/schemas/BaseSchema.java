package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BaseSchema<T> {

    private final List<Predicate<T>> checks = new ArrayList<>();

    public final void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    public final boolean isValid(T value) {
        return checks.stream().allMatch(check -> check.test(value));
    }

}
