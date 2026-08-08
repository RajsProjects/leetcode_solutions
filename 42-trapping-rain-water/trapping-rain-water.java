class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n < 2) {
            return 0;
        }

        int left = 0;
        int right = n - 1;

        int leftMax = height[left];
        int rightMax = height[right];

        int sum = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }

                right--;
            }
        }

        return sum;
    }
}