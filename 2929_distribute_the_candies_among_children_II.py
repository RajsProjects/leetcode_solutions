class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def count_ways(c):
            if c < 0:
                return 0
            return (c + 2) * (c + 1) // 2
            


        total = count_ways(n)
        over1 = 3 * count_ways(n - limit - 1)
        over2 = 3 * count_ways(n - 2 * (limit + 1))
        over3 = count_ways(n - 3 * (limit + 1))

        return total - over1 + over2 - over3
if __name__ == "__main__":
    sol = Solution()
    n = 5
    limit = 2
    result = sol.distributeCandies(n, limit)
    print("Number of ways to distribute candies:", result)