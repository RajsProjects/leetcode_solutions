class Solution {

    int n, k;
    int[] nums;

    class Node {
        int product;
        int[] prefix;

        Node() {
            prefix = new int[k];
        }
    }

    Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.nums = nums;
        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            nums[index] = value;
            update(1, 0, n - 1, index);

            // Query [start, n - 1]
            Node ans = query(1, 0, n - 1, start, n - 1);

            result[q] = ans.prefix[x];
        }

        return result;
    }

    void build(int node, int left, int right) {

        if (left == right) {

            tree[node] = new Node();

            int rem = nums[left] % k;

            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int left, int right, int index) {

        if (left == right) {

            tree[node] = new Node();

            int rem = nums[index] % k;

            tree[node].product = rem;
            tree[node].prefix[rem] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, right, index);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int left, int right, int ql, int qr) {

        if (ql <= left && right <= qr) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (qr <= mid) {
            return query(node * 2, left, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, right, ql, qr);
        }

        Node leftNode = query(node * 2, left, mid, ql, qr);
        Node rightNode = query(node * 2 + 1, mid + 1, right, ql, qr);

        return merge(leftNode, rightNode);
    }

    Node merge(Node left, Node right) {

        Node result = new Node();

        // Product of the whole combined segment
        result.product =
                (left.product * right.product) % k;

        // Prefixes completely inside LEFT
        for (int r = 0; r < k; r++) {
            result.prefix[r] += left.prefix[r];
        }

        // Prefixes that use LEFT + some prefix of RIGHT
        for (int r = 0; r < k; r++) {

            int newRemainder =
                    (left.product * r) % k;

            result.prefix[newRemainder] += right.prefix[r];
        }

        return result;
    }
}