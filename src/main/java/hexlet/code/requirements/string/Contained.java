package hexlet.code.requirements.string;

import hexlet.code.requirements.Required;
import hexlet.code.requirements.Requirable;
import hexlet.code.schemas.BaseSchema;
import java.util.Objects;

public final class Contained extends Required implements Requirable {
    private String substring;

    public Contained(String str, BaseSchema schem) {
        super(schem);
        this.substring = str;
    }

    @Override
    public boolean isValid(Object obj) {
        if (!super.isValid(obj) || Objects.isNull(substring)) {
            return false;
        }

        return String.valueOf(obj).contains(substring);
    }
}
