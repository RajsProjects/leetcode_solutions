class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean allEven = true;

        for (int num : nums1) {
            min = Math.min(min, num);

            if (num % 2 != 0) {
                allEven = false;
            }
        }

        return min % 2 == 1 || allEven;
    }
}