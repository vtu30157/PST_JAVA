class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0, maxSum = nums[0];
        int currMin = 0, minSum = nums[0];
        
        for (int num : nums) {
            // Standard Kadane's for max subarray sum
            currMax = Math.max(currMax + num, num);
            maxSum = Math.max(maxSum, currMax);
            
            // Kadane's variant for min subarray sum
            currMin = Math.min(currMin + num, num);
            minSum = Math.min(minSum, currMin);
            
            totalSum += num;
        }
   
        if (maxSum < 0) {
            return maxSum;
        }
        
        return Math.max(maxSum, totalSum - minSum);
    }
}