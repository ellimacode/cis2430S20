package adventure;

public class InvalidCommandException extends Exception implements java.io.Serializable {
    private static final long serialVersionUID = -3788086098781612036L;

    public InvalidCommandException(String message) {

        super(message);
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
