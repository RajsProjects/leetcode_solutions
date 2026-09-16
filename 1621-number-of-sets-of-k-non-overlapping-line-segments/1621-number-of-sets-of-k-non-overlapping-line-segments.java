class Solution {
    public int numberOfSets(int n, int k) {
         int MOD = 1_000_000_007;

        long[][] dp = new long[n + 1][k + 1];

        // 0 segments can be made in exactly 1 way
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= k; j++) {

            long sum = 0;

            for (int i = 2; i <= n; i++) {

                // Add dp[i - 1][j - 1]
                sum = (sum + dp[i - 1][j - 1]) % MOD;

                // Don't end a segment at i - 1
                // OR end one at i - 1
                dp[i][j] = (dp[i - 1][j] + sum) % MOD;
            }
        }

        return (int) dp[n][k];
    }
}