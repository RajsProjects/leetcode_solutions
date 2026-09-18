class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary-search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while (left <= right) {

            // Cut in nums1
            int partitionA = left + (right - left) / 2;

            // Cut in nums2
            int partitionB = (m + n + 1) / 2 - partitionA;

            // Elements immediately around the cuts
            int Aleft = (partitionA == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partitionA - 1];

            int Aright = (partitionA == m)
                    ? Integer.MAX_VALUE
                    : nums1[partitionA];

            int Bleft = (partitionB == 0)
                    ? Integer.MIN_VALUE
                    : nums2[partitionB - 1];

            int Bright = (partitionB == n)
                    ? Integer.MAX_VALUE
                    : nums2[partitionB];

            // Partition is too far RIGHT in nums1
            if (Aleft > Bright) {
                right = partitionA - 1;
            }

            // Partition is too far LEFT in nums1
            else if (Bleft > Aright) {
                left = partitionA + 1;
            }

            // Correct partition
            else {
                if ((m + n) % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }

                return (Math.max(Aleft, Bleft)
                        + Math.min(Aright, Bright)) / 2.0;
            }
        }

        return 0.0;
    }
}