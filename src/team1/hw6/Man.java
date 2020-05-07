package team1.hw6;

import edu.princeton.cs.introcs.StdDraw;

/**
 * This class extends Human and creates a man class. Responsible for his
 * movements showing on grid.
 * 
 * @author nstavr04.mvasil01
 */
public class Man extends Human implements Cloneable {

	public Man(Man other) {
		super(other);
	}

	public Man(boolean isInfected, boolean giveMask, boolean immune, int humanMovePer, int humanInfHumanPer,
			int humanInfGroundPer, int groundInfHumanPer, Grid belongingGrid) {
		super(isInfected, giveMask, immune, humanMovePer, humanInfHumanPer, humanInfGroundPer, groundInfHumanPer,
				belongingGrid);
	}

	/**
	 * This method checks if the man decides to move, and updates its position
	 */
	@Override
	public void move() {

		// the human decides if he will move
		if (getWillMove()) {
			if (generatePos()) {
				erase();
				// it is a free cell, so it hasnt an infected person
				belongingGrid.setHasInfectedHuman(getCurX(), getCurY(), false);
				updatePosition();
				generateDirection();
				// checking to show the correct image
				if (super.isInfected() == true) {
					// if he is infected, set it to the cell
					belongingGrid.setHasInfectedHuman(getNextX(), getNextY(), true);
					if (getDirection() == 1)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleUPWITHVIRUS.JPG", 0.7,
								0.7);
					else if (getDirection() == 2)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleDOWNWITHVIRUS.JPG",
								0.7, 0.7);
					else if (getDirection() == 3)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleLEFTWITHVIRUS.JPG",
								0.7, 0.7);
					else if (getDirection() == 4)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleRIGHTWITHVIRUS.JPG",
								0.7, 0.7);
				}

				else {
					if (getDirection() == 1)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleUP.JPG", 0.7, 0.7);
					else if (getDirection() == 2)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleDOWN.JPG", 0.7, 0.7);
					else if (getDirection() == 3)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleLEFT.JPG", 0.7, 0.7);
					else if (getDirection() == 4)
						StdDraw.picture(getNextX() + 0.5, getNextY() + 0.5, "PersonAboveViewSingleRIGHT.JPG", 0.7, 0.7);

				}

			}
		}

	}

	/**
	 * This method is responsible for the first drawing of the man
	 */
	@Override
	public void firstDraw() {
		startingPos();
		generateDirection();
		if (super.isInfected() == true) {

//		if (belongingGrid.getHasInfectedHuman(getCurX(), getCurY()))
//			 if he is infected, set it to the cell
			belongingGrid.setHasInfectedHuman(getCurX(), getCurY(), true);
			if (getDirection() == 1)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleUPWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 2)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleDOWNWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 3)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleLEFTWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 4)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleRIGHTWITHVIRUS.JPG", 0.7, 0.7);

		} // test
		else {
			if (getDirection() == 1)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleUP.JPG", 0.7, 0.7);
			else if (getDirection() == 2)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleDOWN.JPG", 0.7, 0.7);
			else if (getDirection() == 3)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleLEFT.JPG", 0.7, 0.7);
			else if (getDirection() == 4)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleRIGHT.JPG", 0.7, 0.7);

		}
	}

	@Override
	public void draw() {

		if (super.isInfected() == true) {
//			if (belongingGrid.getHasInfectedHuman(getCurX(), getCurY()))
			// if he is infected, set it to the cell
				belongingGrid.setHasInfectedHuman(getCurX(), getCurY(), true);
			if (getDirection() == 1)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleUPWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 2)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleDOWNWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 3)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleLEFTWITHVIRUS.JPG", 0.7, 0.7);
			else if (getDirection() == 4)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleRIGHTWITHVIRUS.JPG", 0.7, 0.7);
		} else {
			if (getDirection() == 1)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleUP.JPG", 0.7, 0.7);
			else if (getDirection() == 2)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleDOWN.JPG", 0.7, 0.7);
			else if (getDirection() == 3)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleLEFT.JPG", 0.7, 0.7);
			else if (getDirection() == 4)
				StdDraw.picture(getCurX() + 0.5, getCurY() + 0.5, "PersonAboveViewSingleRIGHT.JPG", 0.7, 0.7);

		}

	}

	@Override
	public Human clone() {
		return new Man(this);
	}

}
