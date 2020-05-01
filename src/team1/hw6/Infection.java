package team1.hw6;

/**
 * This class creates an infection object
 * 
 * @author nstavr04.mvasil01
 *
 */
public class Infection {

	boolean infected;
	Time t;

	public Infection() {
		t = new Time();
	}

	/**
	 * This constructor takes as input 1 parameter. An integer representing the time
	 * of the infection
	 * 
	 * @param numTime
	 */
	public Infection(int numTime) {
		t = new Time(numTime);
	}

	/**
	 * This constructor takes as input 2 parmeters. A boolean reprecenting if the
	 * human is infected, and the time.(duration of the infection)
	 * 
	 * @param infected
	 * @param t
	 */
	public Infection(boolean infected, Time t) {
		super();
		this.infected = infected;
		this.t = t;
	}

	/**
	 * This method goes to the next time of the infection
	 * 
	 * @return
	 */
	public boolean nextTime() {
		if (t.nextTimeUnit())
			return true;
		else
			return false;
	}

}
