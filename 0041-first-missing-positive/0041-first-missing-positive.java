class Solution {
    public int firstMissingPositive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int num  : nums){
            if(num > 0){
                set.add(num);
            }
        }

        if(!set.contains(1)) return 1;

        int missing = 1;

        while(set.contains(missing)){
            missing++;
        }

        return missing;

    }
}