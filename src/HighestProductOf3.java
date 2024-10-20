public class HighestProductOf3 {

    public static int[] highestProductOf3(int[] array) {
        if (array.length < 3) {
            throw new IllegalArgumentException("The array must contain at least three elements.");
        }

        int highest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE, thirdHighest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE, secondLowest = Integer.MAX_VALUE;

        for (int number : array) {
            // Update highest values
            if (number > highest) {
                thirdHighest = secondHighest;
                secondHighest = highest;
                highest = number;
            } else if (number > secondHighest) {
                thirdHighest = secondHighest;
                secondHighest = number;
            } else if (number > thirdHighest) {
                thirdHighest = number;
            }

            // Update lowest values
            if (number < lowest) {
                secondLowest = lowest;
                lowest = number;
            } else if (number < secondLowest) {
                secondLowest = number;
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
