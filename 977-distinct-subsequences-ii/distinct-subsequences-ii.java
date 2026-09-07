class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1_000_000_007;

        long[] end = new long[26];
        long total = 0;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';

            long newEnd = (total + 1) % MOD;

            total = (total + newEnd - end[idx] + MOD) % MOD;

            end[idx] = newEnd;
        }

        return (int) total;
    }
}