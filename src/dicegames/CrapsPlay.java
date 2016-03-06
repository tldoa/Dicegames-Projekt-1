package dicegames;

import java.util.Scanner;

public class CrapsPlay {
	// Instance variables for the game CrapsPlay
	private Die die1;
	private Die die2;
	// 0 = continue, 1=win, 2 = lose, 3 = give up;
	private int state;
	private Scanner scan;
	private int firstRoll;

	// Constructor for the CrapsPlay game, that creates 2 dices
	public CrapsPlay() {
		this.die1 = new Die();
		this.die2 = new Die();
		this.state = 0;
		this.firstRoll = 0;
		this.scan = new Scanner(System.in);
	}

	// Game greeting
	private void sayHello() {
		System.out.println("Velkommen til....trommehvirvel...CRAPS");
	}

	// A method that is called to print a suitable response to the way a game
	// has ended
	private void gameOver() {

		if (state == 1) {
			System.out.println("Du vandt");
		} else if (state == 2) {
			System.out.println("Du tabte");
		} else if (state == 3) {
			System.out.println("Du har givet op");
		}
		scan.close();
	}
	// A method that rolls both die and determines whether your roll is
	// your first roll
	// and then sets the conditions for winning and loosing

	public void takeTurn() {
		this.die1.roll();
		this.die2.roll();
		int actualRoll = this.die1.getFaceValue() + this.die2.getFaceValue();

		System.out.println("Du slog: " + actualRoll);

		if (this.firstRoll == 0) {
			if (actualRoll == 7 || actualRoll == 11) {
				this.state = 1;
			} else if (actualRoll == 2 || actualRoll == 3 || actualRoll == 12) {
				this.state = 2;
			} else {
				this.firstRoll = actualRoll;
			}

		} else {
			if (actualRoll == 7) {
				this.state = 2;
			} else if (actualRoll == firstRoll) {
				this.state = 1;
			} else {
                this.state = 0;
            }
		}
	}

	// A method that initializes the CrapsPlay game and determines whether the
	// game has been won,
	// lost or if the player has forfeited the game
	public void startGame() {
		sayHello();
		while (state == 0) {

			while (state == 0) {

				System.out.println("Vil du kaste terningerne? Angiv Ja eller Nej: ");
				String proceedWithGame = scan.nextLine();
				if (proceedWithGame.equalsIgnoreCase("nej")) {
					this.state = 3;
				} else {
					takeTurn();
				}

			}
			gameOver();

			System.out.println("Vil du spille igen? ");
			String proceedWithGame = scan.nextLine();

            if (proceedWithGame.equalsIgnoreCase("ja")) {
				this.state = 0;
				this.firstRoll = 0;
			} else {
				System.out.println("Taber");
			}

		}
	}

}
