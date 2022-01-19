import java.util.Scanner;

public class Main3 {
    static void generatePattern(int input) {
        int firstPos = 1;
        int secondPos = input;
        int midPos = (input / 2) + 1;
        System.out.println(midPos);
        for (int i = 1; i <= input; ++i) {
            if (i == midPos) {
                for (int k = 1; k <= input; ++k) {
                    if (k == midPos) {
                        System.out.print("/ ");
                    } else 
                        System.out.print("* ");
                }
            }
            else {
                for (int j = 1; j <= input; j++) {
                    if (firstPos == j)
                        System.out.print("\\ ");                   
                    else if (secondPos == j) 
                        System.out.print("/ ");
                    else 
                        System.out.print("* ");
                }
            }
            
            System.out.print("\n");
            ++firstPos;
            --secondPos;
        }
    }
    public static void main(String[] args) {
        int input;
        System.out.println("Enter your number");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        scanner.close();
        if (input / 2 == 0 || input < 5) {
            System.out.println("Wrong input");
            System.exit(1);
        }
        generatePattern(input);
    }
}
