class Solution {
    public int minInsertions(String s) {

        int open = 0;
        int ans = 0;

        int i = 0;

        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                open++;
                i++;
            } 
            else {

                // We need two consecutive ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {

                    if (open > 0) {
                        open--;
                    } else {
                        // Insert '('
                        ans++;
                    }

                    i += 2;

                } else {

                    // Only one ')' exists, so we need another ')'
                    if (open > 0) {
                        open--;
                    } else {
                        // Need '(' before these ')'
                        ans++;
                    }

                    // Add the missing ')'
                    ans++;

                    i++;
                }
            }
        }

        // Every remaining '(' needs two ')'
        ans += open * 2;

        return ans;
    }
}