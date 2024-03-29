package team1.hw6;

/**
 * This exception class is used for exception handling when the infected people
 * given at the start of the program are more than the actual humans
 * 
 * @author team1
 *
 */
public class ExceptionInfMoreThanHumans extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionInfMoreThanHumans() {
		this("The humans that are to be infected are more than the humans available. Try again:");
	}

	public ExceptionInfMoreThanHumans(String message) {
		super(message);
	}
}
