package hexlet.code.requirements.number;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public final class Positive implements Requirable {
    private final BaseSchema schema;

    public Positive(BaseSchema schema) {
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        if (Objects.isNull(obj)) {
            return true;
        }
        return ((Integer) obj) > 0;
    }
}
