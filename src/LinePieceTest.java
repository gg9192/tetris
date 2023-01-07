import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinePieceTest {

	/**
	 * test to make sure that the piece is initialized 
	 * properly.
	 */
	@Test
	void testInit() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new LinePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(2,-3);
		expected[1] = new Tuple(3,-3);
		expected[2] = new Tuple(4,-3);
		expected[3] = new Tuple(5,-3);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 2 to 3
	 */
	@Test
	void rotate2to3() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new LinePiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-4);
		expected[1] = new Tuple(3,-3);
		expected[2] = new Tuple(3,-2);
		expected[3] = new Tuple(3,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 1 to 2
	 */
	@Test
	void rotate1to2() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new LinePiece(b);
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(2,-2);
		expected[1] = new Tuple(3,-2);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(5,-2);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 0 to 1
	 */
	@Test
	void rotate0to1() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new LinePiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-4);
		expected[1] = new Tuple(4,-3);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(4,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 3 to 0
	 */
	@Test
	void rotate3to0() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new LinePiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		p.rotate(); 
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(2,-3);
		expected[1] = new Tuple(3,-3);
		expected[2] = new Tuple(4,-3);
		expected[3] = new Tuple(5,-3);
		assertArrayEquals(expected, p.getPiece());
	}

	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 0 and 2, these rely 
	 * on the same logic.
	 */
	@Test
	void testShadow0And2() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		b.setGrid(2, 10, 1);
		Piece p = new LinePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(2,9);
		expected[1] = new Tuple(3,9);
		expected[2] = new Tuple(4,9);
		expected[3] = new Tuple(5,9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(2, 10, 0);
		b.setGrid(3, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(3, 10, 0);
		b.setGrid(4, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 10, 0);
		b.setGrid(5, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 1 and 3, these rely 
	 * on the same logic.
	 */
	@Test
	void testShadow1And3() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		b.setGrid(4, 10, 1);
		Piece p = new LinePiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,6);
		expected[1] = new Tuple(4,7);
		expected[2] = new Tuple(4,8);
		expected[3] = new Tuple(4,9);
		assertArrayEquals(expected, p.getShadow());
	}
	
}
