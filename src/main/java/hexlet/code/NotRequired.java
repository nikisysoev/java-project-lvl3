package hexlet.code;

import java.util.Objects;

public final class NotRequired implements State {
    @Override
    public Boolean isValid(Object str) {
        return Objects.isNull(str) || isString(str);
    }
}
