class Solution:
    def containsDuplicate(self, nums: list[int]) -> bool:
        for num in nums:
            if nums.count(num) > 1:
                return True
        return False
if __name__ == "__main__":
    s = Solution()
    s.containsDuplicate(nums = [1, 2, 3, 1])