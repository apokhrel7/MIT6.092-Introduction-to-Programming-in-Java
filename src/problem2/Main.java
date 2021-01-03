package problem2;// Package is to organize all of the classes together


class Problem2 {    //having no public/private means class is only accessible to this package

    public void calcSalary(double basePay, int hours) {

        if (basePay < 8) {
            System.out.println("Base pay can't be less than $8.00 an hour");
        } else if (hours > 60) {
            System.out.println("Employee can't work for more than 60 hours");
        } else {
            int overtimeHours = 0;

            if (hours > 40) {
                overtimeHours = hours - 40;
                hours = 40;
            }

            double overtime = overtimeHours * basePay * 1.5;
            double pay = hours * basePay;
            double totalSalary = pay + overtime;
            System.out.println("You must pay this employee $" + totalSalary);

        }
    }

    public void squareRoot(double number, double approximation) {

        double lower_bound = 0d;
        double upper_bound = number;
        byte steps = 0;

        double possible_root = number;

        while ((Math.abs(number - possible_root * possible_root)) >= approximation) {
            if (possible_root * possible_root > number) {
                upper_bound = possible_root;
            } else {
                lower_bound = possible_root;
            }
            possible_root = (upper_bound + lower_bound) / 2;
            steps++;
        }
        // System.out.printf() prints in with a format
        System.out.printf("Square root of %s is about %s. ", number, possible_root); //put %n at end to create new line

        String ternary = (steps == 1) ? steps + " step" : steps + " steps";
        System.out.println("It took " + ternary + " to get the root");
    }

}



// Every java program has the class below to execute program
class Main {

    public static void main(String[] args) {
        // To run in cmd -> C:\Users\Anish\IdeaProjects\learning_java_\src>java com.company.Problem1.problem1.Main
        // typing "sout" is a shortcut for System.out.println();

        Problem2 salary = new Problem2();
        salary.calcSalary(7.85, 43);

        Problem2 root_calculator = new Problem2();
        root_calculator.squareRoot(7, 0.001);



        /*
        This is a multi-line comment
        This is a multi-line comment
        This is a multi-line comment
        */

    }

}
