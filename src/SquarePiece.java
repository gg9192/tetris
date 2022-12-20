public class SquarePiece extends Piece {

        public SquarePiece(Board b) {
        	this.board = b;
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
                            
                        	if (board.getGridValue(t.getX() - 1, t.getY()) != 0) {
                                return false;
                            }
                        }
                    }

                    else if (this.orientation == 2){
                        if (this.centerY > -1) {
                            
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

        }

        @Override
        public void findShadow() {
            int t1 = 0;
            int t2 = 0;
            if (piece[2].getY() > 0 && piece[3].getY() > 0) {
                t1 = piece[2].getY();
                t2 = piece[3].getY();
            }
            
            while (t1 < 23 && t2 <23  && board.getGridValue(piece[2].getX(), t1 + 1) == 0 && board.getGridValue(piece[3].getX(), t2 + 1) == 0) {
                t1++;
                t2++;
            }
            shadow[0] = new Tuple(piece[0].getX(),t1 - 1);
            shadow[1] = new Tuple(piece[1].getX(),t2 - 1);
            shadow[2] = new Tuple(piece[2].getX(),t1);
            shadow[3] = new Tuple(piece[3].getX(),t2);
        }
    }