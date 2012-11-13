package tec;

public class TecInvalidException extends Exception {
    
    public TecInvalidException(String message, Throwable cause) {
	super(message,cause);
    }
    
    public TecInvalidException(String message) {
	super(message);
    }
    
}

