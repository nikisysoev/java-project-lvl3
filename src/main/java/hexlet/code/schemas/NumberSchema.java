package hexlet.code.schemas;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.number.Positive;
import hexlet.code.requirements.number.Range;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        setRequirements(new Required(this));
        return this;
    }

    public NumberSchema positive() {
        setRequirements(new Positive(this));
        return this;
    }

    public NumberSchema range(int number1, int number2) {
        setRequirements(new Range(this, number1, number2));
        return this;
    }

    @Override
    public boolean isThatClass(Object obj) {
        return obj instanceof Number;
    }
}
