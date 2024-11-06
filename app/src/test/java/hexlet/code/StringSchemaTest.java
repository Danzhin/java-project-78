package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {

    private final Validator VALIDATOR = new Validator();
    private StringSchema schema;

    private final String testString = "abc";

    @BeforeEach
    public void beforeEach() {
        schema = VALIDATOR.string();
    }

    @Test
    public void testRequired() {
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }

    @Test
    public void testMinLength() {
        schema.minLength(3);
        assertTrue(schema.isValid(testString));
        schema.minLength(4);
        assertFalse(schema.isValid(testString));
    }

    @Test
    public void testContains() {
        schema.contains("bc");
        assertTrue(schema.isValid(testString));
        schema.contains("cb");
        assertFalse(schema.isValid(testString));
    }
}
