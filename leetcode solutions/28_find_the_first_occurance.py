class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        n, m = len(haystack), len(needle)
        if m == 0:
            return 0  # Empty needle is found at index 0
        
        for i in range(n - m + 1):
            if haystack[i:i + m] == needle:
                return i
        return -1
