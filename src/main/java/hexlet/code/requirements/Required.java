package hexlet.code.requirements;

import hexlet.code.schemas.BaseSchema;

public class Required implements Requirable {
    private final BaseSchema schema;

    public Required(BaseSchema schema) {
        this.schema = schema;
    }

    /**
     */
    @Override
    public boolean isValid(Object obj) {
        return schema.isThatClass(obj) && schema.isNotEmpty(obj);
    }
}
