package enumsAndExceptions;

public class NoActivitiesForDayException extends Exception {
    public NoActivitiesForDayException (String message) {
        super (message);
    }
}
