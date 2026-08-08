import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class Solution {

    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dow = date.getDayOfWeek();
        return dow.toString(); // already returns uppercase e.g. "WEDNESDAY"
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        
        int month = Integer.parseInt(st.nextToken().trim());
        int day = Integer.parseInt(st.nextToken().trim());
        int year = Integer.parseInt(st.nextToken().trim());
        
        String res = findDay(month, day, year);
        
        System.out.println(res);
        
        bufferedReader.close();
    }
}