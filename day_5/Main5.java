/* 5. You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
*/


import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dimension:");
        int dimension = scanner.nextInt();
        int matrix[][] = new int[dimension][dimension];
        System.out.println("Elements:");

        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j)
                matrix[i][j] = scanner.nextInt();
        }
        scanner.close();
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }
        System.out.println("");
        for (int i = 0; i < dimension / 2; ++i) {
            for (int j = i; j < dimension - i - 1; ++j) {
                int tempValueFirst = matrix[i][j];
                int tempValueSecond = matrix[j][dimension - i - 1];  
                int tempValueThird = matrix[dimension - i - 1][dimension - j - 1];  
                int tempValueFourth = matrix[dimension - j - 1][i];


                matrix[j][dimension - i - 1] = tempValueFirst;
                matrix[dimension - i - 1][dimension - j - 1] = tempValueSecond;
                matrix[dimension - j - 1][i] = tempValueThird;
                matrix[i][j] = tempValueFourth;
            } 
        }
        for (int i = 0; i < dimension; ++i) {
            for (int j = 0; j < dimension; ++j)
                System.out.print(matrix[i][j] + " ");
            System.out.println("");
        }
    }
}
