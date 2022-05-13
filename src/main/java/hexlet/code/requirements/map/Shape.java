package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.requirements.Required;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public final class Shape extends Required implements Requirable {
    private final Map<String, BaseSchema> shapes;

    public Shape(BaseSchema schema, Map<String, BaseSchema> shapes) {
        super(schema);
        this.shapes = shapes;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
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

