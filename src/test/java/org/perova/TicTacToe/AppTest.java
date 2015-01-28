package org.perova.TicTacToe;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class AppTest {

	/*----------------------------IsFieldSizeCorrect()--------------------------------*/
	@Test
	public void test_IsFieldSizeCorrect_CorrectFieldSize() {
		App myGame = new App();
		int[][] field = new int[][] { { 2, 0, 1 }, { 2, 1, 1 }, { 1, 1, 2 } };
		boolean actualResult = myGame.isFieldSizeCorrect(field);
		AssertJUnit.assertTrue(actualResult);
	}

	@Test
	public void test_isFieldSizeCorrect_IncorrectFieldSize() {
		App myGame = new App();
		int[][] field = new int[][] { { 2, 0, 1 }, { 2, 1 }, { 1, 1, 2 } };
		boolean actualResult = myGame.isFieldSizeCorrect(field);
		AssertJUnit.assertFalse(actualResult);
	}

	/*-------------------------------goTo()_Right-------------------------------------*/
	@Test
	public void test_goTo_Right_CurrentCellIsEmpty_MakeStepOutOfBoundary() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 9;
		int currentColumn = 9;
		int step = 1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_JustOneElementInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 2;
		int step = 1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_JustFourElementInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 2;
		int step = 1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_OneIsAWinnerInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 2;
		int step = 1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_goTo_Right_TwoIsAWinnerInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 2, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 2;
		int step = 1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(2, actualResult);
	}

	/*---------------------------------goTo()_Left------------------------------------*/
	@Test
	public void test_goTo_Left_CurrentCellIsEmpty_MakeStepOutOfBoundary() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 0;
		int currentColumn = 0;
		int step = -1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_JustOneElementInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 6;
		int step = -1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_JustFourElementInLine() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 6;
		int step = -1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_OneIsAWinnerInCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 6;
		int step = -1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_goTo_Left_TwoIsAWinnerInCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 1, 0, 2, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 2, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int currentRow = 3;
		int currentColumn = 6;
		int step = -1;
		int actualResult = myGame.goTo(field, currentRow, currentColumn, step);
		AssertJUnit.assertEquals(2, actualResult);
	}

	/*------------------------------checkRowsForWinner()-------------------------------*/
	@Test
	public void test_checkRowsForWinner_WinnerIsInThe1stRow() {
		App myGame = new App();
		int[][] field = new int[][] { { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheLastRow() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 2 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInThe3rdRow() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 2 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_NoWinners() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheColumn() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	/*------------------------------checkColumnsForWinner()-------------------------------*/
	@Test
	public void test_checkColumnsForWinner_WinnerIsInThe1stColumn() {
		App myGame = new App();
		int[][] field = new int[][] { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 1, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkColumnsForWinnerWinnerIsInTheLastColumn() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 2 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 } };
		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInThe3rdColumn() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 2, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_NoWinners() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInTheRow() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInTheCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	/*------------------------------checkCrossesForWinner()-------------------------------*/
	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheLeftCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.checkCrossesForWiner(field);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkCrossesForWinnerWinnerIsInTheRightCrossing() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner(field);
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_NoWinners() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheColumn() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheRow() {
		App myGame = new App();
		int[][] field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner(field);
		AssertJUnit.assertEquals(0, actualResult);
	}

}
