import java.util.Arrays;
import java.util.Scanner;


public class Main2 {
    static int[][] removeDuplicatesAndSort(int[][] finalArray) {
        int uniqueArray[][] = new int[50][3];
        int firstIndex = 0, secondIndex = 0;
        for (int i = 0; i < 50; ++i) {
            int firstTemp = finalArray[i][0];
            int secondTemp = finalArray[i][1];
            int thirdTemp = finalArray[i][2];
            int count = 0;
            for (int j = 0; j < 50; ++j) {
                if (firstTemp == finalArray[j][0] && secondTemp == finalArray[j][1] && thirdTemp == finalArray[j][2]) {
                    ++count;
                    if (count > 1) {
                        finalArray[j][0] = -999;
                        finalArray[j][1] = -999;
                        finalArray[j][2] = -999;
                    }
                }
            }
        }
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (finalArray[i][j] != -999) {
                    uniqueArray[firstIndex][secondIndex] = finalArray[i][j];
                    ++secondIndex;
                }
                ++firstIndex;
                secondIndex = 0;
            }
        }
        Arrays.sort(uniqueArray);
        return uniqueArray;
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
        for (int i = 0; i < 6; ++i) {
            for (int j = 1; j < 7; ++j) {
                for (int k = 2; k < 8; ++k) {
                    if (initialArray[i] + initialArray[j] + initialArray[k] == 10) {
                        System.out.println(initialArray[i] + " " + initialArray[j] + " " + initialArray[k]);
                        finalArray[firstIndex][0] = initialArray[i];
                        finalArray[firstIndex][1] = initialArray[j];
                        finalArray[firstIndex][2] = initialArray[k];
                        ++firstIndex;
                    } 
                }
            }
        }
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 3; ++j)
                System.out.print(finalArray[i][j] + " ");
            System.out.print("\n");
        }
        int sortedArray[][] = removeDuplicatesAndSort(finalArray);
        for (int i = 0; i < 50; ++i) {
            for (int j = 0; j < 3; ++j) 
                System.out.print(sortedArray[i][j] + " ");
            System.out.print("\n");
        }
    }
}
