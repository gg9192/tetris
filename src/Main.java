import processing.core.PApplet;

import java.util.Stack;

public class Main extends PApplet{
    int tick = 0;
    public static PApplet processing;
    public static void main(String[] args) {
        PApplet.main("Main",args);

    }
    Stack<Character> input = new Stack<>();

    public void setup() {
        processing = this;
        background(21,42,106);
    }
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
            screen.b.cp.down();
        }
        else if (keyCode == 69) {
            screen.b.hold();
        }

    }

    public void settings() {
        size(885,800 );
    }
    static Screen screen = new Screen();
    public void draw() {
        screen.draw();
    }
}
