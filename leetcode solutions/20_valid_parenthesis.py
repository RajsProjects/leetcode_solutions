class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapping = {')': '(', '}': '{', ']': '['}
        
        for char in s:
            if char in mapping.values():
                stack.append(char)
            elif char in mapping.keys():
                if not stack or stack[-1] != mapping[char]:
                    return False
                stack.pop()
        
        return not stack
if __name__ == "__main__":
    s = Solution()
    print(s.isValid("()"))          # True
    print(s.isValid("()[]{}"))      # True
    print(s.isValid("(]"))          # False
    print(s.isValid("([)]"))        # False
    print(s.isValid("{[]}"))        # True
    print(s.isValid("{{{{}}}}"))    # True
    print(s.isValid("{{{}}}"))      # True
    print(s.isValid("{{{}}"))       # False