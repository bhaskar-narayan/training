/* Given a string s, find the length of the longest substring without repeating characters.
*/

import java.util.Scanner;


public class Main2 {
    public static void main(String[] args) {
        String inputString;
        Scanner scanner = new Scanner(System.in);
        inputString = scanner.nextLine().trim();
        StringBuilder tempString = new StringBuilder();
        tempString.setLength(0);
        int len = 0;
        for (int i = 0; i < inputString.length(); ++i) {
            if (len < tempString.length())
                len = tempString.length();
            if (tempString.toString().indexOf(inputString.charAt(i)) == -1) {
                tempString.append(inputString.charAt(i));
            }                
            else {
                tempString.setLength(0);
                tempString.append(inputString.charAt(i));
            }
        }
        System.out.println(len);
        scanner.close();
    }
}
