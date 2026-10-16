
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        int[] lastSeen = new int[100001];

        java.util.Arrays.fill(lastSeen, -1);

        SegmentTree tree = new SegmentTree(n);
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int previous = lastSeen[nums[i]];

            // Update starting positions where this value
            // introduces a new distinct element.
            tree.update(previous + 1, i);

            // Sum of squares for all subarrays ending at i.
            answer = (answer + tree.getSquareSum()) % MOD;

            lastSeen[nums[i]] = i;
        }

        return (int) answer;
    }

    static class SegmentTree {
        int n;
        long[] sum;
        long[] squareSum;
        long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            squareSum = new long[4 * n];
            lazy = new long[4 * n];
        }

        // Add value to every element in a segment.
        void apply(int node, int left, int right, long value) {
            long length = right - left + 1L;

            squareSum[node] =
                (squareSum[node]
                + 2L * value * sum[node] % MOD
                + value * value % MOD * length % MOD) % MOD;

            sum[node] =
                (sum[node] + value * length) % MOD;

            lazy[node] += value;
        }

        void push(int node, int left, int right) {
            if (lazy[node] == 0 || left == right) {
                return;
            }

            int mid = left + (right - left) / 2;
            long value = lazy[node];

            apply(node * 2, left, mid, value);
            apply(node * 2 + 1, mid + 1, right, value);

            lazy[node] = 0;
        }

        void update(int queryLeft, int queryRight) {
            if (queryLeft > queryRight) {
                return;
            }

            update(1, 0, n - 1, queryLeft, queryRight);
        }

        void update(int node, int left, int right,
                    int queryLeft, int queryRight) {

            if (queryRight < left || right < queryLeft) {
                return;
            }

            if (queryLeft <= left && right <= queryRight) {
                apply(node, left, right, 1);
                return;
            }

            push(node, left, right);

            int mid = left + (right - left) / 2;

            update(node * 2, left, mid,
                   queryLeft, queryRight);

            update(node * 2 + 1, mid + 1, right,
                   queryLeft, queryRight);

            sum[node] =
                (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            squareSum[node] =
                (squareSum[node * 2]
                + squareSum[node * 2 + 1]) % MOD;
        }

        long getSquareSum() {
            return squareSum[1];
        }
    }
}
