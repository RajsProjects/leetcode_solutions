arr = [1,2,2,3,4,4,5]
class Solution(object):
    def removeDuplicates(self, nums):
        if not nums:
            return 0
        
        count = 1
        n = len(nums)
        for i in range(1, n):
            if nums[i] != nums[count - 1]:
                nums[count] = nums[i]
                count += 1
        return count
    
if __name__ == "__main__":
    sol = Solution()
    length = sol.removeDuplicates(arr)
    print("Length of array after removing duplicates:", length)
    print("Array after removing duplicates:", arr[:length])