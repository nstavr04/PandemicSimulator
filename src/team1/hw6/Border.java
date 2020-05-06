package team1.hw6;

public class Border {

	private int[] borderX;

	private int[] borderY;

	private int currentArea;

	private int[] nextArea;

	public Border(int[] borderX, int[] borderY, int[] nextArea, int counter) {

		this.borderX = new int[counter];
		this.borderX = borderX;

		this.borderY = new int[counter];
		this.borderY = borderY;

		this.nextArea = new int[counter];
		this.nextArea = nextArea;

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

}
