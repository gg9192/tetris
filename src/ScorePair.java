
/**
 * This is how the score entries will be held.
 * Implements comparable so we can just add and 
 * use collections.sort!
 * @author alext
 *
 */
public class ScorePair implements Comparable {

	private String name;
	private int score;
	
	public ScorePair(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	@Override
	public boolean equals(Object o) {
		ScorePair sp = (ScorePair) o;
		return this.name == sp.getName() &&
				this.score == sp.getScore();
	}
	
	@Override
	public String toString() {
		return name + ": " + score;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public int compareTo(Object o) {
		ScorePair s = (ScorePair) o;
		if (this.score == s.getScore()) {
			return 0;
		}
		else if (this.score < s.getScore()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
