package mvasil17_nstavr04_HW6;
/**
 * This exception class is used for exception handling when the odds inputs
 * parameters have an unavailable percentage - bigger than 100
 * 
 * @author nstavr04.mvasil01
 *
 */
public class ExceptionUnavailablePercentage extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionUnavailablePercentage() {
		this("Percentage must be 0-100. Try again: ");
	}

	public ExceptionUnavailablePercentage(String message) {
		super(message);
	}

}
