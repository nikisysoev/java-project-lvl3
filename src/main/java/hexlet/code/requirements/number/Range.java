package hexlet.code.requirements.number;

import hexlet.code.requirements.Requirable;
import hexlet.code.requirements.Required;
import hexlet.code.schemas.BaseSchema;

public final class Range extends Required implements Requirable {
    private final int number1;
    private final int number2;

    public Range(BaseSchema schema, int number1, int number2) {
        super(schema);
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
            return false;
        }
        return ((Integer) obj) >= number1 && ((Integer) obj) <= number2;
    }
}
