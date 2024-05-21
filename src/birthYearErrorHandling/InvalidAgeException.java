package birthYearErrorHandling;

public class InvalidAgeException extends Exception{
    public InvalidAgeException(String exceptionMessage) {
        super (exceptionMessage);
    }
}
