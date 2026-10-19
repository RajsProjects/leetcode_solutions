class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smaller = 0;
        int equal = 0;

        for(int num : nums){
            if(num < target){
                smaller++;
            }else if(num == target){
                equal++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = smaller; i < equal + smaller; i++){
            result.add(i);
        }

        return result;
    }
}