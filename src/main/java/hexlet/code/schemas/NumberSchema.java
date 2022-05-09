package hexlet.code.schemas;

import hexlet.code.requirements.number.Positive;
import hexlet.code.requirements.number.Range;

public final class NumberSchema extends BaseSchema {
    public NumberSchema positive() {
        setRequirement(new Positive(this));
        return this;
    }

    public NumberSchema range(int number1, int number2) {
        setRequirement(new Range(number1, number2, this));
        return this;
    }

    @Override
    public Boolean isThatClass(Object obj) {
        return obj instanceof Integer;
    }

    @Override
    public Boolean isNotEmpty(Object obj) {
        return true;
    }
}
