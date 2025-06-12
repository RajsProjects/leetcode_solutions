class Solution:
    def maxAdjacentDistance(self, nums: list[int]) -> int:
        diff1 = nums[-1] - nums[0]
        diff2 = nums[0] - nums[-1]
        max = max(diff1, diff2)
        n = len(nums)
        for i in range(n):
            if i + 1 >= n:
                break
            temp1 = nums[i] - nums[i+1]
            temp2 = nums[i + 1] - nums[i]
            temp = max(temp1, temp2)

            if temp > max: 
                max = temp
        return max
        
