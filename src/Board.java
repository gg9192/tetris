

import processing.core.PFont;

import javax.sound.sampled.Line;
import java.util.*;

public class Board {
    public int level = 1;

    private int lossTick = 0;
    public boolean isLoss = false;
    private int tickMax = 50;

    private int linesCleared = 0;
    private boolean canHold = true;
    public int score = 0;
    private int maxHeight = 23;
    //number of ticks it takes to clear the row
    protected int clearTime = -50;
    //Current piece
    Piece cp;
    boolean needPiece = true;
    static int[][] grid = new int[10][24];
    int tick = 0;
    
    int x;
    int y;

    int held = -1;
    int nextPiece;
    
    public void setGrid(int x, int y, int val) {
    	grid[x][y] = val;
    }

    public void incrementLinesCleared(int val) {
    	linesCleared += val;
    }
    
    public int getLevel() {
    	return this.level;
    }
    
    public Piece getCP() {
    	return cp;
    }
    
    public void incrementScore(int val) {
    	score += val;
    }
    
    public int getMaxHeight() {
    	return this.maxHeight;
    }
    /**
     * Sets the maxHeight to value specified
     * **WARNING** FOR TESTING ONLY
     * @param val 
     */
    public void setMaxHeight(int val) {
    	this.maxHeight = val;
    }
    
	public int getGridValue(int j, int k) {
		return grid[j][k];
	}
	

    
    //10x24
    //piece model https://static.techspot.com/images2/news/bigimage/2019/06/2019-06-06-image-17.jpg
    // color 0 = black null piece
    // color 1 = red L piece
    // color 2 = green line piece
    // color 3 = pink t piece
    // color 4 = blue z piece
    // color 5 = yellow square piece


    // 0 = L piece
    // 1 = Reverse L piece
    // 2 = line piece
    // 3 = t piece
    // 4 = z piece
    // 5 = reverse z piece
    // 6 = square piece
    //centerx = 4

    
    
    public boolean getNeedPiece() {
    	return needPiece;
    }
    
    public void setNeedPiece(Boolean needPiece) {
    	this.needPiece = needPiece;
    }
    
    public int getLinesCleared() {
    	return linesCleared;
    }
    
    public void setLevel(int val) {
    	this.level = val;
    }
    
    public void setTickMax(int val) {
    	this.tickMax = val;
    }
    

    
    
    /**
     * Calculates if the game is lost based on the next piece.
     * @param piece The piece that is checked.
     * @return Boolean based on whether the game is lost or not. 
     */
    public boolean checkLoss(int piece) {
        if (piece == 0) {
            if (grid[3][1] == 0 && grid[4][1] == 0 && grid[5][1] == 0) {
                return false;
            }
            return true;
        }
        else if (piece == 1) {
            if (grid[3][1] == 0 && grid[4][1] == 0 && grid[5][1] == 0) {
                return false;
            }
            return true;

        }
        else if (piece == 2) {
            if (grid[4][3] != 0) {
                return true;
            }
            return false;
        }
        else if (piece == 3) {
            if (grid[3][1] == 0 && grid[4][1] == 0 && grid[5][1] == 0) {
                return false;
            }
            return true;
        }
        else if (piece == 4) {
            if (grid[3][1] == 0 && grid[4][1] == 0 && grid[5][0] == 0) {
                return false;
            }
            return true;
        }
        else if (piece == 5) {
            if (grid[3][0] == 0 && grid[4][1] == 0 && grid[5][1] == 0) {
                return false;
            }
            return true;
        }
        else {
            if (grid[4][1] == 0 && grid[4][1] == 0 && grid[5][1] == 0) {
                return false;
            }
            return true;
        }
    }
    
    /**
     * Function to handle holding a piece when the proper key is pressed. 
     * 
     */
    public void hold() {
        if (canHold) {
            canHold = false;
            //no held piece
            if (held == -1) {
                if (cp instanceof LPiece) {
                    held = 0;
                }
                if (cp instanceof ReverseLPiece) {
                    held = 1;
                }
                if (cp instanceof LinePiece) {
                    held = 2;
                }
                if (cp instanceof TPiece) {
                    held = 3;
                }
                if (cp instanceof ZPiece) {
                    held = 4;
                }
                if (cp instanceof ReverseZPiece) {
                    held = 5;
                }
                if (cp instanceof SquarePiece) {
                    held = 6;
                }
                needPiece = true;
        }
        else {
                int temp = held;
                if (cp instanceof LPiece) {
                    held = 0;
                }
                if (cp instanceof ReverseLPiece) {
                    held = 1;
                }
                if (cp instanceof LinePiece) {
                    held = 2;
                }
                if (cp instanceof TPiece) {
                    held = 3;
                }
                if (cp instanceof ZPiece) {
                    held = 4;
                }
                if (cp instanceof ReverseZPiece) {
                    held = 5;
                }
                if (cp instanceof SquarePiece) {
                    held = 6;
                }
                //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
                if (temp == 0) {
                    cp = new LPiece(this);
                }
                if (temp == 1) {
                    cp = new ReverseLPiece(this);
                }
                if (temp == 2) {
                    cp = new LinePiece(this);
                }
                if (temp == 3) {
                    cp = new TPiece(this);
                }
                if (temp == 4) {
                    cp = new ZPiece(this);
                }
                if (temp == 5) {
                    cp = new ReverseZPiece(this);
                }
                if (temp == 6) {
                    cp = new SquarePiece(this);
                }

            }
        }

    }
    // 0 = L piece
    // 1 = Reverse L piece
    // 2 = line piece
    // 3 = t piece
    // 4 = z piece
    // 5 = reverse z piece
    // 6 = square piece

    // color 0 = black null piece
    // color 1 = red L piece
    // color 2 = green line piece
    // color 3 = pink t piece
    // color 4 = blue z piece
    // color 5 = yellow square piece

    /**
     * Function that handles the drawing of the squares in loss screen.
     * @param numSquares Number of squares drawn
     */
    public void drawLossSquares(int numSquares) {

        int boardX = getCords(0,0).getX();
        int boardY = getCords(0,0).getY();
        for (int x = 0; x <= numSquares; x ++) {
            Main.processing.strokeWeight(4);
            Main.processing.fill(242,168,64);
            Main.processing.rect(boardX,boardY + (x * 100),250,100);
            Main.processing.fill(0,0,0);
            PFont font = Main.processing.createFont("TETRIS.ttf", 30);
            Main.processing.textFont(font);
            Main.processing.text("GAME", boardX + 50, boardY + (x * 100) + 30);
            Main.processing.text("OVER", boardX + 100, boardY + (x * 100) + 70);
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
    public void drawDemoPiece(int x, int y, int type) {
        if (type == 0) {
            drawSquare(1, new Tuple(x,y));
            drawSquare(1, new Tuple(x,y + 25));
            drawSquare(1, new Tuple(x,y + 50));
            drawSquare(1, new Tuple(x + 25,y + 50));
        }
        else if (type == 1) {
            drawSquare(1, new Tuple(x,y));
            drawSquare(1, new Tuple(x,y + 25));
            drawSquare(1, new Tuple(x,y + 50));
            drawSquare(1, new Tuple(x - 25,y + 50));
        }
        else if (type == 2) {
            drawSquare(2, new Tuple(x,y));
            drawSquare(2, new Tuple(x,y + 25));
            drawSquare(2, new Tuple(x,y + 50));
            drawSquare(2, new Tuple(x,y + 75));
        }
        else if (type == 3) {
            drawSquare(3, new Tuple(x,y));
            drawSquare(3, new Tuple(x,y + 25));
            drawSquare(3, new Tuple(x,y + 50));
            drawSquare(3, new Tuple(x + 25,y + 25));
        }
        else if (type == 4) {
            drawSquare(4, new Tuple(x, y));
            drawSquare(4, new Tuple(x + 25, y));
            drawSquare(4, new Tuple(x + 25, y + 25));
            drawSquare(4, new Tuple(x + 50, y + 25));
        }
        else if (type == 5) {
            x -= 12;
            drawSquare(4, new Tuple(x, y + 25));
            drawSquare(4, new Tuple(x + 25, y + 25));
            drawSquare(4, new Tuple(x + 25, y));
            drawSquare(4, new Tuple(x + 50, y));

        }
        else if (type == 6) {
            drawSquare(5, new Tuple(x, y));
            drawSquare(5, new Tuple(x + 25, y));
            drawSquare(5, new Tuple(x, y + 25));
            drawSquare(5, new Tuple(x + 25, y + 25));
        }

    }
    

    /**
     * Constructs a board based on the given X and Y, then decides on a next piece.
     * @param x X coordinate to draw the board at.
     * @param y Y coordinate to draw the board at.
     */
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        nextPiece = (int)Math.floor(Math.random()*(6-0+1)+0);
    }
    
    /**
     * Calculates the coordinates on the screen of a given block in the game 
     * based on the 2-D array that stores board data. 
     * Note that each tetronimo has four blocks
     * @param x x value of 2d array
     * @param y y value of 2d array
     * @return a tuple that gives the coordinates. 
     */
    public Tuple getCords(int x, int y) {
        return new Tuple(this.x + 5 + 25*x, this.y + 5 + 25*y);
    }
    
    public void setCanHold(boolean value) {
    	this.canHold = value;
    }
    
    public boolean getCanHold() {
    	return canHold;
    }
    
   
    
    /**
     * Draws a block based on the color and location given
     * @param color Color of the block
     * color 0 = black null piece
     * color 1 = red L piece
     * color 2 = green line piece
     * color 3 = pink t piece
     * color 4 = blue z piece
     * color 5 = yellow square piece
     * @param t the tuple containing the coordinates of the piece.
     */
    public static void drawSquare(int color, Tuple t) {
        Main.processing.strokeWeight(1);
        if (color == 0) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(0,0,0);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(16,16,16);
            Main.processing.beginShape();
            Main.processing.vertex(t.getX(),t.getY());
            Main.processing.vertex(t.getX() + 25,t.getY());
            Main.processing.vertex(t.getX() + 20,t.getY() + 5);
            Main.processing.vertex(t.getX() + 5,t.getY() + 20);
            Main.processing.vertex(t.getX(),t.getY() + 25);

            Main.processing.endShape();
        }
        else if (color == 1) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(254,17,1);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(253,57,43);
            Main.processing.noStroke();
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX() + 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(255,56,44);
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX() + 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(194,4,6);
            Main.processing.quad(t.getX() + 25, t.getY(), t.getX() + 25, t.getY() + 25, t.getX() + 20,t.getY() + 20, t.getX() + 20, t.getY() + 5);
            Main.processing.fill(116,0,0);
            Main.processing.quad(t.getX(), t.getY() + 25, t.getX() + 25, t.getY() + 25, t.getX() + 20, t.getY() + 20, t.getX() + 5, t.getY() + 20);
        }
        else if (color == 2) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(0,255,0);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(20,230,17);
            Main.processing.noStroke();
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(1,254,3);
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(1,156,3);
            Main.processing.quad(t.getX() + 25, t.getY(), t.getX() + 25, t.getY() + 25, t.getX() + 20,t.getY() + 20, t.getX() + 20, t.getY() + 5);
            Main.processing.fill(2,92,2);
            Main.processing.quad(t.getX(), t.getY() + 25, t.getX() + 25, t.getY() + 25, t.getX() + 20, t.getY() + 20, t.getX() + 5, t.getY() + 20);
        }
        else if (color == 3) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(255,1,245);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(255,2,253);
            Main.processing.noStroke();
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(250,79,255);
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(183,0,153);
            Main.processing.quad(t.getX() + 25, t.getY(), t.getX() + 25, t.getY() + 25, t.getX() + 20,t.getY() + 20, t.getX() + 20, t.getY() + 5);
            Main.processing.fill(111,0,84);
            Main.processing.quad(t.getX(), t.getY() + 25, t.getX() + 25, t.getY() + 25, t.getX() + 20, t.getY() + 20, t.getX() + 5, t.getY() + 20);
        }
        else if (color == 4) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(0,85,254);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(2,75,255);
            Main.processing.noStroke();
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(61,142,255);
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(0,43,161);
            Main.processing.quad(t.getX() + 25, t.getY(), t.getX() + 25, t.getY() + 25, t.getX() + 20,t.getY() + 20, t.getX() + 20, t.getY() + 5);
            Main.processing.fill(0,18,90);
            Main.processing.quad(t.getX(), t.getY() + 25, t.getX() + 25, t.getY() + 25, t.getX() + 20, t.getY() + 20, t.getX() + 5, t.getY() + 20);
        }
        else if (color == 5) {
            Main.processing.stroke(0,0,0);
            Main.processing.fill(255,255,1);
            Main.processing.rect(t.getX(),t.getY(),25,25);
            Main.processing.fill(248,248,4);
            Main.processing.noStroke();
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(254,255,71);
            Main.processing.quad(t.getX() + 1,t.getY()+ 1, t.getX()+ 25, t.getY() + 1, t.getX() + 20, t.getY() + 5, t.getX() + 5, t.getY() + 5);
            Main.processing.fill(148,159,0);
            Main.processing.quad(t.getX() + 25, t.getY(), t.getX() + 25, t.getY() + 25, t.getX() + 20,t.getY() + 20, t.getX() + 20, t.getY() + 5);
            Main.processing.fill(87,92,0);
            Main.processing.quad(t.getX(), t.getY() + 25, t.getX() + 25, t.getY() + 25, t.getX() + 20, t.getY() + 20, t.getX() + 5, t.getY() + 20);
        }
        else if (color < 0) {
            Main.processing.stroke(0,0,0);
            Main.processing.strokeWeight(2);
            Main.processing.fill(255,255,255);
            Main.processing.rect(t.getX(),t.getY(),25,25);
        }
    }
    
    /**
     * This function clears one row of the board, from the given 
     * row, to the maxHeight of the board. Recall that board[0][0] 
     * represents the top left of the board.
     * @param base the row that needs to be cleared
     */
    public void fixBoard(int base) {
        for (int y = base; y > maxHeight; y --) {
            for (int x = 0; x < 10; x ++) {
                grid[x][y] = grid[x][y - 1];

            }
        }
        for (int x = 0; x < 10; x ++) {
            grid[x][maxHeight] = 0;
        }
        maxHeight++;
    }
    /**
     * Checks if the given row can be cleared. If so, prepare the row to be
     * cleared. 
     * @param row The row to be checked 
     * @return boolean based on if the row can be cleared.
     */
    public boolean checkClear(int row) {

        for (int i = 0; i < 10; i ++) {
           if (grid[i][row] == 0) {
               return false;
           }
        }
        for (int i = 0; i < 10; i ++) {
            grid[i][row] = clearTime;
        }

        return true;
    }
    
    /**
     * Draws the board and the pieces associated with it. 
     */
    public void draw(){
        if (isLoss) {
            nextPiece = -1;
                for (int x = 0; x < 10; x ++) {
                    for (int y = 0; y < 24; y ++) {
                        drawSquare(grid[x][y], getCords(x, y));
                    }
                }
                if (lossTick < 36) {
                    lossTick ++;


                }
            drawLossSquares(lossTick/7);

                return;
        }

        // 0 = L piece
        // 1 = Reverse L piece
        // 2 = line piece
        // 3 = t piece
        // 4 = z piece
        // 5 = reverse z piece
        // 6 = square piece
        if (needPiece) {
            if (isLoss == false) {
                int random = (int)Math.floor(Math.random()*(6-0+1)+0);
                if (checkLoss(nextPiece)) {
                    isLoss = true;
                    
                }
                if (nextPiece == 0) {
                    cp = new LPiece(this);
                }
                if (nextPiece == 1) {
                    cp = new ReverseLPiece(this);
                }
                if (nextPiece == 2) {
                    cp = new LinePiece(this);
                }
                if (nextPiece == 3) {
                    cp = new TPiece(this);
                }
                if (nextPiece == 4) {
                    cp = new ZPiece(this);
                }
                if (nextPiece == 5) {
                    cp = new ReverseZPiece(this);
                }
                if (nextPiece == 6) {
                    cp = new SquarePiece(this);
                }
                nextPiece = random;
                needPiece = false;
            }



        }

        if (this.cp.check()) {
            needPiece = true;
            return;
        }
        //turns true the minute a piece that has turned from white to black is detected
        boolean qwe = false;

        Main.processing.strokeWeight(1);
        Main.processing.fill(242,168,64);
        Main.processing.rect(this.x , this.y, (10 * 25) + 10, (24 * 25) + 10);
        for(int y = 23; y > -1 ; y--)
        {
            int canC = -1;
            for (int x = 0; x < 10; x++) {

                drawSquare(grid[x][y], getCords(x, y));
                if (grid[x][y] < 0) {
                    grid[x][y] = grid[x][y] +1;
                    if (grid[x][y] == 0) {qwe = true;
                    canC = y;}
                }

            }
            if (canC != -1) {
                fixBoard(canC);
            }

        }
        tick ++;
        if (tick > tickMax) {
            cp.tick();
            tick = 0;
        }
        cp.draw();
        if (qwe) {needPiece = true;}
    }
    
    
    
    
    
    
    
    

	
    }


