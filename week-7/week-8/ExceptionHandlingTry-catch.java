import java.util.Scanner;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        try {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("java.lang.ArithmeticException: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("java.util.InputMismatchException");
        } finally {
            in.close();
        }
    }
}