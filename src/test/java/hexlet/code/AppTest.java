package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int ZERO = 0;
    private static final int TEN = 10;

    @Test
    void validateStringTest() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid(null));
        assertEquals(true,  schema.isValid("what does the fox say"));
        assertEquals(false,  schema.isValid(SIX));
        assertEquals(false,  schema.isValid('f'));

        schema.required();

        assertEquals(false,  schema.isValid(SIX));
        assertEquals(false,  schema.isValid('f'));
        assertEquals(true,  schema.isValid("what does the fox say"));
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(false, schema.isValid(null));
        assertEquals(false, schema.isValid(""));

        assertEquals(true, schema.contains("what").isValid("what does the fox say"));
        assertEquals(true,  schema.isValid("what does the fox say"));
        assertEquals(true, schema.contains("").isValid("what does the fox say"));

        assertEquals(true, schema.minLength(FIVE).isValid("what does the fox say"));
    }

    @Test
    void validateNumberTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid("567"));

        schema.required();

        assertEquals(true, schema.isValid(SIX));
        assertEquals(false, schema.isValid("567"));
        assertEquals(false, schema.isValid(null));

        assertEquals(true, schema.positive().isValid(SIX));
        assertEquals(false, schema.isValid(-SIX));

        schema.range(FIVE, TEN);

        assertEquals(true, schema.isValid(FIVE));
        assertEquals(true, schema.isValid(SIX));
        assertEquals(false,  schema.isValid(ZERO));
        assertEquals(false,  schema.isValid(-SIX));
    }

    @Test
    void validateMapTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid("567"));

        schema.required();

        assertEquals(false, schema.isValid(null));
        assertEquals(true, schema.isValid(new HashMap()));

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertEquals(true, schema.isValid(data));

        schema.sizeof(2);

        assertEquals(false, schema.isValid(data));

        data.put("key2", "value2");
        assertEquals(true, schema.isValid(data));

    }

    @Test
    void validateInnerMapTest() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", SIX);

        assertEquals(true, schema.isValid(human1));

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null); // true

        assertEquals(true, schema.isValid(human2));

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);

        assertEquals(false, schema.isValid(human3));

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -SIX);

        assertEquals(false, schema.isValid(human4));
    }
}
