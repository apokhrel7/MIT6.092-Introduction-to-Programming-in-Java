package problem7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MagicSquares {

    private final ArrayList<String> myFilesArray = new ArrayList<String>();  // File paths
    private final List<List<String>> matrixNumbs;  // Matrix style list of files

     public MagicSquares() {
         matrixNumbs = new ArrayList<List<String>>();
    }

    private void getMatrix(String textFiles) throws IOException {

        FileReader readFiles = new FileReader(textFiles);
        BufferedReader buffR = new BufferedReader(readFiles);

        String line;

        String[] numbsInRow;  // Array of rows of string numbers

        while ((line = buffR.readLine()) != null) {
            numbsInRow = line.split("\t"); // Separate by tab space

            for (String numbers : numbsInRow) {
                if (!numbers.equals("")) {  // Don't add empty lists
                    matrixNumbs.add(Arrays.asList(numbsInRow));
                    break;
                }
            }
        }
        buffR.close();
    }


    public void addFile(String textFile) {
        myFilesArray.add(textFile);
    }


    public void removeFileByPath(String textFile) {

        boolean fileExists = false;
        for (String fileName : myFilesArray) {

            if (textFile.equals(fileName)) {
                myFilesArray.remove(textFile);
                fileExists = true;
                break;
            }
        }

        if (fileExists) {
            System.out.println("\"" + textFile + "\"" + " was removed");
        }
        else {
            System.out.println("\"" + textFile + "\"" + " not found in the directory");
        }
    }


    public void removeFileByIndex(int index) throws IndexOutOfBoundsException {
        try {
            System.out.println("\"" + myFilesArray.get(index) + "\"" + " was removed\n");
            myFilesArray.remove(index);
        }
        catch (IndexOutOfBoundsException error) {
            System.out.println("Oops! " + error.getMessage() + " for removeFileIndex");
            throw error;
        }
        catch (Exception e) {
            System.out.println("Something went wrong");
            throw e;
        }
    }


    public void clearAllFiles(){
        myFilesArray.clear();
        System.out.println("All files were removed\n");
    }


    public void getMyFiles() {
        if (myFilesArray.size() != 0) {
            System.out.println("My files: ");
            for (String files : myFilesArray) {
                System.out.println("\t" + files);

            }
        }
        else {
            System.out.println("You tried to get your files, but there are no files in the directory");
        }
        System.out.println();
    }


    private boolean checkRows() {

        int sum;
        int check = 0;

        for (int i = 0; i < matrixNumbs.size(); i++) {
            sum = 0;

            for (int j = 0; j < matrixNumbs.size(); j++) {
                sum += Integer.parseInt(matrixNumbs.get(i).get(j));
            }

            if (check == 0) {
                check = sum;  // Keep sum of first row in memory
            }
            else if (sum != check) {
                return false;  // If sum in memory not the same, then row sums are not equal
            }
        }
        return true;
    }


    private boolean checkColumns() {

        int sum;
        int check = 0;

        for (int j = 0; j < matrixNumbs.size(); j++) {
            sum = 0;

            for (int i = 0; i < matrixNumbs.size() ; i++) {
                sum += Integer.parseInt(matrixNumbs.get(i).get(j));
            }

            if (check == 0) {
                check = sum; // keep sum of first row in memory
            }
            else if (check != sum) {
                return false;  // If sum in memory not the same, then row sums are not equal
            }

        }
        return true;
    }


    private boolean checkDiagonals() {

        int diagonal1 = 0;  // Sum of diagonal from left to right
        int diagonal2 = 0;  // Sum of diagonal from right to left

        for (int i = 0, j = 0; i < matrixNumbs.size() && j < matrixNumbs.size(); i++, j++) {
            diagonal1 += Integer.parseInt(matrixNumbs.get(i).get(j));
        }

        for (int i = 0, j = matrixNumbs.size() - 1; i < matrixNumbs.size() && j >= 0; i++, j--) {
            diagonal2 += Integer.parseInt(matrixNumbs.get(i).get(j));
        }

        return diagonal1 == diagonal2;
    }


    public void checkMyFiles() throws IOException {

        if (myFilesArray.size() == 0) {
            System.out.println("There are no files in the directory");
        }

        for (String textFiles : myFilesArray) {
            getMatrix(textFiles);

            File fileName = new File(textFiles);

            System.out.println(fileName.getName());
            System.out.println("\tEqual sum of rows?: " + checkRows());
            System.out.println("\tEqual sum of columns?: " + checkColumns());
            System.out.println("\tEqual sum of diagonals?: " + checkDiagonals());

            matrixNumbs.clear(); // Clears 2D Array list so it can be replaced by another file
            System.out.println();
        }
    }
}


