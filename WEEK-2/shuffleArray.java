class Solution {
    public int[] shuffle(int[] nums, int n) {
        int base = 1001; // max value + 1
        
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int y = nums[i + n];
            // store both values encoded at position i (in the first half)
            nums[i] += (y % base) * base;
        }
        
        // now fill from the back to avoid overwriting unprocessed data
        for (int i = n - 1; i >= 0; i--) {
            int encoded = nums[i];
            int x = encoded % base;
            int y = encoded / base;
            nums[2 * i] = x;
            nums[2 * i + 1] = y;
        }
        
        return nums;
    }
}