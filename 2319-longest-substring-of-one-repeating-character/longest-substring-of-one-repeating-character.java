class Solution {

    static class Node {
        int len;
        int prefix;
        int suffix;
        int best;
        char leftChar;
        char rightChar;

        Node() {}

        Node(char c) {
            len = 1;
            prefix = 1;
            suffix = 1;
            best = 1;
            leftChar = c;
            rightChar = c;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        this.s = s.toCharArray();

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char c = queryCharacters.charAt(i);

            this.s[index] = c;

            update(1, 0, n - 1, index, c);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int node, int left, int right) {

        if (left == right) {
            tree[node] = new Node(s[left]);
            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(
            int node,
            int left,
            int right,
            int index,
            char c) {

        if (left == right) {
            tree[node] = new Node(c);
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, right, index, c);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node a, Node b) {

        Node res = new Node();

        res.len = a.len + b.len;

        res.leftChar = a.leftChar;
        res.rightChar = b.rightChar;

        res.prefix = a.prefix;
        res.suffix = b.suffix;

        res.best = Math.max(a.best, b.best);

        // The two segments connect with the same character
        if (a.rightChar == b.leftChar) {

            // Prefix can extend through the entire right segment
            if (a.prefix == a.len) {
                res.prefix = a.len + b.prefix;
            }

            // Suffix can extend through the entire left segment
            if (b.suffix == b.len) {
                res.suffix = b.len + a.suffix;
            }

            // Best substring crosses the boundary
            res.best = Math.max(
                    res.best,
                    a.suffix + b.prefix
            );
        }

        return res;
    }
}