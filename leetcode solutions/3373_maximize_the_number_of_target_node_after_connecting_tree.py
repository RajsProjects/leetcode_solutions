class Solution(object):
    def maxTargetNodes(self, edges1, edges2):
        def build_graph(edges):
            n = len(edges) + 1
            graph = [[] for _ in range(n)]
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph

        def dfs(graph, node, parent, depth, parity):
            parity[node] = depth % 2
            for neighbor in graph[node]:
                if neighbor != parent:
                    dfs(graph, neighbor, node, depth + 1, parity)

        graph1 = build_graph(edges1)
        graph2 = build_graph(edges2)

        n1 = len(graph1)
        n2 = len(graph2)

        parity1 = [0] * n1
        parity2 = [0] * n2

        dfs(graph1, 0, -1, 0, parity1)
        dfs(graph2, 0, -1, 0, parity2)

        count1 = [0, 0]  # count of even and odd parity in tree1
        count2 = [0, 0]  # count of even and odd parity in tree2

        for p in parity1:
            count1[p] += 1
        for p in parity2:
            count2[p] += 1

        max_count2 = max(count2)

        result = []
        for p in parity1:
            result.append(count1[p] + max_count2)

        return result
