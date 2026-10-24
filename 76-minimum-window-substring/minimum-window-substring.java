
class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;

            if (window[c] <= need[c]) {
                required--;
            }

            while (required == 0) {
                int currentLen = right - left + 1;

                if (currentLen < minLen) {
                    minLen = currentLen;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (window[leftChar] < need[leftChar]) {
                    required++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
