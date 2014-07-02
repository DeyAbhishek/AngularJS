package co.prvn.eatery.exception;

public class EateryException extends Exception{

	private static final long serialVersionUID = 3244080608083739464L;

	public EateryException(){
	}
	
	public EateryException(String message){
		super(message);
	}
	
	public EateryException (String message, Throwable cause){
		super(message, cause);
	}
}
