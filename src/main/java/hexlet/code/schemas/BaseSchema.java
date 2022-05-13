package hexlet.code.schemas;

import hexlet.code.requirements.NotRequired;
import hexlet.code.requirements.Requirable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {
    private final List<Requirable> requirement;

    public BaseSchema() {
        requirement = new ArrayList<>();
        requirement.add(new NotRequired(this));
    }

    public final void setRequirement(Requirable requirable) {
        this.requirement.add(requirable);
    }

    public final boolean isValid(Object obj) {
        for (Requirable requirable: requirement) {
            if (!requirable.isValid(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param obj any Object
     * @return always true
     */
    public boolean isNotEmpty(Object obj) {
        return true;
    }

    public abstract boolean isThatClass(Object obj);
}
