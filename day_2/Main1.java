/* i)Write a program to remove duplicate values from an array 
and returns an array of unique values. int[] removeDuplicates(int[]values)
*/

import java.util.Scanner;


public class Main1 {
    static int[] removeDuplicates(int[] values) {   // Method where duplicates are removed
        int finalArray[] = new int[6];
        int idx = 0;
        for (int i = 0; i < 6; ++i) {
            int temp = values[i];
            int count = 0;
            for (int j = 0; j < 6; j++) {
                if (temp == values[j]) {
                    ++count;
                    if (count > 1)
                        values[j] = -999;           
                }
            }
        }
        for (int i = 0; i < 6; ++i) {
            if (values[i] != -999) {
                finalArray[idx] = values[i];
                ++idx;  
            }
        }
        return finalArray;
    }
    public static void main(String[] args) {
        int initalArray[] = new int[6];
        System.out.println("Enter your values one by one");
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; ++i)     // Array initialization
            initalArray[i] = scanner.nextInt();
        scanner.close();
        int finalArray[] = removeDuplicates(initalArray);
        for (int i = 0; i < finalArray.length; ++i) {   // Final array printing on console
            if (finalArray[i] != 0)
                System.out.print(finalArray[i] + " ");
        }    
    }
}