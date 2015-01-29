package org.perova.TicTacToe;

public class App {

	protected boolean isFieldSizeCorrect(int field[][]) {
		for (int raw = 0; raw < field.length; raw++) {

			if (field.length != field[raw].length) {
				System.out.println("!!! We have a wrong field size !!!");
				return false;
			}

		}

		return true;
	}

	protected void printField(int field[][]) {
		for (int raw = 0; raw < field.length; raw++) {
			for (int column = 0; column < field[raw].length; column++) {
				System.out.print(field[raw][column] + " ");
			}
			System.out.println();
		}
	}

	protected int goTo(int[][] field, int currentRow, int currentColumn,
			int step) {
		int numberOfElements = 0;
		int currentElement = 0;

		if (field[currentRow][currentColumn] != 0) {
			currentElement = field[currentRow][currentColumn];
			numberOfElements++;

			int stepCounter = 1;
			while (stepCounter != 5) {
				if (((currentRow + 1) < field.length)
						&& (currentColumn + step * stepCounter >= 0)
						&& ((currentColumn + step * stepCounter) < field[currentRow].length)
						&& (currentElement == field[currentRow + 1][currentColumn
								+ step * stepCounter])) {
					numberOfElements++;

				} else {
					break;
				}
				stepCounter++;
			}

			if (numberOfElements == 5) {
				return currentElement;
			}

		}
		return 0;
	}

	protected int checkCrossesForWiner(int[][] field) {

		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {

				// Go right
				int rightResult = goTo(field, row, column, 1);

				if (rightResult != 0) {
					return rightResult;
				}
				// Go left
				int leftResult = goTo(field, row, column, -1);

				if (leftResult != 0) {
					return leftResult;
				}
			}
		}
		return 0;
	}

	protected int checkRowsForWinner(int[][] field) {

		for (int row = 0; row < field.length; row++) {
			int numberOfElements = 0;
			int currentElement = 0;
			for (int column = 0; column < field[row].length; column++) {

				if (currentElement != 0 && currentElement == field[row][column]) {

					numberOfElements++;

					if (numberOfElements == 5) {

						return currentElement;

					}
				}

				if (currentElement == 0 && field[row][column] != 0) {

					currentElement = field[row][column];
					numberOfElements++;

				}

				/*
				 * Verifies the case, when we have 5 elements in a row but not
				 * one by one. Example: {0,0,1,1,1,0,1,0,1}
				 */
				if (currentElement != field[row][column]) {
					numberOfElements = 0;
					currentElement = 0;
				}

			}
		}
		return 0;
	}

	protected int checkColumnsForWinner(int[][] field) {

		for (int column = 0; column < field[0].length; column++) {
			int currentElement = 0;
			int numberOfElements = 0;
			for (int row = 0; row < field.length; row++) {
				if (currentElement != 0 && currentElement == field[row][column]) {

					numberOfElements++;

					if (numberOfElements == 5) {

						return currentElement;

					}
				}

				if (currentElement == 0 && field[row][column] != 0) {

					currentElement = field[row][column];
					numberOfElements++;

				}

				/*
				 * Verifies the case, when we have 5 elements in a column but
				 * not one by one. Example: {0,0,1,1,1,0,1,0,1}
				 */
				if (currentElement != field[row][column]) {

					numberOfElements = 0;
					currentElement = 0;

				}

			}

		}
		return 0;
	}

	public void TicTacToe(int[][] field) {
		App game = new App();
		if (game.isFieldSizeCorrect(field) == true) {
			// Print of the field
			game.printField(field);

			// Check crosses for winer
			int crossesWinner = game.checkCrossesForWiner(field);
			if (crossesWinner != 0) {
				System.out.println("CROSSES_Winner is " + crossesWinner);
			}

			// Check rows for winner
			int rowWinner = game.checkRowsForWinner(field);
			if (rowWinner != 0) {
				System.out.println("ROW_Winner is " + rowWinner);
			}

			// Check columns for winner
			int columnWinner = game.checkColumnsForWinner(field);
			if (columnWinner != 0) {

				System.out.println("COLUMN_Winner is " + columnWinner);

			}

			// There is no winner message
			if (crossesWinner == 0 && rowWinner == 0 && columnWinner == 0) {
				System.out.println("There is no winner!!!");
			}
		}
	}

	public static void main(String[] args) {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 2, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } };
		myGame.TicTacToe(field);
	}
}
