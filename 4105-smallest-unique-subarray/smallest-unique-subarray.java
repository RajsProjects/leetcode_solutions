class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        if (n == 1) return 1;

        int[] rank = nums.clone();
        Integer[] sa = new Integer[n];

        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }

        // Build suffix array using doubling
        for (int k = 1; k < n; k *= 2) {
            final int len = k;
            final int[] currentRank = rank;

            Arrays.sort(sa, (a, b) -> {
                if (currentRank[a] != currentRank[b]) {
                    return Integer.compare(currentRank[a], currentRank[b]);
                }

                int rankA = a + len < n ? currentRank[a + len] : -1;
                int rankB = b + len < n ? currentRank[b + len] : -1;

                return Integer.compare(rankA, rankB);
            });

            int[] newRank = new int[n];
            newRank[sa[0]] = 0;

            for (int i = 1; i < n; i++) {
                int a = sa[i - 1];
                int b = sa[i];

                int a1 = rank[a];
                int b1 = rank[b];

                int a2 = a + k < n ? rank[a + k] : -1;
                int b2 = b + k < n ? rank[b + k] : -1;

                newRank[b] = newRank[a];

                if (a1 != b1 || a2 != b2) {
                    newRank[b]++;
                }
            }

            rank = newRank;

            if (rank[sa[n - 1]] == n - 1) {
                break;
            }

            if (k > n / 2) break;
        }

        // Build inverse suffix-array positions
        int[] position = new int[n];

        for (int i = 0; i < n; i++) {
            position[sa[i]] = i;
        }

        // Kasai algorithm: construct LCP array
        int[] lcp = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            int pos = position[i];

            if (pos == 0) {
                common = 0;
                continue;
            }

            int j = sa[pos - 1];

            while (i + common < n &&
                   j + common < n &&
                   nums[i + common] == nums[j + common]) {
                common++;
            }

            lcp[pos] = common;

            if (common > 0) {
                common--;
            }
        }

        // Find the shortest unique subarray
        int answer = n;

        for (int i = 0; i < n; i++) {
            int pos = position[i];

            int maxLcp = lcp[pos];

            if (pos + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[pos + 1]);
            }

            int uniqueLength = maxLcp + 1;

            if (uniqueLength <= n - i) {
                answer = Math.min(answer, uniqueLength);
            }
        }

        return answer;
    }
}