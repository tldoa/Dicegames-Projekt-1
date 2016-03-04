package dicegames;

import java.util.Scanner;

public class Pig {

	private Die die1;
	private int scoreP1;
	private int scoreP2;
	private int tempScore;
	private int gameState;
	private Scanner scan;
	private int winScore;

	public Pig(int winScore) {
		this.die1 = new Die();
		this.scoreP1 = 0;
		this.scoreP2 = 0;
		this.gameState = 3;
		this.tempScore = 0;
		scan = new Scanner(System.in);
		this.winScore = winScore;
	}

	public Pig() {
		this(100);
	}

	public void welcome() {
		System.out.println("Velkommen til gris din gamle gris");
	}

	public void gameOver() {
		if (gameState == 1) {
			System.out.println("Spiller 1 vinder");
		} else if (gameState == 2) {
			System.out.println("Spiller 2 vinder");
		}
	}

	public void takeTurn() {
		this.die1.roll();
		System.out.println("Du rullede: " + this.die1.getFaceValue());
		if (this.die1.getFaceValue() == 1) {
			gameState = -gameState;
			System.out.println("Du rullede 1 dine point er spist");
		} else {
			tempScore = tempScore + this.die1.getFaceValue();
			if (tempScore + scoreP1 >= winScore) {
				gameState = 1;
			} else if (tempScore + scoreP2 >= winScore) {
				gameState = 2;
			}
		}

	}

	public void startGame() {
		welcome();

		while (gameState == 3 || gameState == -3) {
			while (gameState == 3) {
				System.out.println("Vil du kaste terningen Spiller 1? Angiv Ja eller Nej: ");
				String proceedWithGame = scan.nextLine();
				if (proceedWithGame.equalsIgnoreCase("nej")) {
					gameState = -gameState;
				} else {
					takeTurn();
				}
			}
			scoreP1 = scoreP1 + tempScore;
			tempScore = 0;

			while (gameState == -3) {
				System.out.println("Vil du kaste terningen Spiller 2? Angiv Ja eller Nej: ");
				String proceedWithGame = scan.nextLine();
				if (proceedWithGame.equalsIgnoreCase("nej")) {
					gameState = -gameState;
				} else {
					takeTurn();
				}
			}
			scoreP1 = scoreP1 + tempScore;
			tempScore = 0;
		}

		gameOver();
	}

}
