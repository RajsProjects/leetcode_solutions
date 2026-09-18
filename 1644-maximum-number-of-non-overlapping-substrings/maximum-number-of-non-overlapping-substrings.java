class Solution {
    public List<String> maxNumOfSubstrings(String s) {

        int n = s.length();

        // first[c] = first occurrence of character c
        // last[c]  = last occurrence of character c
        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        // Find first and last occurrence
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        // Build valid intervals
        for (int c = 0; c < 26; c++) {

            if (last[c] == -1)
                continue;

            int left = first[c];
            int right = last[c];

            boolean valid = true;

            // Check every character inside the interval
            for (int i = left; i <= right; i++) {

                int current = s.charAt(i) - 'a';

                // This character has an occurrence
                // before our interval starts
                if (first[current] < left) {
                    valid = false;
                    break;
                }

                // This character has an occurrence
                // after our interval ends
                if (last[current] > right) {
                    right = last[current];
                }
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        // Greedy: choose intervals with earliest ending position
        intervals.sort((a, b) -> a[1] - b[1]);

        List<String> result = new ArrayList<>();

        int prevEnd = -1;

        for (int[] interval : intervals) {

            int left = interval[0];
            int right = interval[1];

            if (left > prevEnd) {
                result.add(s.substring(left, right + 1));
                prevEnd = right;
            }
        }

        return result;
    }
}