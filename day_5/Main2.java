/** 2. Write a program to print all the possible combinations according to the input values.
Example :
Given Values
'1' : ['Z', 'Y', 'A'],
'2' : ['B', 'O'],
'12' : ['L']
'3' : ['U', 'P']

Input : 123
Output : [ZBU, ZBP, ZOU, ZOP, YBU, YBP, YOU, YOP, ABU, ABP, AOU, AOP, LU, LP] 
*/

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        char first[] = {'Z', 'Y', 'A'} ;
        char second[]  = {'B', 'O'};
        char firstSecond[] = {'L'};
        char third[] = {'U', 'P'};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter:");
        String inputString = scanner.nextLine().trim();
        scanner.close();
        System.out.println(inputString);
        if (inputString.length() < 2) {
            System.out.println("Wrong input");
        } else if (inputString.length() == 2) {
            if (inputString.equals("12") || inputString.equals("21")) {
                for (int i = 0; i < first.length; ++i) {
                    for (int j = 0; j < second.length; ++j) {
                        for (int k = 0; k < firstSecond.length; ++k) 
                            System.out.print(first[i] + "" + second[j] + "" + firstSecond[k] + ", ");
                    }
                }
            } else if (inputString.equals("23") || inputString.equals("32")) {
                for (int i = 0; i < second.length; ++i) {
                    for (int j = 0; j < third.length; ++j) 
                        System.out.print(second[i] + "" + third[j] + ", ");
                }
            } else if (inputString.equals("13") || inputString.equals("31")) {
                for (int i = 0; i < first.length; ++i) {
                    for (int j = 0; j < third.length; ++j) 
                        System.out.print(first[i] + "" + third[j] + ", ");
                }
            }
        } else {
            for (int i = 0; i < first.length; ++i) {
                for (int j = 0; j < second.length; ++j) {
                    for (int k = 0; k < third.length; ++k) {
                        System.out.print(first[i] + "" + second[j] + "" + third[k] + ", ");
                    }
                }
            }
            for (int i = 0; i < third.length; ++i) {
                for (int j = 0; j < firstSecond.length; ++j)
                    System.out.print(firstSecond[j] + "" + third[i] + ", ");
            }
        }
    }
}
