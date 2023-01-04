import java.util.Arrays;

/**
 * all pieces in the game inherent from this class
 * @author alext
 */
public abstract class Piece {
	int centerX = 4;
    int centerY = -2;
    Tuple[] piece = new Tuple[4];
    Tuple[] shadow = new Tuple[4];
    //https://tetris.fandom.com/wiki/Lock_delay
    int pieceLock =  -1;
    int orientation = 0;
    Board board;
    
    public int getCenterX() {
    	return this.centerX;
    }
    
    public int getCenterY() {
    	return this.centerY;
    }
    
    public Tuple[] getShadow() {
    	return this.shadow;
    }
    
    public Tuple[] getPiece() {
    	return this.piece;
    }
    
    /**
     * Moves the piece down one square. AKA one game tick. 
     */
    public void tick() {

        if (!check() && this.pieceLock == -1) {
            for (int i = 0; i < 4; i++) {
                piece[i].setY(piece[i].getY() + 1);
            }
            this.centerY ++;
            return;
        }

        return;
    }
    
    /**
     * This puts the piece where it would hypothetically land if
     * no further input is given.
     */
    public void down() {
        for (int i = 0; i < 4; i ++) {
            piece[i] = new Tuple(shadow[i].getX(),shadow[i].getY());
        }
        this.pieceLock = 50;
        if (check()) {
            board.setNeedPiece(true);
        }
    }
    
    /**
     * Checks if the piece can move in the direction specified
     * @param dir 0 for left, 1 for right
     * @return Boolean based on whether the piece can move in the given direction
     */
    public boolean checkDir(int dir) {
    	for (Tuple t : piece ) {
    		if (dir == 0) {
    			//left
    			if (!movable(t.getX() - 1, t.getY())) {
    				return false;
    			}
    			
    		}
    		else {
    			//right
    			if (!movable(t.getX() + 1, t.getY())) {
    				return false;
    			}
    		}
    		
    	}
    	return true;
    }
    
    /**
     * The event listen calls this function when "D" is pressed.
     * Moves the piece 1 unit to the left if able to
     */
    public void moveLeft() {

        if (checkDir(0)) {
            this.centerX --;
            for (Tuple t : piece) {




                t.setX(t.getX()-1);
            }
            findShadow();
        }
    }
    
    /**
     * The event listen calls this function when "D" is pressed.
     * Moves the piece 1 unit to the right if able to
     */
    public void moveRight() {
        if (checkDir(1)) {
            this.centerX ++;
            for (Tuple t : piece) {
                t.setX(t.getX()+1);
            }
            findShadow();
        }
    }
    // color 0 = black null piece
    // color 1 = red L piece
    // color 2 = green line piece
    // color 3 = pink t piece
    // color 4 = blue z piece
    // color 5 = yellow square piece

    /**
     * Checks if the piece has "landed" and clears lines on the board
     * as needed.
     * @return boolean based on whether the piece has successfully "landed"
     */
    public boolean check() {
        if (Arrays.equals(piece, shadow)) {
            pieceLock ++;
            if (pieceLock >= 41) {
                board.setCanHold(true);
                int numCleared = 0;
                for (Tuple t : piece) {

                    //puts instance of array actually on the board
                    if (this instanceof LPiece || this instanceof ReverseLPiece) {
                    	board.setGrid(t.getX(), t.getY(), 1);
                    }
                    if (this instanceof LinePiece) {
                        board.setGrid(t.getX(), t.getY(), 2);
                    }
                    if (this instanceof TPiece) {
                    	board.setGrid(t.getX(), t.getY(), 3);
                    }
                    if (this instanceof ZPiece || this instanceof ReverseZPiece) {
                    	board.setGrid(t.getX(), t.getY(), 4);
                    }
                    if (this instanceof SquarePiece) {
                    	board.setGrid(t.getX(), t.getY(), 5);
                    }
                    if (board.checkClear(t.getY())) {
                        numCleared ++;

                    }
            }
                if (board.getCP().piece[0].getY() < board.getMaxHeight()) {
                	board.setMaxHeight(board.getCP().piece[0].getY());
                	}

                if (numCleared == 1) {
                    board.incrementScore(100 * board.getLevel());
                }
                if (numCleared == 2) {
                	board.incrementScore(300 * board.getLevel());
                }
                if (numCleared == 3) {
                	board.incrementScore(500 * board.getLevel());
                }
                if (numCleared == 4) {
                	board.incrementScore(800 * board.getLevel());
                }

                board.incrementLinesCleared(numCleared);
                int temp = board.getLinesCleared()/10;
                if (temp < 29) {
                    board.setLevel(temp + 1);
                }
                board.setTickMax((int) Math.floor(50 * Math.pow(0.8, board.getLevel())));

                return true;


            }

    } else {pieceLock = -1;
            return false;}
        return false;
    }
    
    /**
     * 
     */
    @SuppressWarnings("static-access")
	public void draw() {

        for (Tuple t : piece) {
            if (this instanceof LPiece || this instanceof ReverseLPiece) {
                if (t.getY() > -1) {board.drawSquare(1, board.getCords(t.getX(),t.getY()));}
            }
            if (this instanceof TPiece) {
                if (t.getY() > -1) {board.drawSquare(3, board.getCords(t.getX(),t.getY()));}

            }
            if (this instanceof ZPiece || this instanceof ReverseZPiece) {
                if (t.getY() > -1) {board.drawSquare(4, board.getCords(t.getX(),t.getY()));}

            }
            if (this instanceof SquarePiece) {
                if (t.getY() > -1) {board.drawSquare(5, board.getCords(t.getX(),t.getY()));}

            }
            if (this instanceof LinePiece) {
                if (t.getY() > -1) {board.drawSquare(2, board.getCords(t.getX(),t.getY()));}

            }
        }
        drawShadow();
    }
    
    /**
     * Rotates the piece based on the current orientation.
     */
    public abstract void rotate();
    
    /**
     * Draws the shadow of the piece onto the board.
     */
    public void drawShadow() {
        for (Tuple t : shadow) {
            drawShadowBox(t);
        }
    }
    
    /**
     * Finds the shadow of the piece. Note that the shadow 
     * of a piece is an indicator showing where the piece will
     * land.
     */
    public abstract void findShadow();
    
    
    public void drawShadowBox(Tuple t) {
    	int x = board.getCords(t.getX(),t.getY()).getX();
        int y = board.getCords(t.getX(),t.getY()).getY();
        Main.processing.stroke(242,168,64);
        Main.processing.strokeWeight(2);
        Main.processing.line(x,y,x + 25,y);
        Main.processing.line(x,y + 25, x, y);
        Main.processing.line(x, y + 25, x + 25, y + 25);
        Main.processing.line(x + 25, y + 25, x + 25,y);
    }
    
    /**
     * Tests to see if the grid at the given (i,j) is empty. 
     * Returns false if the piece is out of the grid in a 
     * direction other than above. 
     * @param i
     * @param j
     * @return
     */
    protected boolean isRotatable(int i, int j) {
    	System.out.println(i);
    	if (i < 0 || i > 9) {
    		return false;
    	}
    	else if (j < 0) {
    		return true;
    	}
    	else {
    		return board.getGridValue(i, j) == 0;
    	}
    }
    /**
     * helper function to make sure that the piece can move
     * when the piece isn't on the board. If the piece is on 
     * the board, return false if the given cordinates is NOT
     * empty. 
     * @param i x coordinate 
     * @param j y coordinate
     * @return if the piece can be moved
     */
    private boolean movable(int i, int j) {
    	if (i == -1 || i == 10) {
    		return false;
    	}
    	if (j < 0) {
    		return true;
    	}
    	else {
    		if (board.getGridValue(i, j) == 0) {
    			return true;
    		}
    		return false;
    	}
    }
}
