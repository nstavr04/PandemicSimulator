package team1.hw6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This abstract class represents a Human object. Its responsible for all the
 * properties a human have and all the abilities he has and moves that can make
 * 
 * @authors nstavr04.mvasil01
 */
public abstract class Human {

	Grid belongingGrid = null;

	// Booleans

	private boolean infected;
	private boolean immune;
	private boolean wearMask;

	// Percentages

	private static int humanMovePer;
	private int humanInfHumanPer;
	private int humanInfGroundPer;
	private int groundInfHumanPer;

	// Grid dimensions

	private int gridX;
	private int gridY;

	// Coordinates of human

	private int nextX;
	private int nextY;

	private int curX;
	private int curY;

	private int prevX;
	private int prevY;

	// keep track how many humans are created
	private static int humanCounter = 0;
	// keep track how many infected humans are created
	private static int infectedCounter = 0;
	// keep track how many immune humans are created
	private static int immuneCounter = 0;
	// keep track how many humans have mask
	private static int maskCounter = 0;

	// The direction the human is facing
	private int direction; // 1->up 2->down 3->right 4->left

	// Abstract methods

	public abstract void move();

	public abstract void firstDraw();

	public abstract void draw();

	public Human(Human hum) {
		this.infected = hum.infected;
		this.immune = hum.immune;
		this.wearMask = hum.wearMask;
		this.humanInfHumanPer = hum.humanInfHumanPer;
		this.humanInfGroundPer = hum.humanInfHumanPer;
		this.groundInfHumanPer = hum.groundInfHumanPer;
		this.gridX = hum.gridX;
		this.gridY = hum.gridY;
		this.nextX = hum.nextX;
		this.nextY = hum.nextY;
		this.curX = hum.curX;
		this.curY = hum.curY;
		this.prevX = hum.prevX;
		this.prevY = hum.prevY;

		this.direction = hum.direction;

		this.belongingGrid = hum.belongingGrid;

	}

	public Human(boolean isInfected, boolean giveMask, boolean immune, int humanMovePer, int humanInfHumanPer,
			int humanInfGroundPer, int groundInfHumanPer, Grid belongingGrid) {

		this.belongingGrid = belongingGrid; // test

		gridX = belongingGrid.getWidth(); // test
		gridY = belongingGrid.getHeight(); // test

		// Keep track of the statistics
		humanCounter++;
		if (immune)
			immuneCounter++;
		if (giveMask)
			maskCounter++;

		// Initializations
		this.infected = isInfected;
		this.wearMask = giveMask;
		this.immune = immune;
		this.humanMovePer = humanMovePer;
		this.humanInfGroundPer = humanInfGroundPer;
		this.humanInfHumanPer = humanInfHumanPer;
		this.groundInfHumanPer = groundInfHumanPer;

		// Create the human on grid
		firstDraw();
	}

	/**
	 * Generates the first position of the human on the grid
	 */
	protected void startingPos() {
		boolean generated = false;
		// there will always be a possible startingPos, as you cant have more
		// people than the grid size.
		while (!generated) {
			curX = (int) (Math.random() * gridX);
			curY = (int) (Math.random() * gridY);
			if (!belongingGrid.getBoardPos(curX, curY))
				generated = true;
		}
		// marking the pos of the person
		belongingGrid.setBoardPos(curX, curY, true);

		prevX = curX; // new
		prevY = curY; // new
	}

	/**
	 * Find the next possible move of the human around his block on the grid
	 * 
	 * @return true if found false if otherwise
	 */
	protected boolean generatePos() {
		boolean generated = false;
		// max possible moves: 8
		int xBoard[] = new int[8];
		int yBoard[] = new int[8];
		int index = 0;
		// double for all the neighboring cells
		for (int i = curX - 1; i <= curX + 1; i++) {
			for (int j = curY - 1; j <= curY + 1; j++) {
				// If not out of bounds
				if (i >= 0 && i < gridX && j >= 0 && j < gridY) {
					// If it is a free cell, then its a possible move
					if (!belongingGrid.getBoardPos(i, j)) {
						xBoard[index] = i;
						yBoard[index] = j;
						index++;
						generated = true;
					}
				}
			}
		}
		// no possible moves
		if (!generated)
			return false;
		// new generated move from the board. Just reusing the same variable.
		index = (int) (Math.random() * index);
		nextX = xBoard[index];
		nextY = yBoard[index];
		// the previews place is not inhabited now
		belongingGrid.setBoardPos(curX, curY, false);
		// the next place is inhabited now
		belongingGrid.setBoardPos(nextX, nextY, true); // an o anthropos allakse grid...
		return true;
	}

	/**
	 * Erases the human avatar from the previous block on the grid
	 */
	protected void erase() {
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(curX + 0.5, curY + 0.5, 0.35);

	}

	/**
	 * Updates the coordinates
	 */
	public void updatePosition() {
		prevX = curX;
		prevY = curY;
		curX = nextX;
		curY = nextY;
	}

	/*
	 * Direction of the human (1-4) - 1 UP 2 DOWN 3 LEFT 4 RIGHT
	 */
	public int getDirection() {
		return direction;
	}

	/*
	 * Generates a random direction (1-4)
	 */
	public void generateDirection() {
		direction = (int) (Math.random() * 4) + 1;
	}

	/**
	 * @return the curX
	 */
	public int getCurX() {
		return curX;
	}

	/**
	 * @return the curY
	 */
	public int getCurY() {
		return curY;
	}

	/**
	 * @return the nextX
	 */
	public int getNextX() {
		return nextX;
	}

	/**
	 * @return the nextY
	 */
	public int getNextY() {
		return nextY;
	}

	/**
	 * This method decides if the Human will move
	 * 
	 * @return
	 */
	public static boolean getWillMove() {
		if ((int) (Math.random() * 101) < humanMovePer)
			return true;
		return false;
	}

	/**
	 * This method returns a boolean representing if the man is infected
	 * 
	 * @return
	 */
	public boolean isInfected() {
		return infected;
	}

	/**
	 * This method is responsible to brand the spot of an infected human (using
	 * percantage)
	 */
	public void chanceToBrandTheSpot() {
		// only if the human is already infected
		if (infected == true) {
			if ((int) (Math.random() * 101) <= humanInfGroundPer) {
				belongingGrid.setInfectionPos(curX, curY, infected);
			}
		}
	}

	/**
	 * This method infects humans from ground or from other humans based on
	 * percentages
	 */
	public void chanceToGetInfected() {
		chanceToGetInfectedFromGround();
		chanceToGetInfectedFromHuman();
	}

	/**
	 * This private method infects humans from the ground based on percantages
	 */
	private void chanceToGetInfectedFromGround() {
		// if the current cell is infected
		if (belongingGrid.getInfectionPos(curX, curY) && !infected) {
			// if the human is not immune
			if (!immune) {
				if ((int) (Math.random() * 101) <= groundInfHumanPer) {
					infected = true;
					infectedCounter++;
					System.out.println("A man has been infected from the ground");
				}
			}
		}
	}

	/**
	 * This private method infects humans from humans based on percantages
	 */
	private void chanceToGetInfectedFromHuman() {
		if (!immune && !infected) {
			// double for all the neighboring cells
			for (int i = curX - 1; i <= curX + 1; i++) {
				for (int j = curY - 1; j <= curY + 1; j++) {
					// If not got infected right now
					if (!infected) {
						// If not out of bounds
						if (i >= 0 && i < gridX && j >= 0 && j < gridY) {
							// If it is NOT a free cell
							if (belongingGrid.getBoardPos(i, j)) {
								if (belongingGrid.getHasInfectedHuman(i, j)) {
									if ((int) (Math.random() * 101) <= humanInfHumanPer) {
										this.infected = true;
										infectedCounter++;
										System.out.println("A man has been infected from a Human");
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * This method returns the number of humans constructed
	 * 
	 * @return
	 */
	public static int getHumanCounter() {
		return humanCounter;
	}

	/**
	 * This method returns the number of infected humans
	 * 
	 * @return
	 */
	public static int getInfectedCounter() {
		return infectedCounter;
	}

	/**
	 * This method returns the number of immune humans
	 * 
	 * @return
	 */
	public static int getImmuneCounter() {
		return immuneCounter;
	}

	/**
	 * This method returns the number of humans with masks
	 * 
	 * @return
	 */
	public static int getMaskCounter() {
		return maskCounter;
	}

	/**
	 * @return the gridX
	 */
	public int getGridX() {
		return gridX;
	}

	/**
	 * @param gridX the gridX to set
	 */
	public void setGridX(int gridX) {
		this.gridX = gridX;
	}

	/**
	 * @return the gridY
	 */
	public int getGridY() {
		return gridY;
	}

	/**
	 * @param gridY the gridY to set
	 */
	public void setGridY(int gridY) {
		this.gridY = gridY;
	}

	/**
	 * @return the belongingGrid
	 */
	public Grid getBelongingGrid() {
		return belongingGrid;
	}

	/**
	 * @param belongingGrid the belongingGrid to set
	 */
	public void setBelongingGrid(Grid belongingGrid) {

		Grid grid = new Grid(belongingGrid);

		this.belongingGrid = grid;
		this.gridX = belongingGrid.getWidth();
		this.gridY = belongingGrid.getHeight();
	}

	/**
	 * @return
	 */
	public int isInBorder() {
		return this.belongingGrid.isInBorder(curX, curY);
	}

	/**
	 * @return the prevX
	 */
	public int getPrevX() {
		return prevX;
	}

	/**
	 * @return the prevY
	 */
	public int getPrevY() {
		return prevY;
	}

	@Override
	public abstract Human clone();

}
