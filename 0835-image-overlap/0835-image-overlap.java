class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;
        int maxOverlap = 0;

        for (int rowShift = -(n - 1); rowShift <= n - 1; rowShift++) {

            for (int colShift = -(n - 1); colShift <= n - 1; colShift++) {

                int overlap = 0;

                for (int i = 0; i < n; i++) {

                    for (int j = 0; j < n; j++) {

                        if (img1[i][j] == 0) {
                            continue;
                        }

                        int newRow = i + rowShift;
                        int newCol = j + colShift;

                        if (newRow < 0 || newRow >= n ||
                            newCol < 0 || newCol >= n) {
                            continue;
                        }

                        if (img2[newRow][newCol] == 1) {
                            overlap++;
                        }
                    }
                }

                maxOverlap = Math.max(maxOverlap, overlap);
            }
        }

        return maxOverlap;
    }
}
