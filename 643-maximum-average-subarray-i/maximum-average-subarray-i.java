class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for (int right = 0; right < k; right++) {
            sum += nums[right];
        }

        double maxAverage = (double) sum / k;

        int left = 0;

        for (int right = k; right < nums.length; right++) {
            sum += nums[right] - nums[left];
            left++;

            maxAverage = Math.max(maxAverage, (double) sum / k);
        }

        return maxAverage;
    }
}