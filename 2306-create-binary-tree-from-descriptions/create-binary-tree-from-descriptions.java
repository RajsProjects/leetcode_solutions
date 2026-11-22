/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/*class Solution {

    HashMap<Integer, int[]> map = new HashMap<>();

    public TreeNode createBinaryTree(int[][] descriptions) {

        HashSet<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {

            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            map.putIfAbsent(parent, new int[2]);
            map.putIfAbsent(child, new int[2]);

            if (isLeft == 1) {
                map.get(parent)[0] = child;
            } else {
                map.get(parent)[1] = child;
            }

            children.add(child);
        }

        int root = -1;

        for (int value : map.keySet()) {
            if (!children.contains(value)) {
                root = value;
                break;
            }
        }

        return buildTree(root);
    }

    private TreeNode buildTree(int value) {

        if (value == 0) {
            return null;
        }

        TreeNode node = new TreeNode(value);

        int[] child = map.get(value);

        node.left = buildTree(child[0]);
        node.right = buildTree(child[1]);

        return node;
    }
}
*/
class Solution{

    public static final TreeNode[] map = new TreeNode[100001];

    public TreeNode createBinaryTree(int[][] desc){

        TreeNode root = null;

        for(int[] a : desc){
            map[a[0]] = null;
        }

        for(int[] a : desc){
            map[a[1]] = new TreeNode(a[1]);
        }

        for(int[] a : desc){

            if(map[a[0]] == null){

                root = map[a[0]] = new TreeNode(a[0]);
            }

            if (a[2] == 1) {
                map[a[0]].left = map[a[1]];
            } else {
                map[a[0]].right = map[a[1]];
            }
        }
        return root;
    }
}