package team1.hw6;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdDraw;

/**
 * The main class of the program. Gets all the input arguments and calls the
 * right methods
 * 
 * @author nstavr04.mvasil01
 *
 */
public class PandemicSimulator {

	public static void main(String[] args) throws ExceptionNegativeValue {

		Scanner scan = new Scanner(System.in);

		// Used for exception handling
		boolean continueInput = true;

		System.out.println("Welcome to PandemicSimulator!");
		System.out.println();

		// Get the number of areas
		System.out.println("Give the number of areas:");

		int areaNum = 0;

		do {
			try {

				areaNum = Integer.parseInt(scan.nextLine());

				if (areaNum <= 0)
					throw new ExceptionNegativeValue();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong number of areas. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		// For each area there is different humans count!
		int[] counterForEachArea = new int[areaNum];

		// Array for all the area sizes ( x , y )
		int[][] areaSizes = new int[areaNum][2];

		int maxHumanNum = 0;

		// Border amount for each area
		int borderAmount[] = new int[areaNum];

		// For each area give the size of the corresponding grid
		for (int i = 0; i < areaNum; i++) {

			// Width and height declaration
			areaSizes[i][0] = 0;
			areaSizes[i][1] = 0;

			System.out.println("Give the width scale of the simulation(max: 50) for area " + (i + 1) + " :");

			do {
				try {

					areaSizes[i][0] = Integer.parseInt(scan.nextLine());

					if (areaSizes[i][0] <= 0)
						throw new ExceptionNegativeValue();

					if (areaSizes[i][0] > 50)
						throw new ExceptionNegativeValue(
								"Wrong width scale input. Must be less or equal than 50. Try again: ");

					continueInput = false;

				} catch (NumberFormatException e) {
					System.out.println("Wrong width scale input. Must be a positive number. Try again: ");
				} catch (ExceptionNegativeValue e) {
					System.out.println(e.getMessage());
				}

			} while (continueInput);

			continueInput = true;

			System.out.println("Give the height scale of the simulation(max: 40) for area " + (i + 1) + " :");

			do {
				try {

					areaSizes[i][1] = Integer.parseInt(scan.nextLine());

					if (areaSizes[i][1] <= 0)
						throw new ExceptionNegativeValue();

					if (areaSizes[i][1] > 40)
						throw new ExceptionNegativeValue("Wrong height scale input. Must be less than 40. Try again: ");

					if (areaSizes[i][1] > areaSizes[i][0])
						throw new ExceptionNegativeValue(
								"Wrong height scale input. Must be less than width(For better display). Try again: ");

					continueInput = false;

				} catch (NumberFormatException e) {
					System.out.println("Wrong height scale input. Must be a positive number. Try again: ");
				} catch (ExceptionNegativeValue e) {
					System.out.println(e.getMessage());
				}

			} while (continueInput);

			continueInput = true;

			// Find the max number of humans allowed throughout all grids
			maxHumanNum += areaSizes[i][0] * areaSizes[i][1];

			// NOT IMPLEMENTED YET
			System.out.println("Give border amount. Type -1 for default borders (corners).");

			System.out.println("Give border amount for area " + (i + 1) + " :");

			do {
				try {

					borderAmount[i] = Integer.parseInt(scan.nextLine());

					if (borderAmount[i] < 0)
						throw new ExceptionNegativeValue();

					if (borderAmount[i] > (areaSizes[i][0] * 2 + areaSizes[i][1] * 2 - 4))
						throw new ExceptionNegativeValue(
								"You have exceeded the maximum amount of borders. Try again: ");

					continueInput = false;

				} catch (NumberFormatException e) {
					System.out.println("Wrong border amount input. Must be a positive number. Try again: ");
				} catch (ExceptionNegativeValue e) {
					System.out.println(e.getMessage());
				}

			} while (continueInput);

			continueInput = true;

		}

		int maxBorderAmount = borderAmount[0];

		// Used to get the max border amount of all areas
		for (int j = 1; j < areaNum; j++) {

			if (borderAmount[j] > maxBorderAmount) {
				maxBorderAmount = borderAmount[j];
			}

		}

		int[][] borderX = new int[maxBorderAmount][areaNum];
		int[][] borderY = new int[maxBorderAmount][areaNum];
		int nextArea[][] = new int[maxBorderAmount][areaNum];

		// For each area
		for (int i = 0; i < areaNum; i++) {

			// Give for every single border of the certain area the x , y coordinates as
			// well as the nextArea
			for (int j = 0; j < borderAmount[i]; j++) {

				System.out.println("Give the X coordinate for border " + (j + 1) + " :");

				do {
					try {

						borderX[j][i] = Integer.parseInt(scan.nextLine());

						if (borderX[j][i] < 0)
							throw new ExceptionNegativeValue();

						if (borderX[j][i] >= areaSizes[i][0])
							throw new ExceptionNegativeValue("Coordinate out of bounadries. Try again: ");

						continueInput = false;

					} catch (NumberFormatException e) {
						System.out.println("Wrong border coordinate input. Must be a positive number. Try again: ");
					} catch (ExceptionNegativeValue e) {
						System.out.println(e.getMessage());
					}

				} while (continueInput);

				continueInput = true;

				System.out.println("Give the Y coordinate for border " + (j + 1) + " :");

				do {
					try {

						borderY[j][i] = Integer.parseInt(scan.nextLine());

						if (borderY[j][i] < 0)
							throw new ExceptionNegativeValue();

						if (borderY[j][i] >= areaSizes[i][1])
							throw new ExceptionNegativeValue("Coordinate out of bounadries. Try again: ");

						continueInput = false;

					} catch (NumberFormatException e) {
						System.out.println("Wrong border coordinate input. Must be a positive number. Try again: ");
					} catch (ExceptionNegativeValue e) {
						System.out.println(e.getMessage());
					}

				} while (continueInput);

				continueInput = true;

				System.out.println("Give the area that this border will teleport the human to [1," + areaNum + "]:");

				do {
					try {

						nextArea[j][i] = Integer.parseInt(scan.nextLine());
						// To get the right area number
						nextArea[j][i]--;

						if (nextArea[j][i] < 0)
							throw new ExceptionNegativeValue();

						if (nextArea[j][i] >= areaNum)
							throw new ExceptionNegativeValue("Not valid area. Try again: ");

						continueInput = false;

					} catch (NumberFormatException e) {
						System.out.println("Wrong area input. Must be a number within the boundaries. Try again: ");
					} catch (ExceptionNegativeValue e) {
						System.out.println(e.getMessage());
					}

				} while (continueInput);

				continueInput = true;

			}

		}

		System.out.println("Give the duration of the simulation: ");

		int timeUnits = 0;

		do {
			try {

				timeUnits = Integer.parseInt(scan.nextLine());

				if (timeUnits <= 0)
					throw new ExceptionNegativeValue();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong duration input. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the number of humans of the simulation: ");

		int humanNum = 0;

		do {
			try {

				humanNum = Integer.parseInt(scan.nextLine());

				if (humanNum <= 0)
					throw new ExceptionNegativeValue();
				if (humanNum > maxHumanNum)
					throw new ExceptionHumanMoreThanGrid();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong human number input. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			} catch (ExceptionHumanMoreThanGrid e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		Human humans[] = new Human[humanNum];

		System.out.println("Give how many of those humans to be infected: ");

		int infectedHumans = 0;

		do {
			try {

				infectedHumans = Integer.parseInt(scan.nextLine());

				if (infectedHumans <= 0)
					throw new ExceptionNegativeValue("Infected humans must be at least 1. Try again:");
				if (infectedHumans > humanNum)
					throw new ExceptionInfMoreThanHumans();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong infected humans input. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			} catch (ExceptionInfMoreThanHumans e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		// ODDS

		System.out.println("Give the percentage a human will move: ");

		int humanMovePer = 0;

		do {
			try {

				humanMovePer = Integer.parseInt(scan.nextLine());

				if (humanMovePer < 0)
					throw new ExceptionUnavailablePercentage();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong human move percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give human having mask percentage: ");

		int humanMaskPer = 0;

		do {
			try {

				humanMaskPer = Integer.parseInt(scan.nextLine());

				if (humanMaskPer < 0)
					throw new ExceptionUnavailablePercentage();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong human having mask percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the percentage a human will infect another human: ");

		int humanInfHumanPer = 0;

		do {
			try {

				humanInfHumanPer = Integer.parseInt(scan.nextLine());

				if (humanInfHumanPer < 0)
					throw new ExceptionUnavailablePercentage();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println(
						"Wrong human infecting human percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the percentage a human will infect the ground: ");

		int humanInfGroundPer = 0;

		do {
			try {

				humanInfGroundPer = Integer.parseInt(scan.nextLine());

				if (humanInfGroundPer < 0)
					throw new ExceptionUnavailablePercentage();
				if (humanInfGroundPer > humanInfHumanPer)
					throw new ExceptionInfMoreThanHumans(
							"Ground must have lower percentage of infecting a human than another human a human. Try again:");

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println(
						"Wrong human infecting ground percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			} catch (ExceptionInfMoreThanHumans e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the percentage the ground will infect the human: ");

		int groundInfHumanPer = 0;

		do {
			try {

				groundInfHumanPer = Integer.parseInt(scan.nextLine());

				if (groundInfHumanPer < 0)
					throw new ExceptionUnavailablePercentage();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println(
						"Wrong ground infecting human percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the percentage a human will be immune to the virus: ");

		int humanImmunePer = 0;

		do {
			try {

				humanImmunePer = Integer.parseInt(scan.nextLine());

				if (humanImmunePer < 0)
					throw new ExceptionUnavailablePercentage();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong human immune percentage input. Must be a positive number. Try again: ");
			} catch (ExceptionUnavailablePercentage e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		System.out.println("Give the time for when the ground should clear of any infections it may have.");

		int timeRemoveInf = 0;

		do {
			try {

				timeRemoveInf = Integer.parseInt(scan.nextLine());

				if (timeRemoveInf < 0)
					throw new ExceptionNegativeValue();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong time to remove infection input. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		// Set how long the ground will stay infected
		Time.setTimeUnits(timeRemoveInf);

		scan.close();

		//////////////////////////////////////////////////////////////////////

		//////////////////////////////////////////////////////////////////////

		// Creating the nessessary arrays for the intializations of control panel
		Grid[] gridsarr = new Grid[areaNum];
		Human[][] humansarr = new Human[humanNum][areaNum];

		// Create all nessessary Grid and Human[] objects
		for (int i = 0; i < areaNum; i++) {

			int[] tempX = new int[borderX.length];
			int[] tempY = new int[borderX.length];
			int[] tempNextArea = new int[borderX.length];

			// Transfer the 2D arrays to 1D arrays to make use in Grid constructor
			for (int j = 0; j < borderX.length; j++) {

				tempX[j] = borderX[j][i];
				tempY[j] = borderY[j][i];
				tempNextArea[j] = nextArea[j][i];

			}

			gridsarr[i] = new Grid(areaSizes[i][0], areaSizes[i][1], tempX, tempY, tempNextArea, borderAmount[i]);

		}

		ControlPanel controlP = new ControlPanel(humansarr, gridsarr);

		createHumans(humanNum, infectedHumans, humanMaskPer, humanMovePer, humanInfHumanPer, humanInfGroundPer,
				humanImmunePer, groundInfHumanPer, counterForEachArea);

//		move(humanNum, humans, timeUnits, width, height, humans2, myGrid, myGrid2);

		int temp; // test
		for (int i = 0; i < timeUnits; i++) {
			for (int j = 0; j < areaNum; j++) {
				move(j);
				StdDraw.show(500);
				// Draw the next area's humans
				if (j == (areaNum - 1))
					temp = 0;
				else
					temp = (j + 1);
				drawNext(temp);
				StdDraw.show(500);
			}
		}
		outputPrint(humanNum, infectedHumans);

	}

	/**
	 * The method for making every human move until time runs out
	 * 
	 * @param humanNum
	 * @param humans
	 * @param timeUnits
	 */
	public static void move(int humanNum, Human humans[], int timeUnits, int width, int height, Human humans2[],
			Grid myGrid, Grid myGrid2) {
		boolean flag = true; // test
		int counter = 1; // test
		for (int i = 0; i < timeUnits; i++) {

			for (int j = 0; j < humanNum; j++) {
				if (humans[j] != null && flag == true) {
//				myGrid.setWidth(width);
//				myGrid.setHeight(height);
//				temp Grid = humans[j].getGrid();		gia to mellon
					humans[j].move();
					humans[j].chanceToBrandTheSpot();
					humans[j].chanceToGetInfected();
					StdDraw.show(400);
				}
				if (!flag) {
//					myGrid2.setWidth(15);
//					myGrid2.setHeight(7);
					humans2[j].move();
					humans2[j].chanceToBrandTheSpot();
					humans2[j].chanceToGetInfected();
					StdDraw.show(400);
//					if (counter == 3) {
//						flag = false;
//						counter=1;
//					}
				}
				flag = !flag;
//				StdDraw.show(2500 / humanNum); // 10->200, 20-->100
			}
			// test
//			StdDraw.show(400); // 10->200, 20-->100
			myGrid.updateGrid();
			myGrid2.updateGrid();
		}

	}

	public static void move(int areaNum) {

		for (int j = 0; j < ControlPanel.getGrids()[areaNum].getHumansOnGrid(); j++) { //
			ControlPanel.getGrids()[areaNum].drawInfectionsBack();
			ControlPanel.getHumans()[j][areaNum].move();
			ControlPanel.getHumans()[j][areaNum].chanceToBrandTheSpot();
			ControlPanel.getHumans()[j][areaNum].chanceToGetInfected();
			if (ControlPanel.getHumans()[j][areaNum].isInBorder() != -1) {
				int nextArea = ControlPanel.getHumans()[j][areaNum].isInBorder();
				ControlPanel.teleport(j, areaNum, nextArea);
				ControlPanel.getHumans()[ControlPanel.getTeleportedIndex()][nextArea].startingPos();
				ControlPanel.getGrids()[areaNum].setHumansOnGrid(-1);
				ControlPanel.getGrids()[nextArea].setHumansOnGrid(1);
			}	
		}
		ControlPanel.getGrids()[areaNum].updateGrid();
	}

	public static void drawNext(int areaNum) {
		ControlPanel.getGrids()[areaNum].setDimentions();
		ControlPanel.getGrids()[areaNum].drawGridLines();
		ControlPanel.getGrids()[areaNum].drawInfectionsBack();
		for (int j = 0; j < ControlPanel.getGrids()[areaNum].getHumansOnGrid(); j++) { //
			ControlPanel.getHumans()[j][areaNum].draw();
		}
	}

	/**
	 * The method that calls the correct constructors for human depending on the
	 * percentages given by the user
	 * 
	 * @param hum
	 * @param humNum
	 * @param infectedHumans
	 * @param humanMaskPer
	 * @param humanMovePer
	 * @param humanInfHumanPer
	 * @param humanInfGroundPer
	 * @param humanImmunePer
	 * @param groundInfHumanPer
	 */
	public static void createHumans(int humNum, int infectedHumans, int humanMaskPer, int humanMovePer,
			int humanInfHumanPer, int humanInfGroundPer, int humanImmunePer, int groundInfHumanPer,
			int counterForEachArea[]) {

		boolean isInfected = false;

		// Random percentage to have mask
		int haveMask = 0;
		boolean giveMask = false;

		// Random percentage to be immune
		int beImmune = 0;
		boolean immune = false;

		for (int i = 0; i < humNum; i++) {

			// Check if next human will have mask
			haveMask = (int) (Math.random() * 101);
			// Check if next human will be immune
			beImmune = (int) (Math.random() * 101);

			if (haveMask < humanMaskPer)
				giveMask = true;
			else
				giveMask = false;

			// Used to determine on which area each human will go
			int area = (int) (Math.random() * ControlPanel.getNumOfAreas());
			ControlPanel.getGrids()[area].setHumansOnGrid(1); // elpizoume

			// Make human have infection
			if (infectedHumans > 0) {
				isInfected = true;

				if (giveMask)
					ControlPanel.getHumans()[counterForEachArea[area]][area] = new MaskedMan(isInfected, giveMask,
							immune, humanMovePer, humanInfHumanPer, humanInfGroundPer, groundInfHumanPer,
							ControlPanel.getGrids()[area]);
				else
					ControlPanel.getHumans()[counterForEachArea[area]][area] = new Man(isInfected, giveMask, immune,
							humanMovePer, humanInfHumanPer, humanInfGroundPer, groundInfHumanPer,
							ControlPanel.getGrids()[area]);
				infectedHumans--;

				// Create normal human
			} else {
				isInfected = false;

				if (beImmune < humanImmunePer)
					immune = true;
				else
					immune = false;

				if (giveMask)
					ControlPanel.getHumans()[counterForEachArea[area]][area] = new MaskedMan(isInfected, giveMask,
							immune, humanMovePer, humanInfHumanPer, humanInfGroundPer, groundInfHumanPer,
							ControlPanel.getGrids()[area]);
				else
					ControlPanel.getHumans()[counterForEachArea[area]][area] = new Man(isInfected, giveMask, immune,
							humanMovePer, humanInfHumanPer, humanInfGroundPer, groundInfHumanPer,
							ControlPanel.getGrids()[area]);
			}
			counterForEachArea[area]++;

		}
	}

	/**
	 * The method is responsible for printing the final output messages once the
	 * simulation has come to an end
	 * 
	 * @param humanNum
	 * @param infectedHumans
	 */
	public static void outputPrint(int humanNum, int infectedHumans) {

		System.out.println("\nEnd of Simulation: ");
		System.out.println("Total People: " + humanNum);
		System.out.println("Infected People at the Beginning: " + infectedHumans);
		System.out.println("Total Infected People: " + ((Human.getInfectedCounter() + infectedHumans)));
		System.out.println("Total Immune People: " + Human.getImmuneCounter());
		System.out.println("Total People that wore masks: " + Human.getMaskCounter());

	}

}
