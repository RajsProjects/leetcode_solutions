class Solution {
    public int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftGain = Math.max(0, dfs(root.left));
        int rightGain = Math.max(0, dfs(root.right));

        int pathThroughNode = leftGain + root.val + rightGain;

        maxSum = Math.max(maxSum, pathThroughNode);

        return root.val + Math.max(leftGain, rightGain);
    }
}