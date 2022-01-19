/* iii. Find the largest number less than N whose each digit is prime number.
*/

import java.util.Scanner;

public class Main3 {
    static boolean prime(int number) {  // Determines whether a digit is prime or not
        boolean flag = true;
        if (number == 2)
            return true;
        for (int i = 2; i <= number / 2; ++i) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    static void check(int number) {     // It extracts every digit and sends it for prime check
        while (number >= 2) {
            boolean flag = true;
            int temp = number;
            while (temp != 0) {
                int rem = temp % 10;
                if (!prime(rem)) {
                    flag = false;
                    break;
                }
                temp = temp / 10;
            }
            if (flag) {
                System.out.println("The number is " + number);
                break;
            }
            --number;
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number, avoid using 0 and 1 in digits");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        check(number);
        scanner.close();
    }
}
