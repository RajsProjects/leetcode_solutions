class Solution:
    def maxDiff(self, num: int) -> int:
        num_s = str(num)
        temp = num_s
        a = int(num_s.replace(num_s[0], '9'))
        b = int(num_s.replace(temp[0], "1"))
        return a - b
if __name__ == "__main__":
    s = Solution()
    num = 555
    print(s.maxDiff(num))  # Output: 888
    num = 9
    print(s.maxDiff(num))  # Output: 8
    num = 123456789
    print(s.maxDiff(num))  # Output: 888888888
    num = 1000000000
    print(s.maxDiff(num))  # Output: 9000000000