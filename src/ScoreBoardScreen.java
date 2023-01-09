import processing.core.PFont;

/**
 * The screen to display the scoreboard.
 * @author alext
 *
 */
public class ScoreBoardScreen implements Screen {

	Main m;
	
	public ScoreBoardScreen(Main m) {
		this.m = m;
		System.out.println(this.m);
	}
	
	/**
	 * Handles mouse movement event
	 * @param mouseX X position of mouse
	 * @param mouseY Y position of mouse
	 */
	public void onMouseMove(int mouseX, int mouseY){
		
	}
	
	/**
	 * Handles mouse click event
	 * 
	 * @param mouseX X position of mouse
	 * @param mouseY Y position of mouse
	 */
	public void onMouseClick(int mouseX, int mouseY) {
		
	}
	
	/**
	 * Draws the high scores
	 */
	private void drawHighScores() {
		int y = 250;
		PFont font = Main.processing.createFont("TETRIS.ttf", 70, true);
        Main.processing.textFont(font);
		for (int i = 0; i < 5; i++) {
			String number = String.valueOf(i + 1) + ": ";
			Main.processing.text(number + Main.s.get(i), 220, y + 70 * i);
		}
	}
	
	@Override
	public void draw() {
		Main.processing.background(21,42,106);
		Main.processing.stroke(242,168,64);
		Main.processing.strokeWeight(15);
		Main.processing.fill(21,42,106);
		Main.processing.rect(200,100,500,480,20);
		Main.processing.fill(242,168,64);
		PFont font = Main.processing.createFont("TETRIS.ttf", 70, true);
        Main.processing.textFont(font);
        Main.processing.text("HI-SCORES", 220, 160);
        drawHighScores();
	}

}
