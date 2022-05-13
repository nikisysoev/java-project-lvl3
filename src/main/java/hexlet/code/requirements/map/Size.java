package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;
import java.util.Map;

public final class Size implements Requirable {
    private final int size;
    private final BaseSchema schema;

    public Size(BaseSchema schem, int siz) {
        this.size = siz;
        this.schema = schem;
    }

    @Override
    public boolean isValid(Object obj) {
        return ((Map) obj).size() == size;
    }
}
