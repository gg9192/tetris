import processing.core.PApplet;
import java.util.Stack;

public class Main extends PApplet{
    int tick = 0;
    public static PApplet processing;
    Game screen = new Game();
    public static void main(String[] args) {
        PApplet.main("Main",args);

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
        //a = 65
        //d = 68
        //s = 83
        //r = 82
        //e = 69
        if (keyCode == 65) {
            screen.b.cp.moveLeft();
        }
        else if (keyCode == 68) {
            screen.b.cp.moveRight();
        }
        else if (keyCode == 82) {
            screen.b.cp.rotate();
        }
        else if (keyCode == 83) {
            if(screen.b.isLoss == false) {
                if (screen.b.cp != null) {
                    screen.b.cp.down();
                }

            }

        }
        else if (keyCode == 69) {
            screen.b.hold();
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
        screen.draw();
    }
}
