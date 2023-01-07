import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SquarePieceTest {

	/**
	 * Test to make sure that the piece was initialized properly
	 */
	@Test
	void init() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new SquarePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-2);
		expected[1] = new Tuple(5,-2);
		expected[2] = new Tuple(4,-1);
		expected[3] = new Tuple(5,-1);
		assertArrayEquals(expected, p.getPiece());
	}
	

	/**
	 * Test that the shadow is calculated correctly for orientation 0
	 */
	@Test
	void testShadow0() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		b.setGrid(4, 10, 1);
		Piece p = new SquarePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4, 8);
		expected[1] = new Tuple(5, 8);
		expected[2] = new Tuple(4, 9);
		expected[3] = new Tuple(5, 9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 10, 0);
		b.setGrid(5, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}	
	
	/**
	 * Test that the shadow does not go through the floor. 
	 */
	@Test 
	void testFloor() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new SquarePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4, 22);
		expected[1] = new Tuple(5, 22);
		expected[2] = new Tuple(4, 23);
		expected[3] = new Tuple(5, 23);
		assertArrayEquals(expected, p.getShadow());
	}
	
	
	

}
