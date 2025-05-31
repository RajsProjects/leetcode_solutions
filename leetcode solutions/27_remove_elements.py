class Solution(object):
    def removeElement(self, nums, val):
        n = len(nums)
        if n == 0:
            return 0
        for i in range(n - 1, -1, -1):
            if nums[i] == val:
                nums.pop(i)
        return len(nums)
if __name__ == "__main__":
    nums = [3, 2, 2, 3, 4, 5, 3]
    val = 3
    solution = Solution()
    new_length = solution.removeElement(nums, val)
    print("New length:", new_length)
    print("Modified array:", nums[:new_length])  # Print only the modified part of the array
