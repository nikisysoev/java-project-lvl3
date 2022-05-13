package hexlet.code.requirements.number;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class Range implements Requirable {
    private final int number1;
    private final int number2;
    private final BaseSchema schema;

    public Range(BaseSchema schema, int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.schema = schema;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!schema.isThatClass(obj)) {
            return false;
        }
        return ((Integer) obj) >= number1 && ((Integer) obj) <= number2;
    }
}
