/* i) Write a method Boolean isValidSudoku(int[][]Sudoku)
Returns true if the given Sudoku is correctly arranged otherwise false.

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/

public class Main1 {
    static boolean isDuplicates(int[] partArray) {      // Method for checking duplicates (row-wise & column-wise)
        for (int i = 0; i < 9; ++i) {
            if (partArray[i] == 0)
                continue;
            int temp = partArray[i];
            int count = 0;
            for (int j = 0; j < 9; ++j) {
                if (temp == partArray[j]) {
                    ++count;
                    if (count > 1)
                        return false;
                }
            }
        }
        return true;
    }
    static boolean customDuplicatesCheck(int[][] sudokuArray, int firstIndex, int secondIndex) {    // Customized method for checking duplicates (3x3 matrix-wise)
        int tempBoxArray[] = new int[9];
        int tempBoxArrayIndex = 0;
        for (int i = firstIndex; i < firstIndex + 3; ++i) {
            for (int j = secondIndex; j < secondIndex + 3; ++j) {
                tempBoxArray[tempBoxArrayIndex] = sudokuArray[i][j];
                ++tempBoxArrayIndex;
            }
            boolean result = isDuplicates(tempBoxArray);
            if (!result)
                return false;
        }
        return true;
    }
    static boolean rowSearch(int[][] sudokuArray) {     // Method for searching row-wise
        int tempRowArray[] = new int[9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j)
                tempRowArray[j] = sudokuArray[i][j];
            boolean result = isDuplicates(tempRowArray);
            if (!result)
                return false;
        }
        return true;
    }
    static boolean colSearch(int[][] sudokuArray) {     // Method for searching column-wise
        int tempColArray[] = new int[9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j)
                tempColArray[j] = sudokuArray[j][i];
            boolean result = isDuplicates(tempColArray);
            if (!result)
                return false;
        }
        return true;
    }
    static boolean boxSearch(int[][] sudokuArray) {     // Method for searching 3x3 matrix-wise
        if (
            customDuplicatesCheck(sudokuArray, 0, 0) &&
            customDuplicatesCheck(sudokuArray, 3, 0) &&
            customDuplicatesCheck(sudokuArray, 6, 0) &&
            customDuplicatesCheck(sudokuArray, 0, 3) &&
            customDuplicatesCheck(sudokuArray, 3, 3) &&
            customDuplicatesCheck(sudokuArray, 6, 3) &&
            customDuplicatesCheck(sudokuArray, 0, 6) &&
            customDuplicatesCheck(sudokuArray, 3, 6) &&
            customDuplicatesCheck(sudokuArray, 6, 6)
        )
            return true;
        else
            return false;
    }
    static boolean isValidSudoku(int[][] sudokuArray) { // Method where all essential methods are called
        boolean rowSearchResult = rowSearch(sudokuArray);
        if (!rowSearchResult) 
            return false;
        boolean colSearchResult = colSearch(sudokuArray);
        if (!colSearchResult)
            return false;
        boolean boxSearchResult = boxSearch(sudokuArray);
        if (!boxSearchResult)
            return false;
        return true;
    }
    public static void main(String[] args) {
        int sudokuArray[][] = {                         // Initialization of 9x9 Sudoku Matrix as Two-Dimensional array
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 },
        };
        boolean valid = isValidSudoku(sudokuArray);
        System.out.println(valid);
    }
}