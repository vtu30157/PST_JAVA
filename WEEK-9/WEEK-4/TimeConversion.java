import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String timeConversion(String s) {
        String period = s.substring(s.length() - 2);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, s.length() - 2); // :mm:ss

        if (period.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else { // PM
            if (hour != 12) {
                hour += 12;
            }
        }

        String hourStr = (hour < 10 ? "0" : "") + hour;
        return hourStr + rest;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        System.out.println(timeConversion(s));
    }
}