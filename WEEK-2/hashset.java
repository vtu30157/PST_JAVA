import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        Set<String> uniquePairs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String first = st.nextToken();
            String second = st.nextToken();
            
            String pair = first + " " + second;
            uniquePairs.add(pair);
            
            sb.append(uniquePairs.size()).append("\n");
        }
        
        System.out.print(sb);
    }
}