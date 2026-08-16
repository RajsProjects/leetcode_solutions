class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];

        for (int stone : stones) {
            count[stone % 3]++;
        }

        int c0 = count[0];
        int c1 = count[1];
        int c2 = count[2];

        // All stones are divisible by 3.
        // Alice must take one and immediately loses.
        if (c1 == 0 && c2 == 0) {
            return false;
        }

        // Even number of 0-remainer stones.
        if (c0 % 2 == 0) {
            return c1 > 0 && c2 > 0;
        }

        // Odd number of 0-remainer stones.
        return Math.abs(c1 - c2) > 2;
    }
}