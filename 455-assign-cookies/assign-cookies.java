class Solution {
    public int findContentChildren(int[] g, int[] s) {

        // Sort both arrays concurrently
        CompletableFuture<Void> sortChildren =
                CompletableFuture.runAsync(() -> Arrays.sort(g));

        CompletableFuture<Void> sortCookies =
                CompletableFuture.runAsync(() -> Arrays.sort(s));

        // Wait for both sorting tasks to finish
        CompletableFuture.allOf(sortChildren, sortCookies).join();

        // Greedy matching
        int res = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; ) {

            if (s[j] >= g[i]) {
                res++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return res;
    }
}