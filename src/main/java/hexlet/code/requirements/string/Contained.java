package hexlet.code.requirements.string;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class Contained implements Requirable {
    private final String substring;
    private final BaseSchema schema;

    public Contained(String substrin, BaseSchema schem) {
        this.substring = substrin;
        this.schema = schem;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!schema.isThatClass(substring)) {
            return false;
        }
        return String.valueOf(obj).contains(substring);
    }
}
