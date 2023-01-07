import processing.core.PFont;

public class StartMenu implements Screen{
	Main m;
	
	boolean playHover = false;
	boolean hsHover = false;
	boolean aboutHover = false;
	boolean quitHover = false;
	
	
	public StartMenu(Main m) {
		this.m = m;
	}

	/**
	 * Handles mouse movement event
	 * @param mouseX X position of mouse
	 * @param mouseY Y position of mouse
	 */
	public void onMouseMove(int mouseX, int mouseY){
		if (mouseX >= 220 && mouseX <= 528 && 
				mouseY >= 245 && mouseY <= 340) {
			this.playHover = true;
		}
		else if (mouseX >= 220 && mouseX <= 740 &&
				mouseY >= 360 && mouseY <= 440) {
			this.hsHover = true;
		}
		else if (mouseX >= 220 && mouseX <= 617 &&
				 mouseY >= 460 && mouseY <= 541) {
			this.aboutHover = true;
		}
		else if (mouseX >= 220 && mouseX <= 470 && 
				mouseY >= 562 && mouseY <= 652) {
			this.quitHover = true;
		}
		else {
			this.playHover = false;
			this.hsHover = false;
			this.aboutHover = false;
			this.quitHover = false;
			
		}
		
	}
	
	/**
	 * Handles mouse click event
	 * 
	 * @param mouseX X position of mouse
	 * @param mouseY Y position of mouse
	 */
	public void onMouseClick(int mouseX, int mouseY) {
		if (mouseX >= 220 && mouseX <= 528 && 
				mouseY >= 245 && mouseY <= 340) {
			m.setModeGame();
		}
		else if (mouseX >= 220 && mouseX <= 470 && 
				mouseY >= 562 && mouseY <= 652) {
			Main.processing.exit();
		}
		else if (mouseX >= 220 && mouseX <= 617 &&
				 mouseY >= 460 && mouseY <= 541) {
			m.setModeAbout();
		}
	}
	
	/**
	 * Draws the menu
	 */
	@Override
	public void draw() {
		Main.processing.background(21,42,106);
		Main.processing.strokeWeight(5);
        Main.processing.stroke(242,168,64);
        Main.processing.stroke(242,168,64);
        Main.processing.fill(242,168,64);
        PFont font = Main.processing.createFont("TETRIS.ttf", 100, true);
        Main.processing.textFont(font);
        Main.processing.text("TETRIS", 220, 140);
        font = Main.processing.createFont("TETRIS.ttf", 35, true);
        Main.processing.textFont(font);
        Main.processing.text("A game re-coded by ", 220, 180);
        Main.processing.text("Alex Guo",220,210);  
        Main.processing.fill(0,0,0);
        Main.processing.stroke(0,0,0);
        
        //buttons and their positions
        /*
        Main.processing.rect(220, 245, 308, 95);
        Main.processing.rect(220, 360, 520, 80);
        Main.processing.rect(220, 460, 397, 81);
        Main.processing.rect(220, 562, 250, 90);
        */
        drawButtons();        
	}
	
	/**
	 * draws the buttons on the screen
	 */
	private void drawButtons() {
		Main.processing.fill(242,170,64);
		PFont font = Main.processing.createFont("TETRIS.ttf", 100, true);
        Main.processing.textFont(font);
        
        Main.processing.stroke(242,168,64);
        if (playHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("Play!",220,320);
        }
        else {
        	Main.processing.fill(242,170,64);
        	Main.processing.text("Play!",220,320);
        }
        if (hsHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("Hi-Score",220,435);
        }
        else {
        	Main.processing.fill(242,170,64);
        	Main.processing.text("Hi-Score",220,435);
        }
        if (aboutHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("About",225,536);
        }
        else {
        	Main.processing.fill(242,170,64);
        	Main.processing.text("About",225,536);
        }
        if (quitHover) {
        	Main.processing.fill(302,228,124);
        	Main.processing.text("Quit",225,638);
        }
        else {
        	Main.processing.fill(242,170,64);
        	Main.processing.text("Quit",225,638);
        }        
	}
	

}
