class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int length = 0;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            map.put(
                rightChar,
                map.getOrDefault(rightChar, 0) + 1
            );

            while (map.get(rightChar) > 2) {

                char leftChar = s.charAt(left);

                map.put(
                    leftChar,
                    map.get(leftChar) - 1
                );

                left++;
            }

            length = Math.max(length, right - left + 1);
        }

        return length;
    }
}