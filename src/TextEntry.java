import processing.core.PFont;

public class TextEntry implements Screen{

	private int x;
	private int y;
	private int length;
	private int height;
	private String text = "";
	private boolean isActive;
	
	public TextEntry(int x, int y, int len, int height) {
		this.x = x;
		this.y = y;
		this.length = len;
		this.height = height;
	}
	
	/**
	 * Adds the character C to the text
	 * @param c
	 */
	private void addChar(char c) {
		String s = Character.toString(c);
		this.text = this.text + s;
	}
	
	/**
	 * Removes the last character
	 */
	private void backSpace() {
		this.text = this.text.substring(0, text.length() - 2);
	} 
	
	/**
	 * Handles key press event
	 */
	public void onKeyPress(int keyCode) {
		
	}
	
	@Override
	public void draw() {
		Main.processing.stroke(242,170,64);
		Main.processing.strokeWeight(10);
		Main.processing.fill(21,42,106);
		Main.processing.rect(x, y, length, height);
		Main.processing.textAlign(Main.processing.CENTER);
		PFont font = Main.processing.createFont("TETRIS.ttf", 50, true);
        Main.processing.textFont(font);
        Main.processing.fill(242,170,64);
        Main.processing.text("che", (length/2) + x, y + (height/2) + 15);
        Main.processing.textAlign(Main.processing.LEFT);
		
	}

}
