class Solution {

    static class Interval {
        int l, r, w, index;

        Interval(int l, int r, int w, int index) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.index = index;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    int[] next;
    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {

            int l = intervals.get(i).get(0);
            int r = intervals.get(i).get(1);
            int w = intervals.get(i).get(2);

            arr[i] = new Interval(l, r, w, i);
        }

        // Sort by left endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            return Integer.compare(a.r, b.r);
        });

        // Store all left endpoints
        int[] left = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = arr[i].l;
        }

        // Find next non-overlapping interval
        next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = upperBound(left, arr[i].r);
        }

        dp = new Result[n + 1][5];

        Result answer = solve(0, 4);

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }

        return result;
    }

    // First index where left[index] > target
    private int upperBound(int[] left, int target) {

        int low = 0;
        int high = left.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (left[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private Result solve(int i, int k) {

        // No intervals left
        // OR cannot select anything more
        if (i == arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // -------------------------
        // Choice 1: Skip interval
        // -------------------------

        Result skip = solve(i + 1, k);


        // -------------------------
        // Choice 2: Take interval
        // -------------------------

        Result nextResult = solve(next[i], k - 1);

        long takeScore = arr[i].w + nextResult.score;

        List<Integer> takeIndices =
                new ArrayList<>(nextResult.indices);

        takeIndices.add(arr[i].index);

        // Indices must be sorted
        Collections.sort(takeIndices);

        Result take = new Result(takeScore, takeIndices);


        // Choose better result
        dp[i][k] = better(take, skip);

        return dp[i][k];
    }

    private Result better(Result a, Result b) {

        // First maximize score
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller
        if (isSmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean isSmaller(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}