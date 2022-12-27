import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseZPieceTests {

	/**
	 * Test to ensure that the piece rotates correctly
	 * from 0 to 1
	 */
	@Test
	void rotate0to1() {
		Board b = new Board(0,0);
		Piece p = new ReverseZPiece(b);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-3);
		expected[1] = new Tuple(5,-3);
		expected[2] = new Tuple(3,-2);
		expected[3] = new Tuple(4,-2);
		assertArrayEquals(expected, p.getPiece());
		
	}

}
