package team1.hw6;

public class ControlPanel {
	
	private static Human[][] humans;
	private static Grid[] grids;
//	private int humanNums[];

	public ControlPanel(Human[][] humans, Grid grids[]) {
		ControlPanel.humans = humans;
		ControlPanel.grids = grids;
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
	
	
}
