package webprog.exceptions;

public class InvalidTermekszamException extends Throwable {
    public InvalidTermekszamException(String termekszam) {
        super(termekszam);
    }
}
