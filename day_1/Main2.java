/* ii. Write a program (without using inbuilt fuctions and not using Stings or array)
to swap first and last digits of any number.
*/

import java.util.Scanner;


public class Main2 {
    static int multiplier = 1;
    static int getDigit(int number) {
        int digit = number % 10;
        //System.out.println(digit);
        return digit;
    }
    static int reverseNumber(int number) {
        int reverse = 0, remainder, count = 0;
        while (number != 0) {
            remainder = number % 10;
            reverse = reverse * 10 + remainder;
            if (count > 0)
                multiplier = multiplier * 10;
            number = number / 10;
            ++count;
        }
        System.out.println(multiplier);
        return reverse;
    }
    public static void main(String[] args) {
        int inputNumber;
        int firstDigit, lastDigit;
        int reversedNumber;
        int finalNumber, preFinalNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your number");
        inputNumber = scanner.nextInt();
        scanner.close();
        lastDigit = getDigit(inputNumber);
        reversedNumber = reverseNumber(inputNumber);
        firstDigit = getDigit(reversedNumber);
        preFinalNumber = (lastDigit * multiplier) + (inputNumber - firstDigit * multiplier);
        finalNumber = (preFinalNumber / 10) * 10 + firstDigit;
        System.out.println("The final number is : " + finalNumber);
    }
}
