public class LPiece extends Piece{

        public LPiece(Board b) {
        	this.board = b;
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX, centerY);
            piece[2] = new Tuple(centerX, centerY + 1);
            piece[3] = new Tuple(centerX + 1, centerY + 1);
            findShadow();
        }
        
        /**
         * Checks if the piece is able to rotate
         * @return a boolean based on whether the pice can rotate 
         * or not
         */
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
                    return board.getGridValue(centerX, centerY - 1) == 0 && board.getGridValue(centerX, centerY) == 0 && 
                    		board.getGridValue(centerX, centerY + 1) == 0 && board.getGridValue(centerX + 1, centerY + 1) == 0;
                	
                }
                else if (this.orientation == 1) {
                    if (this.centerX == 0) {
                        return false;
                    }
                    return board.getGridValue(centerX - 1, centerY) == 0 && board.getGridValue(centerX, centerY) == 0 && 
                    		board.getGridValue(centerX, centerY + 1) == 0 && board.getGridValue(centerX + 1, centerY + 1) == 0;
                }
                else if (this.orientation == 2) {
                	return board.getGridValue(centerX - 1, centerY - 1) == 0 && board.getGridValue(centerX, centerY - 1) == 0 && 
                    		board.getGridValue(centerX, centerY) == 0 && board.getGridValue(centerX, centerY + 1) == 0;
                    
                }
                else {
                    if (this.centerX == 9) {
                        return false;
                    }
                    return board.getGridValue(centerX - 1, centerY) == 0 && board.getGridValue(centerX, centerY) == 0 && 
                    		board.getGridValue(centerX + 1, centerY) == 0 && board.getGridValue(centerX - 1, centerY + 1) == 0;
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
                            
                        	if (board.getGridValue(t.getX() - 1, t.getY()) != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > 0) {
                            
                        	if (board.getGridValue(t.getX() - 1, t.getY()) != 0) {
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
                        	if (board.getGridValue(t.getX() + 1, t.getY()) != 0) {
                                return false;
                            }
                        }
                        else if (this.orientation == 2){
                            if (this.centerY > -1) {
                            	if (board.getGridValue(t.getX() + 1, t.getY()) != 0) {
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

                while (t1 < 23 && t2 < 23 && board.getGridValue(piece[2].getX(), t1 + 1) == 0 && board.getGridValue(piece[3].getX(), t2 + 1) == 0) {
                	
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
                
                while (t1 < 23 && t2 < 23 && t3 < 23 && board.getGridValue(piece[1].getX(), t1 + 1) == 0 && 
                		board.getGridValue(piece[2].getX(), t2 + 1) == 0 && board.getGridValue(piece[3].getX(), t3 + 1) == 0) {
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
                
                while (t1 < 23 && t2 < 23 && board.getGridValue(piece[3].getX(), t2 + 1) == 0 && board.getGridValue(piece[0].getX(), t1 + 1) == 0 ) {
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
                
                while (t1 < 23 && t2 < 23  && t3 <23 && board.getGridValue(piece[1].getX(), t1 + 1) == 0 && 
                		board.getGridValue(piece[2].getX(), t2 + 1) == 0 && board.getGridValue(piece[3].getX(), t3 + 1) == 0) {
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
