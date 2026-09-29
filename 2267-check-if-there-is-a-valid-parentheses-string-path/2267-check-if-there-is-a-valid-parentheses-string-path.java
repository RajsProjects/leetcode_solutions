class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 == 1) {
            return false;
        }

        // dp[i][j][balance]
        boolean[][][] dp = new boolean[m][n][m + n];

        // Starting cell must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Skip starting cell
                if (i == 0 && j == 0) {
                    continue;
                }

                int change = grid[i][j] == '(' ? 1 : -1;

                for (int balance = 0; balance < m + n; balance++) {

                    int newBalance = balance + change;

                    // Balance can never be negative
                    if (newBalance < 0) {
                        continue;
                    }

                    // From top
                    if (i > 0 && dp[i - 1][j][balance]) {
                        dp[i][j][newBalance] = true;
                    }

                    // From left
                    if (j > 0 && dp[i][j - 1][balance]) {
                        dp[i][j][newBalance] = true;
                    }
                }
            }
        }

        // Valid means final balance is exactly 0
        return dp[m - 1][n - 1][0];
    }
}