class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            maxHeap.offer(Math.abs(nums[i]));
        }

        long score = 0;

        for(int i = 0; i < n; i++){
            int value = maxHeap.poll();

            long squared = (long) value * value;

            if(i < (n+1)/2){
                score += squared;
            }else{
                score -= squared;
            }
        }
        return score;
    }
}