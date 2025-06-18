class Solution:
    def divideArray(self, nums: list[int], k: int) -> list[list[int]]:
        if len(nums) % 3 != 0:
            return []

        nums.sort()
        res = []
        for i in range(0 , len(nums), 3):
            group = nums[i:i+3]
            if group[-1] - group[0] <= k:
                res.append(group)
            else:
                return []
        return res
