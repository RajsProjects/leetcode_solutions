from collections import defaultdict, deque

class Solution(object):
    def largestPathValue(self, colors, edges):
        n = len(colors)
        graph = defaultdict(list)
        indegree = [0] * n

        # Build the graph
        for u, v in edges:
            graph[u].append(v)
            indegree[v] += 1

        # count[i][c] = max count of color c (0–25) at node i
        count = [[0] * 26 for _ in range(n)]
        queue = deque()

        # Initialize nodes with 0 indegree
        for i in range(n):
            if indegree[i] == 0:
                queue.append(i)

        visited = 0
        max_color = 0

        while queue:
            node = queue.popleft()
            visited += 1
            color_index = ord(colors[node]) - ord('a')
            count[node][color_index] += 1

            # Update neighbors
            for neighbor in graph[node]:
                for i in range(26):
                    count[neighbor][i] = max(count[neighbor][i], count[node][i])
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    queue.append(neighbor)

            max_color = max(max_color, max(count[node]))

        # If all nodes not visited, there's a cycle
        return max_color if visited == n else -1
    