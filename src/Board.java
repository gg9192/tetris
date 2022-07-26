import javax.print.attribute.standard.OrientationRequested;
import javax.sound.sampled.Line;
import java.util.*;

public class Board {
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
    public Board(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Tuple getCords(int x, int y) {
        Tuple t = new Tuple(this.x + 5 + 25*x, this.y + 5 + 25*y);

        return t;
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
            Main.processing.vertex(t.getX() + 5,t.getY() + 5);
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
    }
    Piece cp;
    boolean needPiece = true;
     //static int[][] grid = new int[10][24];
     //uncomment next line for testing
     static int[][] grid = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
    //int[][] board = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    //int[][] board = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};
    //int[][] board =  {{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}};
    //int [][] board = {{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4},{4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4}};
    //int[][] board = {{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5},{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5}};
    public void draw(){
        if (needPiece) {
            cp = new LPiece(4,1);
            needPiece = false;
            /*(
            int random = (int)Math.floor(Math.random()*(6-0+1)+0);
            if (random == 0) {
                cp = new LinePiece(4,1);
            }
            if (random == 1) {
                cp = new SquarePiece(4,1);
            }
            if (random == 2) {
                cp = new LPiece(4,1);
            }
            if (random == 3) {
                cp = new ReverseLPiece(4,1);
            }
            if (random == 4) {
                cp = new ZPiece(4,1);
            }
            if (random == 5) {
                cp = new ReverseZPiece(4,1);
            }
            if (random == 6) {
                cp = new TPiece(4,1);
            }
            needPiece = false;

             */
        }
        if (this.cp.check()) {
            System.out.println("asdasdasd");
            needPiece = true;
            return;
        }

        Main.processing.strokeWeight(1);
        Main.processing.fill(242,168,64);
        Main.processing.rect(this.x , this.y, (10 * 25) + 10, (24 * 25) + 10);
        for(int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                drawSquare(grid[x][y], getCords(x, y));

            }
        }
        cp.draw();
    }
    public abstract class Piece {
        int orientation = -1;
        int centerX;
        int centerY;
        public Piece(int x, int y) {
            this.centerX = x;
            this.centerY = y;
        }

        public void down() {
            for (int i = 0; i < 4; i ++) {
                piece[i] = new Tuple(shadow[i].getX(),shadow[i].getY());
            }
            if (check()) {
                needPiece = true;
            }
        }
        Tuple[] piece = new Tuple[4];
        Tuple[] shadow = new Tuple[4];
        public boolean checkDir (int dir) {
            if (dir == 0) {
                for (Tuple t : piece ) {
                    if (t.getX() == 0 || grid[t.getX() - 1][t.getY()] != 0) {
                        return false;
                    }
                }
            }
            else {
                for (Tuple t : piece ) {
                    if (t.getX() == 9 || grid[t.getX() + 1][t.getY()] != 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        public void moveLeft() {
            System.out.println("asystem" + Arrays.toString(piece));
            if (checkDir(0) == true) {
                this.centerX --;
                for (Tuple t : piece) {
                    t.setX(t.getX()-1);
                }
                findShadow();
            }
        }
        public void moveRight() {
            if (checkDir(1) == true) {
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

            }
                return true;
        }
            return false;
        }
        public void draw() {

            for (Tuple t : piece) {
                if (this instanceof LPiece || this instanceof ReverseLPiece) {
                    drawSquare(1, getCords(t.getX(),t.getY()));
                }
                if (this instanceof TPiece) {
                    drawSquare(3, getCords(t.getX(),t.getY()));
                }
                if (this instanceof ZPiece || this instanceof ReverseZPiece) {
                    drawSquare(4, getCords(t.getX(),t.getY()));
                }
                if (this instanceof SquarePiece) {
                    drawSquare(5, getCords(t.getX(),t.getY()));
                }
                if (this instanceof LinePiece) {
                    drawSquare(2, getCords(t.getX(),t.getY()));
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

        public LPiece(int x, int y) {
            super(x, y);
            this.rotate();
        }
        public boolean canRotate() {
            if (this.orientation == 0) {
                if (grid[centerX][centerY -1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else if (this.orientation == 1) {
                if (this.centerX == 0) {
                    return false;
                }
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else if (this.orientation == 2) {
                if (grid[centerX - 1][centerY -1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else {
                if (this.centerX == 9) {
                    return false;
                }
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX - 1][centerY + 1] == 0){
                    return true;
                }
                return false;
            }
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
                    return;
                }
                else{
                    this.orientation--;
                    return;
                }
            }
            else if (this.orientation == 1) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX + 1, centerY - 1);
                    piece[1] = new Tuple(centerX - 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    this.findShadow();
                    return;
                }
                else{
                    this.orientation--;
                    return;
                }


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
                int t1 = piece[2].getY();
                int t2 = piece[3].getY();
                while (t1 < 23 && t2 < 23 &&grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;

                }
                shadow[0] = new Tuple(piece[2].getX(),t1);
                shadow[1] = new Tuple(piece[3].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(), t1 -1);
                shadow[3] = new Tuple(piece[2].getX(), t1 - 2);
            }
            else if (this.orientation == 1) {
                int t1 = piece[1].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 < 23 && t2 < 23 && t3 < 23 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0 && grid[piece[1].getX()][t1 + 1] == 0 ) {
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
                int t1 = piece[0].getY();
                int t2 = piece[3].getY();
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
                int t1 = piece[1].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 < 23 && t2 < 23  && t3 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1 + 1);
                shadow[1] = new Tuple(piece[1].getX(), t1);
                shadow[2] = new Tuple(piece[2].getX(), t1);
                shadow[3] = new Tuple(piece[3].getX(), t1);
            }
        }
    }
    public class ZPiece extends Piece {

        public ZPiece(int x, int y) {
            super(x, y);
            rotate();
        }
        public boolean canRotate() {
            System.out.println(centerX);
            if (this.orientation == 0) {
                if (centerX == 9) {return false;}
                if (grid[centerX + 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX - 1][centerY] == 0) {
                    return true;
                }
                return false;
            }
            if (this.orientation == 1) {
                if (centerX == 9) {return false;}
                if (grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 1][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            if (orientation == 2) {
                if (grid[centerX + 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX - 1][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else {
                if (grid[centerX - 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0) {
                    return true;
                }
                return false;

            }

        }

        @Override
        public void rotate() {
            this.orientation++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX + 1, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY - 1);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX - 1, centerY);
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
                piece[0] = new Tuple(centerX + 1, centerY);
                piece[1] = new Tuple(centerX, centerY);
                piece[2] = new Tuple(centerX, centerY + 1);
                piece[3] = new Tuple(centerX - 1, centerY + 1);
                findShadow();
            }
            else {
                piece[0] = new Tuple(centerX - 1, centerY - 1);
                piece[1] = new Tuple(centerX - 1, centerY);
                piece[2] = new Tuple(centerX, centerY);
                piece[3] = new Tuple(centerX, centerY + 1);
                findShadow();
                this.orientation = -1;
            }

        }

        @Override
        public void findShadow() {

            if (this.orientation == 0) {
                int t1 = piece[2].getY();
                int t2 = piece[3].getY();
                int t3 = piece[0].getY();
                while (t1 < 23 && t2 <23 && t3 <23 && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 && grid[piece[0].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX() - 1,t1);
                shadow[1] = new Tuple(piece[0].getX() - 2,t1);
                shadow[2] = new Tuple(piece[0].getX(),t1 - 1);
                shadow[3] = new Tuple(piece[0].getX() -1,t1 - 1);
                return;


            }
            if (this.orientation == 1) {
                int t1 = piece[1].getY();
                int t2 = piece[3].getY();
                while (t1 < 23 && t2 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1 - 1);
                shadow[2] = new Tuple(piece[1].getX(), t1);
                shadow[1] = new Tuple(piece[2].getX(), t2);
                shadow[3] = new Tuple(piece[3].getX(), t2 - 1);
                return;
            }
            if (this.orientation == 2) {
                int t1 = piece[0].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 < 23 && t2 < 23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[2] = new Tuple(piece[1].getX(), t1);
                shadow[1] = new Tuple(piece[2].getX(), t2);
                shadow[3] = new Tuple(piece[3].getX(), t2);
                return;
            }
            else {
                int t1 = piece[1].getY();
                int t2 = piece[3].getY();
                while (t1 < 23 && t2 < 23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(), t1);
                shadow[2] = new Tuple(piece[1].getX(), t1 - 1);
                shadow[1] = new Tuple(piece[2].getX(), t2);
                shadow[3] = new Tuple(piece[3].getX(), t2 - 1);
                return;
            }
        }


    }
    public class SquarePiece extends Piece {

        public SquarePiece(int x, int y) {
            super(x, y);
            rotate();
            findShadow();
        }

        @Override
        public void rotate() {
            piece[0] = new Tuple(centerX, centerY);
            piece[1] = new Tuple(centerX + 1, centerY);
            piece[2] = new Tuple(centerX + 1, centerY + 1);
            piece[3] = new Tuple(centerX, centerY + 1);

        }

        @Override
        public void findShadow() {
            int t1 = piece[2].getY();
            int t2 = piece[3].getY();
            while (t1 < 23 && t2 <23  && grid[piece[2].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                t1++;
                t2++;
            }
            shadow[0] = new Tuple(piece[0].getX(),t1);
            shadow[1] = new Tuple(piece[1].getX(),t2);
            shadow[2] = new Tuple(piece[2].getX(),t1 - 1);
            shadow[3] = new Tuple(piece[3].getX(),t2 - 1);
        }
    }
    public class TPiece extends Piece {
        int orientation = -1;
        public TPiece(int x, int y) {
            super(x, y);
            this.rotate();
            this.findShadow();
        }

        @Override
        public void rotate() {
            this.orientation ++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY - 1);
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
                    piece[2] = new Tuple(centerX, centerY + 1);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    this.findShadow();
                    return;

                }
                orientation --;
                return;
            }
            else {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY - 1);
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
            if (orientation == 0) {
                if (centerX == 9) {return false;}
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX + 1][centerY] == 0) {
                    return true;
                }
                return false;
            }
            else if (orientation == 1) {

                if (grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else if (orientation == 2) {
                if (centerX == 0) {
                    return false;
                }
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY] == 0) {
                    return true;
                }
                return false;
            }
            else {

                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
        }

        @Override
        public void findShadow() {
            if (this.orientation == 0) {
                int t1 = piece[0].getY();
                int t2 = piece[1].getY();
                int t3 = piece[3].getY();
                while (t1 < 23 && t2 <23 && t3 <23  && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[1].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1 ++;
                    t2++;
                    t3++;
                }
                shadow[3] = new Tuple(piece[0].getX(),t2);
                shadow[2] = new Tuple(piece[1].getX(),t2);
                shadow[1] = new Tuple(piece[2].getX(),t2 - 1);
                shadow[0] = new Tuple(piece[3].getX(),t2);
                return;
            }
            if (this.orientation == 1) {
                int t1 = piece[3].getY();
                int t2 = piece[2].getY();
                while (t1 < 23 && t2 <23   && grid[piece[3].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0) {
                    t1 ++;
                    t2++;
                }
                shadow[3] = new Tuple(piece[0].getX(),t1);
                shadow[2] = new Tuple(piece[1].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[2].getX(),t2);
                shadow[0] = new Tuple(piece[3].getX(),t1 - 2);
                return;
            }
            if (this.orientation == 2   ) {
                int t1 = piece[0].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 < 23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1 ++;
                    t2++;
                    t3++;
                }
                shadow[3] = new Tuple(piece[0].getX(),t1);
                shadow[2] = new Tuple(piece[1].getX(),t2);
                shadow[1] = new Tuple(piece[2].getX(),t3);
                shadow[0] = new Tuple(piece[3].getX(),t1);
                return;
            }
            else {
                int t1 = piece[0].getY();
                int t2 = piece[3].getY();
                while (t1 < 23 && t2 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0) {
                    t1 ++;
                    t2++;
                }
                shadow[3] = new Tuple(piece[3].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t2);
                shadow[0] = new Tuple(piece[0].getX(),t1);
                return;

            }


        }
    }
    public class LinePiece extends Piece {

        public LinePiece(int x, int y) {
            super(x, y);
            rotate();
            findShadow();
        }

        public boolean canRotate() {
            if (this.orientation == 0) {
                if (grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX][centerY + 2] == 0) {
                    return true;
                }
                return false;
            }
            else {
                if (centerX == 0 || centerX == 8 || centerX == 9) {return false;}
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 2][centerY] == 0) {
                    return true;
                }
                return false;
            }
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
                if (canRotate()) {piece[0] = new Tuple(centerX - 1, centerY);
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
                int t1 = piece[3]. getY();
                while (t1 <23  && grid[piece[3].getX()][t1 + 1] == 0) {
                    t1++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[0].getX(),t1-1);
                shadow[2] = new Tuple(piece[0].getX(),t1-2);
                shadow[3] = new Tuple(piece[0].getX(),t1-3  );
                return;
            }
            else {
                int t1 = piece[0]. getY();
                int t2 = piece[1]. getY();
                int t3 = piece[2]. getY();
                int t4 = piece[3]. getY();
                while (t1 <23  && t2 <23  && t3 <23  && t4 <23  && grid[piece[0].getX()][t1 + 1] == 0  && grid[piece[1].getX()][t2 + 1] == 0  && grid[piece[2].getX()][t3 + 1] == 0  && grid[piece[3].getX()][t4 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                    t4++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t1);
                return;
            }


        }

    }
    public class ReverseLPiece extends Piece {

        public ReverseLPiece(int x, int y) {
            super(x, y);
            rotate();
            findShadow();
        }

        public boolean canRotate() {
            if (this.orientation == 0) {
                if (this.centerX == 9) {return false;}
                if (grid[centerX - 1][centerY - 1] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0) {
                    return true;
                }
                return false;
            }
            if (this.orientation == 1) {
                if (grid[centerX + 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0) {return true;}
                return false;
            }
            if (this.orientation == 2) {
                if (this.centerX == 0) {return false;}
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX + 1][centerY + 1] == 0) {
                    return true;
                }
                return false;
            }
            else { if(grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX - 1][centerY + 1] == 0) {
            return true;
            }
            return false;
            }
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
                    piece[0] = new Tuple(centerX + 1, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY - 1);
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
            System.out.println(this.orientation);
            if (orientation == 0) {
                int t1 = piece[1].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
                shadow[1] = new Tuple(piece[1].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(),t3);
                shadow[3] = new Tuple(piece[3].getX(),t3);
                return;
            }
            if (orientation == 1) {
                int t1 = piece[0].getY();
                int t2 = piece[3].getY();
                while (t1 <23 && t2 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[0].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(),t1);
                shadow[3] = new Tuple(piece[3].getX(),t2 - 1);
                return;
            }
            if (orientation == 2) {
                int t1 = piece[0].getY();
                int t2 = piece[1].getY();
                int t3 = piece[3].getY();
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
                int t1 = piece[2].getY();
                int t2 = piece[3].getY();
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

        public ReverseZPiece(int x, int y) {
            super(x, y);
            rotate();
            findShadow();
        }

        public boolean canRotate() {
            if (this.orientation == 0) {
                if (centerX == 9) {
                    return false;
                }

                if (grid[centerX - 1][centerY - 1] == 0 && grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX + 1][centerY] == 0) {
                    return  true;
                }
                return false;
            }
            if (this.orientation == 1) {

                if (grid[centerX + 1][centerY -1] == 0 && grid[centerX + 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY  + 1] == 0) {
                    return true;
                }
                return false;
            }
            if (this.orientation == 2) {
                if (centerX == 0) {
                    return false;
                }
                if (grid[centerX - 1][centerY] == 0 && grid[centerX][centerY] == 0 && grid[centerX][centerY + 1] == 0 && grid[centerX + 1][centerY  + 1] == 0) {
                    return true;
                }
                return false;
            }
            else {
                if (grid[centerX][centerY - 1] == 0 && grid[centerX][centerY] == 0 && grid[centerX - 1][centerY] == 0 && grid[centerX - 1][centerY  + 1] == 0) {
                    return true;
                }
                return false;
            }
        }

        @Override
        public void rotate() {
            this.orientation ++;
            if (this.orientation == 0) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY - 1);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX + 1, centerY);
                    findShadow();
                    return;
                }
                this.orientation--;
                return;
            }
            if (this.orientation == 1) {
                if (canRotate()) {piece[0] = new Tuple(centerX + 1, centerY -1);
                    piece[1] = new Tuple(centerX + 1, centerY);
                    piece[2] = new Tuple(centerX, centerY);
                    piece[3] = new Tuple(centerX, centerY  + 1);
                    findShadow();
                    return;}
                this.orientation--;
                return;

            }
            if (this.orientation == 2) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX - 1, centerY);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX, centerY + 1);
                    piece[3] = new Tuple(centerX + 1, centerY  + 1);
                    findShadow();
                    return;}
                    this.orientation--;
                    return;

            }
            if (this.orientation == 3) {
                if (canRotate()) {
                    piece[0] = new Tuple(centerX, centerY - 1);
                    piece[1] = new Tuple(centerX, centerY);
                    piece[2] = new Tuple(centerX - 1, centerY);
                    piece[3] = new Tuple(centerX - 1, centerY  + 1);
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
                int t1 = piece[0].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0) {
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
                int t1 = piece[1].getY();
                int t2 = piece[3].getY();
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
                int t1 = piece[0].getY();
                int t2 = piece[2].getY();
                int t3 = piece[3].getY();
                while (t1 <23 && t2 <23 && t3 <23 && grid[piece[0].getX()][t1 + 1] == 0 && grid[piece[2].getX()][t2 + 1] == 0 && grid[piece[3].getX()][t3 + 1] == 0 ) {
                    t1++;
                    t2++;
                    t3++;
                }
                shadow[0] = new Tuple(piece[3].getX(),t2);
                shadow[1] = new Tuple(piece[1].getX(),t2);
                shadow[2] = new Tuple(piece[2].getX(),t3 - 1);
                shadow[3] = new Tuple(piece[0].getX(),t3 - 1);
                return;
            }
            else {
                int t1 = piece[1].getY();
                int t2 = piece[3].getY();
                while (t1 <23 && t2 <23 && grid[piece[1].getX()][t1 + 1] == 0 && grid[piece[3].getX()][t2 + 1] == 0 ) {
                    t1++;
                    t2++;
                }
                shadow[0] = new Tuple(piece[3].getX(),t1);
                shadow[1] = new Tuple(piece[1].getX(),t1 - 1);
                shadow[2] = new Tuple(piece[2].getX(),t2);
                shadow[3] = new Tuple(piece[0].getX(),t1);
                return;
            }
        }
    }
    }


