package mvasil17_nstavr04_HW6;

/**
 * A time class representing the time needed to leave the infection from the
 * ground
 * 
 * @author nstavr04.mvasil01
 *
 */
public class Time {

	private static int timeUnits;
	private boolean outOfTime = false;
	private int eachTime;

	/**
	 * This default constructor initializes the time at the value of the static int
	 * timeUnits
	 */
	public Time() {
		eachTime = Time.timeUnits;
	}

	/**
	 * This constructor takes as input an integer representing the time units
	 * 
	 * @param timeUnits
	 */
	public Time(int timeUnits) { // timeUnits must be greater than 0.
		this.timeUnits = timeUnits;
	}

	/**
	 * This method continues the time and returns true if the has ran out (0)
	 * 
	 * @return
	 */
	public boolean nextTimeUnit() {
		eachTime--;
		if (eachTime == 0) {
			outOfTime = true;
			return true;
		} else
			return false;
	}

	/**
	 * @return the timeUnits
	 */
	public int getTimeUnits() {
		return eachTime;
	}

	/**
	 * @param timeUnits the timeUnits to set
	 */
	public static void setTimeUnits(int timeUnits) {
		Time.timeUnits = timeUnits;
	}

	/**
	 * This method returns if the time has ran out
	 * 
	 * @return
	 */
	public boolean isOutOfTime() {
		return outOfTime;
	}
}
