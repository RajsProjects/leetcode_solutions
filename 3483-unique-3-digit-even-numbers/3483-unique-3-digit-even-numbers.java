class Solution {
    public int totalNumbers(int[] digits) {

        int[] freq = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            freq[digit]++;
        }

        int count = 0;

        for (int i = 1; i <= 9; i++) {          // Hundreds digit
            for (int j = 0; j <= 9; j++) {      // Tens digit
                for (int k = 0; k <= 8; k += 2) { // Units digit

                    // Check if we have enough copies
                    int[] used = new int[10];
                    used[i]++;
                    used[j]++;
                    used[k]++;

                    boolean possible = true;

                    for (int d = 0; d <= 9; d++) {
                        if (used[d] > freq[d]) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}