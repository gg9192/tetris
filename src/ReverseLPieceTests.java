import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseLPieceTests {

	/**
	 * test to make sure that the piece is initialized 
	 * properly.
	 */
	void testInit() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-3);
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
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-3);
		expected[1] = new Tuple(5,-3);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(4,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 1
	 */
	@Test
	void testShadow1() {
		Board b = new Board(0,0);
		b.setGrid(5, 10, 1);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,9);
		expected[1] = new Tuple(5,9);
		expected[2] = new Tuple(4,10);
		expected[3] = new Tuple(4,11);
		assertArrayEquals(expected, p.getShadow());
		p.moveLeft();
		p.moveRight();
		b.setGrid(5, 10, 0);
		b.setGrid(4, 12, 1);
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test that the shadow does not go through the floor at
	 * orientation 1.
	 */
	@Test
	void test1Floor1() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,21);
		expected[1] = new Tuple(5,21);
		expected[2] = new Tuple(4,22);
		expected[3] = new Tuple(4,23);
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 1 to 2
	 */
	@Test
	void testRotate1to2() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-2);
		expected[1] = new Tuple(4,-2);
		expected[2] = new Tuple(5,-2);
		expected[3] = new Tuple(5,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	
	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 2
	 */
	@Test
	void testShadow2() {
		Board b = new Board(0,0);
		b.setGrid(5, 10, 1);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,8);
		expected[1] = new Tuple(4,8);
		expected[2] = new Tuple(5,8);
		expected[3] = new Tuple(5,9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(5, 10, 0);
		b.setGrid(4, 9, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 9, 0);
		b.setGrid(3, 9, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to make sure that the shadow does not go
	 * through the floor at orientation 2.
	 */
	@Test
	void testFloor2() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,22);
		expected[1] = new Tuple(4,22);
		expected[2] = new Tuple(5,22);
		expected[3] = new Tuple(5,23);
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 2 to 3
	 */
	@Test 
	void rotate2to3() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-3);
		expected[1] = new Tuple(4,-2);
		expected[2] = new Tuple(3,-1);
		expected[3] = new Tuple(4,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 3
	 */
	@Test
	void testShadow3() {
		Board b = new Board(0,0);
		b.setGrid(3, 10, 1);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,7);
		expected[1] = new Tuple(4,8);
		expected[2] = new Tuple(3,9);
		expected[3] = new Tuple(4,9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(3, 10, 0);
		b.setGrid(4, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to make sure that the shadow does not go
	 * through the floor at orientation 3.
	 */
	@Test
	void testFloor3() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,21);
		expected[1] = new Tuple(4,22);
		expected[2] = new Tuple(3,23);
		expected[3] = new Tuple(4,23);
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 3 to 0
	 */
	@Test 
	void rotate3to0() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-3);
		expected[1] = new Tuple(3,-2);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(5,-2);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 0
	 */
	@Test
	void testShadow0() {
		Board b = new Board(0,0);
		b.setGrid(3, 10, 1);
		Piece p = new ReverseLPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,8);
		expected[1] = new Tuple(3,9);
		expected[2] = new Tuple(4,9);
		expected[3] = new Tuple(5,9);
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
	 * Test to make sure that the shadow does not go
	 * through the floor at orientation 0.
	 */
	@Test
	void testFloor0() {
		Board b = new Board(0,0);
		Piece p = new ReverseLPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,22);
		expected[1] = new Tuple(3,23);
		expected[2] = new Tuple(4,23);
		expected[3] = new Tuple(5,23);
		assertArrayEquals(expected, p.getShadow());	
	}
	
}
