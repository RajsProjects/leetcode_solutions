class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save the string before this '('
                stack.push(current);
                current = new StringBuilder();

            } else if (ch == ')') {
                // Reverse everything inside the parentheses
                current.reverse();

                // Restore the previous context
                StringBuilder previous = stack.pop();

                // Append reversed substring to it
                previous.append(current);

                current = previous;

            } else {
                // Normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}