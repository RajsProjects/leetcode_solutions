class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] best = new int[n];

        // best[i] = shortest target-sum subarray
        // completely inside [0 ... i]
        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;
        int shortest = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Since all numbers are positive
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                // Find the best previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                shortest = Math.min(shortest, len);
            }

            // Carry forward the best previous answer
            if (right == 0) {
                best[right] = shortest;
            } else {
                best[right] = Math.min(best[right - 1], shortest);
            }
        }

        return ans == INF ? -1 : ans;
    }
}