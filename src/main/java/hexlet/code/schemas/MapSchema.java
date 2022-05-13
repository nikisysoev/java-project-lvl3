package hexlet.code.schemas;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.map.Shape;
import hexlet.code.requirements.map.Size;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        setRequirement(new Required(this));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> shapes) {
        setRequirement(new Shape(this, shapes));
        return this;
    }

    public MapSchema sizeof(int size) {
        setRequirement(new Size(this, size));
        return this;
    }

    @Override
    public boolean isThatClass(Object obj) {
        return obj instanceof Map;
    }
}
