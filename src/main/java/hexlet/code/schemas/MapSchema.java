package hexlet.code.schemas;

import hexlet.code.requirements.map.Size;
import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema sizeof(int size) {
        setRequirement(new Size(size, this));
        return this;
    }

    @Override
    public Boolean isThatClass(Object obj) {
        return obj instanceof Map;
    }

    @Override
    public Boolean isNotEmpty(Object obj) {
        return true;
    }
}
