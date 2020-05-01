package team1.hw6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Creates a ground infection object
 * 
 * @author nstavr04.mvasil01
 */
public class GroundInfection extends Infection {

	/**
	 * This constructor takes as input 2 integers representing the coordinates
	 * x and y of the infection
	 * @param x
	 * @param y
	 */
	public GroundInfection(int x, int y) {
		super();
		drawInfection(x, y);
	}
	
	/**
	 * This private method draws the infection on the grid
	 * @param x
	 * @param y
	 */
	private void drawInfection(int x, int y) {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.square(x + 0.5, y + 0.5, 0.45);
	}

}
