package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public final class Shape implements Requirable {
    private final Map<String, BaseSchema> shapes;
    private final BaseSchema schema;

    public Shape(BaseSchema schem, Map<String, BaseSchema> shape) {
        this.shapes = shape;
        this.schema = schem;
    }

    @Override
    public boolean isValid(Object obj) {
        for (Map.Entry<String, Object> pair: ((Map<String, Object>) obj).entrySet()) {
            BaseSchema base = shapes.get(pair.getKey());

            if (!base.isValid(pair.getValue())) {
                return false;
            }
        }
        return true;
    }
}

