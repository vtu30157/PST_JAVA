import java.util.Scanner;

class Arithmetic {
    int add(int num1, int num2) {
        return num1 + num2;
    }
}

class Adder extends Arithmetic {
}

class Solution {
    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println("My superclass is: " + adder.getClass().getSuperclass().getName());

        int num1 = 42, num2 = 13, num3 = 20;
        int sum = adder.add(num1, num2);
        sum = adder.add(sum, num3);

        System.out.println(num1 + " " + num2 + " " + num3);
    }
}