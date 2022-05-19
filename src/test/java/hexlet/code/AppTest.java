package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class AppTest {
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int ZERO = 0;
    private static final int TEN = 10;
    private final Validator v = new Validator();

    @Test
    void validateStringTest() {
        StringSchema schema = v.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid(SIX));
        assertFalse(schema.isValid('f'));

        schema.required();

        assertFalse(schema.isValid(SIX));
        assertFalse(schema.isValid('f'));
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        assertTrue(schema.contains("what").isValid("what does the fox say"));
        assertTrue(schema.isValid("what does the fox say"));
        assertTrue(schema.contains("").isValid("what does the fox say"));

        assertTrue(schema.minLength(FIVE).isValid("what does the fox say"));
        assertFalse(schema.minLength(FIVE).isValid("what"));
        assertFalse(schema.contains("hexlet").isValid("what does the fox say"));
    }

    @Test
    void validateNumberTest() {
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid("567"));

        schema.required();

        assertTrue(schema.isValid(SIX));
        assertFalse(schema.isValid("567"));
        assertFalse(schema.isValid(null));

        assertTrue(schema.positive().isValid(SIX));
        assertFalse(schema.isValid(-SIX));

        schema.range(FIVE, TEN);

        assertTrue(schema.isValid(FIVE));
        assertTrue(schema.isValid(SIX));
        assertFalse(schema.isValid(ZERO));
        assertFalse(schema.isValid(-SIX));
    }

    @Test
    void validateMapTest() {
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid("567"));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);

        assertFalse(schema.isValid(data));

        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }

    @Test
    void validateInnerMapTest() {
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", SIX);

        assertTrue(schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);

        assertTrue(schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        assertFalse(schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -SIX);

        assertFalse(schema.isValid(human4));
    }
}
