class Solution:
    def divideString(self, s: str, k: int, fill: str) -> list[str]:
        groups = [s[i:i+k] for i in range(0, len(s), k)]
        if len(groups[-1]) < k:
            groups[-1] += fill * (k - len(groups[-1]))
        return groups
    
if __name__ == "__main__":
    s = "abcdefghij"
    k = 3
    fill = "x"
    solution = Solution()
    result = solution.divideString(s, k, fill)
    print(result)  # Output: ['abc', 'def', 'ghi', 'jxx']