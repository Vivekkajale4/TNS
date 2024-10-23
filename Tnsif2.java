import java.util.Scanner;

public class Tnsif2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder lowerCasePart = new StringBuilder();
        StringBuilder upperCasePart = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCasePart.append(ch);
            } else {
                lowerCasePart.append(ch);
            }
        }

        System.out.println(lowerCasePart.toString() + upperCasePart.toString());
    }
}
