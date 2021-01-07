package problem7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MagicSquaresSol {
    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));

        boolean isMagic = true;
        int lastSum = -1;
        
        // For each line in the file ...
        String line;
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            String[] parts = line.split("\t");
            int sum = 0;
            for (String part : parts) {
                try {
                    sum += Integer.parseInt(part);
                }
                catch (NumberFormatException ignored) {
                }
            }

            if (lastSum == -1) {
                // If this is the first row, remember the sum
                lastSum = sum;
            } else if (lastSum != sum) {
                // if the sums don't match, it isn't magic, so stop reading
                isMagic = false;
                break;
            }
        }
        
        reader.close();
        return isMagic;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames =
                { "C:\\Users\\Anish\\Documents\\MIT Courses\\Java\\src\\problem7\\Mercury.txt",
                        "C:\\Users\\Anish\\Documents\\MIT Courses\\Java\\src\\problem7\\Luna.txt"};

        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }
}



/*package problem7;

        import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;

public class MagicSquares {
    String textFile;

    public MagicSquares(String textFile) {
        this.textFile = textFile;
    }

    public boolean checkRows(String nameOfFile) throws IOException, NumberFormatException {
        FileReader readFiles = new FileReader(nameOfFile);
        BufferedReader buffR = new BufferedReader(readFiles);

        String line;

        int check = 0;
        int sum;
        String[] numbsInRow;  // Array of rows of string numbers

        while ((line = buffR.readLine()) != null) {
            numbsInRow = line.split("\t");

            sum = 0;
            for (String numbers : numbsInRow) {
                if (!numbers.equals("")) {          // "" refers to a new row
                    sum += Integer.parseInt(numbers);  // Add sum of the numbers in current row
                }
                else {          // If a new row has started, remember previous row sum
                    sum = check;
                }
            }

            if (check == 0) {  // Store first sum of row in a variable to compare other rows
                check = sum;
            }
            else if (check != sum) {  // Not all rows equal, exit loop
                return false;
            }
        }

        buffR.close();
        return true;
    }


    public static void main(String[] args) throws IOException {
        String[] myFiles = {
                "src/problem7/Test.txt",
                "src/problem7/Mercury.txt",
                "src/problem7/Luna.txt"
        };

        MagicSquares squares = new MagicSquares();

        for(String files : textFiles) {
            System.out.println("Does " + "\"" + files + "\"" + " have equal sum of rows?: " + squares.checkRows(files));
        }
    }
}*/
