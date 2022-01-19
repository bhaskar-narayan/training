/* ii) Write a method Boolean isKingSafe(int[][]chessBoard)
Returns true if king in the given chess board is safe from the given enemies otherwise false;
NOTE: Enemies are- Horse, Camel, Queen, Elephant only
Do not consider the colour case of the chess board for traversal of camel and all.
*/

import java.util.Scanner;

public class Main2 {
    static boolean rowCheck(char[][] chessArray, int kingX) {               // This method checks horizontally for elephant
        for (int i = 0; i < 8; ++i) {
            if (chessArray[kingX][i] == 'E' || chessArray[kingX][i] == 'Q')
                return false;
        }
        return true;
    }

    static boolean colCheck(char[][] chessArray, int kingY) {               // This method checks vertically for elephant
        for (int i = 0; i < 8; ++i) {
            if (chessArray[i][kingY] == 'E' || chessArray[i][kingY] == 'Q')
                return false;
        }
        return true;
    }

    static boolean diagCheck(char[][] chessArray, int kingX, int kingY) {   // This method checks diagonally for camel
        int i, j;
        for (i = kingX, j = kingY;; --i, ++j) {
            try {
                if (chessArray[i][j] == 'C' || chessArray[i][j] == 'Q')
                    return false;
            } catch (Exception e) {
                break;
            }
        }
        for (i = kingX, j = kingY;; ++i, --j) {
            try {
                if (chessArray[i][j] == 'C' || chessArray[i][j] == 'Q')
                    return false;
            } catch (Exception e) {
                break;
            }
        }
        for (i = kingX, j = kingY;; --i, --j) {
            try {
                if (chessArray[i][j] == 'C' || chessArray[i][j] == 'Q')
                    return false;
            } catch (Exception e) {
                break;
            }
        }
        for (i = kingX, j = kingY;; ++i, ++j) {
            try {
                if (chessArray[i][j] == 'C' || chessArray[i][j] == 'Q')
                    return false;
            } catch (Exception e) {
                break;
            }
        }
        return true;
    }

    static boolean horseCheck(char[][] chessArray, int kingX, int kingY) {  // Method for checking the position of horse
        try {
            if (chessArray[kingX - 1][kingY + 2] == 'H' ||
                    chessArray[kingX - 1][kingY - 2] == 'H' ||
                    chessArray[kingX + 1][kingY + 2] == 'H' ||
                    chessArray[kingX + 1][kingY - 2] == 'H' ||
                    chessArray[kingX - 2][kingY - 1] == 'H' ||
                    chessArray[kingX - 2][kingY + 1] == 'H' ||
                    chessArray[kingX + 2][kingY - 1] == 'H' ||
                    chessArray[kingX + 2][kingY + 1] == 'H')
                return false;
        } catch (Exception e) {
        }
        return true;
    }

    static boolean isKingSafe(char[][] chessArray, int kingX, int kingY) {  // Method where all essential methods are called
        boolean rowCheckResult = rowCheck(chessArray, kingX);
        if (!rowCheckResult)
            return false;
        boolean colCheckResult = colCheck(chessArray, kingY);
        if (!colCheckResult)
            return false;
        boolean diagCheckResult = diagCheck(chessArray, kingX, kingY);
        if (!diagCheckResult)
            return false;
        boolean horseCheckResult = horseCheck(chessArray, kingX, kingY);
        if (!horseCheckResult)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int kingX, kingY;
        int xAddress, yAddress;
        char chessArray[][] = {                                         // 8x8 matrix initialization
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
        };
        Scanner scanner = new Scanner(System.in);
        System.out.println("King X: ");                                 // Initialization of location index
        kingX = scanner.nextInt();
        System.out.println("King Y: ");
        kingY = scanner.nextInt();
        chessArray[kingX][kingY] = 'K';
        System.out.println("Horse X: ");
        xAddress = scanner.nextInt();
        System.out.println("Horse Y: ");
        yAddress = scanner.nextInt();
        chessArray[xAddress][yAddress] = 'H';
        System.out.println("Camel X: ");
        xAddress = scanner.nextInt();
        System.out.println("Camel Y: ");
        yAddress = scanner.nextInt();
        chessArray[xAddress][yAddress] = 'C';
        System.out.println("Queen X: ");
        xAddress = scanner.nextInt();
        System.out.println("Queen Y: ");
        yAddress = scanner.nextInt();
        chessArray[xAddress][yAddress] = 'Q';
        System.out.println("Elephant X: ");
        xAddress = scanner.nextInt();
        System.out.println("Elephant Y: ");
        yAddress = scanner.nextInt();
        chessArray[xAddress][yAddress] = 'E';
        scanner.close();
        boolean safe = isKingSafe(chessArray, kingX, kingY);
        System.out.println(safe);
    }
}
