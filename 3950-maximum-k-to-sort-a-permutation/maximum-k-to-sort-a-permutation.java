
class Solution {
    public int sortPermutation(int[] nums) {
        int k = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                k &= nums[i];
            }
        }

        return k == Integer.MAX_VALUE ? 0 : k;
    }
}
