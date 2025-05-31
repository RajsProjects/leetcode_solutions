class Solution(object):
    def differenceOfSums(self, n, m):
        div = []
        non_div = []
        for i in range(n):
            if (i + 1) % m == 0:
                div.append(i + 1)
            else:
                non_div.append(i + 1)
        return sum(non_div) - sum(div)
if __name__ == "__main__":
    s = Solution()
    print(s.differenceOfSums(10, 3))  # Example usage
    print(s.differenceOfSums(20, 3))  # Another example