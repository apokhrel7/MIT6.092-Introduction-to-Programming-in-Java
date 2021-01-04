package problem2;// Package is to organize all of the classes together


class Problem2 {    //having no public/private means class is only accessible to this package

    public void calcSalary(double basePay, int hours) {

        if (basePay < 8) {
            System.out.println("Base pay can't be less than $8.00 an hour");
        } 
        else if (hours > 60) {
            System.out.println("Employee can't work for more than 60 hours");
        } 
        
        else {
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
}



// Every java program has the class below to execute program
class Main {

    public static void main(String[] args) {
 
        Problem2 salary = new Problem2();
        salary.calcSalary(7.85, 43);


    }

}
