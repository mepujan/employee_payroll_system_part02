package part02;

//Pujan Gautam - c0842623
//Project Part-02
//Submission Date: 4/19/2022


public class InvalidSinException extends Exception {
	
	private static final long serialVersionUID = 1L;

	//default error message constructor
	public InvalidSinException() {
		super("Error: Invalid SIN Number Provided.");
	}
	
	//one argument constructor taking the message as an argument
	public InvalidSinException(String message) {
		super(message);
	}

}
