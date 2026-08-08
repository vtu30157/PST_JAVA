import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        // Custom comparator: for two strings a, b, place a before b
        // if concatenation (a+b) is larger than (b+a)
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        
        // Edge case: if the largest number is "0", the whole array is all zeros
        if (strs[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}