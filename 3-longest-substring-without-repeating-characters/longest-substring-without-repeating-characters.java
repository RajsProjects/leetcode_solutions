class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int count = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
                count--;
            }

            set.add(s.charAt(right));
            count++;

            max = Math.max(max, count);
        }

        return max;
    }
}