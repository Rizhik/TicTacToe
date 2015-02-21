package org.perova.TicTacToe;

import java.util.Scanner;

public class App {
	int[][] field;
	int coordinateByX = 0;
	int coordinateByY = 0;
	int currentPlayer = 1;
	Scanner sc = new Scanner(System.in);

	protected void setField(int[][] field) {
		this.field = field;
	}

	protected void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	protected App(int sizeByX, int sizeByY) {

		int[][] newField = new int[sizeByX][sizeByY];
		for (int i = 0; i < sizeByX; i++) {
			for (int j = 0; j < sizeByY; j++) {
				newField[i][j] = 0;
			}
		}

		setField(newField);
	}

	protected void printField() {
		for (int raw = 0; raw < field.length; raw++) {
			for (int column = 0; column < field[raw].length; column++) {
				System.out.print(field[raw][column] + " ");
			}
			System.out.println();
		}
	}

	protected int[] requestCoordinate(int playerId) {
		int[] coordinates = new int[2];
		System.out.print("Please, input coordinate X for " + playerId + ": ");

		coordinates[0] = sc.nextInt();

		System.out.print("Please, input coordinate Y for " + playerId + ": ");
		coordinates[1] = sc.nextInt();

		return coordinates;
	}

	protected int[][] makeMove(int playerId) {

		int[] coordinates = requestCoordinate(playerId);

		int x = coordinates[0];
		int y = coordinates[1];

		if (field[x][y] != 0) {
			System.out
					.println("You made a wrong step. This cell is marked already");
		} else {
			if (playerId == 1) {
				field[x][y] = 1;
			} else {
				field[x][y] = 2;
			}
		}
		return field;
	}

	protected int countPlayerCells(int currentRow, int currentColumn, int offset) {
		int numberOfElements = 0;
		int currentElement = 0;

		if (field[currentRow][currentColumn] != 0) {
			currentElement = field[currentRow][currentColumn];
			numberOfElements++;

			int stepCounter = 1;
			while (stepCounter != 5) {
				if (((currentRow + stepCounter) < field.length)
						&& (currentColumn + offset * stepCounter >= 0)
						&& ((currentColumn + offset * stepCounter) < field[currentRow].length)
						&& (currentElement == field[currentRow + stepCounter][currentColumn
								+ offset * stepCounter])) {
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

	protected int checkCrossesForWiner() {

		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {

				// Go right
				int rightResult = countPlayerCells(row, column, 1);

				if (rightResult != 0) {
					return rightResult;
				}
				// Go left
				int leftResult = countPlayerCells(row, column, -1);

				if (leftResult != 0) {
					return leftResult;
				}
			}
		}
		return 0;
	}

	protected int checkRowsForWinner() {

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

	protected int checkColumnsForWinner() {

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

	protected int findWinner() {

		// Check crosses for winer
		int crossesWinner = checkCrossesForWiner();
		if (crossesWinner != 0) {
			System.out.println("CROSSES_Winner is " + crossesWinner);
			return crossesWinner;
		}

		// Check rows for winner
		int rowWinner = checkRowsForWinner();
		if (rowWinner != 0) {
			System.out.println("ROW_Winner is " + rowWinner);
			return rowWinner;
		}

		// Check columns for winner
		int columnWinner = checkColumnsForWinner();
		if (columnWinner != 0) {
			System.out.println("COLUMN_Winner is " + columnWinner);
			return columnWinner;
		}

		// There is no winner message
		return 0;

	}

	public void startGame() {

		do {
			printField();

			// Change player on each step
			makeMove(currentPlayer);
			if (currentPlayer == 1) {
				currentPlayer = 2;
			} else {
				currentPlayer = 1;
			}

		} while (findWinner() == 0);
		sc.close();
	}

	public static void main(String[] args) {
		App myGame = new App(5, 5);
		myGame.startGame();
	}
}
