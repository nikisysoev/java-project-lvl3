package hexlet.code.requirements.string;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class MinLength implements Requirable {
    private final int length;
    private final BaseSchema schema;

    public MinLength(int lengt, BaseSchema schem) {
        this.length = lengt;
        this.schema = schem;
    }

    @Override
    public boolean isValid(Object obj) {
        return String.valueOf(obj).length() >= length;
    }
}
