class Solution:
    def maxTargetNodes(self, edges1, edges2, k):
        def build_graph(edges):
            n = len(edges) + 1
            graph = [[] for _ in range(n)]
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph

        def dfs(graph, node, parent, steps):
            if steps == 0:
                return 1
            count = 1
            for neighbor in graph[node]:
                if neighbor != parent:
                    count += dfs(graph, neighbor, node, steps - 1)
            return count

        graph1 = build_graph(edges1)
        graph2 = build_graph(edges2)

        max_reach_in_graph2 = 0
        if k > 0:
            for i in range(len(graph2)):
                reach = dfs(graph2, i, -1, k - 1)
                max_reach_in_graph2 = max(max_reach_in_graph2, reach)

        result = []
        for i in range(len(graph1)):
            reach = dfs(graph1, i, -1, k)
            total_reach = reach + max_reach_in_graph2
            result.append(total_reach)

        return result
