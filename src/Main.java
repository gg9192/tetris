import processing.core.PApplet;
import java.util.Stack;

public class Main extends PApplet{
	
	public static enum gameMode {
		MAINMENU,
		GAME
	}
	
	gameMode gm = gameMode.MAINMENU;
			
	public void setModeGame() {
		gm = gameMode.GAME;
	}
	
    
    //encapsulation?
    public static PApplet processing;
    Game screen = new Game();
    StartMenu sm = new StartMenu(this);
    
    public static void main(String[] args) {
        PApplet.main("Main",args);

    }
    
    public void mouseMoved() {
    	if (gm == gameMode.MAINMENU) {
    		sm.onMouseMove(mouseX, mouseY);
    	}
    }
    
    public void mouseClicked() {
    	sm.onMouseClick(mouseX, mouseY);
    }
    
    /**
     * This function is run once, when the program starts. It's used to 
     * define initial environment properties
     */
    public void setup() {
        processing = this;
        background(21,42,106);
    }
    
    /**
     * This function handles when a key is released
     */
    public void keyReleased() {
        if (gm == gameMode.GAME) {
        	screen.b.keyPressed(keyCode);
        }
        

    }
    /**
     * The settings() method runs before the sketch has been set up.
     * In this case, this is used to specify the window size
     */
    public void settings() {
        size(885,800);
    }
    
    /**
     * This is a processing function that draws to the screen.
     */
    public void draw() {
    	if (gm == gameMode.GAME) {
    		screen.draw();
    	}
    	else {
    		sm.draw();
    	}
    }
}
