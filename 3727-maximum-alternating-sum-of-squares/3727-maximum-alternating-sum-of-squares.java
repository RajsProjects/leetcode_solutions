class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++){
            nums[i] = Math.abs(nums[i]);
        }

        Arrays.sort(nums);

        long score = 0;

        for(int i = 0; i < n; i++){

            long squared = (long) nums[i] * nums[i];

            if(i < n/2){
                score -= squared;
            }else{
                score += squared;
            }
        }
        return score;
    }
}