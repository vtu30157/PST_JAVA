import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        List<List<Integer>> lines = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            
            List<Integer> currentLine = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                currentLine.add(Integer.parseInt(st.nextToken()));
            }
            lines.add(currentLine);
        }
        
        int q = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // line number (1-indexed)
            int y = Integer.parseInt(st.nextToken()); // position (1-indexed)
            
            try {
                int value = lines.get(x - 1).get(y - 1);
                sb.append(value).append("\n");
            } catch (IndexOutOfBoundsException e) {
                sb.append("ERROR!").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}