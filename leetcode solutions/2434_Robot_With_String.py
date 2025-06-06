class Solution(object):
    def robotWithString(self, s):
        stack = []
        result = []
        
        # Step 1: Precompute the smallest character to the right of each position
        min_right = [None] * len(s)
        min_char = 'z'
        for i in reversed(range(len(s))):
            min_char = min(min_char, s[i])
            min_right[i] = min_char

        # Step 2: Traverse the string and process characters
        for i in range(len(s)):
            stack.append(s[i])
            # Try popping from stack if top <= min_char in remaining s
            while stack and (i == len(s)-1 or stack[-1] <= min_right[i + 1]):
                result.append(stack.pop())
        
        # Step 3: Pop remaining characters from stack
        while stack:
            result.append(stack.pop())
        
        return ''.join(result)
