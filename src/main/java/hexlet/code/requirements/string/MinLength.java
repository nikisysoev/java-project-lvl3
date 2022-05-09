package hexlet.code.requirements.string;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class MinLength extends Required implements Requirable {
    private int length;

    public MinLength(int lengt, BaseSchema schem) {
        super(schem);
        this.length = lengt;
    }

    @Override
    public Boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
            return false;
        }
        return String.valueOf(obj).length() >= length;
    }
}
