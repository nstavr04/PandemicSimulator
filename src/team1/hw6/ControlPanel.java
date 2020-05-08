package team1.hw6;

/**
 * This class acts as a ControlPanel making it able to control from the
 * PandemicSimlator - Main the actions taken between humans and grids
 * 
 * @author team1
 *
 */
public class ControlPanel {

	private static Human[][] humans;
	private static Grid[] grids;

	private static int numOfAreas;

	private static int teleportedIndex;

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

	/**
	 * @return number of areas
	 */
	public static int getNumOfAreas() {
		return numOfAreas;
	}

	/**
	 * @return number of humans
	 */
	public static int getNumOfHumans() {
		return humans.length;
	}

	/**
	 * Transfers a human to human array of the other area and fils the spot on the
	 * previous array
	 * 
	 * @param j           Human position on array
	 * @param prevAreaNum
	 * @param nextAreaNum
	 */
	public static void teleport(int j, int prevAreaNum, int nextAreaNum) {
		System.out.println(
				"A human has been teleported from area " + (prevAreaNum + 1) + " to area " + (nextAreaNum + 1));

		teleportedIndex = 0;

		for (int i = 0; i < humans.length; i++) {
			// teleport him
			if (humans[i][nextAreaNum] == null) {
				humans[i][nextAreaNum] = humans[j][prevAreaNum].clone();
				humans[j][prevAreaNum] = null;
				teleportedIndex = i;
				break;
			}
		}

	}

	/**
	 * @return the teleported human index on the array
	 */
	public static int getTeleportedIndex() {
		return teleportedIndex;
	}

}
