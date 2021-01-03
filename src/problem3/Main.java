package problem3;

class Marathon{

    public int fastestRunner(int [] listTimes) {
        int minNumber = 2_000_000;  // Set value for the class attribute
        int index = 0;

        for (int runner = 0; runner < listTimes.length; runner++) {
            if (listTimes[runner] < minNumber) {
                minNumber = listTimes[runner];
                index = runner;
            }
        }

        return index; // return index of fastest person
    }
}


class Main {

    public static void main(String[] args) {

        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };

        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };

        Marathon person = new Marathon();
        int fastestIndex = person.fastestRunner(times);

        System.out.println("The fastest person was " + names[fastestIndex] + ". They finished in " +
                times[fastestIndex] + " minutes.");

    }
}
