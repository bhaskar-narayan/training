/** 3. Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true 
*/


public class Main3 {
    static boolean binarySearch(int[] array, int searchElement, int l, int r) {
        if (r >= l) {
            int midIndex = l + (r - l) / 2;
            if (array[midIndex] == searchElement)
                return true;
            if (array[midIndex] > searchElement)
                return binarySearch(array, searchElement, l, midIndex - 1);
            return binarySearch(array, searchElement, midIndex + 1, r);
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 },
        };
        int firstIndex = 0, secondIndex = 0;
        int length = matrix[0].length * matrix.length;
        int oneDimensionalArray[] = new int[length];
        for (int i = 0; i < length; ++i) {
            if (secondIndex == matrix[0].length) {
                secondIndex = 0;
                ++firstIndex;
            }
            oneDimensionalArray[i] = matrix[firstIndex][secondIndex];
            ++secondIndex;
        }
        boolean result = binarySearch(oneDimensionalArray, 3, 0, oneDimensionalArray.length - 1);
        System.out.println(result);
    }
}
