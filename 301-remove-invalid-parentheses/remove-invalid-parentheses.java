class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        int left = 0;
        int right = 0;

        // Find the minimum number of '(' and ')' to remove
        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                left++;
            } 
            else if (ch == ')') {

                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right);

        return ans;
    }

    private void backtrack(String s, int start, int left, int right) {

        // We have removed the minimum required parentheses
        if (left == 0 && right == 0) {

            if (isValid(s)) {
                ans.add(s);
            }

            return;
        }

        for (int i = start; i < s.length(); i++) {

            // Avoid duplicate results
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            // Only remove parentheses
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                continue;
            }

            // Remove '('
            if (left > 0 && s.charAt(i) == '(') {

                String next =
                    s.substring(0, i) + s.substring(i + 1);

                backtrack(next, i, left - 1, right);
            }

            // Remove ')'
            if (right > 0 && s.charAt(i) == ')') {

                String next =
                    s.substring(0, i) + s.substring(i + 1);

                backtrack(next, i, left, right - 1);
            }
        }
    }

    private boolean isValid(String s) {

        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balance++;
            }
            else if (ch == ')') {

                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}