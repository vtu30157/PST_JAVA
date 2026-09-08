import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            String s = sc.nextLine().trim();
            int n = s.length();
            int half = n / 2;
            
            int[] countA = new int[26];
            int[] countB = new int[26];
            
            for (int i = 0; i < half; i++) {
                countA[s.charAt(i) - 'a']++;
            }
            
            for (int i = n - half; i < n; i++) {
                countB[s.charAt(i) - 'a']++;
            }
            
            boolean isLapindrome = true;
            for (int i = 0; i < 26; i++) {
                if (countA[i] != countB[i]) {
                    isLapindrome = false;
                    break;
                }
            }
            
            sb.append(isLapindrome ? "YES" : "NO").append("\n");
        }
        
        System.out.print(sb);
    }
}