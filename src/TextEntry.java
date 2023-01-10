import processing.core.PFont;

public class TextEntry implements Screen{

	private int x;
	private int y;
	private int length;
	private int height;
	private String text = "";
	private boolean isActive = false;
	
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
		this.text = this.text.substring(0, text.length() - 1);
	} 
	
	
	/**
	 * Handle mouse click
	 */
	public void onClick(int mouseX, int mouseY) {
		
		if (mouseY >= y && mouseY <= y + height
				&& mouseX >= x && mouseX <= x + length) {
			System.out.println("asd");
			this.isActive = true;
			return;
		} 
		else {
			this.isActive = false;
			System.out.println("dfg");
			return;
		}
	}
	
	/**
	 * Handles key press event
	 */
	public void onKeyPress(int keyCode) {
		if (isActive) {
			if (keyCode == 8) {
				if (this.text.length() > 0) {
					backSpace();
					return;
				}
			}
			if (text.length() >= 3) {
				return;
			}
			if (keyCode == 65) {
				this.addChar('A');
				return;
			}
			if (keyCode == 66) {
				this.addChar('B');
				return;
			}
			if (keyCode == 67) {
				this.addChar('C');
				return;
			}
			if (keyCode == 68) {
				this.addChar('D');
				return;
			}
			if (keyCode == 69) {
				this.addChar('E');
				return;
			}
			if (keyCode == 70) {
				this.addChar('F');
				return;
			}
			if (keyCode == 71) {
				this.addChar('G');
				return;
			}
			if (keyCode == 72) {
				this.addChar('H');
				return;
			}
			if (keyCode == 73) {
				this.addChar('I');
				return;
			}
			if (keyCode == 74) {
				this.addChar('J');
				return;
			}
			if (keyCode == 75) {
				this.addChar('K');
				return;
			}
			if (keyCode == 76) {
				this.addChar('L');
				return;
			}
			if (keyCode == 77) {
				this.addChar('M');
				return;
			}
			if (keyCode == 78) {
				this.addChar('N');
				return;
			}
			if (keyCode == 79) {
				this.addChar('O');
				return;
			}
			if (keyCode == 80) {
				this.addChar('P');
				return;
			}
			if (keyCode == 81) {
				this.addChar('Q');
				return;
			}
			if (keyCode == 82) {
				this.addChar('R');
				return;
			}
			if (keyCode == 83) {
				this.addChar('S');
				return;
			}
			if (keyCode == 84) {
				this.addChar('T');
				return;
			}
			if (keyCode == 85) {
				this.addChar('U');
				return;
			}
			if (keyCode == 86) {
				this.addChar('V');
				return;
			}
			if (keyCode == 87) {
				this.addChar('W');
				return;
			}
			if (keyCode == 88) {
				this.addChar('X');
				return;
			}
			if (keyCode == 89) {
				this.addChar('Y');
				return;
			}
			if (keyCode == 90) {
				this.addChar('Z');
				return;
			}
			
			
		}
	}
	
	@Override
	public void draw() {
		Main.processing.stroke(242,170,64);
		Main.processing.strokeWeight(10);
		Main.processing.fill(21,42,106);
		
		//handles isActive
		if (isActive) {
			Main.processing.stroke(302,228,124);
			Main.processing.rect(x, y, length, height);
		}
		else {
			Main.processing.stroke(242,170,64);
			Main.processing.rect(x, y, length, height);
		}
		
		Main.processing.textAlign(Main.processing.CENTER);
		PFont font = Main.processing.createFont("TETRIS.ttf", 50, true);
        Main.processing.textFont(font);
        Main.processing.fill(242,170,64);
        Main.processing.text(text, (length/2) + x, y + (height/2) + 15);
        Main.processing.textAlign(Main.processing.LEFT);
		
	}

}
