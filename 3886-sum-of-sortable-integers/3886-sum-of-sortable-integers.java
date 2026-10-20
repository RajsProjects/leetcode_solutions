
import java.util.*;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];
        int[] descents = new int[n];

        prefixMax[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i - 1]);
        }

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        for (int i = 1; i < n; i++) {
            descents[i] = descents[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int answer = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int end = start + k - 1;

                int count = descents[end] - descents[start];

                if (nums[end] > nums[start]) {
                    count++;
                }

                if (count > 1) {
                    valid = false;
                    break;
                }
            }

            if (!valid) continue;

            for (int start = k; start < n; start += k) {
                if (prefixMax[start] > suffixMin[start]) {
                    valid = false;
                    break;
                }
            }

            if (valid) answer += k;
        }

        return answer;
    }
}
