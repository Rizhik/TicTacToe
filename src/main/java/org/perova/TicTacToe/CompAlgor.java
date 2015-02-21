package org.perova.TicTacToe;

public class CompAlgor {

	protected int[] maxElementInMatrix(int[][] decisionMatrix) {
		int[] maxElement = new int[3];

		for (int row = 0; row < decisionMatrix.length; row++) {
			for (int column = 0; column < decisionMatrix[row].length; column++) {
				if (row == 0 && column == 0) {
					maxElement[0] = decisionMatrix[row][column];
					maxElement[1] = row;
					maxElement[2] = column;
				}
				if (maxElement[0] < decisionMatrix[row][column]) {
					maxElement[0] = decisionMatrix[row][column];
					maxElement[1] = row;
					maxElement[2] = column;
				}
			}
		}
		return maxElement;
	}

	protected int[][] copyMatrix(int[][] originalMatrix) {
		int[][] newMatrix = new int[originalMatrix.length][originalMatrix[0].length];
		for (int row = 0; row < originalMatrix.length; row++) {
			for (int column = 0; column < originalMatrix[row].length; column++) {

				newMatrix[row][column] = originalMatrix[row][column];

			}
		}
		return newMatrix;
	}

	protected int[][] combineMatrix(int[][] summaryMatrix,
			int[][] originalMatrix) {

		for (int row = 0; row < originalMatrix.length; row++) {
			for (int column = 0; column < originalMatrix[row].length; column++) {
				if (summaryMatrix[row][column] < originalMatrix[row][column]) {
					summaryMatrix[row][column] = originalMatrix[row][column];
				}
			}
		}
		return summaryMatrix;
	}

	protected int[][] combineMatrix(int[][] decisionMatrixByHorizontal,
			int[][] decisionMatrixByVertical, int[][] decisionMatrixByDiagonal) {
		// Put decisionMatrixByHorizontal into the summaryMatrix
		int[][] sumMatrix_ByHor = copyMatrix(decisionMatrixByHorizontal);

		// Add decisionMatrixByVertical to the summaryMatrix
		int[][] sumMatrix_ByHor_and_ByVert = combineMatrix(sumMatrix_ByHor,
				decisionMatrixByVertical);

		// Add decisionMatrixByDiagonal to the summaryMatrix
		int[][] summaryMatrix = combineMatrix(sumMatrix_ByHor_and_ByVert,
				decisionMatrixByDiagonal);

		// return final matrix
		return summaryMatrix;
	}

	protected boolean isFieldEmpty(int[][] field) {

		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {
				if (field[row][column] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	protected int[][] createMatrixForHorizontalLine(int[][] field, int playerID) {
		int[][] matrixWithHorizCoef = new int[field.length][field[0].length];

		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {

				// If current cell is occupied by X or O
				if (field[row][column] != 0) {

					matrixWithHorizCoef[row][column] = 0;

				} else {

					int numberOfMyCells = 0;

					// If next cell is occupied
					int counter = 0;
					int offset = 1;
					while ((column + offset < field[row].length)
							&& (field[row][column + offset]) == playerID) {
						counter++;
						offset++;
					}
					int coefByNextElements = 20 + 20 * counter;
					numberOfMyCells = counter;

					// If previous cell is occupied
					counter = 0;
					offset = 1;
					while ((column - offset > 0)
							&& (field[row][column - offset]) == playerID) {
						counter++;
						offset++;
					}

					int coefByPrevElements = 20 + 20 * counter;
					numberOfMyCells = numberOfMyCells + counter;

					if (coefByNextElements > coefByPrevElements) {
						matrixWithHorizCoef[row][column] = coefByNextElements;
					} else {
						matrixWithHorizCoef[row][column] = coefByPrevElements;
					}

					// If empty cell is located between group of my cells:
					// XXX_Empty_XXX
					int coefByNumberOfMyCells = 20 + 20 * numberOfMyCells;
					if (coefByNumberOfMyCells > matrixWithHorizCoef[row][column]) {
						matrixWithHorizCoef[row][column] = coefByNumberOfMyCells;
					}
				}
			}

		}

		return matrixWithHorizCoef;
	}

	protected int[][] createMatrixForVerticalLine(int[][] field, int playerID) {
		int[][] matrixWithVertCoef = new int[field.length][field[0].length];

		for (int column = 0; column < field[0].length; column++) {
			for (int row = 0; row < field.length; row++) {

				// If current cell is occupied by X or O
				if (field[row][column] != 0) {

					matrixWithVertCoef[row][column] = 0;

				} else {

					int numberOfMyCells = 0;

					// If next cell is occupied
					int counter = countPlayerCells(field, playerID, row,
							column, 1, 0);

					int coefByNextElements = 20 + 20 * counter;
					numberOfMyCells = counter;

					// If previous cell is occupied
					counter = countPlayerCells(field, playerID, row, column,
							-1, 0);

					int coefByPrevElements = 20 + 20 * counter;
					numberOfMyCells = numberOfMyCells + counter;

					if (coefByNextElements > coefByPrevElements) {
						matrixWithVertCoef[row][column] = coefByNextElements;
					} else {
						matrixWithVertCoef[row][column] = coefByPrevElements;
					}

					// If empty cell is located between group of my cells:
					// XXX_Empty_XXX
					int coefByNumberOfMyCells = 20 + 20 * numberOfMyCells;
					if (coefByNumberOfMyCells > matrixWithVertCoef[row][column]) {
						matrixWithVertCoef[row][column] = coefByNumberOfMyCells;
					}
				}
			}

		}

		return matrixWithVertCoef;
	}

	public boolean isStepAvailable(int[][] field, int playerID, int row,
			int column, int x_offset, int y_offset) {

		if ((row + x_offset < field.length)
				&& (column + y_offset < field[row].length)
				&& (row + x_offset >= 0) && (column + y_offset >= 0) &&

				(field[row + x_offset][column + y_offset] == playerID)) {
			return true;
		}

		return false;

	}

	public int countPlayerCells(int[][] field, int playerID, int row,
			int column, int x_offset, int y_offset) {
		int counter = 0;
		int initial_offsetX = x_offset;
		int initial_offsetY = y_offset;

		while (isStepAvailable(field, playerID, row, column, x_offset, y_offset)) {
			counter++;
			x_offset = initial_offsetX + x_offset;
			y_offset = initial_offsetY + y_offset;

		}
		return counter;
	}

	protected int[][] createMatrixForDiagonalLine(int[][] field, int playerID) {
		int[][] matrixWithDiagonalCoef = new int[field.length][field[0].length];

		// right and down
		for (int row = 0; row < field.length; row++) {
			for (int column = 0; column < field[row].length; column++) {
				// If current cell is occupied by X or O
				if (field[row][column] != 0) {

					matrixWithDiagonalCoef[row][column] = 0;

				} else {

					int numberOfMyCells = 0;
					int[] coefByNextElements = new int[4];

					// Diagonal from Left to Right
					int counter = countPlayerCells(field, playerID, row,
							column, 1, 1);
					coefByNextElements[0] = 20 + 20 * counter; // RD
					numberOfMyCells = counter;

					counter = countPlayerCells(field, playerID, row, column,
							-1, -1);
					coefByNextElements[1] = 20 + 20 * counter; // LU
					numberOfMyCells = numberOfMyCells + counter;

					int maxOfFirstDiagonal = 20 + 20 * numberOfMyCells;

					// Diagonal from Right to Left
					counter = countPlayerCells(field, playerID, row, column, 1,
							-1);
					coefByNextElements[2] = 20 + 20 * counter; // LD
					numberOfMyCells = counter;

					counter = countPlayerCells(field, playerID, row, column,
							-1, 1);
					coefByNextElements[3] = 20 + 20 * counter; // RU
					numberOfMyCells = numberOfMyCells + counter;

					int maxOfSecondDiagonal = 20 + 20 * numberOfMyCells;

					// Find Maximum
					int maximum = 0;
					for (int index = 0; index < coefByNextElements.length; index++) {

						if (index == 0) {
							maximum = coefByNextElements[index];
						}
						if (maximum < coefByNextElements[index]) {
							maximum = coefByNextElements[index];
						}

					}

					matrixWithDiagonalCoef[row][column] = maximum;

					if (maxOfFirstDiagonal > matrixWithDiagonalCoef[row][column]) {
						matrixWithDiagonalCoef[row][column] = maxOfFirstDiagonal;
					}

					if (maxOfSecondDiagonal > matrixWithDiagonalCoef[row][column]) {
						matrixWithDiagonalCoef[row][column] = maxOfSecondDiagonal;
					}

				}
			}
		}
		return matrixWithDiagonalCoef;
	}

	public int[] makeStep(int[][] field, int playerID) {
		int[] decision = new int[3];
		if (isFieldEmpty(field)) {

			int rowNumber = (int) (Math.random() * field.length);
			int columnNumber = (int) (Math.random() * field[0].length);
			decision[0] = 0;
			decision[1] = rowNumber;
			decision[2] = columnNumber;

		} else {
			int[][] diagonal = createMatrixForDiagonalLine(field, playerID);
			int[][] vertical = createMatrixForVerticalLine(field, playerID);
			int[][] horizontal = createMatrixForHorizontalLine(field, playerID);
			int[][] summary = combineMatrix(horizontal, vertical, diagonal);
			decision = maxElementInMatrix(summary);

		}
		return decision;

	}

}
