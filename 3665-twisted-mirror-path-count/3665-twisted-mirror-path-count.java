
class Solution {

    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        long[][] right = new long[m][n];
        long[][] down = new long[m][n];

        // Robot starts at (0, 0).
        // It starts without a previous direction,
        // so we treat its initial position as one way.
        right[0][0] = 1;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == m - 1 && j == n - 1) {
                    continue;
                }

                if (grid[i][j] == 1) {

                    // Mirror:
                    // Entered from left -> reflect down
                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + right[i][j]) % MOD;
                    }

                    // Entered from above -> reflect right
                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + down[i][j]) % MOD;
                    }

                } else {

                    // Empty cell: both directions are possible
                    long ways = (right[i][j] + down[i][j]) % MOD;

                    if (j + 1 < n) {
                        right[i][j + 1] =
                            (right[i][j + 1] + ways) % MOD;
                    }

                    if (i + 1 < m) {
                        down[i + 1][j] =
                            (down[i + 1][j] + ways) % MOD;
                    }
                }
            }
        }

        return (int) ((right[m - 1][n - 1]
                     + down[m - 1][n - 1]) % MOD);
    }
}
