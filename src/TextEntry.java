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
	 * get the string stored at the textbox
	 * @return
	 */
	public String getString() {
		return this.text;
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
			
			switch (keyCode) {
			case 65:
				this.addChar('A');
				break;
			case 66:
				this.addChar('B');
				break;
			case 67:
				this.addChar('C');
				break;
			case 68:
				this.addChar('D');
				break;
			case 69:
				this.addChar('E');
				break;
			case 70:
				this.addChar('F');
				break;
			case 71:
				this.addChar('G');
				break;
			case 72:
				this.addChar('H');
				break;
			case 73:
				this.addChar('I');
				break;
			case 74:
				this.addChar('J');
				break;
			case 75:
				this.addChar('K');
				break;
			case 76:
				this.addChar('L');
				break;
			case 77:
				this.addChar('M');
				break;
			case 78:
				this.addChar('N');
				break;
			case 79: 
				this.addChar('O');
				break;
			case 80:
				this.addChar('P');
				break;
			case 81:
				this.addChar('Q');
				break;
			case 82:
				this.addChar('R');
				break;
			case 83:
				this.addChar('S');
				break;
			case 84: 
				this.addChar('T');
				break;
			case 85:
				this.addChar('U');
				break;
			case 86:
				this.addChar('V');
				break;
			case 87:
				this.addChar('W');
				break;
			case 88:
				this.addChar('X');
				break;
			case 89:
				this.addChar('Y');
				break;
			case 90:
				this.addChar('Z');
				break;
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
