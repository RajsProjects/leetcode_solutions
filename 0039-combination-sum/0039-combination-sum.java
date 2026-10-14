import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, path, result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int remaining,
            int startIndex,
            List<Integer> path,
            List<List<Integer>> result) {

        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int candidate = candidates[i];

            // Candidates are sorted, so later candidates will be too large.
            if (candidate > remaining) {
                break;
            }

            // 1. Choose
            path.add(candidate);

            // 2. Explore — reuse this candidate if necessary.
            backtrack(
                    candidates,
                    remaining - candidate,
                    i,
                    path,
                    result
            );

            // 3. Undo
            path.remove(path.size() - 1);
        }
    }
}