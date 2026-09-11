class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentPrefix = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            currentPrefix += nums[i];

            int prevPrefix = currentPrefix - k;

            if (map.containsKey(prevPrefix)) {
                count += map.get(prevPrefix);
            }

            map.put(currentPrefix, map.getOrDefault(currentPrefix, 0) + 1);
        }

        return count;
    }
}