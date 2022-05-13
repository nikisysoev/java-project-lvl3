package hexlet.code.requirements;

import hexlet.code.schemas.BaseSchema;
import java.util.Objects;

public final class NotRequired implements Requirable {
    private final BaseSchema schema;

    public NotRequired(BaseSchema schema) {
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        return Objects.isNull(obj) || schema.isThatClass(obj);
    }
}
