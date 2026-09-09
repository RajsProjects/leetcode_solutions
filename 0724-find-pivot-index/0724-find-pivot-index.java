class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] leftPrefix = new int[n];
        int[] rightPrefix = new int[n];

        // Left sum at index 0 = 0
        leftPrefix[0] = 0;

        // Build left sums
        for (int i = 1; i < n; i++) {
            leftPrefix[i] = leftPrefix[i - 1] + nums[i - 1];
        }

        // Right sum at last index = 0
        rightPrefix[n - 1] = 0;

        // Build right sums
        for (int i = n - 2; i >= 0; i--) {
            rightPrefix[i] = rightPrefix[i + 1] + nums[i + 1];
        }

        // Find pivot
        for (int i = 0; i < n; i++) {
            if (leftPrefix[i] == rightPrefix[i]) {
                return i;
            }
        }

        return -1;
    }
}