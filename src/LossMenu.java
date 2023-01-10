import processing.core.PFont;

/*
 * Menu that handles when the game is lost.
 * 
 */
public class LossMenu implements Screen {
	
	Main m;
	Game g;
	private boolean backHover = false;
	private boolean quitHover = false;
	private boolean isHighScore = false;
	private boolean saveHover = false;
	private TextEntry textbox;
	private boolean isSaved = false;
	
	
	public LossMenu(Main me, Game g) {
		this.m = me;
		this.g = g;
		if (Main.s.getSize() < 4 || g.getScore() > Main.s.getScorePair(Main.s.getSize() - 1).getScore()) {
			this.isHighScore = true;
			textbox = new TextEntry(150, 430, 200, 60);
		}
	}
	
	/**
	 * Handles mouse click.
	 * @param mouseX X position of Mouse
	 * @param mouseY Y position of Mouse
	 */
	public void onClick(int mouseX, int mouseY) {
		if (mouseX >= 260 && mouseX <= 620 
				&& mouseY >= 525 && mouseY <= 606) {
			m.setModeMenu();
			return;
		}
		else if (mouseX >= 320 && mouseX <= 562 &&
				mouseY >= 633 && mouseY <= 725) {
			Main.processing.exit();
			return;
		}
		if (isHighScore) {
			if (!isSaved) {
				textbox.onClick(mouseX, mouseY);
			}
			return;
		}
	}
	
	/**
	 * Handles mouse move.
	 * @param mouseX X position of Mouse
	 * @param mouseY Y position of Mouse
	 */
	public void onMouseMove(int mouseX, int mouseY) {
		if (mouseX >= 260 && mouseX <= 620 
				&& mouseY >= 525 && mouseY <= 606) {
			Main.processing.cursor(12);
			backHover = true;
			return;
		}
		else if (mouseX >= 320 && mouseX <= 562 &&
				mouseY >= 633 && mouseY <= 725) {
			Main.processing.cursor(12);
			quitHover = true;
			return;
		}
		else if (!isSaved) {
			if (mouseX >= 150 && mouseX <= 350 &&
					mouseY >= 430 && mouseY <= 490) {
				Main.processing.cursor(2);
				return;
			}
			else if (mouseX >= 448 && mouseX <= 688 &&
					mouseY >= 426 && mouseY <= 486) {
				Main.processing.cursor(12);
				saveHover = true;
				return;
			}
			else {
				Main.processing.cursor(0);
				backHover = false;
				quitHover = false;
				saveHover = false;
				return;
				}
		}
		else {
			Main.processing.cursor(0);
			backHover = false;
			quitHover = false;
			return;
		}
	}
	
	/**
	 * Handles key press event
	 */
	public void onKeyPress(int keyCode) {
		if (isHighScore) {
			textbox.onKeyPress(keyCode);
		}
	}
	
	
	
	/**
	 * Draws the screen elements that allows a user to 
	 * save their High Score
	 */
	private void drawHS() {
		PFont font = Main.processing.createFont("TETRIS.ttf", 40, true);
        Main.processing.textFont(font);
        Main.processing.fill(242,168,64);
        Main.processing.text("Hi-Score! Click the textbox", 120, 270);
        Main.processing.text("and input your initials. ", 160, 310);
        Main.processing.text("(No non-alpha characters ", 130, 350);
        Main.processing.text("and max length of 3)", 170, 390);
        textbox.draw();
        font = Main.processing.createFont("TETRIS.ttf", 70, true);
        Main.processing.textFont(font);
        
        /*hitbox of save button
        Main.processing.fill(0,0,0);
        Main.processing.strokeWeight(0);
        Main.processing.rect(448, 426, 240, 60);
        */
        
        if (!isSaved) {
        	if (saveHover) {
        		Main.processing.fill(302,228,124);
        		Main.processing.text("Save", 450, 480);
        	}
        	else {
        		Main.processing.fill(242,168,64);
                Main.processing.text("Save", 450, 480);
        	}
        	
        }
        else {
        	Main.processing.fill(242,168,64);
            Main.processing.text("Saved", 430, 480);
        }
        
        
	}
	
	
	
	/**
	 * Draws the loss menu
	 */
	@Override
	public void draw() {
		int x = 250;
		int y = 180;
		Main.processing.background(21,42,106);
		PFont font = Main.processing.createFont("TETRIS.ttf", 100, true);
        Main.processing.textFont(font);
        Main.processing.fill(242,168,64);
        Main.processing.text("GAME", x, y - 50);
        Main.processing.text("OVER", x + 17, y + 40);
        y = y + 420;
        
        /*Hitboxes
        Main.processing.fill(0,0,0);
        Main.processing.rect(260, 525, 360, 81);
        Main.processing.rect(320, 633, 242, 92);
        */
        
        if (isHighScore) {
        	drawHS();
        }
        
        font = Main.processing.createFont("TETRIS.ttf", 100, true);
        Main.processing.textFont(font);

        Main.processing.fill(242,168,64);
        
        if (backHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("Menu", x + 10, y);
        }
        else {
        	Main.processing.fill(242,168,64);
        	Main.processing.text("Menu", x + 10, y);
        }
        if (quitHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("Quit", x + 70, y + 110);
        }
        else {
        	Main.processing.fill(242,168,64);
        	Main.processing.text("Quit", x + 70, y + 110);
        }
        
        
		
	}

}
