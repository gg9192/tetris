import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ScoreboardTests {
	
	/**
	 * Test that the scores are sorted. 
	 */
	@Test
	void testSort() {
		ScoreBoard s = new ScoreBoard();
		s.addScore("kate", 170);
		s.addScore("mary", 300);
		s.addScore("bob", 100);
		ArrayList<ScorePair> expected = new ArrayList<ScorePair>();
		expected.add(new ScorePair("mary", 300));
		expected.add(new ScorePair("kate", 170));
		expected.add(new ScorePair("bob", 100));
		assertEquals(expected, s.getScoreboard());
	}
	
	/**
	 * Test that the scores are sorted. 
	 */
	@Test
	void testSort1() {
		ScoreBoard s = new ScoreBoard();
		s.addScore("bob", 100);
		s.addScore("mary", 300);
		s.addScore("larry", 70);
		s.addScore("kate", 170);
		ArrayList<ScorePair> expected = new ArrayList<ScorePair>();
		expected.add(new ScorePair("mary", 300));
		expected.add(new ScorePair("kate", 170));
		expected.add(new ScorePair("bob", 100));
		expected.add(new ScorePair("larry", 70));
		assertEquals(expected, s.getScoreboard());
	}
	
	/**
	 * Test to make sure that only 5 of the top are kept
	 * when more than 5 elements are added.
	 */
	@Test
	void testMorethan5() {
		ScoreBoard s = new ScoreBoard();
		s.addScore("bob", 100);
		s.addScore("mary", 300);
		s.addScore("larry", 70);
		s.addScore("kate", 170);
		s.addScore("mike", 200);
		s.addScore("jackson", 250);
		ArrayList<ScorePair> expected = new ArrayList<ScorePair>();
		expected.add(new ScorePair("mary", 300));
		expected.add(new ScorePair("jackson", 250));
		expected.add(new ScorePair("mike", 200));
		expected.add(new ScorePair("kate", 170));
		expected.add(new ScorePair("bob", 100));
	}

}
