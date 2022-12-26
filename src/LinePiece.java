public class LinePiece extends Piece {

        public LinePiece(Board b) {
        	this.board = b;
            this.centerY--;
            piece[0] = new Tuple(centerX, centerY - 1);
            piece[1] = new Tuple(centerX, centerY);
            piece[2] = new Tuple(centerX, centerY + 1);
            piece[3] = new Tuple(centerX, centerY + 2);
            findShadow();
        }

        public boolean canRotate() {

            if (this.orientation == 0) { 
            	if (this.centerY < 2) {
            		if (centerX == 0|| centerX == 9) {
            			return false;
            		}
                return true;
            	}
            }
            if (this.orientation == 1) {
                if (this.centerY < 2) {
                	if (centerX == 0|| centerX == 9) {
                		return false;
                		}
                    return true;
                    }
            }


            
            if (this.orientation == 0) {
                return board.getGridValue(centerX, centerY - 1) == 0 && board.getGridValue(centerX, centerY) == 0 && 
                		board.getGridValue(centerX, centerY + 1) == 0 && board.getGridValue(centerX, centerY + 2) == 0;
            }
            else {
                if (centerX == 0|| centerX == 9) {return false;}
                return board.getGridValue(centerX - 1, centerY) == 0 && board.getGridValue(centerX, centerY) == 0 && 
                		board.getGridValue(centerX + 1, centerY) == 0 && board.getGridValue(centerX + 2, centerY) == 0;
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
                        if (this.centerY >= 1) 
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
                
                while (t1 <23  && board.getGridValue(piece[3].getX(), t1 + 1) == 0) {
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
                while (t1 <23  && t2 <23  && t3 <23  && t4 <23  && board.getGridValue(piece[0].getX(), t1 + 1) == 0  && 
                		board.getGridValue(piece[1].getX(), t2 + 1) == 0  && board.getGridValue(piece[2].getX(), t3 + 1) == 0  
                		&& board.getGridValue(piece[3].getX(), t4 + 1) == 0) {
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