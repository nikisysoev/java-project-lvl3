package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public final class Shape implements Requirable {
    private final Map<String, BaseSchema> shapes;
    private final BaseSchema schema;

    public Shape(BaseSchema schema, Map<String, BaseSchema> shapes) {
        this.shapes = shapes;
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!schema.isThatClass(obj)) {
            return false;
        }
        for (Map.Entry<String, Object> pair: ((Map<String, Object>) obj).entrySet()) {
            BaseSchema schema = shapes.get(pair.getKey());

            if (!schema.isValid(pair.getValue())) {
                return false;
            }
        }
        return true;
    }
}

