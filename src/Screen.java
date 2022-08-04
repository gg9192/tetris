import processing.core.PFont;
import processing.core.PImage;

public class Screen {
    public Board b = new Board(350,150);
    public void draw() {
        Main.processing.background(21,42,106);
        b.draw();
        PImage logo = Main.processing.loadImage("Logo.png");
        PFont font = Main.processing.createFont("TETRIS.ttf", 20);
        Main.processing.image(logo, 30, 400);
        Main.processing.strokeWeight(5);
        Main.processing.stroke(242,168,64);
        Main.processing.fill(61, 101, 201);
        Main.processing.rect(70,60,200,300);
        Main.processing.rect(650,60,200,180);
        Main.processing.textFont(font);
        Main.processing.fill(0,0,0);
        Main.processing.text("HELD PIECE", 90, 95);
        Main.processing.text("NEXT PIECE", 675, 95);
        Main.processing.fill(242,168,64);
        Main.processing.textSize(30);
        Main.processing.text("Score: " + b.score, 315, 90);
        b.drawDemoPiece(740,110,5);
    }

}
