class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        int n = a.length;
        int m = b.length;

        // dp[i] = number of characters of word2 that can be
        // matched exactly using word1[i...n-1].
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && a[i] == b[j]) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        while (i < n && j < m) {

            // Normal exact match
            if (a[i] == b[j]) {
                ans[j] = i;
                j++;
            }

            // Use our one allowed mismatch
            else if (dp[i + 1] >= m - j - 1) {
                ans[j] = i;
                j++;
                i++;

                // From now on, we must match exactly.
                break;
            }

            i++;
        }

        // Match the remaining characters exactly
        while (i < n && j < m) {
            if (a[i] == b[j]) {
                ans[j] = i;
                j++;
            }
            i++;
        }

        // Couldn't form word2
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}