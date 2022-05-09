package hexlet.code.schemas;

import hexlet.code.requirements.NotRequired;
import hexlet.code.requirements.Required;
import hexlet.code.requirements.Requirable;

public abstract class BaseSchema {
    private Requirable requirement;

    public final void setRequirement(Requirable requiremen) {
        this.requirement = requiremen;
    }

    public BaseSchema() {
        this.requirement = new NotRequired(this);
    }

    public final Boolean isValid(Object obj) {
        return requirement.isValid(obj);
    }

    public final BaseSchema required() {
        this.requirement = new Required(this);
        return this;
    }

    public abstract Boolean isThatClass(Object obj);

    public abstract Boolean isNotEmpty(Object obj);
}
