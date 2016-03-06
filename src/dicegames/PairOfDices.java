package dicegames;

import java.util.Arrays;

/**
 * This class models one pair of dice. This is useful for games where you have
 * to throw two dice at once.
 */
public class PairOfDices {

	private Die die1;
	private Die die2;
	private int numberOfRolls;
	private int pairsCounter;
	private int biggestRoll;
	private int[] rolls;

    /**Constructs a pair of dices with any number of sides
     * @param sides the number of sides on the die.
     */
    //
	public PairOfDices(int sides) {
		this.die1 = new Die(sides);
		this.die2 = new Die(sides);
		this.numberOfRolls = 0;
		this.pairsCounter = 0;
		this.biggestRoll = 0;
		this.rolls = new int[] {0, 0, 0, 0, 0, 0};
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

		this.rolls[this.die2.getFaceValue() - 1]++;
		this.rolls[this.die1.getFaceValue() - 1]++;

		if (this.die1.getFaceValue() == this.die2.getFaceValue()) {
			this.pairsCounter++;
		}
		if (getSumOfDices() > biggestRoll) {
			this.biggestRoll = getSumOfDices();
		}

	}

	// resets all game memory
	public void resetPairOfDices() {
		this.numberOfRolls = 0;
		this.pairsCounter = 0;
		this.biggestRoll = 0;
		this.die1.setFaceValue(1);
		this.die2.setFaceValue(1);

        Arrays.fill(this.rolls, 0);
	}

    /**A method for displaying the biggest roll
     * @return the biggest roll.
     */
    public int getBiggestRoll() {
		return this.biggestRoll;
	}

    /**A method for displaying the number of pairs achieved in the current game
     * @return the number of dice pairs rolled.
     */
	public int getPairs() {
		return this.pairsCounter;
	}

    /**A method for displaying the sum of the current roll
     * @return the sum of the dice roll.
     */
    public int getSumOfDices() {
		return this.die1.getFaceValue() + this.die2.getFaceValue();
	}

    /**A method for displaying the number of rolls in the current game
     * @return the number of dice rolls.
     */
    public int getNumberOfRolls() {
		return numberOfRolls;
	}

    /**A method for displaying the value of the current roll for Die1
     * @return the face-value of the first die.
     */
    public int getResult1Die1() {
		return this.die1.getFaceValue();
	}

    /**A method for displaying the value of the current roll for Die2
     * @return the face-value of the second die.
     */
    public int getResult2Die2() {
		return this.die2.getFaceValue();
	}

    /**
     * @return an array of dice roll frequencies
     */
    public int[] getRolls() {
		return this.rolls;
	}

}
