import static org.junit.jupiter.api.Assertions.*;import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ZPieceTest {

	/**
	 * Test to ensure that the piece rotates correctly
	 * from 3 to 0
	 */
	@Test
	void rotate3to0() {
		Board b = new Board(0,0);
		Piece p = new ZPiece(b);
		p.rotate();
		p.rotate();
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-3);
		expected[1] = new Tuple(4,-3);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(5,-2);
		assertArrayEquals(expected, p.getPiece());
	}
	

	/**
	 * Test to ensure that the shadow is calculated
	 * correctly at orientation 1
	 */
	@Test
	void testShadow0() {
		Board b = new Board(0,0);
		b.setGrid(3, 10, 1);
		Piece p = new ZPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,9);
		expected[1] = new Tuple(4,9);
		expected[2] = new Tuple(4,10);
		expected[3] = new Tuple(5,10);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(3, 10, 0);
		b.setGrid(4, 11, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 11, 0);
		b.setGrid(5, 11, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test that the shadow does not go through the floor at
	 * orientation 0.
	 */
	@Test
	void test1Floor0() {
		Board b = new Board(0,0);
		Piece p = new ZPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,22);
		expected[1] = new Tuple(4,22);
		expected[2] = new Tuple(4,23);
		expected[3] = new Tuple(5,23);
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Test to ensure that the piece rotates correctly
	 * from 0 to 1
	 */
	@Test
	void rotate0to1() {
		Board b = new Board(0,0);
		Piece p = new ZPiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(5,-3);
		expected[1] = new Tuple(5,-2);
		expected[2] = new Tuple(4,-2);
		expected[3] = new Tuple(3,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	

}
