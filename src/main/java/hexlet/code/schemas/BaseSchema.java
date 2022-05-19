package hexlet.code.schemas;

import hexlet.code.requirements.NotRequired;
import hexlet.code.requirements.Requirable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema {
    private final List<Requirable> requirements;

    public BaseSchema() {
        requirements = new ArrayList<>();
        requirements.add(new NotRequired(this));
    }

    public final void setRequirements(Requirable requirable) {
        this.requirements.add(requirable);
    }

    public final boolean isValid(Object obj) {
        for (Requirable requirable: requirements) {
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
