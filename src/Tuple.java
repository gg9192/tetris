public class Tuple implements Comparable{
    private int x;
    private int y;
    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int i) {
        this.x = i;
    }

    public void setY(int i) {
        this.y = i;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tuple) {
            Tuple t = (Tuple) o;
            return this.x == t.x && this.y == t.y;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    @Override
    public int compareTo(Object o) {
        Tuple t = (Tuple) o;
        if (this.x == t.x && this.y == t.y) {
            return 0;
        }
        else {
            if (this.x < t.x) {
                return -1;

            }
            else if (this.x > t.x) {return 1;}

            else {
                if (this.y < t.y) {
                    return -1;

                }
                else {return 1;}
            }

        }
    }
}
