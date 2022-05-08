package hexlet.code;

import java.util.Objects;

public final class MinLength implements State {
    private Integer length;

    public MinLength(Integer lengt) {
        this.length = lengt;
    }

    @Override
    public Boolean isValid(Object str) {
        if (Objects.isNull(str)) {
            return false;
        }
        return String.valueOf(str).length() >= length;
    }
}
