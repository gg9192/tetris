import processing.core.PFont;
import processing.core.PImage;
/**
 * This handles rendering the elements on the screen
 * @author alext
 *
 */
public class Game implements Screen{
    private Board b = new Board(350,150, this);
    // 0 = L piece
    // 1 = Reverse L piece
    // 2 = line piece
    // 3 = t piece
    // 4 = z piece
    // 5 = reverse z piece
    // 6 = square piece

    Main m;
    private boolean isLoss = false;	
    
    public void loseGame() {
    	this.isLoss = true;
    	lm = new LossMenu(m, this);
    }
    
    public Board getBoard() {
    	return this.b;
    }
    
    private LossMenu lm;
    
    public int getScore() {
    	return b.getScore();
    }
    
    public Game(Main me) {
    	this.m = me;
    	System.out.println(this.m);
    	
    	//for testing
    	//loseGame();
    	
    }
    
    /**
	 * Handles mouse click.
	 * @param mouseX X position of Mouse
	 * @param mouseY Y position of Mouse
	 */
	public void onClick(int mouseX, int mouseY) {
		if (isLoss) {
			lm.onClick(mouseX, mouseY);
		}
	}
	
	
	
	/**
	 * Handles mouse move.
	 * @param mouseX X position of Mouse
	 * @param mouseY Y position of Mouse
	 */
	public void onMouseMove(int mouseX, int mouseY) {
		if (isLoss) {
			lm.onMouseMove(mouseX, mouseY);
		}
	}
    
    /**
     * Draws a piece at the given location to show next and current piece. 
     * @param x X coordinate of piece.
     * @param y Y coordinate of piece.
     * @param type Type of piece to be drawn.
     * 0 = L piece
     * 1 = Reverse L piece
     * 2 = line piece
     * 3 = t piece
     * 4 = z piece
     * 5 = reverse z piece
     * 6 = square piece
     */
    @SuppressWarnings("static-access")
	public void drawDemoPiece(int x, int y, int type) {
        if (type == 0) {
            b.drawSquare(1, new Tuple(x,y));
            b.drawSquare(1, new Tuple(x + 25,y));
            b.drawSquare(1, new Tuple(x + 50,y));
            b.drawSquare(1, new Tuple(x + 50,y -25));
        }
        else if (type == 1) {
        	b.drawSquare(1, new Tuple(x,y -25));
        	b.drawSquare(1, new Tuple(x + 25,y));
        	b.drawSquare(1, new Tuple(x + 50,y));
        	b.drawSquare(1, new Tuple(x,y));
        }
        else if (type == 2) {
        	b.drawSquare(2, new Tuple(x,y));
        	b.drawSquare(2, new Tuple(x + 25,y));
        	b.drawSquare(2, new Tuple(x + 50,y));
        	b.drawSquare(2, new Tuple(x + 70,y));
        }
        else if (type == 3) {
        	b.drawSquare(3, new Tuple(x,y));
        	b.drawSquare(3, new Tuple(x + 25,y));
        	b.drawSquare(3, new Tuple(x + 50,y));
        	b.drawSquare(3, new Tuple(x + 25,y - 25));
        }
        else if (type == 4) {
        	b.drawSquare(4, new Tuple(x, y));
        	b.drawSquare(4, new Tuple(x + 25, y));
        	b.drawSquare(4, new Tuple(x + 25, y + 25));
        	b.drawSquare(4, new Tuple(x + 50, y + 25));
        }
        else if (type == 5) {
        	b.drawSquare(4, new Tuple(x, y + 25));
        	b.drawSquare(4, new Tuple(x + 25, y + 25));
        	b.drawSquare(4, new Tuple(x + 25, y));
        	b.drawSquare(4, new Tuple(x + 50, y));

        }
        else if (type == 6) {
        	b.drawSquare(5, new Tuple(x, y));
        	b.drawSquare(5, new Tuple(x + 25, y));
        	b.drawSquare(5, new Tuple(x, y + 25));
        	b.drawSquare(5, new Tuple(x + 25, y + 25));
        }

    }
    
    /**
     * Draws the next piece
     */
    public void drawNext() {
        int x = 740;
        int y = 120;

         if (b.nextPiece == 0) {
            drawDemoPiece(x - 30,y + 40,0);
        }
        if (b.nextPiece == 1) {
            drawDemoPiece(x - 25,y + 40,1);
        }
        if (b.nextPiece == 2) {
            drawDemoPiece(x - 35,y + 30,2);
        }
        if (b.nextPiece == 3) {
            drawDemoPiece(x - 28,y + 40,3);
        }
        if (b.nextPiece == 4) {
            drawDemoPiece(x - 25,y + 15,4);
        }
        if (b.nextPiece == 5) {
            drawDemoPiece(x - 27,y + 16,5);
        }
        if (b.nextPiece == 6) {
            drawDemoPiece(x - 14,y + 15,6);

    }}
    
    /**
     * Draws the held piece, if one exists. 
     */
    private void drawHeld() {
        if (b.held == 0) {
        	drawDemoPiece(130,160,0);
        }
        if (b.held == 1) {
        	drawDemoPiece(130,160,1);
        }
        if (b.held == 2) {
            drawDemoPiece(120,150,2);
        }
        if (b.held == 3) {
            drawDemoPiece(133,160,3);
        }
        if (b.held == 4) {
            drawDemoPiece(130,140,4);
        }
        if (b.held == 5) {
            drawDemoPiece(130,140,5);
        }
        if (b.held == 6) {
            drawDemoPiece(143,140,6);
        }
    }
    /**
     * This function draws the elements on the screen.
     */
    public void draw() {
        if (!isLoss) {
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
            Main.processing.text("HELD PIECE", 95, 95);
            Main.processing.text("NEXT PIECE", 675, 95);
            Main.processing.fill(242,168,64);
            Main.processing.textSize(30);
            Main.processing.text("Score: " + b.score, 315, 90);
            drawHeld();
            drawNext();
        }
        else {
        	lm.draw();
        }
    	

    }

}
