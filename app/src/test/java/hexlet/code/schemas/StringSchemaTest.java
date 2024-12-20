package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {

    private final Validator validator = new Validator();
    private StringSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = validator.string();
    }

    @Test
    public void requiredTest() {
        schema.required();
        assertTrue(schema.isValid("abc"));
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void minLengthTest() {
        schema.minLength(3);
        assertTrue(schema.isValid("abc"));
        assertFalse(schema.isValid("ab"));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void containsTest() {
        schema.contains("bc");
        assertTrue(schema.isValid("abc"));
        assertFalse(schema.isValid("acb"));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void combinationTest() {
        schema.required().minLength(3).contains("bc");
        assertTrue(schema.isValid("abc"));
        assertFalse(schema.isValid("bc"));
        assertFalse(schema.isValid("cba"));
        assertFalse(schema.isValid(null));
    }

}
