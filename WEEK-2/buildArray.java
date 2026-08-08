class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        
        // Encoding pass: store both old and new value in each slot
        for (int i = 0; i < n; i++) {
            nums[i] += n * (nums[nums[i] % n] % n);
        }
        
        // Decoding pass: extract the new value
        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }
        
        return nums;
    }
}