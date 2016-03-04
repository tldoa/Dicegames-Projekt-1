package dicegames;

/**
 * This class models one pair of dices. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {

	private Die die1;
	private Die die2;
	private int numberOfRolls;
	private int numberOfSixes;
	private int numberOfFives;
	private int numberOfFour;
	private int numberOfThree;
	private int numberOfTwo;
	private int numberOfOne;
	private int pairsCounter;
	private int biggestRoll;
	private int[] myArray;

	/**
	 * Constructor for objects of class PairOfDices
	 */
	// Constructs a pair of dices with any number of sides
	public PairOfDices(int sides) {
		this.die1 = new Die(sides);
		this.die2 = new Die(sides);
		this.numberOfRolls = 0;
		this.numberOfSixes = 0;
		this.numberOfFives = 0;
		this.numberOfFour = 0;
		this.numberOfThree = 0;
		this.numberOfTwo = 0;
		this.numberOfOne = 0;
		this.pairsCounter = 0;
		this.biggestRoll = 0;
		this.myArray = new int[] { 0, 0, 0, 0, 0, 0 };
	}

	// Constructs a pair of dices with 6 sides
	public PairOfDices() {
		this(6);
	}
	// A method for rolling a pair of dices, the method also calculates how many
	// times a given value
	// has been rolled, the biggest roll and how many times a pair has been
	// rolled

	public void rollBothDices() {
		this.numberOfRolls++;
		this.die1.roll();
		this.die2.roll();

		this.myArray[this.die2.getFaceValue() - 1]++;
		this.myArray[this.die1.getFaceValue() - 1]++;
		// System.out.println(faceValue + " " + myArray[faceValue]);
		// }
		if (this.die1.getFaceValue() == 6) {
			numberOfSixes++;
		} else if (this.die1.getFaceValue() == 5) {
			numberOfFives++;
		} else if (this.die1.getFaceValue() == 4) {
			numberOfFour++;
		} else if (this.die1.getFaceValue() == 3) {
			numberOfThree++;
		} else if (this.die1.getFaceValue() == 2) {
			numberOfTwo++;
		} else if (this.die1.getFaceValue() == 1) {
			numberOfOne++;
		}

		if (this.die2.getFaceValue() == 6) {
			numberOfSixes++;
		} else if (this.die2.getFaceValue() == 5) {
			numberOfFives++;
		} else if (this.die2.getFaceValue() == 4) {
			numberOfFour++;
		} else if (this.die2.getFaceValue() == 3) {
			numberOfThree++;
		} else if (this.die2.getFaceValue() == 2) {
			numberOfTwo++;
		} else if (this.die2.getFaceValue() == 1) {
			numberOfOne++;
		}

		if (this.die1.getFaceValue() == this.die2.getFaceValue()) {
			this.pairsCounter++;
		}
		if (this.die1.getFaceValue() + this.die2.getFaceValue() > biggestRoll) {
			this.biggestRoll = this.die1.getFaceValue() + this.die2.getFaceValue();
		}

	}

	// resets all game memory
	public void resetPairOfDices() {
		this.numberOfRolls = 0;
		this.numberOfSixes = 0;
		this.numberOfFives = 0;
		this.numberOfFour = 0;
		this.numberOfThree = 0;
		this.numberOfTwo = 0;
		this.numberOfOne = 0;
		this.pairsCounter = 0;
		this.biggestRoll = 0;
		this.die1.setFaceValue(1);
		this.die2.setFaceValue(1);

	}
	// A method for displaying the biggest roll

	public int getBiggestRoll() {
		return this.biggestRoll;
	}

	// A method for displaying the number of pairs achieved in the current game
	public int getPairs() {
		return this.pairsCounter;
	}
	// A method for displaying the sum of the current roll

	public int getsumOfDices() {
		return this.die1.getFaceValue() + this.die2.getFaceValue();
	}
	// A method for displaying the number of rolls in the current game

	public int getNumberOfRolls() {
		return numberOfRolls;
	}
	// A method for displaying the number of Sixes rolled in the current game

	public int getNumberOfSixes() {
		return numberOfSixes;
	}
	// A method for displaying the number of Fives rolled in the current game

	public int getNumberOfFives() {
		return numberOfFives;
	}
	// A method for displaying the number of Four's rolled in the current game

	public int getNumberOfFour() {
		return numberOfFour;
	}
	// A method for displaying the number of Three's rolled in the current game

	public int getNumberOfThree() {
		return numberOfThree;
	}
	// A method for displaying the number of Two's rolled in the current game

	public int getNumberOfTwo() {
		return numberOfTwo;
	}
	// A method for displaying the number of Ones rolled in the current game

	public int getNumberOfOne() {
		return numberOfOne;
	}

	// A method for displaying the value of the current roll for Die1

	public int getResult1Die1() {
		return this.die1.getFaceValue();
	}
	// A method for displaying the value of the current roll for Die2

	public int getResult2Die2() {
		return this.die2.getFaceValue();
	}

	public int[] getMyArray() {
		return this.myArray;
	}

}
