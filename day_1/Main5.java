public class Main5 {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            if (i % 1 == 0 &&
                    i % 2 == 0 &&
                    i % 3 == 0 &&
                    i % 4 == 0 &&
                    i % 5 == 0 &&
                    i % 6 == 0 &&
                    i % 7 == 0 &&
                    i % 8 == 0 &&
                    i % 9 == 0) {
                System.out.println("The smallest number is " + i);
                break;
            }
            ++i;
        }
    }
}
