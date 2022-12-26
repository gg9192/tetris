import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinePieceTests {

	/**
	 * Makes sure that the piece rotates properly
	 * from orientation 0 to 1
	 */
	@Test
	void rotate0to1() {
		Board b = new Board(0,0);
		Piece p = new LinePiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3, -3);
		expected[1] = new Tuple(4, -3);
		expected[2] = new Tuple(5, -3);
		expected[3] = new Tuple(6, -3);
		assertArrayEquals(expected, p.getPiece());
	}
	

	/**
	 * Makes sure that the piece rotates properly
	 * from orientation 1 to 0
	 */
	@Test
	void rotate1to0() {
		Board b = new Board(0,0);
		Piece p = new LinePiece(b);
		p.rotate();
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4, -4);
		expected[1] = new Tuple(4, -3);
		expected[2] = new Tuple(4, -2);
		expected[3] = new Tuple(4, -1);
		assertArrayEquals(expected, p.getPiece());
	}
	
	/**
	 * Verify that the shadow is computed correctly at orientation 0
	 */
	@Test
	void shadowAt0() {
		Board b = new Board(0,0);
		b.setGrid(4, 10, 1);
		Piece p = new LinePiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4, 6);
		expected[1] = new Tuple(4, 7);
		expected[2] = new Tuple(4, 8);
		expected[3] = new Tuple(4, 9);
		assertArrayEquals(expected, p.getShadow());
		//make sure that it dosen't go through the board.
		p.moveRight();
		expected[0] = new Tuple(5, 20);
		expected[1] = new Tuple(5, 21);
		expected[2] = new Tuple(5, 22);
		expected[3] = new Tuple(5, 23);
		assertArrayEquals(expected, p.getShadow());
	}

	/**
	 * Verify that the shadow is computed correctly at orientation 0
	 */
	@Test
	void shadowAt1() {
		Board b = new Board(0,0);
		b.setGrid(3, 10, 1);
		Piece p = new LinePiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3, 9);
		expected[1] = new Tuple(4, 9);
		expected[2] = new Tuple(5, 9);
		expected[3] = new Tuple(6, 9);
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(3, 10, 0);
		b.setGrid(4, 10, 1);
		//shadow is only calculated on movement and rotation
		//to be not computationally intensive, we are recomputing
		//the shadow
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(4, 10, 0);
		b.setGrid(5, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
		b.setGrid(5, 10, 0);
		b.setGrid(6, 10, 1);
		p.moveLeft();
		p.moveRight();
		assertArrayEquals(expected, p.getShadow());
	}
	
	/**
	 * Verify that the shadow does not go through the 
	 * floor at orientation 0.
	 */
	@Test
	void o1TestFloor() {
		Board b = new Board(0,0);
		Piece p = new LinePiece(b);
		p.rotate();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3, 23);
		expected[1] = new Tuple(4, 23);
		expected[2] = new Tuple(5, 23);
		expected[3] = new Tuple(6, 23);
		assertArrayEquals(expected, p.getShadow());
	}
}
