import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseZPieceTests {

	/**
	 * Test to ensure that the piece rotates correctly
	 * from 0 to 0
	 */
	@Test
	void rotate3to0() {
		Board b = new Board(0,0);
		Piece p = new ReverseZPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-3);
		expected[1] = new Tuple(5,-3);
		expected[2] = new Tuple(3,-2);
		expected[3] = new Tuple(4,-2);
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
		Piece p = new ReverseZPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,8);
		expected[1] = new Tuple(5,8);
		expected[2] = new Tuple(3,9);
		expected[3] = new Tuple(4,9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(3, 10, 0);
		b.setGrid(4, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 10, 0);
		b.setGrid(5, 9, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test that the shadow does not go through the floor at
	 * orientation 1.
	 */
	@Test
	void test1Floor1() {}
	
}
