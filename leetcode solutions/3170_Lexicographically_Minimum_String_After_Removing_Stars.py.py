class Solution(object):
    def clearStars(self, s):
        stack = []
        for ch in s:
            if ch == '*':
                if stack:
                    min_char_index = stack.index(min(stack))
                    stack.pop(min_char_index)
            else:
                stack.append(ch)
        return ''.join(sorted(stack))

if __name__ == "__main__":
    sol = Solution()
    print(sol.clearStars("aaba*"))  
    print(sol.clearStars("abc"))    
    print(sol.clearStars("cbacd*")) 
