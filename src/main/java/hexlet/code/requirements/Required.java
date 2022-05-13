package hexlet.code.requirements;

import hexlet.code.schemas.BaseSchema;

public final class Required implements Requirable {
    private final BaseSchema schema;

    public Required(BaseSchema schem) {
        this.schema = schem;
    }

    /**
     */
    @Override
    public boolean isValid(Object obj) {
        return schema.isThatClass(obj) && schema.isNotEmpty(obj);
    }
}
