class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        // Remove both from the front
        int front = right + 1;

        // Remove both from the back
        int back = n - left;

        // Remove one from front and one from back
        int both = (left + 1) + (n - right);

        return Math.min(front, Math.min(back, both));
    }
}