import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < n; i++) {
            primaryDiagonal += arr[i][i];
            secondaryDiagonal += arr[i][n - 1 - i];
        }

        int result = Math.abs(primaryDiagonal - secondaryDiagonal);

        System.out.println(result);
    }
}