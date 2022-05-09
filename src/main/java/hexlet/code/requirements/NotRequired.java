package hexlet.code.requirements;

import hexlet.code.schemas.BaseSchema;
import java.util.Objects;

public final class NotRequired implements Requirable {
    private BaseSchema schema;

    public NotRequired(BaseSchema schem) {
        this.schema = schem;
    }

    @Override
    public Boolean isValid(Object obj) {
        return Objects.isNull(obj) || schema.isThatClass(obj);
    }
}
