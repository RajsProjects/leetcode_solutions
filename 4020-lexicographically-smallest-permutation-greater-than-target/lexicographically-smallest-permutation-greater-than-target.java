class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Match target from left to right.
        int i = 0;

        while (i < n) {
            int c = target.charAt(i) - 'a';

            if (freq[c] == 0) {
                break;
            }

            freq[c]--;
            i++;
        }

        // Backtrack from the current position.
        int j = i - 1;

        // First try the mismatch position itself.
        if (i < n) {
            j = i;
        }

        while (j >= 0) {

            // If this character was part of the matched prefix,
            // put it back so we can try a larger character here.
            if (j < i) {
                freq[target.charAt(j) - 'a']++;
            }

            int current = target.charAt(j) - 'a';

            // Find the smallest character greater than target[j].
            for (int c = current + 1; c < 26; c++) {

                if (freq[c] == 0) {
                    continue;
                }

                char[] result = new char[n];

                // Keep prefix equal to target.
                for (int p = 0; p < j; p++) {
                    result[p] = target.charAt(p);
                }

                // Make the first difference here.
                result[j] = (char) ('a' + c);
                freq[c]--;

                // Fill remaining positions with smallest possible chars.
                int pos = j + 1;

                for (int x = 0; x < 26; x++) {
                    while (freq[x] > 0) {
                        result[pos++] = (char) ('a' + x);
                        freq[x]--;
                    }
                }

                return new String(result);
            }

            j--;
        }

        return "";
    }
}