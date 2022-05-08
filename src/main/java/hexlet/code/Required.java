package hexlet.code;

public final class Required implements State {
    @Override
    public Boolean isValid(Object str) {
        return isString(str) && !String.valueOf(str).isEmpty();
    }
}
