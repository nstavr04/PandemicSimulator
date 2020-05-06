package team1.hw6;

public class ControlPanel {

	private static Human[][] humans;
	private static Grid[] grids;
//	private int humanNums[];

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

	public static int getNumOfAreas() {
		return numOfAreas;
	}

	public static int getNumOfHumans() {
		return humans.length;
	}

	public static void teleport (int j, int prevAreaNum, int nextAreaNum) {//j = thesi athropou sto pinaka
		System.out.println("ControlPanel -> teleport -> humans.length: " + humans.length);
		for (int i=0; i<getGrids()[nextAreaNum].getHumansOnGrid(); i++) {	//teleport him
			if (humans[i][nextAreaNum] == null) {
				humans[i][nextAreaNum] = humans[j][prevAreaNum];
				teleportedIndex = i;
				break;
			}
		}
		for (int i=j; i<getGrids()[prevAreaNum].getHumansOnGrid(); i++) {
//			if (humans[i+1][prevAreaNum] != null)
			humans[i][prevAreaNum] = humans[i+1][prevAreaNum]; 
		}
		
	}
	
	public static int getTeleportedIndex () {
		return teleportedIndex;
	}

}
