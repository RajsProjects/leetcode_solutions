class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {

        int[] freq = new int[100001];

        // Build frequency of absolute differences
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
        }

        int k = k1 + k2;

        // Greedily reduce the largest differences
        for (int d = 100000; d > 0 && k > 0; d--) {

            if (freq[d] == 0) {
                continue;
            }

            int move = Math.min(k, freq[d]);

            freq[d] -= move;
            freq[d - 1] += move;

            k -= move;
        }

        // Calculate final sum of squares
        long result = 0;

        for (int d = 1; d <= 100000; d++) {
            result += (long) d * d * freq[d];
        }

        return result;
    }
}