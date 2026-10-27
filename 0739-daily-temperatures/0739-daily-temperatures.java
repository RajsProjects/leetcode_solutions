class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        int[] stack = new int[n];
        int sp = -1;

        for (int i = n - 1; i >= 0; i--) {
            int current = temperatures[i];

            // Remove days with temperatures less than
            // or equal to the current temperature.
            while (sp >= 0 && current >= temperatures[stack[sp]]) {
                sp--;
            }

            // Find the nearest warmer day.
            if (sp >= 0) {
                result[i] = stack[sp] - i;
            }

            // Push the current day's index.
            stack[++sp] = i;
        }

        return result;
    }
}