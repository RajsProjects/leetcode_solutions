
import java.util.*;

class Solution {

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        // Step 1: Build the original tree
        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        // Step 2: Track the latest ancestor for each character
        int[] last = new int[26];
        Arrays.fill(last, -1);

        int[] newParent = new int[n];
        newParent[0] = -1;

        // Store DFS preorder
        int[] order = new int[n];
        int orderIndex = 0;

        // Iterative DFS with enter/exit events
        int[] nodeStack = new int[2 * n + 5];
        int[] prevStack = new int[2 * n + 5];
        boolean[] exitStack = new boolean[2 * n + 5];

        int top = 0;

        nodeStack[top] = 0;
        exitStack[top] = false;

        while (top >= 0) {

            int node = nodeStack[top];
            int previous = prevStack[top];
            boolean isExit = exitStack[top];

            top--;

            int c = s.charAt(node) - 'a';

            // Backtracking: restore previous ancestor
            if (isExit) {
                last[c] = previous;
                continue;
            }

            // Record preorder
            order[orderIndex++] = node;

            // Find closest matching ancestor
            previous = last[c];

            if (node != 0) {
                newParent[node] = (previous != -1)
                        ? previous
                        : parent[node];
            }

            // Current node becomes latest ancestor
            last[c] = node;

            // Schedule exit event
            top++;
            nodeStack[top] = node;
            prevStack[top] = previous;
            exitStack[top] = true;

            // Visit original children
            for (int i = children[node].size() - 1; i >= 0; i--) {

                int child = children[node].get(i);

                top++;
                nodeStack[top] = child;
                exitStack[top] = false;
            }
        }

        // Step 3: Calculate subtree sizes
        int[] answer = new int[n];
        Arrays.fill(answer, 1);

        // Process reverse preorder
        for (int i = n - 1; i > 0; i--) {

            int node = order[i];

            answer[newParent[node]] += answer[node];
        }

        return answer;
    }
}
