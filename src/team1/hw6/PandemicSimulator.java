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

				if (areaNum < 0)
					throw new ExceptionNegativeValue();

				continueInput = false;

			} catch (NumberFormatException e) {
				System.out.println("Wrong number of areas. Must be a positive number. Try again: ");
			} catch (ExceptionNegativeValue e) {
				System.out.println(e.getMessage());
			}

		} while (continueInput);

		continueInput = true;

		// Array for all the area sizes ( x , y )
		int[][] areaSizes = new int[areaNum][areaNum];

		int maxHumanNum = 0;

		// For each area give the size of the corresponding grid
		for (int i = 0; i < areaNum; i++) {

			// Width and height declaration
			areaSizes[i][0] = 0;
			areaSizes[i][1] = 0;

			System.out.println("Give the width scale of the simulation(max: 50): ");

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

			System.out.println("Give the height scale of the simulation(max: 40): ");

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

			gridsarr[i] = new Grid(areaSizes[i][0], areaSizes[i][1]);

		}

		ControlPanel controlP = new ControlPanel(humansarr, gridsarr);

		createHumans(humanNum, infectedHumans, humanMaskPer, humanMovePer, humanInfHumanPer, humanInfGroundPer,
				humanImmunePer, groundInfHumanPer);

//		move(humanNum, humans, timeUnits, width, height, humans2, myGrid, myGrid2);

		
		for (int i=0; i<timeUnits; i++) {
			for (int j=0; j<areaNum; j++) {
				move(j);
				StdDraw.show(500);
				drawNext(j);
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

		for (int j = 0; j < ControlPanel.getGrids()[areaNum].getHumansOnGrid(); j++) { // elpizoume
			ControlPanel.getHumans()[j][areaNum].move();
			ControlPanel.getHumans()[j][areaNum].chanceToBrandTheSpot();
			ControlPanel.getHumans()[j][areaNum].chanceToGetInfected();
		}

	}

	public static void drawNext(int areaNum) {
		for (int j = 0; j < ControlPanel.getGrids()[areaNum].getHumansOnGrid(); j++) { // elpizoume
			ControlPanel.getGrids()[areaNum].DrawGridLines();
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
			int humanInfHumanPer, int humanInfGroundPer, int humanImmunePer, int groundInfHumanPer) {

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
			ControlPanel.getGrids()[area].setHumansOnGrid(1);	//elpizoume

			// Make human have infection
			if (infectedHumans > 0) {
				isInfected = true;

				if (giveMask)
					ControlPanel.getHumans()[i][area] = new MaskedMan(isInfected, giveMask, immune, humanMovePer,
							humanInfHumanPer, humanInfGroundPer, groundInfHumanPer, ControlPanel.getGrids()[area]);
				else
					ControlPanel.getHumans()[i][area] = new Man(isInfected, giveMask, immune, humanMovePer,
							humanInfHumanPer, humanInfGroundPer, groundInfHumanPer, ControlPanel.getGrids()[area]);
				infectedHumans--;

				// Create normal human
			} else {
				isInfected = false;

				if (beImmune < humanImmunePer)
					immune = true;
				else
					immune = false;

				if (giveMask)
					ControlPanel.getHumans()[i][area] = new MaskedMan(isInfected, giveMask, immune, humanMovePer,
							humanInfHumanPer, humanInfGroundPer, groundInfHumanPer, ControlPanel.getGrids()[area]);
				else
					ControlPanel.getHumans()[i][area] = new Man(isInfected, giveMask, immune, humanMovePer,
							humanInfHumanPer, humanInfGroundPer, groundInfHumanPer, ControlPanel.getGrids()[area]);
			}

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
