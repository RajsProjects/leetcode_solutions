from itertools import count
class Solution:
    def lexicalOrder(self, n: int) -> list[int]:
        output = []
        for i in count(1, 1):
            output.append(str(i))
            if i >= n:
                break
        output = sorted(output)
        return [int(num) for num in output]    
if __name__ == "__main__":
    n = 13
    sol = Solution()
    print(sol.lexicalOrder(n))  # Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]