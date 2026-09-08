import java.util.*;
import java.io.*;

class Solution {
    static void func(ArrayList AL) {
        Iterator it = AL.iterator();
        while (it.hasNext() && !it.next().equals("###"));
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int T = in.nextInt();

        ArrayList AL = new ArrayList();
        for (int i = 0; i < num; i++) {
            AL.add(in.nextInt());
        }
        AL.add("###");
        for (int i = 0; i < T; i++) {
            AL.add(in.next());
        }
        func(AL);
    }
}