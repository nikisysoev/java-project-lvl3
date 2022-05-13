package hexlet.code.requirements.number;

import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;

public final class Range implements Requirable {
    private final int number1;
    private final int number2;
    private final BaseSchema schema;

    public Range(BaseSchema schem, int num1, int num2) {
        this.number1 = num1;
        this.number2 = num2;
        this.schema = schem;
    }

    @Override
    public boolean isValid(Object obj) {
        return ((Integer) obj) >= number1 && ((Integer) obj) <= number2;
    }
}
