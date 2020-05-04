package team1.hw6;

public class ControlPanel {

	private static Human[][] humans;
	private static Grid[] grids;
//	private int humanNums[];

	private static int numOfAreas;

	public ControlPanel(Human[][] humans, Grid grids[]) {
		ControlPanel.humans = humans;
		ControlPanel.grids = grids;

		// Check for null
		this.numOfAreas = humans[0].length;
	}

	/**
	 * @return the humans
	 */
	public static Human[][] getHumans() {
		return humans;
	}

	/**
	 * @param humans the humans to set
	 */
	public static void setHumans(Human[][] humans) {
		ControlPanel.humans = humans;
	}

	/**
	 * @return the grids
	 */
	public static Grid[] getGrids() {
		return grids;
	}

	/**
	 * @param grids the grids to set
	 */
	public static void setGrids(Grid[] grids) {
		ControlPanel.grids = grids;
	}

	public static int getNumOfAreas() {
		return numOfAreas;
	}

}
