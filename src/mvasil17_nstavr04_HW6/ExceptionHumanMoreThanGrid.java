package mvasil17_nstavr04_HW6;

/**
 * This exception class is used for exception handling when the humans are more
 * than what the grid can fit
 * 
 * @author nstavr04.mvasil01
 *
 */
public class ExceptionHumanMoreThanGrid extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceptionHumanMoreThanGrid() {
		this("More humans than the grid size. Try again:");
	}

	public ExceptionHumanMoreThanGrid(String message) {
		super(message);
	}

}
