import java.io.*;
import java.util.*;

class Singleton {
    private static Singleton instance;
    public String t;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void printMessage() {
        System.out.println("Hello I am a singleton! Let me say " + t + " to you");
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        Singleton singleton = Singleton.getSingleInstance();
        singleton.t = s;

        singleton.printMessage();
    }
}