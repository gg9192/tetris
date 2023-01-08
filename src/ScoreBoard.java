import java.util.ArrayList;
import java.util.Collections;


/**
 * Data structure that handles the scoreboard.
 * Note that duplicate names in the scoreboard 
 * is allowed for player skill expression. 
 * @author alext
 *
 */
public class ScoreBoard {

	ArrayList<ScorePair> scores = new ArrayList<ScorePair>();
	
	/**
	 * adds a score to the score board, then sorts. If adding 
	 * the score makes the score board have more than 5 entries,
	 * remove the last entry
	 * @param name name of the player
	 * @param score score achieved
	 */
	public void addScore(String name, int score) {
		ScorePair s = new ScorePair(name, score);
		scores.add(s);
		Collections.sort(scores);
		if (scores.size() > 5) {
			scores.remove(5);
		}
	}
	
	/**
	 * Gets the list of scores.
	 * **FOR TESTING ONLY**
	 * @return list of scores
	 */
	public ArrayList<ScorePair> getScoreboard() {
		return scores;
	}
	
	/**
	 * Get the ith entry in the score board as a string. If no such 
	 * entry exists, return dashes. 
	 * @param i
	 */
	public String get(int i) {
		if (i >= scores.size()) {
			return "---------";
		}
		else {
			return scores.get(i).toString();
		}
	} 
	
	
	
}
