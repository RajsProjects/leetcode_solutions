class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need[c]++;
        }

        int required = t.length();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            if (window[c] <= need[c]) {
                required--;
            }

            while (required == 0) {

                int currentLength = right - left + 1;

                if (currentLength < minLength) {
                    minLength = currentLength;
                    start = left;
                }

                c = s.charAt(left);
                window[c]--;
                left++;

                if (window[c] < need[c]) {
                    required++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}