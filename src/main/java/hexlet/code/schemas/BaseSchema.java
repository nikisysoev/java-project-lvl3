package hexlet.code.schemas;

import hexlet.code.requirements.NotRequired;
import hexlet.code.requirements.Requirable;

public abstract class BaseSchema {
    private Requirable requirement;

    public BaseSchema() {
        this.requirement = new NotRequired(this);
    }

    public final void setRequirement(Requirable requirement) {
        this.requirement = requirement;
    }

    public final boolean isValid(Object obj) {
        return requirement.isValid(obj);
    }

    /**
     */
    public boolean isNotEmpty(Object obj) {
        return true;
    }

    public abstract boolean isThatClass(Object obj);
}
