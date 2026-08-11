class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        // Find longest sequential prefix
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        // Find the smallest missing number >= sum
        int x = sum;

        while (contains(nums, x)) {
            x++;
        }

        return x;
    }

    private boolean contains(int[] nums, int x) {
        for (int num : nums) {
            if (num == x) {
                return true;
            }
        }

        return false;
    }
}