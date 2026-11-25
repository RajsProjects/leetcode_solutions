class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {

        if (root == null) {
            return;
        }

        path += root.val;

        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        path += "->";

        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}