package hexlet.code;

public interface State {
    Boolean isValid(Object str);

    default Boolean isString(Object str) {
        return str instanceof String;
    }
}
