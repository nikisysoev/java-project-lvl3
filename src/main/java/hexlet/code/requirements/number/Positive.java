package hexlet.code.requirements.number;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class Positive extends Required implements Requirable {
    public Positive(BaseSchema schema) {
        super(schema);
    }

    @Override
    public boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
            return false;
        }
        return ((Integer) obj) >= 0;
    }
}
