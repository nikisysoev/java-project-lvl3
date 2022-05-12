package hexlet.code.requirements.map;

import hexlet.code.requirements.Requirable;
import hexlet.code.requirements.Required;
import hexlet.code.schemas.BaseSchema;

import java.util.Map;

public final class Size extends Required implements Requirable {
    private final int size;

    public Size(int siz, BaseSchema schem) {
        super(schem);
        this.size = siz;
    }

    @Override
    public Boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
            return false;
        }
        return ((Map) obj).size() == size;
    }
}
