import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<String> set = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            set.add(a + " " + b);
            System.out.println(set.size());
        }
    }
}