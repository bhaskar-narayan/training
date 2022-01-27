/**
 * 1. Write a method void printArray(int[][]arr)
 * Prints array elements clock wise and anti-clockwise alternatively.
 * Input :
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Output :
 * 1 2 3 6 9 8 7 4 5
 * 3 2 1 4 7 8 9 6 5
 */

import java.util.Scanner;


public class Main1 {
    static void printClockWise(int[][] arr, int dimension) {
    }

    static void printAntiClockWise(int[][] arr, int dimension) {

    }

    static void printArray(int[][] arr, int dimension) {
        printClockWise(arr, dimension);
        printAntiClockWise(arr, dimension);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dimension:");
        int dimension = scanner.nextInt();
        int inputArray[][] = new int[dimension][dimension];
        System.out.println("Enter array elements one by one");
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j)
                inputArray[i][j] = scanner.nextInt();
        }
        scanner.close();
        printArray(inputArray, dimension);
    }
}