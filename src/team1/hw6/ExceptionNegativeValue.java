package team1.hw6;

/**
 * This exception class is used for exception handling when the input parameters
 * given by the user have a negative value
 * 
 * @author nstavr04.mvasil01
 *
 */
public class ExceptionNegativeValue extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionNegativeValue() {
		this("Input must be a positive number. Try again:");
	}

	public ExceptionNegativeValue(String message) {
		super(message);
	}

}
