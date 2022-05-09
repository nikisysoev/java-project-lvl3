package hexlet.code.requirements;

import hexlet.code.schemas.BaseSchema;

public class Required implements Requirable {
    private BaseSchema schema;

    public Required(BaseSchema schem) {
        this.schema = schem;
    }

    /**
     */
    @Override
    public Boolean isValid(Object obj) {
        return schema.isThatClass(obj) && schema.isNotEmpty(obj);
    }
}
