class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long sum = countArea(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long countArea(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Stop if outside the grid or on water/already visited.
        if (i < 0 || i >= m || j < 0 || j >= n
                || grid[i][j] == 0) {
            return 0;
        }

        // Save the value, then mark this cell as visited.
        long sum = grid[i][j];
        grid[i][j] = 0;

        sum += countArea(grid, i - 1, j); // Up
        sum += countArea(grid, i + 1, j); // Down
        sum += countArea(grid, i, j - 1); // Left
        sum += countArea(grid, i, j + 1); // Right

        return sum;
    }
}