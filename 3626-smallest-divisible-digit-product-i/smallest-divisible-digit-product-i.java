class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (isValid(n, t)) {
                return n;
            }
            n++;
        }
    }

    private boolean isValid(int num, int t) {
        int product = 1;

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product % t == 0;
    }
}