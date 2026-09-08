import java.util.*;
import java.io.*;

interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        AdvancedArithmetic myCalculator = new MyCalculator();

        System.out.print("I implemented: ");
        for (Class i : myCalculator.getClass().getInterfaces()) {
            System.out.println(i.getName());
        }

        System.out.println(myCalculator.divisor_sum(n));
    }
}