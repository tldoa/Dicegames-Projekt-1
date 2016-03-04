package dicegames;

import java.util.Scanner;

public class PairOfDicesTheGame {
	private Scanner scan;
	private PairOfDices theseDice;

	// TODO Auto-generated method stub
	public PairOfDicesTheGame() {
		theseDice = new PairOfDices(6);
		scan = new Scanner(System.in);
	}
	// Scanner scan = new Scanner(System.in);

	private void gameOver() {
		System.out.println("Tak for spillet du fik " + theseDice.getPairs() + " par." + "\nDit højeste kast var "
				+ theseDice.getBiggestRoll() + ".\nDu kastede " + theseDice.getNumberOfSixes() + " Seksere"
				+ ".\nDu kastede " + theseDice.getNumberOfFives() + " Femmere" + ".\nDu kastede "
				+ theseDice.getNumberOfFour() + " Fire'ere" + ".\nDu kastede " + theseDice.getNumberOfThree()
				+ " Tre'ere" + ".\nDu kastede " + theseDice.getNumberOfTwo() + " To'ere" + ".\nDu kastede "
				+ theseDice.getNumberOfOne() + " Et'ere");
		scan.close();
	}

	public void startGame() {
		System.out.println("Velkommen til spillet over dem alle, Pair Of Dices!");

		boolean finished = false;

		while (!finished) {
			System.out.println("Vil du kaste terningerne? Angiv Ja eller Nej: ");
			String proceedWithGame = scan.nextLine();
			if (proceedWithGame.equalsIgnoreCase("nej")) {
				finished = true;
			} else {
				theseDice.rollBothDices();
				System.out.println("Terning 1 rullede: " + theseDice.getResult1Die1());
				System.out.println("Terning 2 rullede: " + theseDice.getResult2Die2());
				System.out.println("Den samlede sum for dit kast blev: " + theseDice.getsumOfDices());
			}
		}
		gameOver();

	}

}
