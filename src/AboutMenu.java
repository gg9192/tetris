import processing.core.PFont;

public class AboutMenu implements Screen {
	
	private Main m;
	private boolean backHover = false;
	
	public AboutMenu(Main m ) {
		this.m = m;
	}
	
	//draws the back button
	private void drawButtons () {
		/*
		button hitbox
		Main.processing.fill(0,0,0);
		Main.processing.rect(250, 594, 323, 80);
		*/
		
		Main.processing.fill(242,168,64);
		PFont font = Main.processing.createFont("TETRIS.ttf", 100, true);
		Main.processing.textFont(font);
		if (backHover) {
			Main.processing.fill(302,228,124);
			Main.processing.text("Back", 250,670);
		}
		else {
			Main.processing.fill(242,168,64);
			Main.processing.text("Back", 250,670);
			
		}
	}
	
	/**
	 * Handles mouseMovement event
	 * @param mouseX X coordinate of mouse
	 * @param mouseY Y coordinate of mouse
	 */
	public void onHover(int mouseX, int mouseY) {
		if (mouseX >= 250 & mouseX <= 572 
				&& mouseY >= 594 && mouseY <= 674) {
			backHover = true;
		}
		else {
			backHover = false;
		}
	}
	
	/**
	 * Handles mouseClick event
	 * @param mouseX X coordinate of mouse
	 * @param mouseY Y coordinate of mouse
	 */
	public void onClick(int mouseX, int mouseY) {
		if (mouseX >= 250 & mouseX <= 572 
				&& mouseY >= 594 && mouseY <= 674) {
				m.setModeMenu();
		}
	}
	
	
	/**
	 * Draws the about menu
	 */
	@Override
	public void draw() {
		//everything is based off this, makes centering
		//it later easier!
		int x = 70;
		int y = 80;
		
		Main.processing.fill(242,168,64);
		Main.processing.background(21,42,106);
		PFont font = Main.processing.createFont("TETRIS.ttf", 30, true);
		Main.processing.textFont(font);
        Main.processing.text("Hello everyone, thank you for visiting", x, y);
        Main.processing.text("my project. My name is Alex Guo and I", x, y + 30);
        Main.processing.text("am currently a student majoring in ", x, y + 60);
        Main.processing.text("Computer Science at the University ", x, y + 90);
        Main.processing.text("of Iowa. Aside from school, I enjoy ", x, y + 120);
        Main.processing.text("coding projects like this and playing ", x, y + 150);
        Main.processing.text("videogames. Thanks for checking out my ", x, y + 180);
        //https://www.op.gg/summoners/na/gg9192
      	//#EasterEGG!
        Main.processing.text("project! This is coded entirly from ", x, y + 210);
        Main.processing.text("scrach using the processing.js. ", x, y + 240);
        Main.processing.text("No copyright infringement is intended. ", x, y + 270);
        
        //how to play
        int playX = 250;
        Main.processing.text("How to play: ", playX, y + 320);
        Main.processing.text("A: move piece Left ", playX, y + 350);
        Main.processing.text("D: move piece Right", playX, y + 380);
        Main.processing.text("E: hold Piece", playX, y + 410);
        Main.processing.text("R: rotate  Piece", playX, y + 440);
		
        drawButtons();
        
	}

}
