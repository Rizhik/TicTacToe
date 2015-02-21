package org.perova.TicTacToe;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class AppTest {

	/*-------------------------------makeMove-------------------------------------*/
	// int[][] makeMove(int playerId)

	/*---------------------------requestCoordinate---------------------------------*/
	// int[] requestCoordinate(int playerId)

	/*---------------------------countPlayerCells---------------------------------*/
	// int countPlayerCells(int currentRow, int currentColumn, int offset)

	/*-------------------------------goTo()_Right-------------------------------------*/
	@Test
	public void test_goTo_Right_CurrentCellIsEmpty_MakeStepOutOfBoundary() {

		App myGame = new App(10, 10);

		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_JustOneElementInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_JustFourElementInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Right_OneIsAWinnerInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_goTo_Right_TwoIsAWinnerInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(2, actualResult);
	}

	/*---------------------------------goTo()_Left------------------------------------*/
	@Test
	public void test_goTo_Left_CurrentCellIsEmpty_MakeStepOutOfBoundary() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_JustOneElementInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_JustFourElementInLine() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_goTo_Left_OneIsAWinnerInCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_goTo_Left_TwoIsAWinnerInCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
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
		int actualResult = myGame.countPlayerCells(currentRow, currentColumn,
				step);
		AssertJUnit.assertEquals(2, actualResult);
	}

	/*------------------------------checkRowsForWinner()-------------------------------*/
	@Test
	public void test_checkRowsForWinner_WinnerIsInThe1stRow() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheLastRow() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 2 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInThe3rdRow() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 2, 2, 2, 2 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_NoWinners() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheColumn() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkRowsForWinner_WinnerIsInTheCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkRowsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	/*------------------------------checkColumnsForWinner()-------------------------------*/
	@Test
	public void test_checkColumnsForWinner_WinnerIsInThe1stColumn() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 1, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkColumnsForWinnerWinnerIsInTheLastColumn() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 2 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 } };
		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInThe3rdColumn() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 2, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_NoWinners() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInTheRow() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkColumnsForWinner_WinnerIsInTheCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkColumnsForWinner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	/*------------------------------checkCrossesForWinner()-------------------------------*/
	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheLeftCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.checkCrossesForWiner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheRightCrossing() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 0, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 0, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_NoWinners() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheColumn() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_checkCrossesForWinner_WinnerIsInTheRow() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int actualResult = myGame.checkCrossesForWiner();
		AssertJUnit.assertEquals(0, actualResult);
	}

	/*------------------------------findWinner()-------------------------------*/
	@Test
	public void test_findWinner_Crosses_WinerIs1() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_findWinner_Crosses_WinerIs2() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_findWinner_Row_WinerIs1() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_findWinner_Row_WinerIs2() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 2, 2, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}

	@Test
	public void test_findWinner_Column_WinerIs1() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 2, 1, 2, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 2, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 1, 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(1, actualResult);
	}

	@Test
	public void test_findWinner_Column_WinerIs2() {
		App myGame = new App(10, 10);
		myGame.field = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 2, 2, 2, 0, 2, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 2, 0, 0, 0, 0 },
				{ 0, 0, 1, 2, 2, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 2, 0, 1, 2, 0, 0, 0 },
				{ 0, 0, 2, 2, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

		int actualResult = myGame.findWinner();
		AssertJUnit.assertEquals(2, actualResult);
	}
}
