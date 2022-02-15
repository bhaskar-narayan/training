public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
        stringBuilder.append("Narayan");
        System.out.println(stringBuilder);
    }
}
