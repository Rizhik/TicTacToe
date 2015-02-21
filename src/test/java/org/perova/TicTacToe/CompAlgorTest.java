package org.perova.TicTacToe;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class CompAlgorTest {

	@Test
	public void test_maxElementInMatrix() {
		CompAlgor ai = new CompAlgor();
		int[][] matrix = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 7, 9, 18, 2, 5, 0, 0, 0 },
				{ 0, 0, 1, 0, 4, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int[] actualResult = ai.maxElementInMatrix(matrix);
		int[] expectedResult = { 18, 3, 4 };
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void test_copyMatrix() {
		CompAlgor ai = new CompAlgor();
		int[][] matrix = new int[][] { { 0, 0, 7, 9, 18, 2, 5, 0, 0, 0 },
				{ 0, 0, 1, 0, 4, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 2, 0, 0, 0 } };
		int[][] actualResult = ai.copyMatrix(matrix);
		AssertJUnit.assertArrayEquals(matrix, actualResult);
	}

	@Test
	public void test_combineMatrix_2() {
		CompAlgor ai = new CompAlgor();
		int[][] summaryMatrix = new int[][] { { 0, 10, 80, 5, -40 },
				{ 40, -60, 0, 50, 1 }, { -10, 90, 20, 45, 0 },
				{ 60, -30, 0, 70, 2 }, { 0, 55, 100, 30, -20 } };

		int[][] originalMatrix = new int[][] { { 7, 9, 18, 2, 5 },
				{ 100, 45, 4, -20, 80 }, { -10, 40, 0, 90, -60 },
				{ 55, 70, 20, -40, 30 }, { 1, -30, 100, 0, 10 } };

		int[][] expectedResult = new int[][] { { 7, 10, 80, 5, 5 },
				{ 100, 45, 4, 50, 80 }, { -10, 90, 20, 90, 0 },
				{ 60, 70, 20, 70, 30 }, { 1, 55, 100, 30, 10 } };

		int[][] actualResult = ai.combineMatrix(summaryMatrix, originalMatrix);
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void test_combineMatrix_3() {
		CompAlgor ai = new CompAlgor();

		int[][] decisionMatrixByHorizontal = new int[][] {
				{ 0, 10, 80, 5, -40 }, { 40, -60, 0, 50, 1 },
				{ -10, 90, 20, 45, 0 }, { 60, -30, 0, 70, 2 },
				{ 0, 55, 100, 30, -20 } };

		int[][] decisionMatrixByVertical = new int[][] { { 7, 9, 18, 2, 5 },
				{ 100, 45, 4, -20, 80 }, { -10, 40, 0, 90, -60 },
				{ 55, 70, 20, -40, 30 }, { 1, -30, 100, 0, 10 } };

		int[][] decisionMatrixByDiagonal = new int[][] {
				{ 2, -20, 20, 100, 3 }, { -30, 10, 7, 30, -10 },
				{ 70, 6, 0, 5, 80 }, { -40, 40, 8, 50, -50 },
				{ 4, 90, 60, 9, 1 } };

		int[][] expectedResult = new int[][] { { 7, 10, 80, 100, 5 },
				{ 100, 45, 7, 50, 80 }, { 70, 90, 20, 90, 80 },
				{ 60, 70, 20, 70, 30 }, { 4, 90, 100, 30, 10 } };

		int[][] actualResult = ai.combineMatrix(decisionMatrixByHorizontal,
				decisionMatrixByVertical, decisionMatrixByDiagonal);
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void test_isFieldEmpty_IsNotEmpty() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 10, 80, 5, -40 },
				{ 40, -60, 0, 50, 1 }, { -10, 90, 20, 45, 0 },
				{ 60, -30, 0, 70, 2 }, { 0, 55, 100, 30, -20 } };
		boolean actualResult = ai.isFieldEmpty(field);
		AssertJUnit.assertEquals(false, actualResult);
	}

	@Test
	public void test_isFieldEmpty_IsEmpty() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		boolean actualResult = ai.isFieldEmpty(field);
		AssertJUnit.assertEquals(true, actualResult);
	}

	@Test
	public void test_createMatrixForHorizontalLine() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 2, 2, 2, 2, 0 }, { 1, 2, 2, 0, 0 },
				{ 1, 1, 2, 0, 0 }, { 0, 0, 0, 2, 2 }, { 1, 1, 1, 0, 1 } };

		int[][] expectedResult = new int[][] { { 0, 0, 0, 0, 20 },
				{ 0, 0, 0, 20, 20 }, { 0, 0, 0, 20, 20 }, { 20, 20, 20, 0, 0 },
				{ 0, 0, 0, 80, 0 } };
		int[][] actualResult = ai.createMatrixForHorizontalLine(field, 1);
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void test_createMatrixForVerticalLine() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 1, 2, 2, 2, 0 }, { 1, 2, 2, 0, 0 },
				{ 1, 1, 2, 0, 0 }, { 0, 0, 0, 2, 2 }, { 1, 1, 1, 0, 1 } };

		int[][] expectedResult = new int[][] { { 0, 0, 0, 0, 20 },
				{ 0, 0, 0, 20, 20 }, { 0, 0, 0, 20, 20 },
				{ 100, 60, 40, 0, 0 }, { 0, 0, 0, 20, 0 } };
		int[][] actualResult = ai.createMatrixForVerticalLine(field, 1);
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void test_isStepAvailable_RD() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 2, 2, 1, 1);
		AssertJUnit.assertEquals(true, actualResult);
	}

	@Test
	public void test_isStepAvailable_RU() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 2, 2, -1, 1);
		AssertJUnit.assertEquals(true, actualResult);
	}

	@Test
	public void test_isStepAvailable_LD() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 2, 2, 1, -1);
		AssertJUnit.assertEquals(true, actualResult);
	}

	@Test
	public void test_isStepAvailable_LU() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 1, 0, 1, 0 }, { 1, 0, 0, 0, 1 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 2, 2, -1, -1);
		AssertJUnit.assertEquals(true, actualResult);
	}

	@Test
	public void test_isStepAvailable_00() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 0, 0, -1, -1);
		AssertJUnit.assertEquals(false, actualResult);
	}

	@Test
	public void test_isStepAvailable_33() {
		CompAlgor ai = new CompAlgor();

		int[][] field = new int[][] { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 } };
		boolean actualResult = ai.isStepAvailable(field, 1, 4, 4, 1, 1);
		AssertJUnit.assertEquals(false, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_RD() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 1 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, 1, 1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_LU() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, -1, -1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_LD() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, 1, -1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_RU() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 1 }, { 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, -1, 1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Up() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, -1, 0);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Down() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 1, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, 1, 0);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_Right() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, 0, 1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_countPlayerCells_Diagonal_Left() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		int actualResult = ai.countPlayerCells(field, 1, 2, 2, 0, -1);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_createMatrixForDiagonalLine() {
		CompAlgor ai = new CompAlgor();
		int[][] field = new int[][] { { 0, 2, 2, 2, 0 }, { 1, 2, 2, 0, 0 },
				{ 1, 1, 2, 0, 0 }, { 0, 0, 0, 2, 2 }, { 1, 1, 1, 0, 0 } };

		int[][] expectedResult = new int[][] { { 80, 0, 0, 0, 20 },
				{ 0, 0, 0, 40, 40 }, { 0, 0, 0, 80, 40 }, { 20, 40, 20, 0, 0 },
				{ 0, 0, 0, 40, 80 } };
		int[][] actualResult = ai.createMatrixForDiagonalLine(field, 2);
		AssertJUnit.assertArrayEquals(expectedResult, actualResult);
	}
}
