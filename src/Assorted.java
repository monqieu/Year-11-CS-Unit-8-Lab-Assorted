import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Assorted {

    /**
     * Challenge 1
     *
     * Takes a list of integer values represented as a mix of both
     * integer and string data types.
     * @param list a list of integer values represented as a mix of both
     *             integer and string data types. E.g. [12, "54", "78", 16]
     * @return the sum of the elements in the list as if all elements were
     *         integer data types.
     */
    public static int findSum(List<?> list) {
        int sum = 0;

        //loop through the list using regular for loop
        for( int i = 0; i < list.size(); i++){
           //get the current element
           Object currentElement = list.get(i);

           //check if it is a number
            if(currentElement instanceof Integer){
                // Convert currentElement to Integer type
                // Store it in variable called 'number'
                Integer number = (Integer) currentElement;
                sum = sum + number;     //add this number to the sum
            }

            if(currentElement instanceof String){
                String stringNumber = (String) currentElement;
                int number = Integer.parseInt(stringNumber);
                sum = sum + number;
            }
        }
        return sum;
    }

    /**
     * Challenge 2
     *
     * Takes a list of integers and strings and returns a new list containing
     * the integers only (filters the strings out).
     * @param list a list of integer and string values. E.g [1, 2, "a", 5]
     * @return a list containing integers only.
     */
    public static List<Integer> filterStrings(List list) {
        // Create a new empty list to store our numbers
        List<Integer> numbersOnly = new ArrayList<>();
        for( int i = 0; i < list.size(); i++){
            // get current element and store it in an object variable
            Object currentObject = list.get(i);

            //check of this object is an integer
            if(currentObject instanceof Integer){
                Integer number = (Integer) currentObject;
                numbersOnly.add(number);
            }
        }
        //return final list with only the integers
        return numbersOnly;
    }

    /**
     * Challenge 3
     *
     * Takes a list of strings and returns a new list that includes each element
     * prepended by the correct line number.
     * @param list a list of string values e.g. ["a", "b", "c"]
     * @return a list where each element is prepended by the correct line number
     *         e.g. ["1: a", "2: b", "3: c"]
     */
    public static List<String> lineNumbering(List<String> list) {
        //List<String> - storing strings like "1: a", "2: b".
        List<String> prependedList  = new ArrayList<>();

        for(int i = 0; i < list.size(); i++){
            // don't need Object here since we know it's a String
            // list parameter is List<String>, can get String directly
            String currentString = list.get(i);

            // i + 1 -> converts 0,1,2 to 1,2,3
            String numberedLine = (i+1) + ": " + currentString;

            // add to result list
            prependedList.add(numberedLine);
        }

        return prependedList;
    }

    /**
     * Challenge 4
     *
     * There is a bus moving in the city which takes and drops some people at each
     * bus stop.
     *
     * You are provided with a list (or array) of integer pairs. Elements of each pair
     * represent the number of people that get on the bus (the first item) and the number
     * of people that get off the bus (the second item) at a bus stop.
     *
     * Your task is to return the number of people who are still on the bus after the last
     * bus stop (after the last array). Even though it is the last bus stop, the bus might
     * not be empty and some people might still be inside the bus, they are probably
     * sleeping there :D
     *
     * @param list a list of integer pairs.
     * @return the number of people who are still on the bus after the last stop.
     */
    public static int busStop(List<Integer[]> list) {
        /** notes: List<Integer[]> means EACH ELEMENT in the list is an Integer array
         * each Integer array contains 2 numbers, [peopleGettingOn, peopleGettingOff]
         * e.g. [10,0] -> first bus stop, 10 people get on, 0 get off
         */

        // declare variable to track people on bus
        int peopleOnBus = 0;

        // Loop through each stop using index
        for (int i = 0; i < list.size(); i++){
            // get current bus stop array from the list using index i
            // each stop is an array with 2 numbers: [ON, OFF]
            Integer[] currentStop = list.get(i);

            // first number (index 0) is people getting on
            int peopleGettingOn = currentStop[0];

            // second number (index 1) is people getting off
            int peopleGettingOff = currentStop[1];

            // add new passengers
            peopleOnBus = peopleOnBus + peopleGettingOn;

            // remove leaving passengers
            peopleOnBus = peopleOnBus - peopleGettingOff;
         }

        return peopleOnBus;
    }

    /**
     * Challenge 5
     *
     * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
     * @param list a list of integer values. Each element is either a 0 or a 1.
     * @return the decimal value of the binary representation of the list.
     *         Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
     */

    /**
     * Binary position values
     * binary number:   1011
     * position :       3210
     * value:           8021 = 11(decimal)
     *
     * each position represents 2 raised to that power
     * 2^3 2^2 2^1 2^0
     * 8   4   2   1
     */

    public static int toBinary(List<Integer> list) {
        int result = 0;
        int power = 0;

        // start from the end of the list, least sifnificant
        for (int i = list.size() - 1; i >= 0; i--){
            if (list.get(i) == 1){
                result += Math.pow(2, power);
            }
            power++;
        }

        return result;
    }

    /**
     * Challenge 6
     *
     * Your goal is to implement a method which subtracts one list
     * from another and returns the result.
     *
     * It should remove all values from listA, which are present in listB keeping their order.
     * If a value is present in listB, all of its occurrences must be removed from listA.
     *
     * @param listA a list of integer values.
     * @param listB a list of integer values.
     * @return a list that contains the difference between listB and listA.
     *         e.g. subtractList([1,2], [1]) returns [2]
     *              subtractList([1,2,2,2,3], [2]) returns [1,3]
     */
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        List<Integer> subtractedList = new ArrayList<>();
        int intA;
        int intB;

        for(int i = 0; i< listA.size(); i++ ){
            intA = listA.get(i);
            intB = listB.get(i);

            subtractedList.add(i, intB-intA);
        }

        return subtractedList;
    }

    /**
     * Challenge 7
     *
     * Your goal is to implement a method which takes a list of integers and sorts the odd
     * numbers in ascending order while leaving the even numbers in their original positions.
     *
     * @param list a list of integers.
     * @return a list where the odd integers have been sorted in ascending order and the even
     *         integers remain in their original position.
     */
    public static List<Integer> sortOdd(List<Integer> list) {
        List<Integer> oddNumbers = new ArrayList<>();
        for (int i = 0; i < list.size(); i ++){
            if(list.get(i)%2 != 0){
                oddNumbers.add(list.get(i));
            }
        }
        Collections.sort(oddNumbers);   //sorts the odd numbers in ascending order

        List<Integer> result = new ArrayList<>();
        int oddIndex = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 == 0){
                result.add(i,list.get(i));
            } else {
                result.add(oddNumbers.get(oddIndex), list.get(i));
                oddIndex ++;
            }
        }
        return result;
    }

    /**
     * Challenge 8
     *
     * Your goal is to implement a method which takes two values (a lower bound and an upper
     * bound) and returns a list of numbers that are between the lower bound and upper bound
     * (inclusive) that have a certain property.
     *
     * The property is as follows:
     *
     * The number 89 is the first integer with more than one digit whose individual digits
     * can sum to the value 89 by raising each digit to the power of the place or column of
     * which it resides. For example, 89 = 8^1 + 9^2. The next number having this property is
     * 135. 135 = 1^1 + 3^2 + 5^3.
     *
     * @param lowerBound an integer representing the lower bound.
     * @param upperBound an integer representing the upper bound.
     * @return a list containing all the numbers between lowerBound and upperBound (inclusive)
     *         that meet the property mentioned above.
     *         e.g. uniqueNumber(1,10) returns [1,2,3,4,5,6,7,8,9]
     *              uniqueNumber(1,100) returns [1,2,3,4,5,6,7,8,9,89]
     */
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        // create list to store results
        List<Integer> result = new ArrayList<>();

        // check each number by incrementing through each in the range (bounded by upper and lowerBound)
        for (int number = lowerBound; number <= upperBound; number++){
            if(hasProperty(number)){
                result.add(number);
            }
        }
        return result;
    }

    // Helper method hasProperty to check if number has the required property
    private static boolean hasProperty(int num){
        // Convert number to string to process each digit
        String numberStr = String.valueOf(num);
        int length = numberStr.length();

        // Calculate sum of digits raised to their positions
        int sum = 0;
        for (int i = 0; i < length; i++){
            int digit = Integer.parseInt(numberStr.charAt(i) + "");
            sum += Math.pow(digit, i+1);
        }

        // returns true if sum equals the original number
        return sum == num;
    }

    /**
     * Challenge 9
     *
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've
     * been, and now they want to show Charlie their entire collection. However, Charlie doesn't
     * like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times.
     *
     * He tells them that he will only sit for the session if they show the same motif at most N
     * times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them
     * to remove numbers such that their list contains each number only up to N times, without
     * changing the order?
     *
     * @param list a list of motifs.
     * @param n the maximum number of occurrences of a specific motif that is allowed.
     * @return a list containing each motif at most n times.
     *         e.g. filterNTimes([1,2,3,1,2,1,2,3], 2) returns [1,2,3,1,2,3]
     *              filterNTimes([20,37,20,21], 1) returns [20,37,21]
     */
    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        List<Integer> result = new ArrayList<>();

        for(int num = 0; num > list.size(); num++){
            int count = 0;

            // look through our result list to count how many times we've seen this number
            for (int numResult = 0; numResult > result.size(); numResult++){
                if (num == numResult){
                    count ++;
                }
            }
            //if we haven't seen this number n times yet
            if (count < n){
                result.add(num);
            }
        }

        return result;
    }

    /**
     *
     * Challenge 10
     *
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were
     * "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST"
     * and "EAST" too.
     *
     * Going to one direction and coming back the opposite direction right away is a needless
     * effort. Since this is the wild west, with dreadful weather and not much water, it's
     * important to save yourself some energy, otherwise you might die of thirst!
     *
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following:
     *
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     *
     * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable,
     * better stay to the same place! So the task is to give to the man a simplified version
     * of the plan. A better plan in this case is simply:
     *
     * ["WEST"]
     *
     * Your task is to write a method which will take a list of strings and returns a list
     * of strings with the needless directions removed.
     *
     * @param directions a list of directions.
     * @return a list with the needless directions removed.
     *         e.g. wildWest(["NORTH", "SOUTH", "EAST", "WEST"]) returns []
     *              wildWest(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"]) returns
     *              ["WEST", "WEST"]
     */
    public static List<String> wildWest(List<String> directions) {
        // Create a working list we can modify, copy of the input list
        List<String> working = new ArrayList<>(directions);

        // Keep checking until no more pairs can be cancelled
        boolean foundPair = true;
        while (foundPair) {
            foundPair = false;
            // Check each direction with all directions that follow it
            for (int i = 0; i < working.size() - 1; i++) {
                for (int j = i + 1; j < working.size(); j++) {
                    String dir1 = working.get(i);
                    String dir2 = working.get(j);

                    if (areOpposite(dir1, dir2)) {
                        // Remove both directions (remove j first as it's larger)
                        working.remove(j);
                        working.remove(i);
                        foundPair = true;
                        break;  // break inner loop as i is now invalid
                    }
                }
                if (foundPair) break;  // break outer loop to restart checking
            }
        }

        return working;
    }

    private static boolean areOpposite(String dir1, String dir2) {
        return (dir1.equals("NORTH") && dir2.equals("SOUTH")) ||
                (dir1.equals("SOUTH") && dir2.equals("NORTH")) ||
                (dir1.equals("EAST") && dir2.equals("WEST")) ||
                (dir1.equals("WEST") && dir2.equals("EAST"));
    }

    /**
     * Challenge 11
     *
     * There is a queue for the self-checkout tills at the supermarket. Your task is to write a
     * method to calculate the total time required for all the customers to check out!
     *
     * There is only queue serving many tills.
     * The order of the queue never changes.
     * The front person in the queue (the first element in queue) proceeds to a till as soon
     * as it becomes free.
     *
     * @param queue a list of queue times. Each element represents a customer and how long
     *                  in minutes it will take them to check out.
     * @param tillsOpen the number of tills currently available for customers to use.
     * @return an integer that represents how long it will take for all the customers to check
     *         out.
     *         e.g. queueTime([5,3,4], 1) returns 12
     *              queueTime([10,2,3,3], 2) returns 10
     *              queueTime([2,3,10], 2) returns 12
     */
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        // if queue is empty, no time needed
        if (queue.isEmpty()){
            return 0;
        }

        //create array to track time remaining at each till
        int[] tills = new int[tillsOpen];

        for (int i = 0; i < queue.size(); i++){
            // Assuming first till (position 0) has least time
            int minTillIndex = 0;

            //Check each till to find the one with least time
            for(int j = 0; j < tills.length; j++){
                if(tills[j] < tills[minTillIndex]) {
                    // rewrite minTillIndex as the new found least value
                    minTillIndex = j;
                }
            }

            //queue.get(i) gets the time needed for current customer
            // add their time to the till with least waiting time
            tills[minTillIndex] += queue.get(i);
        }
        // After all customers are assigned, finding till with most time
        // Start by assuming first till has max time
        int maxTime = tills[0];

        for (int i = 0; i < tills.length; i++){
            if (tills[i] > maxTime) {
                // rewrite the new max time
                maxTime = tills[i];
            }
        }
        return maxTime;
    }
}
