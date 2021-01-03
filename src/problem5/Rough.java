package problem5;


import java.util.Arrays;

class Rough {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[digits.length - 1] == 9) {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
            else if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            }
            else {
                digits[i] += 1;


            }
        }
        return digits;
    }
}


class Main {

    public static void main(String[] args) {
        Rough testing = new Rough();
        int [] digitsTest = {9,9, 8};
        System.out.println(Arrays.toString(testing.plusOne(digitsTest)));


    }

}


