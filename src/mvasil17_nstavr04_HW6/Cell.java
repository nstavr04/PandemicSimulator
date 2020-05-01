package mvasil17_nstavr04_HW6;

/**
 * This class represents a single Cell on the Grid. Every single one has its own
 * properties.
 * 
 * @author nstavr04.mvasil01
 */
public class Cell {

	private boolean inhabited;
	private boolean infected;
	private int infectedTime;
	private Infection inf = null;
	private boolean hasInfectedHuman;

	/**
	 * This constructor initializes the cell
	 */
	public Cell() {
		inhabited = false;
		infected = false;
		hasInfectedHuman = false;
		infectedTime = 0;
	}

	/**
	 * @return the hasInfectedHuman
	 */
	public boolean getHasInfectedHuman() {
		return hasInfectedHuman;
	}

	/**
	 * @param hasInfectedHuman set the value of hasInfectedHuman
	 */
	public void setHasInfectedHuman(boolean hasInfectedHuman) {
		this.hasInfectedHuman = hasInfectedHuman;
	}

	/**
	 * @return the inhabited
	 */
	public boolean isInhabited() {
		return inhabited;
	}

	/**
	 * @return the infected
	 */
	public boolean isInfected() {
		return infected;
	}
	
	/**
	 * @param infected set the value of infected
	 */
	public void setInfected(int x, int y, boolean infected) {
		this.infected = infected;
		inf = new GroundInfection(x, y);
		
	}

	/**
	 * @return the infectedTime
	 */
	public int getInfectedTime() {
		return infectedTime;
	}

	/**
	 * @param inhabited the inhabited to set
	 */
	public void setInhabited(boolean inhabited) {
		this.inhabited = inhabited;
	}

	/**
	 * This method updates the time of the cell
	 * 
	 * @return true if there is next timeUnit , false if otherwise
	 */
	public boolean updateTime() {
		if (inf.nextTime())
			return true;
		else
			return false;
	}

}
