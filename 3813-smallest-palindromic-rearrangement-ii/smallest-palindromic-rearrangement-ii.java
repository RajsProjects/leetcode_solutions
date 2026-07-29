class Solution {
    private static final long MAX_K = 1_000_001L;

    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char mid = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
                freq[i]--;
                break;
            }
        }

        int[] half = new int[26];
        int halfLen = 0;
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            halfLen += half[i];
        }

        if (multinomial(half) < k) {
            return "";
        }

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) {
                    continue;
                }

                half[c]--;

                long ways = multinomial(half);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= (int) ways;
                half[c]++;
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if (mid != 0) {
            ans.append(mid);
        }
        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }

    private long multinomial(int[] cnt) {
        int total = 0;
        for (int x : cnt) {
            total += x;
        }

        long res = 1;

        for (int i = 0; i < 26; i++) {
            res *= binom(total, cnt[i]);
            if (res >= MAX_K) {
                return MAX_K;
            }
            total -= cnt[i];
        }

        return res;
    }

    private long binom(int n, int k) {
        if (k > n) {
            return 0;
        }

        k = Math.min(k, n - k);

        long res = 1;

        for (int i = 1; i <= k; i++) {
            res = res * (n - i + 1) / i;
            if (res >= MAX_K) {
                return MAX_K;
            }
        }

        return res;
    }
}