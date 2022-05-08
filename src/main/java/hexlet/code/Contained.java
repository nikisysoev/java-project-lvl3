package hexlet.code;

import java.util.Objects;

public final class Contained implements State {
    private String substring;

    public Contained(String str) {
        this.substring = str;
    }

    @Override
    public Boolean isValid(Object str) {
        if (Objects.isNull(str) || Objects.isNull(substring)) {
            return false;
        }

        return String.valueOf(str).contains(substring);
    }
}
