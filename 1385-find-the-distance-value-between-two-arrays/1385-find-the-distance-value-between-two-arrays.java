import java.util.Arrays;

class Solution {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int x : arr1) {

            int index = lowerBound(arr2, x);

            boolean valid = true;

            // Check the right-side element
            if (index < arr2.length &&
                Math.abs(arr2[index] - x) <= d) {
                valid = false;
            }

            // Check the left-side element
            if (index > 0 &&
                Math.abs(arr2[index - 1] - x) <= d) {
                valid = false;
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }

    private int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}