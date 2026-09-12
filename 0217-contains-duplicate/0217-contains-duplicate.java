class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        if(set.size() != nums.length) return true;

        return false;
    }
}