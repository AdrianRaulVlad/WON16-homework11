package enumsAndExceptions;

public class NoActivityException extends RuntimeException  {
    public NoActivityException (String message) {
        super (message);
    }
}
