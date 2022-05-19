package hexlet.code.schemas;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.string.Contained;
import hexlet.code.requirements.string.MinLength;

public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        setRequirements(new Required(this));
        return this;
    }

    public StringSchema contains(String substring) {
        setRequirements(new Contained(substring, this));
        return this;
    }

    public StringSchema minLength(int length) {
        setRequirements(new MinLength(length, this));
        return this;
    }

    @Override
    public boolean isThatClass(Object obj) {
        return obj instanceof String;
    }

    @Override
    public boolean isNotEmpty(Object obj) {
        return !String.valueOf(obj).isEmpty();
    }
}
