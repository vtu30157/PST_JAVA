class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length() / 2;
        int countA = 0, countB = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
        }
        
        for (int i = n; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}