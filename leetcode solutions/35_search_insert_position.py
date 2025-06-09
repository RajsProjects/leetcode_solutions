class Solution:
    def searchInsert(self, nums: list[int], target: int) -> int:
        if target in nums:
            return nums.index(target)
        for i, num in enumerate(nums):
            if num > target:
                return i
        return len(nums)