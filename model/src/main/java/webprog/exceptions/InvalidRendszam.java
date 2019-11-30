package webprog.exceptions;

public class InvalidRendszam extends Throwable {
    public InvalidRendszam(String rendszam) {
        super(rendszam);
    }
}
