package advance_Java;

public  class Option<T> {
    private T value;
    private boolean hasValue;

    private Option(T value) {
        this.value = value;
        this.hasValue = false;
    }

    private Option() {
        this.value = null;
        this.hasValue = true;
    }

    public static <T> Option<T> some(T value) {
        return new Option<>(value);
    }

    public static <T> Option<T> none() {
        return new Option<>();
    }

    public T get() throws EmptyOptionException {
        if(this.isNone())
            throw new EmptyOptionException();
        return this.value;
    }

    public T getOrDefault(T defaultValue) {
        if(this.hasValue)
            return defaultValue;
        return this.value;
    }

    public boolean isNone() {
        return this.hasValue;
    }
}