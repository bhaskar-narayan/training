/* i. Write down a method boolean isNameValid(String name).
A name is valid if following conditions are satisfied:
    It does not contain any vowel more than once.
    If the name contains two 'S', then there is not any 'T' in between them (both in capital cases).
*/

import java.util.Scanner;

public class Main1 {
    static boolean isNameValid(String name) {
        int vCount = 0;
        for (int i = 0; i < name.length(); ++i) {
            if (name.charAt(i) == 'a' || name.charAt(i) == 'e' || name.charAt(i) == 'i' || name.charAt(i) == 'o' || name.charAt(i) == 'u' ||
                    name.charAt(i) == 'A' || name.charAt(i) == 'E' || name.charAt(i) == 'I' || name.charAt(i) == 'O' || name.charAt(i) == 'U')
                ++vCount;
            if (name.charAt(i) == 'S') {
                for (int j = i; j < name.length(); j++) {
                    if (name.charAt(j) == 'T') {
                        for (int k = j; k < name.length(); k++) {
                            if (name.charAt(k) == 'S')
                                return false;
                        }
                    }
                }
            }
            if (vCount == 2)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter the name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim();
        scanner.close();
        System.out.println(isNameValid(name));
    }
}