
class Solution {
    public int sumCounts(List<Integer> nums) {
        int distValue = 0;

        for (int i = 0; i < nums.size(); i++) {
            HashSet<Integer> unique = new HashSet<>();

            for (int j = i; j < nums.size(); j++) {
                unique.add(nums.get(j));

                int size = unique.size();
                distValue += size * size;
            }
        }

        return distValue;
    }
}
