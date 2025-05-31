class Solution(object):
    def isPalindrome(self, x):
        if not isinstance(x, int):
            print('x is not an integer')
        elif str(x) == str(x)[::-1]:
            return print("true")
        else:
            return print("false")


if __name__ == "__main__":
    s = Solution()
    s.isPalindrome(121)  