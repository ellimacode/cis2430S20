package adventure;

public class InvalidCommandException extends Exception{
    public InvalidCommandException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
