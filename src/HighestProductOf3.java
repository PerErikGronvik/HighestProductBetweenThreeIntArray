public class HighestProductOf3 {

    public static int[] highestProductOf3(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("The array must contain at least three elements.");
        }

        int highest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE, thirdHighest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE, secondLowest = Integer.MAX_VALUE;

        for (int number : array) {
            // Update highest values using nested if statements to increase efficiency. Loss of readability
            if (number > thirdHighest) { // Log n
                if (number > secondHighest) { // log n of log n
                    if (number > highest) { // log n of log n of log n
                        // Update highest values
                        thirdHighest = secondHighest;
                        secondHighest = highest;
                        highest = number;
                    } else {
                        // Update second and third highest
                        thirdHighest = secondHighest;
                        secondHighest = number;
                    }
                } else {
                    // Update third highest
                    thirdHighest = number;
                }
            }

            // Update lowest values
            if (number < secondLowest) { // log n
                if (number < lowest) { // log n of log n
                    // Update lowest values
                    secondLowest = lowest;
                    lowest = number;
                } else {
                    // Update second lowest
                    secondLowest = number;
                }
            }
        }

        // Calculate possible products
        int productOf3Highest = highest * secondHighest * thirdHighest;
        int productOf2LowestAndHighest = lowest * secondLowest * highest;

        // Find the highest product
        int highestProduct = Math.max(productOf3Highest, productOf2LowestAndHighest);

        // If the highest product is less than or equal to zero
        if (highestProduct <= 0) {
            // Check if zero is present in the array
            boolean hasZero = false;
            for (int number : array) {
                if (number == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (hasZero) {
                return new int[]{0, 0, 0};
            }
        }

        // Return the three numbers that give the highest product
        if (productOf3Highest > productOf2LowestAndHighest) {
            return new int[]{highest, secondHighest, thirdHighest};
        } else {
            return new int[]{lowest, secondLowest, highest};
        }
    }
}
