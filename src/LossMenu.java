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
	
	public LossMenu(Main me, Game g) {
		this.m = me;
		this.g = g;
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
		}
		else if (mouseX >= 320 && mouseX <= 562 &&
				mouseY >= 633 && mouseY <= 725) {
			Main.processing.exit();
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
			backHover = true;
		}
		else if (mouseX >= 320 && mouseX <= 562 &&
				mouseY >= 633 && mouseY <= 725) {
			quitHover = true;
		}
		else {
			backHover = false;
			quitHover = false;
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
        Main.processing.text("GAME", x, y);
        Main.processing.text("OVER", x + 17, y + 90);
        y = y + 420;
        
        /*Hitboxes
        Main.processing.fill(0,0,0);
        Main.processing.rect(260, 525, 360, 81);
        Main.processing.rect(320, 633, 242, 92);
        */
        
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
