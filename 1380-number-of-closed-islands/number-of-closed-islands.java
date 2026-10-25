class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, visited, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        // Outside the grid
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return true;
        }

        // Water or an already visited cell
        if (grid[i][j] == 1 || visited[i][j]) {
            return true;
        }

        // Mark the land cell as visited
        visited[i][j] = true;

        // Check whether this land cell touches the boundary
        boolean isClosed = (i != 0 && i != m - 1 &&
                            j != 0 && j != n - 1);

        // Explore all four directions
        boolean up = dfs(grid, visited, i - 1, j);
        boolean down = dfs(grid, visited, i + 1, j);
        boolean left = dfs(grid, visited, i, j - 1);
        boolean right = dfs(grid, visited, i, j + 1);

        return isClosed && up && down && left && right;
    }


}
