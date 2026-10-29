class Solution {
    private int[][] up;
    private int[] depth, tin, tout, prefix;
    private char[] chars;
    private FenwickXor bit;
    private int timer;

    private static class FenwickXor {
        int[] tree;
        int n;

        FenwickXor(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        void update(int index, int value) {
            for (int i = index + 1; i <= n; i += i & -i) {
                tree[i] ^= value;
            }
        }

        int query(int index) {
            int result = 0;
            for (int i = index + 1; i > 0; i -= i & -i) {
                result ^= tree[i];
            }
            return result;
        }

        void rangeUpdate(int left, int right, int value) {
            update(left, value);
            if (right + 1 < n) {
                update(right + 1, value);
            }
        }
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        chars = s.toCharArray();
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        prefix = new int[n];

        int log = 1;
        while ((1 << log) <= n) {
            log++;
        }

        up = new int[log][n];

        int[] parent = new int[n];
        int[] order = new int[n];
        int[] stack = new int[n];
        int[] subtreeSize = new int[n];

        Arrays.fill(parent, -1);

        int top = 0;
        timer = 0;

        stack[top++] = 0;
        parent[0] = 0;
        prefix[0] = 1 << (chars[0] - 'a');

        // Iterative DFS
        while (top > 0) {
            int u = stack[--top];

            tin[u] = timer;
            order[timer++] = u;

            for (int v : graph[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                prefix[v] = prefix[u]
                        ^ (1 << (chars[v] - 'a'));

                stack[top++] = v;
            }
        }

        // Calculate subtree sizes
        Arrays.fill(subtreeSize, 1);

        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            subtreeSize[parent[u]] += subtreeSize[u];
        }

        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + subtreeSize[u] - 1;
        }

        // Binary lifting table for LCA
        for (int u = 0; u < n; u++) {
            up[0][u] = parent[u];
        }

        for (int k = 1; k < log; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }

        bit = new FenwickXor(n);
        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.trim().split("\\s+");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (newChar - 'a');
                int delta = oldMask ^ newMask;

                if (delta != 0) {
                    // Updating u changes prefix masks
                    // for every node in u's subtree.
                    bit.rangeUpdate(tin[u], tout[u], delta);
                    chars[u] = newChar;
                }

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLCA(u, v);

                int prefixU = prefix[u] ^ bit.query(tin[u]);
                int prefixV = prefix[v] ^ bit.query(tin[v]);

                int pathMask = prefixU ^ prefixV
                        ^ (1 << (chars[lca] - 'a'));

                // At most one character may have odd frequency.
                answer.add(Integer.bitCount(pathMask) <= 1);
            }
        }

        return answer;
    }

    private int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < up.length; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = up.length - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }
}
