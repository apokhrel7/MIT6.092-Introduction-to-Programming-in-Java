package problem7;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MagicSquares squares = new MagicSquares();
        squares.addFile("src/problem7/Test.txt");
        squares.addFile("src/problem7/Luna.txt");

        // Getting added files, and checking for magic square (columns, rows, diagonals)
        squares.getMyFiles();
        squares.checkMyFiles();

        // Different ways to remove files
        squares.removeFileByPath("src/problem7/Luna.txt");
        squares.removeFileByIndex(0);

        squares.getMyFiles();
        squares.addFile("src/problem7/Mercury.txt");

        // Removing all files
        squares.clearAllFiles();
        squares.getMyFiles();
    }
}

