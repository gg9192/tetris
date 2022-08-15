import processing.core.PFont;
import processing.core.PImage;

public class Screen {
    public Board b = new Board(350,150);
    // 0 = L piece
    // 1 = Reverse L piece
    // 2 = line piece
    // 3 = t piece
    // 4 = z piece
    // 5 = reverse z piece
    // 6 = square piece

    public void drawNext() {
        int x = 740;
        int y = 120;

         if (b.nextPiece == 0) {
            b.drawDemoPiece(x,y,0);
        }
        if (b.nextPiece == 1) {
            b.drawDemoPiece(x,y,1);
        }
        if (b.nextPiece == 2) {
            b.drawDemoPiece(x,y,2);
        }
        if (b.nextPiece == 3) {
            b.drawDemoPiece(x,y,3);
        }
        if (b.nextPiece == 4) {
            b.drawDemoPiece(x,y,4);
        }
        if (b.nextPiece == 5) {
            b.drawDemoPiece(x,y,5);
        }
        if (b.nextPiece == 6) {
            b.drawDemoPiece(x,y,6);



    }}
    private void drawHeld() {
        if (b.held == 0) {
            b.drawDemoPiece(150,120,0);
        }
        if (b.held == 1) {
            b.drawDemoPiece(150,120,1);
        }
        if (b.held == 2) {
            b.drawDemoPiece(150,120,2);
        }
        if (b.held == 3) {
            b.drawDemoPiece(150,120,3);
        }
        if (b.held == 4) {
            b.drawDemoPiece(150,140,4);
        }
        if (b.held == 5) {
            b.drawDemoPiece(150,120,5);
        }
        if (b.held == 6) {
            b.drawDemoPiece(150,120,6);
        }
    }
    public void draw() {
        Main.processing.background(21,42,106);
        b.draw();
        PImage logo = Main.processing.loadImage("Logo.png");
        PFont font = Main.processing.createFont("TETRIS.ttf", 20);
        Main.processing.image(logo, 30, 400);
        Main.processing.strokeWeight(5);
        Main.processing.stroke(242,168,64);
        Main.processing.fill(61, 101, 201);
        Main.processing.rect(70,60,200,180);
        Main.processing.rect(650,60,200,180);
        Main.processing.textFont(font);
        Main.processing.fill(0,0,0);
        Main.processing.text("HELD PIECE", 90, 95);
        Main.processing.text("NEXT PIECE", 675, 95);
        Main.processing.fill(242,168,64);
        Main.processing.textSize(30);
        Main.processing.text("Score: " + b.score, 315, 90);
        drawHeld();
        drawNext();

    }

}
