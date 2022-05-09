package hexlet.code.requirements.number;

import hexlet.code.requirements.Requirable;
import hexlet.code.requirements.Required;
import hexlet.code.schemas.BaseSchema;

public final class Range extends Required implements Requirable {
    private final int number1;
    private final int number2;

    public Range(int num1, int num2, BaseSchema schem) {
        super(schem);
        this.number1 = num1;
        this.number2 = num2;
    }

    @Override
    public Boolean isValid(Object obj) {
        if (!super.isValid(obj)) {
            return false;
        }
        return ((Integer) obj) >= number1 && ((Integer) obj) <= number2;
    }
}
