import java.util.Scanner;
import java.util.regex.Pattern;

public class Main4 {
    static boolean check(String url) {
        if (url.length() < 8)
            return false;
        try {
            if (url.substring(0, 7) == "http://" || url.substring(0, 8) == "https://") {
                if (url.substring(0, 7) == "http://") {
                    
                } else {

                }
            }
            else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("Enter your URL");
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine().trim();
        scanner.close();
        System.out.println(Pattern.matches("https?[:]//\\w*.\\w*", url));
    }
}
