import java.util.*;

class Solution {
    public List<Integer> naivePatternSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        
        // Slide the pattern over text one position at a time
        for (int i = 0; i <= n - m; i++) {
            int j;
            
            // Check if pattern matches text starting at index i
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            
            // If j reached m, all characters matched
            if (j == m) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.naivePatternSearch("geeksforgeeks", "geeks"));
        // Output: [0, 8]
        
        System.out.println(sol.naivePatternSearch("aabaacaadaabaaba", "aaba"));
        // Output: [0, 9, 12]
    }
}