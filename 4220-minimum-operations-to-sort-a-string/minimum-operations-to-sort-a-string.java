class Solution {
    public int minOperations(String s) {
        int n = s.length();

        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);

        // Already sorted
        if (s.equals(new String(sorted))) {
            return 0;
        }

        // A two-character unsorted string cannot be fixed
        if (n == 2) {
            return -1;
        }

        // One operation if either endpoint is already correct
        if (s.charAt(0) == sorted[0] ||
            s.charAt(n - 1) == sorted[n - 1]) {
            return 1;
        }

        // Count occurrences of the minimum and maximum
        char min = sorted[0];
        char max = sorted[n - 1];

        int minCount = 0;
        int maxCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == min) {
                minCount++;
            }
            if (s.charAt(i) == max) {
                maxCount++;
            }
        }

        // Unique maximum at the start and unique minimum at the end
        if (s.charAt(0) == max && maxCount == 1 &&
            s.charAt(n - 1) == min && minCount == 1) {
            return 3;
        }

        return 2;
    }
}
