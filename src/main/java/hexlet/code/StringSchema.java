package hexlet.code;

public final class StringSchema {
    private State state;

    public StringSchema(State stat) {
        this.state = stat;
    }

    public Boolean isValid(Object str) {
        return state.isValid(str);
    }

    public StringSchema required() {
        this.state = new Required();
        return this;
    }

    public StringSchema contains(String substring) {
        this.state = new Contained(substring);
        return this;
    }

    public StringSchema minLength(Integer length) {
        this.state = new MinLength(length);
        return this;
    }
}
