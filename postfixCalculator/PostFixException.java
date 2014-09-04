package postfixCalculator;

@SuppressWarnings("serial")
public class PostFixException extends RuntimeException {
	
	public PostFixException() {
		super();
	}
	
	public PostFixException(String message) {
		super(message);
	}

}
