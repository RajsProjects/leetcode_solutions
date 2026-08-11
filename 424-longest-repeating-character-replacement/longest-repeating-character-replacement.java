class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';

            // Add current character
            freq[index]++;

            // Most frequent character in the window
            maxFreq = Math.max(maxFreq, freq[index]);

            // Shrink while window is invalid
            while ((right - left + 1) - maxFreq > k) {

                int leftIndex = s.charAt(left) - 'A';
                freq[leftIndex]--;

                left++;
            }

            // Current window is valid
            maxLength = Math.max(
                maxLength,
                right - left + 1
            );
        }

        return maxLength;
    }
}
