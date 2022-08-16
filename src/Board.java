

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
    protected int clearTime = -50;

    //10x24
    //piece model https://static.techspot.com/images2/news/bigimage/2019/06/2019-06-06-image-17.jpg
    // color 0 = black null piece
    // color 1 = red L piece
    // color 2 = green line piece
    // color 3 = pink t piece
    // color 4 = blue z piece
    // color 5 = yellow square piece
    int x;
    int y;

    public int held = -1;
    public int nextPiece;

    // 0 = L piece
    // 1 = Reverse L piece
    // 2 = line piece
    // 3 = t piece
    // 4 = z piece
    // 5 = reverse z piece
    // 6 = square piece
    //centerx = 4

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
                    cp = new LPiece();
                }
                if (temp == 1) {
                    cp = new ReverseLPiece();
                }
                if (temp == 2) {
                    cp = new LinePiece();
                }
                if (temp == 3) {
                    cp = new TPiece();
                }
                if (temp == 4) {
                    cp = new ZPiece();
                }
                if (temp == 5) {
                    cp = new ReverseZPiece();
                }
                if (temp == 6) {
                    cp = new SquarePiece();
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
    int rowToBeCleared = 0;
    int howManyRows = 0;
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
        nextPiece = (int)Math.floor(Math.random()*(6-0+1)+0);
    }
    public Tuple getCords(int x, int y) {
        return new Tuple(this.x + 5 + 25*x, this.y + 5 + 25*y);
    }
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
    Piece cp;
    boolean needPiece = true;
     static int[][] grid = new int[10][24];
     //uncomment next line for testing
    int tick = 0;
     //static int[][] grid = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1}
     //                      ,{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
      //                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
      //                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
      //                      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
       //                     {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1},
        //                    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
         //                  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
            //                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1},
             //               {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    //int[][] board = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    //int[][] board = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    //int[][] board =  {{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
    //int [][] board = {{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}};
    //int[][] board = {{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}};

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
    private boolean canClear(int col) {

        for (int i = 0; i < 10; i ++) {
           if (grid[i][col] == 0) {
               return false;
           }
        }
        for (int i = 0; i < 10; i ++) {
            grid[i][col] = clearTime;
        }

        return true;
    }
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
                    System.out.println(isLoss);
                    System.out.println("asdfasdaeftw");
                }
                if (nextPiece == 0) {
                    cp = new LPiece();
                }
                if (nextPiece == 1) {
                    cp = new ReverseLPiece();
                }
                if (nextPiece == 2) {
                    cp = new LinePiece();
                }
                if (nextPiece == 3) {
                    cp = new TPiece();
                }
                if (nextPiece == 4) {
                    cp = new ZPiece();
                }
                if (nextPiece == 5) {
                    cp = new ReverseZPiece();
                }
                if (nextPiece == 6) {
                    cp = new SquarePiece();
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
    public abstract class Piece {
        int centerX = 4;
        int centerY = -2;

        //https://tetris.fandom.com/wiki/Lock_delay
        int pieceLock =  -1;
        int orientation = 0;
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
        public void down() {
            for (int i = 0; i < 4; i ++) {
                piece[i] = new Tuple(shadow[i].getX(),shadow[i].getY());
            }
            this.pieceLock = 50;
            if (check()) {
                needPiece = true;
            }
        }
        Tuple[] piece = new Tuple[4];
        Tuple[] shadow = new Tuple[4];
        public abstract boolean checkDir(int dir);
        public void moveLeft() {
            if (checkDir(0)) {
                this.centerX --;
                for (Tuple t : piece) {




                    t.setX(t.getX()-1);
                }
                findShadow();
            }
        }
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

        public boolean check() {
            if (Arrays.equals(piece, shadow)) {
                pieceLock ++;
                if (pieceLock >= 41) {
                    canHold = true;
                    int numCleared = 0;
                    for (Tuple t : piece) {

                        //puts instance of array actually on the board
                        if (this instanceof LPiece || this instanceof ReverseLPiece) {
                            grid[t.getX()][t.getY()] = 1;
                        }
                        if (this instanceof LinePiece) {
                            grid[t.getX()][t.getY()] = 2;
                        }
                        if (this instanceof TPiece) {
                            grid[t.getX()][t.getY()] = 3;
                        }
                        if (this instanceof ZPiece || this instanceof ReverseZPiece) {
                            grid[t.getX()][t.getY()] = 4;
                        }
                        if (this instanceof SquarePiece) {
                            grid[t.getX()][t.getY()] = 5;
                        }
                        if (canClear(t.getY())) {
                            numCleared ++;

                        }
                }
                    if (cp.piece[0].getY() < maxHeight) {maxHeight = cp.piece[0].getY();}

                    if (numCleared == 1) {
                        score += 100 * level;
                    }
                    if (numCleared == 2) {
                        score += 300 * level;
                    }
                    if (numCleared == 3) {
                        score += 500 * level;
                    }
                    if (numCleared == 4) {
                        score += 800 * level;
                    }

                    linesCleared += numCleared;

                    int temp = linesCleared/10;
                    if (temp < 29) {
                        level = temp + 1;
                    }

                    tickMax = (int) Math.floor(50 * Math.pow(0.8, level));

                    return true;


                }

        } else {pieceLock = -1;
                return false;}
            return false;
        }
        public void draw() {

            for (Tuple t : piece) {
                if (this instanceof LPiece || this instanceof ReverseLPiece) {
                    if (t.getY() > -1) {drawSquare(1, getCords(t.getX(),t.getY()));}
                }
                if (this instanceof TPiece) {
                    if (t.getY() > -1) {drawSquare(3, getCords(t.getX(),t.getY()));}

                }
                if (this instanceof ZPiece || this instanceof ReverseZPiece) {
                    if (t.getY() > -1) {drawSquare(4, getCords(t.getX(),t.getY()));}

                }
                if (this instanceof SquarePiece) {
                    if (t.getY() > -1) {drawSquare(5, getCords(t.getX(),t.getY()));}

                }
                if (this instanceof LinePiece) {
                    if (t.getY() > -1) {drawSquare(2, getCords(t.getX(),t.getY()));}

                }
            }
            drawShadow();
        }
        public abstract void rotate();
        public void drawShadow() {
            for (Tuple t : shadow) {
                drawShadowBox(t);
            }
        }
        public abstract void  findShadow();
        public void drawShadowBox(Tuple t) {
            int x = getCords(t.getX(),t.getY()).getX();
            int y = getCords(t.getX(),t.getY()).getY();
            Main.processing.stroke(242,168,64);
            Main.processing.strokeWeight(2);
            Main.processing.line(x,y,x + 25,y);
            Main.processing.line(x,y + 25, x, y);
            Main.processing.line(x, y + 25, x + 25, y + 25);
            Main.processing.line(x + 25, y + 25, x + 25,y);
        }
    }
    public class LPiece extends Piece{

        public LPiece() {
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX, centerY);
            piece[2] = new Tuple(centerX, centerY + 1);
            piece[3] = new Tuple(centerX + 1, centerY + 1);
            findShadow();
        }
        public boolean canRotate() {
            if (centerY < 1) {
                if (this.orientation == 1) {
                    if (this.centerX == 0) {
                        return false;
                    }
                }
                else {if (this.centerX == 9) {
                    return false;
                }

                }
                return true;
            }
            else {
                if (this.orientation == 0) {
                    return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY + 1] == 0;
                }
                else if (this.orientation == 1) {
                    if (this.centerX == 0) {
                        return false;
                    }
                    return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY + 1] == 0;
                }
                else if (this.orientation == 2) {
                    return grid[centerX - 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0;
                }
                else {
                    if (this.centerX == 9) {
                        return false;
                    }
                    return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX - 1][centerY + 1] == 0;
                }
            }

        }
        //left is 0
        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > 0) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        @Override
        public void rotate() {
            this.orientation ++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY -1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY + 1);
                    piece[3] = new Tuple(centerX + 1, centerY + 1);
                    this.findShadow();
                }
                else{
                    this.orientation--;
                }
                return;
            }
            else if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX + 1, centerY - 1);
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    this.findShadow();
                }
                else{
                    this.orientation--;
                }
                return;


            }
            else if (this.orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY -1);
                    piece[1] = new Tuple(centerX, centerY - 1);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX , centerY + 1);
                    this.findShadow();
                    return;
                }
                this.orientation--;
                return;

            }
            else {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX - 1, centerY + 1);
                    this.orientation = -1;
                    this.findShadow();
                    return;
                }
                this.orientation--;
                return;

            }
        }
        @Override
        public void findShadow() {
            if (this.orientation == 0) {
                int t1 = 0;
                int t2 = 0;
                if (piece[2].getY() > 0 || piece[3].getY() > 0) {

                    t1 = piece[2].getY();
                    t2 = piece[3].getY();
                }


                while (t1 < 23 && t2 < 23 &&grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;

                }
                shadow[0] = new Tuple(piece[0].getX(),t1 - 2);
                shadow[1] = new Tuple(piece[1].getX(),t1 - 1);
                shadow[2] = new Tuple(piece[2].getX(), t1);
                shadow[3] = new Tuple(piece[3].getX(), t1);
            }
            else if (this.orientation == 1) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;
                if (piece[1].getY() > 0 || piece[2].getY() > 0 || piece[3].getY() > 0) {

                    t1 = piece[1].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();

                }
                while (t1 < 23 && t2 < 23 && t3 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }


                shadow[0] = new Tuple(piece[0].getX(), t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(), t1 );
                shadow[2] = new Tuple(piece[2].getX(), t1 );
                shadow[3] = new Tuple(piece[3].getX(), t1 );
            }
            else if (this.orientation == 2) {
                int t1 = 0;
                int t2 = 2;
                if (piece[0].getY() > 0 || piece[3].getY() > 0) {
                    t1 = piece[0].getY();
                    t2 = piece[3].getY();
                }
                while (t1 < 23 && t2 < 23 && grid[piece[3].getX()][t2 + 1] == 0 && grid[piece[0].getX()][t1 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[1] = new Tuple(piece[2].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t1 + 1);
                shadow[3] = new Tuple(piece[2].getX(), t1 + 2);

            }
            else {
                int t1 = 0;
                int t2 = 0;
                int t3 = 1;
                if (piece[1].getY() > 0 || piece[2].getY() > 0 || piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();
                }
                while (t1 < 23 && t2 < 23  && t3 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t1);
                shadow[3] = new Tuple(piece[3].getX(), t1 + 1);
            }
        }
    }

    public class ZPiece extends Piece {
        public ZPiece() {
            piece[0] = new Tuple(centerX - 1, centerY - 1);
            piece[1] = new Tuple(centerX , centerY - 1);
            piece[2] = new Tuple(centerX, centerY);
            piece[3] = new Tuple(centerX + 1, centerY);
            findShadow();
        }
        public boolean canRotate() {
            if (this.centerY < 1) {
                if (this.orientation == 0) {
                    if (centerX == 9) {return false;}
                }
                if (this.orientation == 1) {
                    if (centerX == 9 ) {return false;}}
                if (orientation == 2) {
                    if (centerX == 0) {return false;}}
                return true;
            }
            if (this.orientation == 0) {
                if (centerX == 9) {return false;}
                return grid[centerX + 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX - 1][centerY] == 0;
            }
            if (this.orientation == 1) {
                if (centerX == 9 ) {return false;}

                return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 1][centerY + 1] == 0;
            }
            if (orientation == 2) {
                if (centerX == 0) {return false;}
                return grid[centerX + 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX - 1][centerY + 1] == 0;
            }
            else {

                return grid[centerX - 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0;

            }

        }

        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        @Override
        public void rotate() {
            this.orientation++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[1] = new Tuple(centerX + 1, centerY - 1);
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[3] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX - 1, centerY);
                    findShadow();
                    return;
                }
                this.orientation--;
                return;

            }
            if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY + 1);
                    findShadow();

                    return;
                }
                this.orientation--;
                return;
            }
            if (this.orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY);
                    piece[1] = new Tuple(centerX + 1, centerY);
                    piece[2] = new Tuple(centerX - 1, centerY + 1);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    findShadow();
                    return;
                }
                this.orientation--;
                return;
            }
            else {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY - 1);
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    findShadow();
                    this.orientation = -1;
                    return;
                }
                this.orientation--;
                return;

            }

        }

        @Override
        public void findShadow() {

            if (this.orientation == 0) {
                int t1 = 1;
                int t2 = 1;
                int t3 = 0;

                if (piece[2].getY() > 1 && piece[3].getY() > 1 && piece[1].getY() > 0) {
                    t1 = piece[2].getY();
                    t2 = piece[3].getY();
                    t3 = piece[1].getY();
                }
                while (t1 < 23 && t2 <23 && t3 <23 && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 && grid[piece[0].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t3);
                shadow[1] = new Tuple(piece[1].getX(),t3);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t1);
                return;


            }
            if (this.orientation == 1) {
                int t1 = 0;
                int t2 = 1;
                if (piece[1].getY() > 1 && piece[3].getY() > 1 ) {
                    t1 = piece[1].getY();
                    t2 = piece[3].getY();

                }
                while (t1 < 23 && t2 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t2 - 1);
                shadow[3] = new Tuple(piece[3].getX(), t2);
                return;
            }
            if (this.orientation == 2) {
                int t1 = 0;
                int t2 = 1;
                int t3 = 1;
                if (piece[1].getY() > 1 && piece[2].getY() > 1 && piece[3].getY() > 1 ) {
                    t1 = piece[1].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();

                }
                while (t1 < 23 && t2 < 23 && t3 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t2);
                shadow[3] = new Tuple(piece[3].getX(), t2);
            }
            else {
                int t1 = 0;
                int t2 = 1;
                if (piece[1].getY() > 1 && piece[3].getY() > 1) {
                    t1 = piece[1].getY();
                    t2 = piece[3].getY();
                }
                while (t1 < 23 && t2 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t2 - 1);
                shadow[3] = new Tuple(piece[3].getX(), t2);
            }


        }


    }
    public class SquarePiece extends Piece {

        public SquarePiece() {
            this.centerY--;
            piece[0] = new Tuple(centerX, centerY);
            piece[1] = new Tuple(centerX + 1, centerY);
            piece[2] = new Tuple(centerX, centerY + 1);
            piece[3] = new Tuple(centerX + 1, centerY + 1);
            findShadow();
        }

        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        @Override
        public void rotate() {

        }

        @Override
        public void findShadow() {
            int t1 = 0;
            int t2 = 0;
            if (piece[2].getY() > 0 && piece[3].getY() > 0) {
                t1 = piece[2].getY();
                t2 = piece[3].getY();
            }
            while (t1 < 23 && t2 <23  && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                t1++;
                t2++;
            }
            shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
            shadow[1] = new Tuple(piece[1].getX(),t2 - 1);
            shadow[2] = new Tuple(piece[2].getX(),t1);
            shadow[3] = new Tuple(piece[3].getX(),t2);
        }
    }
    public class TPiece extends Piece {
        int orientation = 0;
        public TPiece() {
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX - 1, centerY);
            piece[2] = new Tuple(centerX, centerY);
            piece[3] = new Tuple(centerX + 1, centerY);
            this.findShadow();
        }

        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        @Override
        public void rotate() {
            this.orientation ++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    this.findShadow();
                    return;
                }
                orientation--;
                return;
            }
            else if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    this.findShadow();
                    return;
                }
                orientation--;
                return;
            }
            else if (this.orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    this.findShadow();
                    return;

                }
                orientation --;
                return;
            }
            else {
                if (canRotate()) {
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    this.findShadow();
                    orientation = -1;
                    return;
                }
                orientation--;
                return;
            }
        }
        public boolean canRotate(){


                if (centerY < 1) {
                    if (orientation == 0) {
                        if (centerX == 9) {return false;}}
                    if (orientation == 2) {if (centerX == 0) {
                        return false;
                    }

                }
                    return true;
                }


            if (orientation == 0) {
                if (centerX == 9) {return false;}
                return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX + 1][centerY] == 0;
            }
            else if (orientation == 1) {

                return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX][centerY + 1] == 0;
            }
            else if (orientation == 2) {
                if (centerX == 0) {
                    return false;
                }
                return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY] == 0;
            }
            else {

                return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY + 1] == 0;
            }
        }

        @Override
        public void findShadow() {
            if (this.orientation == 0) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;
                if (piece[1].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();
                }

                while (t1 < 23 && t2 <23 && t3 <23  && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1 ++;
                    t2++;
                    t3++;
                }
                shadow[3] = new Tuple(piece[3].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(),t2);
                shadow[1] = new Tuple(piece[1].getX(),t2);
                shadow[0] = new Tuple(piece[0].getX(),t2 - 1);
                return;
            }
            if (this.orientation == 1) {
                int t1 = 1;
                int t2 = 0;
                if (piece[3].getY() > 0 && piece[2].getY() > 0) {
                    t1 = piece[3].getY();
                    t2 = piece[2].getY();
                }
                while (t1 < 23 && t2 <23   && grid[piece[3].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0) {
                    t1 ++;
                    t2++;
                }
                shadow[3] = new Tuple(piece[3].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t1 -1);
                shadow[0] = new Tuple(piece[0].getX(),t1 - 2);
                return;
            }
            if (this.orientation == 2   ) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 1;
                if (piece[0].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[0].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();
                }
                while (t1 < 23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1 ++;
                    t2++;
                    t3++;
                }
                shadow[3] = new Tuple(piece[3].getX(), t3);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[0] = new Tuple(piece[0].getX(),t1);
            }
            else {
                int t1 = 0;
                int t2 = 1;
                if (piece[1].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[3].getY();
                }
                while (t1 < 23 && t2 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1 ++;
                    t2++;
                }
                shadow[3] = new Tuple(piece[3].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(),t2 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t2 - 1);
                shadow[0] = new Tuple(piece[0].getX(),t2 - 2);

            }
            return;


        }
    }
    public class LinePiece extends Piece {

        public LinePiece() {
            this.centerY--;
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX, centerY);
            piece[2] = new Tuple(centerX, centerY + 1);
            piece[3] = new Tuple(centerX, centerY + 2);
            findShadow();
        }

        public boolean canRotate() {

            if (this.orientation == 0) { if (this.centerY < 2) {
                if (centerX == 0|| centerX == 9) {return false;}
                return true;
            }}
            if (this.orientation == 1) {
                if (this.centerY < 2) {if (centerX == 0|| centerX == 9) {return false;}
                    return true;}
            }


            if (this.orientation == 0) {
                return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX][centerY + 2] == 0;
            }
            else {
                if (centerX == 0|| centerX == 9) {return false;}
                return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 2][centerY] == 0;
            }
        }

        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        @Override
        public void rotate() {
            this.orientation++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY + 1);
                    piece[3] = new Tuple(centerX, centerY + 2);
                    findShadow();
                    return;
                }
                orientation--;
                return;
            }
            if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX + 2, centerY);
                    this.orientation = -1;
                    findShadow();
                    return;
                }
                orientation--;
                return;

            }
        }

        @Override
        public void findShadow() {

            if (orientation == 0) {
                int t1 = 0;
                if (piece[3].getY()> 0) {
                    t1 = piece[3].getY();
                }
                while (t1 <23  && grid[piece[3].getX()][t1 + 1] == 0) {
                    t1++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1-3);
                shadow[1] = new Tuple(piece[1].getX(),t1-2);
                shadow[2] = new Tuple(piece[2].getX(),t1-1);
                shadow[3] = new Tuple(piece[3].getX(),t1  );
            }
            else {
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;
                int t4 = 0;
                if (piece[0].getY() > 0 && piece[1].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {}
                while (t1 <23  && t2 <23  && t3 <23  && t4 <23  && grid[piece[0].getX()][t1 + 1] == 0  && grid[piece[1].getX()][t2 + 1] == 0  && grid[piece[2].getX()][t3 + 1] == 0  && grid[piece[3].getX()][t4 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                    t4++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t1  );
            }

            return;


        }

    }
    public class ReverseLPiece extends Piece {

        public ReverseLPiece() {
            piece[0] = new Tuple(centerX - 1, centerY - 1);
            piece[1] = new Tuple(centerX - 1, centerY);
            piece[2] = new Tuple(centerX, centerY);
            piece[3] = new Tuple(centerX + 1, centerY);
            findShadow();
        }

        public boolean canRotate() {
            if (this.centerY < 1) {
                if (this.orientation == 0) {
                    if (this.centerX == 9) {return false;}
                }
                if (this.orientation == 2) {
                    if (this.centerX == 0) {return false;}}
                return true;
            }
            if (this.orientation == 0) {
                if (this.centerX == 9) {return false;}
                return grid[centerX - 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0;
            }
            if (this.orientation == 1) {
                return grid[centerX + 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0;
            }
            if (this.orientation == 2) {
                if (this.centerX == 0) {return false;}
                return grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 1][centerY + 1] == 0;
            }
            else {
                return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX - 1][centerY + 1] == 0;
            }
        }

        //left is 0
        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                        }
                    }
                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
            }

        }
            return true;
        }

        @Override
        public void rotate() {
            orientation++;
            if (orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY - 1);
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    findShadow();
                    return;
                }
                orientation--;
                return;
            }
            else if (orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX + 1, centerY - 1);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX, centerY + 1);
                    findShadow();
                    return;}
                orientation--;
                return;
            }
            else if (orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY + 1);
                    findShadow();
                    return;
                }
                orientation--;
                return;
            }
            else {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY + 1);
                    piece[3] = new Tuple(centerX - 1, centerY + 1);
                    findShadow();
                    orientation = -1;
                    return;
                }
                orientation--;
                return;
            }
        }

        @Override
        public void findShadow() {
            System.out.println("shit");
            if (orientation == 0) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;
                if (piece[1].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[2].getY();
                    t2 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && t2 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t1);
                return;
            }
            if (orientation == 1) {
                int t1 = 0;
                int t2 = 2;

                if (piece[1].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t2 - 1);
                shadow[3] = new Tuple(piece[3].getX(),t2);
                return;
            }
            if (orientation == 2) {
                int t1 = 0;
                int t2 = 0;
                int t3 = 1;

                if (piece[0].getY() > 0 && piece[1].getY() > 0 && piece[3].getY() > 0 ) {
                    t1 = piece[0].getY();
                    t2 = piece[1].getY();
                    t3 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[1].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t1 + 1);
                return;
            }
            if (orientation == 3 || this.orientation == -1) {
                int t1 = 0;
                int t2 = 0;

                if (piece[2].getY() > 0 && piece[2].getY() > 0) {
                    t1 = piece[2].getY();
                    t2 = piece[3].getY();
                }

                while (t1 <23 && t2 <23 && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t2- 2);
                shadow[1] = new Tuple(piece[1].getX(),t2 - 1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t2);
                return;
            }
        }

    }
    public class ReverseZPiece extends Piece {

        public ReverseZPiece() {
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX + 1, centerY - 1);
            piece[2] = new Tuple(centerX , centerY);
            piece[3] = new Tuple(centerX - 1, centerY);
            findShadow();
        }



        @Override
        public boolean checkDir(int dir) {
            for (Tuple t : piece) {
                if (dir == 0) {
                    if (t.getX() == 0) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY >= 1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            if (grid[t.getX() - 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                    }
                }
                else {
                    if (t.getX() == 9) {
                        return false;
                    }
                    if (this.orientation == 0 || this.orientation == 1 || this.orientation == 3) {
                        if (this.centerY > 0) {
                            if (grid[t.getX() + 1][t.getY()] != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                                if (grid[t.getX() + 1][t.getY()] != 0) {
                                    return false;
                                }
                            }
                        }
                    }
                }

            }
            return true;
        }

        public boolean canRotate() {
            if (this.centerY <= -1) {
                if (this.orientation == 2) {
                    if (centerX == 0) {
                        return false;
                    }}}
            if (this.centerY <= 0) {
                if (this.orientation == 0) {
                    if (centerX == 9) {
                        return false;
                    }}
            else return true;}





            if (this.orientation == 0) {
                if (centerX == 9) {
                    return false;
                }

                return grid[centerX][centerY - 1] == 0 && grid[centerX + 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0;
            }
            if (this.orientation == 1) {

                return grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 1][centerY] == 0;
            }
            if (this.orientation == 2) {
                if (centerX == 0) {
                    return false;
                }
                return grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX - 1][centerY + 1] == 0 && grid[centerX][centerY + 1] == 0;
            }
            else {
                return grid[centerX - 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0;
            }
        }
        @Override
        public void rotate() {
            this.orientation ++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX + 1, centerY - 1);
                    piece[2] = new Tuple(centerX - 1, centerY);
                    piece[3] = new Tuple(centerX, centerY);
                    findShadow();
                    return;
                }
                this.orientation--;
                return;
            }
            if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY -1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX + 1, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY  + 1);
                    findShadow();
                    return;}
                this.orientation--;
                return;

            }
            if (this.orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY);
                    piece[1] = new Tuple(centerX + 1, centerY);
                    piece[2] = new Tuple(centerX - 1, centerY + 1);
                    piece[3] = new Tuple(centerX, centerY  + 1);
                    findShadow();
                    return;}
                    this.orientation--;
                    return;

            }
            if (this.orientation == 3) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY - 1);
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX, centerY  + 1);
                    findShadow();
                    this.orientation = -1;
                    return;
                }
                this.orientation--;
                return;
            }
            }



        @Override
        public void findShadow() {

            if (orientation == 0) {
                int t1 = 0;
                int t2 = 1;
                int t3 = 1;
                if (piece[1].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {
                     t1 = piece[1].getY();
                     t2 = piece[2].getY();
                     t3 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t3);
                shadow[3] = new Tuple(piece[3].getX(),t3);
                return;
            }
            if (orientation == 1) {
                int t1 = 0;
                int t2 = 1;
                if (piece[1].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[1].getY();
                    t2 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t2 - 1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t2);
                return;
            }

            if (orientation == 2) {
                int t1 = 0;
                int t2 = 1;
                int t3 = 1;
                if (piece[0].getY() > 0 && piece[2].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[0].getY();
                    t2 = piece[2].getY();
                    t3 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0 ) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1 + 1);
                shadow[3] = new Tuple(piece[3].getX(),t1 + 1);
            }
            else {
                int t1 = 0;
                int t2 = 1;
                if (piece[2].getY() > 0 && piece[3].getY() > 0) {
                    t1 = piece[2].getY();
                    t2 = piece[3].getY();
                }
                while (t1 <23 && t2 <23 && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t2-1);
                shadow[3] = new Tuple(piece[3].getX(),t2);
            }
            return;
        }
    }
    }


