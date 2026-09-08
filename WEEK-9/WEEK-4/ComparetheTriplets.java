import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] compareTriplets(int[] a, int[] b) {
        int[] result = new int[2];
        for (int i = 0; i < 3; i++) {
            if (a[i] > b[i]) {
                result[0]++;
            } else if (a[i] < b[i]) {
                result[1]++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st1.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] b = new int[3];
        for (int i = 0; i < 3; i++) {
            b[i] = Integer.parseInt(st2.nextToken());
        }

        int[] result = compareTriplets(a, b);

        System.out.println(result[0] + " " + result[1]);
    }
}