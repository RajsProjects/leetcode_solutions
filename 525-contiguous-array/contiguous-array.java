class Solution {
    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 → -1, 1 → +1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // Repeated prefix sum
            if (map.containsKey(sum)) {

                maxLength = Math.max(
                    maxLength,
                    i - map.get(sum)
                );

            } else {

                // Store FIRST occurrence only
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}