import java.util.*;
import java.io.*;

public class Solution {

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();

        for (var grade : grades) {
            if (grade < 38) {
                result.add(grade);
                continue;
            }

            var nextMultiple = ((grade / 5) + 1) * 5;
            if (nextMultiple - grade < 3) {
                result.add(nextMultiple);
            } else {
                result.add(grade);
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        var bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();
        for (int i = 0; i < gradesCount; i++) {
            var item = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(item);
        }

        List<Integer> result = gradingStudents(grades);

        var sb = new StringBuilder();
        for (var grade : result) {
            sb.append(grade).append("\n");
        }

        System.out.print(sb);
        bufferedReader.close();
    }
}