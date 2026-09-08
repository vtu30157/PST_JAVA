import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layers = Math.min(m, n) / 2;

        for (int k = 0; k < layers; k++) {
            // Build the ring coordinates in clockwise order
            List<int[]> coords = new ArrayList<>();

            int topRow = k, bottomRow = m - 1 - k;
            int leftCol = k, rightCol = n - 1 - k;

            // top row: left -> right
            for (int c = leftCol; c <= rightCol; c++) {
                coords.add(new int[]{topRow, c});
            }
            // right col: top+1 -> bottom
            for (int rr = topRow + 1; rr <= bottomRow; rr++) {
                coords.add(new int[]{rr, rightCol});
            }
            // bottom row: right-1 -> left (only if bottomRow != topRow)
            if (bottomRow != topRow) {
                for (int c = rightCol - 1; c >= leftCol; c--) {
                    coords.add(new int[]{bottomRow, c});
                }
            }
            // left col: bottom-1 -> top+1 (only if rightCol != leftCol)
            if (rightCol != leftCol) {
                for (int rr = bottomRow - 1; rr >= topRow + 1; rr--) {
                    coords.add(new int[]{rr, leftCol});
                }
            }

            int len = coords.size();
            int[] values = new int[len];
            for (int i = 0; i < len; i++) {
                values[i] = matrix[coords.get(i)[0]][coords.get(i)[1]];
            }

            int shift = r % len;
            int[] rotated = new int[len];
            for (int i = 0; i < len; i++) {
                rotated[i] = values[(i + shift) % len];
            }

            for (int i = 0; i < len; i++) {
                int[] pos = coords.get(i);
                matrix[pos[0]][pos[1]] = rotated[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
                if (j != n - 1) sb.append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}