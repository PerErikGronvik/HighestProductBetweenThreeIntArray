import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array1 = {-10, -20, -30};           // All negative numbers without zero
        int[] array2 = {-10, -20, -30, 0};        // Negative numbers with zero
        int[] array3 = {-10, -20, 5, 6};          // Mixed numbers
        int[] array4 = {-5, -4, -3, 0};           // Negative numbers and zero
        int[] array5 = {100, 200, 300};           // All positive numbers

        printResult(array1);
        printResult(array2);
        printResult(array3);
        printResult(array4);
        printResult(array5);
    }

    public static void printResult(int[] array) {
        int[] result = HighestProductOf3.highestProductOf3(array);
        int product = result[0] * result[1] * result[2];
        System.out.println("The numbers that give the highest product of 3 are: " + Arrays.toString(result) + " with a product of: " + product);
    }
}
