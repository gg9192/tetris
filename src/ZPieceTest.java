import static org.junit.jupiter.api.Assertions.*;import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ZPieceTest {

	/**
	 * Test to ensure that the piece rotates correctly
	 * from 0 to 1
	 */
	@Test
	void rotate0to1() {
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

}
