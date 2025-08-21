/**
 * location methods of the sudoku board.
 * @author jacks
 * @version 1.01
 */
public class Location {

    int r;
    int c;

    /**
     * constructor for the location.
     * @param r row of the sudoku board
     * @param c and the column
     */
    public Location(int r, int c) {
        this.r = r;
        this.c = c;
    }

    /**
     * @return current row
     */
    public int getRow() {
        return r;
    }

    /**
     * @return current column
     */
    public int getColumn() {
        return c;
    }

    /**
     * @return next location
     */
    public Location next() {
        Location next;
        if (c == 8) {
            if (r == 8) {
                next = null;
            } else {
                next = new Location(r + 1, 0);
            }
        } else {
            next = new Location(r, c + 1);
        }
        return next;
    }

    /**
     * @return location in row, col format
     */
    public String toString() {
        return r + ", " + c;
    }
}
