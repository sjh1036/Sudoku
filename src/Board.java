import java.util.Scanner;

/**
 * reads in board from file, keeps track of numbers positions.
 * reads out board.
 * @author jacks
 * @version 1.01
 */
public class Board {

    int[][] board;

    /**
     * @param sc scanner for file
     */
    public Board(Scanner sc) {
        board = readBoard(sc);
    }

    /**
     * @param sc scanner for file
     * @return board in 2D array
     */
    public static int[][] readBoard(Scanner sc) {
        int[][] board = new int[9][9];
        boolean bool = true;

        for (int r = 0; r < 9; r++) {
            String str = sc.nextLine();
            for (int c = 0; c < 9; c++) {
                if (str.length() == 9) {
                    switch (str.charAt(c)) {
                        case '-':
                            board[r][c] = 0;
                            break;
                        case '1':
                            board[r][c] = 1;
                            break;
                        case '2':
                            board[r][c] = 2;
                            break;
                        case '3':
                            board[r][c] = 3;
                            break;
                        case '4':
                            board[r][c] = 4;
                            break;
                        case '5':
                            board[r][c] = 5;
                            break;
                        case '6':
                            board[r][c] = 6;
                            break;
                        case '7':
                            board[r][c] = 7;
                            break;
                        case '8':
                            board[r][c] = 8;
                            break;
                        case '9':
                            board[r][c] = 9;
                            break;
                        default:
                            bool = false;
                            break;

                    }
                } else {
                    bool = false;
                    break;
                }
                if (!bool) {
                    break;
                }

            }

        }

        if (bool) {
            return board;
        } else {
            return null;
        }
    }

    /**
     * @param row row
     * @param col column
     * @return number
     */
    public int get(int row, int col) {
        return board[row][col];
    }

    /**
     * @param row row
     * @param col column
     * @param value val set
     */
    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    /**
     * @param row row
     * @param number number
     * @return if in row
     */
    public boolean containsInRow(int row, int number) {
        boolean bool = false;
        for (int c = 0; c <= 8; c++) {
            if (board[row][c] == number) {
                bool = true;
                break;
            }
        }
        return bool;
    }

    /**
     * @param col column
     * @param number number
     * @return if in column
     */
    public boolean containsInCol(int col, int number) {
        boolean bool = false;
        for (int r = 0; r <= 8; r++) {
            if (board[r][col] == number) {
                bool = true;
            }
        }
        return bool;
    }

    /**
     * @param row row
     * @param col column
     * @param number number
     * @return if in box
     */
    public boolean containsInBox(int row, int col, int number) {
        int rowBox = -1;
        int colBox = -1;

        switch (row) {
            case 0:
            case 1:
            case 2:
                rowBox = 0;
                break;
            case 3:
            case 4:
            case 5:
                rowBox = 3;
                break;
            case 6:
            case 7:
            case 8:
                rowBox = 6;
                break;
        }

        colBox = switch (col) {
            case 0, 1, 2 -> 0;
            case 3, 4, 5 -> 3;
            case 6, 7, 8 -> 6;
            default -> colBox;
        };

        boolean bool = false;
        for (int r = rowBox; r <= rowBox + 2; r++) {
            for (int c = colBox; c <= colBox + 2; c++) {
                if (board[r][c] == number) {
                    bool = true;
                }
            }
        }
        return bool;
    }

    /**
     * @param row row
     * @param col column
     * @param number number
     * @return if allowed
     */
    public boolean isAllowed(int row, int col, int number) {
        if (containsInRow(row, number) || containsInCol(col, number) || containsInBox(row, col, number)) {
            return false;
        } else if (board[row][col] != 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return string format of board
     */
    public String toString() {
        String out = "";
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                out += "+-------+-------+-------+\n";
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    out += "| ";
                }
                if (board[r][c] == 0) {
                    out += "- ";
                } else {
                    out += board[r][c] + " ";
                }
            }
            out += "|\n";
        }
        out += "+-------+-------+-------+";
        return out;
    }


}

