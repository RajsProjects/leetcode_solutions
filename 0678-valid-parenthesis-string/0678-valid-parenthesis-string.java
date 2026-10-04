class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }

            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }

            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // We cannot have negative minimum
            minOpen = Math.max(0, minOpen);

            // Even maximum possibility is invalid
            if (maxOpen < 0) {
                return false;
            }
        }

        // We need some possibility with zero unmatched '('
        return minOpen == 0;
    }
}