package hexlet.code.requirements.string;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class Contained implements Requirable {
    private final String substring;
    private final BaseSchema schema;

    public Contained(String substring, BaseSchema schema) {
        this.substring = substring;
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!schema.isThatClass(substring)) {
            return false;
        }
        return String.valueOf(obj).contains(substring);
    }
}
