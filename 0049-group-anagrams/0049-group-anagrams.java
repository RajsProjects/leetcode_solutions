class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            int[] freq = new int[26];

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for (int count : freq) {
                keyBuilder.append('#').append(count);
            }

            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(str);
        }

        return new ArrayList<>(map.values());
    }
}