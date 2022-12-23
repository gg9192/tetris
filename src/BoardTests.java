import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class BoardTests {
	/**
	 * Fills one row in the board grid with one's.
	 * @param b The board to be filled
	 * @param j The row
	 */
	private static void fillRow(Board b, int j) {
		for (int i = 0; i < 10; i ++) {
			b.setGrid(i, j, 1);
		}
	}
	
	/**
	 * Fills one row in the grid grid with one's.
	 * @param b The grid to be filled
	 * @param j The row
	 */
	private static void fillRow(int[][] b, int j) {
		for (int i = 0; i < 10; i ++) {
			b[i][j] = 1;
		}
	}

	/**
	 * Verifies that the board was properly cleared.
	 */
	@Test
	void testFixBoard() {
		Board b = new Board(0,0);
		fillRow(b, 23);
		fillRow(b, 22);
		b.setGrid(2, 21, 1);
		b.setGrid(5, 21, 1);
		int[][] grid = new int[10][24];
		fillRow(grid, 23);
		grid[2][22] = 1;
		grid[5][22] = 1;
		b.setMaxHeight(21);
		b.fixBoard(23);
		assertArrayEquals(grid, b.getEntireBoard());
	}

	/**
	 * Verifies that the board was properly cleared.
	 */
	@Test
	void testFixBoard1() {
		Board b = new Board(0,0);
		fillRow(b, 23);
		fillRow(b, 22);
		fillRow(b, 21);
		b.setGrid(0, 20, 1);
		b.setGrid(1, 19, 1);
		b.setGrid(2, 18, 1);
		b.setMaxHeight(18);
		b.fixBoard(22);
		int[][] grid = new int[10][24];
		fillRow(grid, 23);
		fillRow(grid, 22);
		grid[0][21] = 1;
		grid[1][20] = 1;
		grid[2][19] = 1;
		assertArrayEquals(grid, b.getEntireBoard());
		
		
	}
			
}
