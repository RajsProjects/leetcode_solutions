from collections import deque

class Solution:
    def maxCandies(self, status, candies, keys, containedBoxes, initialBoxes):
        n = len(status)
        visited = [False] * n
        have = set(initialBoxes)
        keys_set = set()
        q = deque(initialBoxes)
        total_candies = 0

        while q:
            current = q.popleft()
            if visited[current]:
                continue
            if status[current] == 0 and current not in keys_set:
                continue
            visited[current] = True
            total_candies += candies[current]
            for key in keys[current]:
                keys_set.add(key)
                if key in have and not visited[key]:
                    q.append(key)
            for box in containedBoxes[current]:
                have.add(box)
                if status[box] == 1 or box in keys_set:
                    if not visited[box]:
                        q.append(box)
        return total_candies
