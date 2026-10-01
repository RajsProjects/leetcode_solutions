class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] state = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            int course = req[0];
            int prerequisite = req[1];

            graph.get(prerequisite).add(course);
        }

        // Check every disconnected component
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, List<List<Integer>> graph, int[] state) {

        // Currently visiting -> cycle
        if (state[node] == 1) {
            return false;
        }

        // Already completely processed
        if (state[node] == 2) {
            return true;
        }

        // Mark as currently visiting
        state[node] = 1;

        for (int neighbor : graph.get(node)) {

            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }

        // Completely processed
        state[node] = 2;

        return true;
    }
}