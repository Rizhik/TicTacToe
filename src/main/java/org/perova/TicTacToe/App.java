package org.perova.TicTacToe;

public class App {
	

	protected boolean isFieldSizeCorrect(int field[][]) {
		for (int raw = 0; raw < field.length; raw++) {
			for (int column = 0; column < field[raw].length; column++) {
				if (field.length != field[raw].length) {
					System.out.println("!!! We have a wrong field size !!!");
					return false;
				}
			}
		}

		return true;
	}

	protected void printField(int field[][]) {
		for (int raw = 0; raw < field.length; raw++) {
			for (int column = 0; column < field[raw].length; column++) {
				System.out.print(field[raw][column]);
			}
			System.out.println();
		}
	}

	protected int checkCrossesForWiner(int[][] field) {
		if (field[0][0] == field[1][1] && field[0][0] == field[2][2]) {
			System.out.println("Winer is " + field[0][0]);
			return field[0][0];
		}

		if (field[0][2] == field[1][1] && field[2][0] == field[0][2]) {
			System.out.println("Winer is " + field[0][2]);
			return field[0][2];
		}
		return 0;
	}

	protected int checkRawsForWinner(int[][] field) {
		int numberOfOne = 0;
		int numberOfTwo = 0;
		for (int raw = 0; raw < field.length; raw++) {
			for (int column = 0; column < field[raw].length; column++) {
				if (field[raw][column] == 1) {
					numberOfOne++;
				}
				if (field[raw][column] == 2) {
					numberOfTwo++;
				}
			}
			if (numberOfOne == field.length) {
				System.out.println("Winer is 1");
				return 1;
			}

			if (numberOfTwo == field.length) {
				System.out.println("Winer is 2");
				return 2;
			}
			numberOfOne = 0;
			numberOfTwo = 0;
		}
		return 0;
	}

	protected int checkColumnsForWinner(int[][] field) {
		int numberOfOne = 0;
		int numberOfTwo = 0;
		for (int column = 0; column < 3; column++) { // need to find solution
														// for 3
			for (int raw = 0; raw < field.length; raw++) {
				if (field[raw][column] == 1) {
					numberOfOne++;
				}
				if (field[raw][column] == 2) {
					numberOfTwo++;
				}
			}
			if (numberOfOne == field.length) {
				System.out.println("Winer is 1");
				return 1;
			}

			if (numberOfTwo == field.length) {
				System.out.println("Winer is 2");
				return 2;
			}
			numberOfOne = 0;
			numberOfTwo = 0;
		}
		return 0;
	}

	public void TicTacToe(int[][] field) {
		App game = new App();
		if (game.isFieldSizeCorrect(field) == true) {
			// Print of the field
			game.printField(field);

			// Check crosses for winer
			if (game.checkCrossesForWiner(field) == 0) {

				// Check raws for winner
				if (game.checkRawsForWinner(field) == 0) {

					// Check columns for winner
					if (game.checkColumnsForWinner(field) == 0) {

						System.out.println("There is no winer!");

					}
				}
			}
		}
	}

	public static void main(String[] args) {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 1, 0 }, { 2, 1, 0 }, { 2, 0, 2 } };
		myGame.TicTacToe(field);
	}
}
