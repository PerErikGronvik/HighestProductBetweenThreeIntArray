import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {-10, -20, -30};           // All negative numbers without zero
        int[] array2 = {-10, -20, -30, 0};        // Negative numbers with zero
        int[] array3 = {-10, -20, 5, 6};          // Mixed numbers
        int[] array4 = {-5, -4, -3, 0};           // Negative numbers and zero
        int[] array5 = {100, 200, 300};           // All positive numbers
        int[] array6 = {0,0,0};                   // all zero
        int[] array7 = {0,0,0,0};                 // all zero
        int[] array8 = {-34,-56,0};               // Zero, but 3

        // Large
        Random random = new Random();
        int[] array9 = new int[100_000_000];
        // Fill the array with random integers between -1,000,000 and 1,000,000
        for (int i = 0; i < 100_000_000; i++) {
            array9[i] = random.nextInt(2_000_001) - 1_000_000;
        }

        printResult(array1);
        printResult(array2);
        printResult(array3);
        printResult(array4);
        printResult(array5);
        printResult(array6);
        printResult(array7);
        printResult(array8);
        long startTime = System.nanoTime();
        printResult(array9);
        long endTime = System.nanoTime();
        long durationInMillis = (endTime - startTime) / 1_000_000;
        System.out.print("Execution time for 100_000_000: " + durationInMillis + " milliseconds");
    }

    public static void printResult(int[] array) {
        try {
            int[] result = HighestProductOf3.highestProductOf3(array);
            int product = result[0] * result[1] * result[2];
            System.out.println("The numbers that give the highest product of 3 are: "
                    + Arrays.toString(result) + " with a product of: " + product);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


}
