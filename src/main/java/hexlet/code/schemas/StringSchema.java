package hexlet.code.schemas;

import hexlet.code.requirements.string.Contained;
import hexlet.code.requirements.string.MinLength;

public final class StringSchema extends BaseSchema {
    public StringSchema contains(String substring) {
        setRequirement(new Contained(substring, this));
        return this;
    }

    public StringSchema minLength(int length) {
        setRequirement(new MinLength(length, this));
        return this;
    }

    @Override
    public Boolean isThatClass(Object obj) {
        return obj instanceof String;
    }

    @Override
    public Boolean isNotEmpty(Object obj) {
        return !String.valueOf(obj).isEmpty();
    }
}
