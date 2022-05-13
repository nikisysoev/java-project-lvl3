package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public final class Size implements Requirable {
    private final int size;
    private final BaseSchema schema;

    public Size(BaseSchema schema, int size) {
        this.size = size;
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!schema.isThatClass(obj)) {
            return false;
        }
        return ((Map) obj).size() == size;
    }
}
