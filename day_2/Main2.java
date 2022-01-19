/*  Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum. 
The function should find all triplets in the array that sum up to the target sum and return a two-dimensional array of all these triplets. 
The numbers in each triplet should be ordered in ascending order, 
and the triplets themselves should be ordered in ascending order with respect to the numbers they hold. 
If no three numbers sum up to the target sum, the function should return an empty array
*/

import java.util.Scanner;

public class Main2 {
    static int[][] arraySort(int[][] finalArray) {              // Sorting the row elements
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 2 - j; ++k) {
                    if (finalArray[i][k] > finalArray[i][k + 1]) {
                        int temp = finalArray[i][k];
                        finalArray[i][k] = finalArray[i][k + 1];
                        finalArray[i][k + 1] = temp;
                    }
                }
            }
        }
        return finalArray;
    }

    static int[][] removeDuplicates(int[][] sortedArray) {      // Removing duplicate values
        for (int i = 0; i < 50; ++i) {
            int firstTemp = sortedArray[i][0];
            int secondTemp = sortedArray[i][1];
            int thirdTemp = sortedArray[i][2];
            int count = 0;
            for (int j = 0; j < 50; ++j) {
                if (firstTemp == sortedArray[j][0] &&
                        secondTemp == sortedArray[j][1] &&
                        thirdTemp == sortedArray[j][2]) {
                    ++count;
                    if (count > 1) {
                        sortedArray[j][0] = -999;
                        sortedArray[j][1] = -999;
                        sortedArray[j][2] = -999;
                    }
                }
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int initialArray[] = new int[8];
        int finalArray[][] = new int[50][3];
        int firstIndex = 0;
        System.out.println("Enter the elements of array");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; ++i)
            initialArray[i] = scanner.nextInt();
        scanner.close();
        for (int i = 0; i < 6; ++i) {                           // Determining triplets
            for (int j = 1; j < 7; ++j) {
                for (int k = 2; k < 8; ++k) {
                    if (initialArray[i] + initialArray[j] + initialArray[k] == 10) {
                        try {                                   
                            if (finalArray[firstIndex - 1][0] == initialArray[i] &&
                                    finalArray[firstIndex - 1][1] == initialArray[j] &&
                                    finalArray[firstIndex - 1][2] == initialArray[k])
                                continue;
                        } catch (Exception e) {
                        }
                        finalArray[firstIndex][0] = initialArray[i];
                        finalArray[firstIndex][1] = initialArray[j];
                        finalArray[firstIndex][2] = initialArray[k];
                        ++firstIndex;
                    }
                }
            }
        }
        int sortedArray[][] = arraySort(finalArray);
        int uniqueArray[][] = removeDuplicates(sortedArray);
        for (int i = 0; i < 50; ++i) {
            if (uniqueArray[i][0] == 0 || uniqueArray[i][0] == -999)
                continue;
            for (int j = 0; j < 3; ++j) {
                System.out.print(uniqueArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
