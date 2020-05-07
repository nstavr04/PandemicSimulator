package team1.hw6;

/**
 * This class represents a border on a grid
 * 
 * @author nstavr04.mvasil17
 *
 */
public class Border {

	private int xGrid;

	private int yGrid;

	private int[] borderX;

	private int[] borderY;

	private int currentArea;

	private int[] nextArea;

	private int borderAmount; // num of borders

	public Border(int[] borderX, int[] borderY, int[] nextArea, int borderAmount, int xGrid, int yGrid) {

		this.borderAmount = borderAmount;
		
		this.borderX = new int[borderAmount];
		this.borderX = borderX;

		this.borderY = new int[borderAmount];
		this.borderY = borderY;

		this.nextArea = new int[borderAmount];
		this.nextArea = nextArea;

		this.xGrid = xGrid;
		this.yGrid = yGrid;

	}

	/**
	 * @return the borderX
	 */
	public int[] getBorderX() {
		return borderX;
	}

	/**
	 * @return the borderY
	 */
	public int[] getBorderY() {
		return borderY;
	}

	/**
	 * @return the currentArea
	 */
	public int getCurrentArea() {
		return currentArea;
	}

	/**
	 * @return the nextArea
	 */
	public int[] getNextArea() {
		return nextArea;
	}

	/**
	 * If the human is in border, return the area that he is supposed to go next.
	 * Otherwise return -1
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int isInBoarder(int x, int y) { // x,y = current pos of human
		for (int i = 0; i < borderAmount; i++) {
			if (borderX[i] == x && borderY[i] == y) {
				return nextArea[i];
			}
		}
		return -1;
	}

}
