package hexlet.code.requirements.number;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

import java.util.Objects;

public final class Positive extends Required implements Requirable {
    public Positive(BaseSchema schema) {
        super(schema);
    }

    @Override
    public boolean isValid(Object obj) {
        if (Objects.isNull(obj)) {
            return true;
        }
        return ((Integer) obj) >= 0;
    }
}
