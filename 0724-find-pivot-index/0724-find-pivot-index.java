class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = Arrays.stream(nums).sum();

        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
           leftSum += nums[i];
           
           if(leftSum == rightSum){
            return i;
           }

           rightSum -= nums[i];
           
        }

        return -1;
    }
}