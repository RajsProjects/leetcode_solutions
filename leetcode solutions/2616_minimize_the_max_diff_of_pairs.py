class Solution:
    def minimizeMax(self, nums: list[int], p: int) -> int:
        nums.sort()
        print(f"Sorted nums: {nums}")
        low, high = 0, max(nums) - min(nums)
        while low <= high:
            mid = low + (high - low) // 2
            pairs = 0
            i = 0
            while i < len(nums) - 1:
                if nums[i + 1] - nums[i] <= mid:
                    pairs += 1
                    i += 2
                else:
                    i += 1
            if pairs >= p:
                high = mid - 1
            else:
                low = mid + 1
            print(f"low: {low}, high: {high}, mid: {mid}, pairs: {pairs}")
        return low
if __name__ == "__main__":
    nums = [10,1,2,7,1,3]
    p = 2
    sol = Solution()
    print(sol.minimizeMax(nums, p))  # Output: 2