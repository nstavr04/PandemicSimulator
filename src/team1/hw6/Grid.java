package team1.hw6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This class represents the grid shown on the program. Its responsible for
 * keeping the data in it up to date.
 * 
 * @author nstavr04.mvasil01
 *
 */
public class Grid {

	// X
	private static int width;
	// Y
	private static int height;
	// All the cells
	private static Cell[][] c1;

	public Grid(int x, int y) {
		width = x;
		height = y;
		// Set the proper dimentions the first time
		SetDimentions(width, height);
		// Draw the grid lines the first time
		DrawGridLines(width, height);
		// Create the cells the first time
		createCells(width, height);
	}

	/**
	 * This method is responsible to draw the lines of the grid
	 * 
	 * @param x the width
	 * @param y the height
	 */
	private void DrawGridLines(int x, int y) {
		StdDraw.setPenRadius(0.002 / ((x + y) / 2.0 / 50.0));

		for (int i = 0; i <= x; i++)
			StdDraw.line(i, 0, i, y);
		for (int i = 0; i <= y; i++)
			StdDraw.line(0, i, x, i);
	}

	/**
	 * This method takes as parameters the size of the grid (x,y). For better
	 * display the width must be greater or equal to the y. (Xmax = 50, Ymax=40)
	 * 
	 * @param x width
	 * @param y height
	 */
	private void SetDimentions(int x, int y) {
		if (y > 20)
			StdDraw.setCanvasSize(800 + x * 20, 800 + 20 * 10);
		else if (x > 35) {
			StdDraw.setCanvasSize(800 + x * 20, 800 + y * 10);
		} else
			StdDraw.setCanvasSize(800 + x * 30, 800 + y * 10);
		StdDraw.clear(StdDraw.WHITE);
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);
	}

	/**
	 * This private method is responsible to create the cells for the grid
	 * 
	 * @param width  the width
	 * @param height the height
	 */
	private void createCells(int width, int height) {

		c1 = new Cell[width][height];

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				c1[i][j] = new Cell();
			}
		}
	}

	/**
	 * This static method updates the cells of the Grid. It is removing the
	 * infection from the cell when its time pass 
	 */
	public static void updateGrid() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (c1[i][j].isInfected()) {
					if (c1[i][j].updateTime()) {
						c1[i][j].setInfected(i, j, false);
						StdDraw.setPenColor(StdDraw.WHITE);
						StdDraw.setPenRadius(0.0032 / ((width + height) / 2.0 / 50.0));
						StdDraw.square(i + 0.5, j + 0.5, 0.44);
						StdDraw.setPenColor(StdDraw.BLACK);
						StdDraw.setPenRadius(0.002 / ((width + height) / 2.0 / 50.0));
						StdDraw.square(i + 0.5, j + 0.5, 0.5);
					}
				}
			}
		}
	}

	/**
	 * @return the infection
	 */
	public static boolean getInfectionPos(int x, int y) {
		return c1[x][y].isInfected();
	}

	/**
	 * This method takes as input 2 integers representing the coordinates x, y of
	 * the cell, and a boolean to set, representing if the cell is infected.
	 * 
	 * @param x
	 * @param y
	 * @param infected
	 */
	public static void setInfectionPos(int x, int y, boolean infected) {
		c1[x][y].setInfected(x,y,infected);
	}

	/**
	 * This method sets a certain cell if its inhabited or not accordingly
	 * 
	 * @param i
	 * @param j
	 * @param inhabited
	 */
	public static void setBoardPos(int i, int j, boolean inhabited) {
		c1[i][j].setInhabited(inhabited);
	}

	/**
	 * This method returns if a certain grid block is inhabited or not
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean getBoardPos(int x, int y) { // static
		return c1[x][y].isInhabited();
	}

	/**
	 * @return the width
	 */
	public static int getWidth() {
		return width;
	}

	/**
	 * @return the height
	 */
	public static int getHeight() {
		return height;
	}

	/**
	 * This method sets in the cell a boolean that determines if it has an infected
	 * human on it
	 * 
	 * @param x
	 * @param y
	 * @param infected
	 */
	public static void setHasInfectedHuman(int x, int y, boolean infected) {
		c1[x][y].setHasInfectedHuman(infected);
	}

	/**
	 * This static method returns a boolean representing if the cell has an infected
	 * human inside
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean getHasInfectedHuman(int x, int y) {
		return c1[x][y].getHasInfectedHuman();
	}

	
	
	
	
	//test
	
	/**
	 * @param width the width to set
	 */
	public static void setWidth(int width) {
		Grid.width = width;
		Human.setGridX(width);
	}

	/**
	 * @param height the height to set
	 */
	public static void setHeight(int height) {
		Grid.height = height;
		Human.setGridY(height);
	}
	
	
	
	
	

}
