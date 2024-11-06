package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    private final Validator VALIDATOR = new Validator();
    private StringSchema schema;

    @BeforeEach
    public void beforeEach() {
        schema = VALIDATOR.string();
    }

    @Test
    public void testRequired() {
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
    }

    @Test
    public void testMinLength() {
        schema.minLength(3);
        assertTrue(schema.isValid("abc"));
        schema.minLength(4);
        assertFalse(schema.isValid("abc"));
    }

    @Test
    public void testContains() {
        schema.contains("bc");
        assertTrue(schema.isValid("abc"));
        schema.contains("cb");
        assertFalse(schema.isValid("abc"));
    }
}
