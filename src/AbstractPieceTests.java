

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/*
 * Note that we can test this with an arbitrary piece
 * because the logic is inherited from the super class. 
 */
class AbstractPieceTests {
	
	/**
	 * Test that the piece correctly moves down one unit. 
	 */
	@Test
	void testTick() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.tick();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,-2);
		expected[1] = new Tuple(3,-1);
		expected[2] = new Tuple(4,-1);
		expected[3] = new Tuple(5,-1);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(-1, p.getCenterY());
	}

	/**
	 * Test that moveLeft correctly moves the piece
	 * one unit to the left. 
	 */
	@Test
	void testMoveLeft() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.moveLeft();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(3,-3);
		expected[1] = new Tuple(2,-2);
		expected[2] = new Tuple(3,-2);
		expected[3] = new Tuple(4,-2);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(3, p.getCenterX());
	}
	
	/**
	 * Test that moveLeft correctly moves the piece
	 * one unit to the right. 
	 */
	@Test
	void testMoveRight() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.moveRight();
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(5,-3);
		expected[1] = new Tuple(4,-2);
		expected[2] = new Tuple(5,-2);
		expected[3] = new Tuple(6,-2);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(5, p.getCenterX());
	}
	
	/**
	 * Makes sure that the piece doesn't go through
	 * the left boarder
	 */
	@Test
	void testLeftBoarder() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.moveLeft();
		p.moveLeft();
		p.moveLeft();
		//at this point, we are at the left edge of the board
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(1,-3);
		expected[1] = new Tuple(0,-2);
		expected[2] = new Tuple(1,-2);
		expected[3] = new Tuple(2,-2);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(1, p.getCenterX());
		p.moveLeft(); //should stay the same
		assertArrayEquals(expected, p.getPiece());
		assertEquals(1, p.getCenterX());
		
	}
	
	/**
	 * Makes sure that the piece doesn't go through
	 * the right boarder
	 */
	@Test
	void testRightBoarder() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.moveRight();
		p.moveRight();
		p.moveRight();
		p.moveRight();
		//at this point, we are at the right edge of the board
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(8,-3);
		expected[1] = new Tuple(7,-2);
		expected[2] = new Tuple(8,-2);
		expected[3] = new Tuple(9,-2);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(8, p.getCenterX());
		p.moveRight();
		assertArrayEquals(expected, p.getPiece());
		assertEquals(8, p.getCenterX());
	}
	
	/**
	 * Makes sure that the piece can't ghost through 
	 * other pieces when moving left. 
	 */
	@Test
	void testGhostLeft() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.tick();
		p.tick();
		p.tick();
		
		//Piece is on the board
		b.setGrid(2, 1, 3);
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,0);
		expected[1] = new Tuple(3,1);
		expected[2] = new Tuple(4,1);
		expected[3] = new Tuple(5,1);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(4, p.getCenterX());
		p.moveLeft();
		//shouldn't have moved
		assertArrayEquals(expected, p.getPiece());
	}

	/**
	 * Makes sure that the piece can't ghost through 
	 * other pieces when moving right. 
	 */
	@Test
	void testGhostRight() {
		Game g = new Game(null);
		Board b = new Board(0, 0, g);
		Piece p = new TPiece(b);
		p.tick();
		p.tick();
		p.tick();
		//Piece is on the board
		Tuple[] expected = new Tuple[4];
		expected[0] = new Tuple(4,0);
		expected[1] = new Tuple(3,1);
		expected[2] = new Tuple(4,1);
		expected[3] = new Tuple(5,1);
		b.setGrid(5, 0, 1);
		assertArrayEquals(expected, p.getPiece());
		assertEquals(4, p.getCenterX());
		p.moveRight();
		//shouldn't have moved
		assertArrayEquals(expected, p.getPiece());
		assertEquals(4, p.getCenterX());
	}
	
	
	

}
