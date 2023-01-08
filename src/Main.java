import processing.core.PApplet;
import java.util.Stack;

public class Main extends PApplet{
	
	public static enum gameMode {
		MAINMENU,
		GAME,
		ABOUT
	}
	
	gameMode gm = gameMode.MAINMENU;
	
	public void setModeGame() {
		gm = gameMode.GAME;
	}
	
	public void setModeAbout() {
		gm = gameMode.ABOUT;
	}
	
	public void setModeMenu() {
		gm = gameMode.MAINMENU;
	}
    
    //encapsulation?
    public static PApplet processing;
    public static ScoreBoard s;
    Game game = new Game(this);
    StartMenu sm = new StartMenu(this);
    AboutMenu am = new AboutMenu(this);
    
    public static void main(String[] args) {
    	PApplet.main("Main",args);

    }
    
    public void newGame() {
    	this.game = new Game(this);
    }
    
    public void mouseMoved() {
    	if (gm == gameMode.MAINMENU) {
    		sm.onMouseMove(mouseX, mouseY);
    	}
    	if (gm == gameMode.ABOUT) {
    		am.onHover(mouseX, mouseY);
    	}
    	if (gm == gameMode.GAME) {
    		game.onMouseMove(mouseX, mouseY);
    	}
    }
    
    public void mouseClicked() {
    	if (gm == gameMode.MAINMENU) {
    		sm.onMouseClick(mouseX, mouseY);
    	}
    	if (gm == gameMode.ABOUT) {
    		am.onClick(mouseX, mouseY);
    	}
    	if (gm == gameMode.GAME) {
    		game.onClick(mouseX, mouseY);
    	}
    }
    
    /**
     * This function is run once, when the program starts. It's used to 
     * define initial environment properties
     */
    public void setup() {
    	this.s = new ScoreBoard();
        processing = this;
        background(21,42,106);
    }
    
    /**
     * This function handles when a key is released
     */
    public void keyReleased() {
        if (gm == gameMode.GAME) {
        	game.getBoard().keyPressed(keyCode);
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
    		game.draw();
    	}
    	else if (gm == gameMode.MAINMENU) {
    		sm.draw();
    	}
    	else if (gm == gameMode.ABOUT) {
    		am.draw();
    	}
    	
    }
}
