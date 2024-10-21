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

        // Find the highest product to remove faulty logic
        int highestProduct = Math.max(productOf3Highest, productOf2LowestAndHighest);

        // If the highest product is less than or equal to zero
        if (highestProduct <= 0) {
            // Perform zero check outside the main loop, to avoid efficiency loss.
            boolean hasZero = false;
            for (int number : array) {
                if (number == 0) {
                    hasZero = true;
                    break;
                }
            }

            // Handle the rare edge case
            if (hasZero && highestProduct == 0 && highest <= 0) {
                // Check if not all numbers are zero, because then the product is considered defined.
                boolean allZero = true;
                for (int number : array) {
                    if (number != 0) {
                        allZero = false;
                        break;
                    }
                }
                // I have chosen to say products that contain free variables are not able to be defined. I could have returned any random combination with zero and be slightly mathematically wrong, in some cases this is desired to avoid exceptions. This is a tradeof.
                if (!allZero && array.length != 3) {
                    throw new IllegalArgumentException("One of the numbers of the highest product is zero, this causes the other values to be free. Thus, the highest product cannot be defined.");
                }
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
