import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {

    // Complete the maxSubarray function below.
    static int[] maxSubarray(int[] arr) {
        int n = arr.length;

        // ----- Maximum Subarray Sum (Kadane's Algorithm) -----
        int maxEndingHere = arr[0];
        int maxSubarraySum = arr[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSubarraySum = Math.max(maxSubarraySum, maxEndingHere);
        }

        // ----- Maximum Subsequence Sum -----
        // Sum of all positive elements. If all elements are negative,
        // the best we can do is pick the single largest (least negative) element.
        int maxSubsequenceSum = 0;
        int maxElement = arr[0];
        boolean hasPositive = false;

        for (int num : arr) {
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
            maxElement = Math.max(maxElement, num);
        }

        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }

        return new int[]{maxSubarraySum, maxSubsequenceSum};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().replaceAll("\\s+$", "").split(" ");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = maxSubarray(arr);

            bufferedWriter.write(
                Arrays.stream(result)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "))
            );
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}