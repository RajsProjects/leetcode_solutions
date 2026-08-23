class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int diff = 0;
        int q1 = 0;
        int q2 = 0;

        for (int i = 0; i < half; i++) {
            char left = num.charAt(i);
            char right = num.charAt(i + half);

            if (left == '?') {
                q1++;
            } else {
                diff += left - '0';
            }

            if (right == '?') {
                q2++;
            } else {
                diff -= right - '0';
            }
        }

        if ((q1 + q2) % 2 == 1) {
            return true;
        }

        return diff != 9 * (q2 - q1) / 2;
    }
}