class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        double maxSum = sum;

        for(int right = k; right < nums.length; right++){
            sum += nums[right] - nums[right - k];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum/k;
    }
}