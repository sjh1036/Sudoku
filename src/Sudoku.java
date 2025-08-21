import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * sudoku.
 * thank you john.
 * @author jacks
 * @version 1.01
 */
public class Sudoku {
    Board board;
    int recursionCount = 0;
    int backupCount = 0;

    /**
     * @param sc scanner
     */
    public Sudoku(Scanner sc) {
        board = new Board(sc);
    }

    /**
     * @param loc starting location
     * @return if solved
     */
    public boolean solve(Location loc) {
        if (loc == null) {
            recursionCount++;
            return true;
        } else if (board.get(loc.getRow(), loc.getColumn()) != 0) {
            recursionCount++;
            return solve(loc.next());
        } else {
            recursionCount++;
            for (int count = 1; count <= 9; count++) {
                if (board.isAllowed(loc.getRow(), loc.getColumn(), count)) {
                    board.set(loc.getRow(), loc.getColumn(), count);
                    if (solve(loc.next())) {
                        return true;
                    } else {
                        board.set(loc.getRow(), loc.getColumn(), 0);
                    }
                }
            }
            backupCount++;
            return false;
        }
    }

    /**
     * @return recursionCount
     */
    public int getRecursionCount() {
        return recursionCount;
    }

    /**
     * @return backupCount
     */
    public int getBackupCount() {
        return backupCount;
    }

    /**
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param args system arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the absolute path to the sudoku file:");
        String fileName = sc.next();
        File file = new File(fileName);

        try {
            Scanner boardScanner = new Scanner(file);
            Sudoku sudoku = new Sudoku(boardScanner);
            System.out.println("Initial configuration of the sudoku");
            System.out.println(sudoku.getBoard().toString());
            Location loc = new Location(0, 0);
            if (sudoku.solve(loc)) {
                System.out.println("Successful!");
                System.out.println("Final configuration of the sudoku");
                System.out.println(sudoku.getBoard().toString());
                System.out.println("Recursion count = " + sudoku.getRecursionCount());
                System.out.println("Backup count = " + sudoku.getBackupCount());
            } else {
                System.out.println("No solution");
                System.out.println(sudoku.getBoard().toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }

}
