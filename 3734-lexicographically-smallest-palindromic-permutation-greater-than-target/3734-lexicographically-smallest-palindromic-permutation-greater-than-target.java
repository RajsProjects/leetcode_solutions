class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // A palindrome can have at most one odd-frequency character.
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if ((cnt[i] & 1) == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int halfLen = n / 2;

        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        // Try to construct the smallest palindrome >= target
        // by building its left half greedily.
        StringBuilder left = new StringBuilder();

        for (int i = 0; i < halfLen; i++) {
            int targetChar = target.charAt(i) - 'a';

            // First try to keep the prefix equal to target.
            if (half[targetChar] > 0) {
                half[targetChar]--;
                left.append((char) ('a' + targetChar));
                continue;
            }

            // We cannot match target[i].
            // Try the smallest available character greater than target[i].
            int bigger = -1;

            for (int c = targetChar + 1; c < 26; c++) {
                if (half[c] > 0) {
                    bigger = c;
                    break;
                }
            }

            if (bigger != -1) {
                left.append((char) ('a' + bigger));
                half[bigger]--;

                // Fill the rest as small as possible.
                for (int c = 0; c < 26; c++) {
                    while (half[c] > 0) {
                        left.append((char) ('a' + c));
                        half[c]--;
                    }
                }

                return makePalindrome(left, middle);
            }

            // No larger character is possible at this position.
            // Backtrack to an earlier position.
            break;
        }

        /*
         * The prefix matched target's first half.
         * The resulting palindrome may already be > target
         * because of the right half.
         */
        String candidateLeft = left.toString();

        if (candidateLeft.length() == halfLen) {
            String candidate = makePalindrome(left, middle);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * Backtrack: find the rightmost position where we can
         * replace the chosen character with a larger one.
         */
        int[] originalHalf = new int[26];
        for (int i = 0; i < 26; i++) {
            originalHalf[i] = cnt[i] / 2;
        }

        for (int pos = halfLen - 1; pos >= 0; pos--) {
            int[] remaining = originalHalf.clone();

            boolean possible = true;

            // Match target's prefix before pos.
            for (int i = 0; i < pos; i++) {
                int c = target.charAt(i) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(pos) - 'a';

            // Choose the smallest character > target[pos].
            for (int c = targetChar + 1; c < 26; c++) {
                if (remaining[c] == 0) {
                    continue;
                }

                remaining[c]--;

                StringBuilder ansLeft = new StringBuilder();
                ansLeft.append(target, 0, pos);
                ansLeft.append((char) ('a' + c));

                // Fill remaining positions with the smallest chars.
                for (int x = 0; x < 26; x++) {
                    while (remaining[x] > 0) {
                        ansLeft.append((char) ('a' + x));
                        remaining[x]--;
                    }
                }

                return makePalindrome(ansLeft, middle);
            }
        }

        return "";
    }

    private String makePalindrome(StringBuilder left, char middle) {
        String right = new StringBuilder(left).reverse().toString();

        if (middle != 0) {
            return left.toString() + middle + right;
        }

        return left.toString() + right;
    }
}