package tec;

public class TecInvalidException extends Exception {
    public final Usager quelUsager;
    public final Transport quelTransport;
    
    public TecInvalidException(String message) {
	this(message, null, null);
    }
    
    public TecInvalidException(String message, Usager u, Transport t) {
	super(message);
	quelTransport = t;
	quelUsager = u;
    }

    
}

