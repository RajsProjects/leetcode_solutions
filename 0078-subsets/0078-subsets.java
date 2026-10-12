class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backtrack(nums, 0, path, result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int index,
            List<Integer> path,
            List<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // TAKE
        path.add(nums[index]);
        backtrack(nums, index + 1, path, result);

        // UNDO
        path.remove(path.size() - 1);

        // DON'T TAKE
        backtrack(nums, index + 1, path, result);
    }
}