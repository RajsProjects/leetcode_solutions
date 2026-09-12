class NumMatrix {

    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        prefix = new int[row + 1][col + 1];

       for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {

                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int answer = prefix[row2 + 1][col2 + 1]
           - prefix[row1][col2 + 1]
           - prefix[row2 + 1][col1]
           + prefix[row1][col1];

        return answer;
    }
}

/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */