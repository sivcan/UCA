import java.util.*;

public class TestJava{
    public static void main(String args[]) {
        System.out.println("Hi!");
        Scanner scanner = new Scanner(System.in);
        String myStr = scanner.nextLine();
        int x = scanner.nextInt();
        scanner.close();

        System.out.println("The string entered is : " + myStr);
        System.out.println("The integer entered is : " + x);
    }
}
