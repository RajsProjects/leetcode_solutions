class Solution:
    def kMirror(self, k: int, n: int) -> int:
        def is_palindrome(s):
            return s == s[::-1]
        
        def to_base_k(num, k):
            res = ""
            while num:
                res = str(num % k) + res
                num //= k
            return res
        
        def generate_palindromes():
            length = 1
            while True:
                for half in range(10 ** ((length - 1) // 2), 10 ** ((length + 1) // 2)):
                    s = str(half)
                    yield int(s + s[-2::-1] if length % 2 else s + s[::-1])
                length += 1
        
        ans = 0
        count = 0
        for num in generate_palindromes():
            if is_palindrome(to_base_k(num, k)):
                ans += num
                count += 1
                if count == n:
                    break
        return ans