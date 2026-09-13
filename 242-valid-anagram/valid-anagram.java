class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < n; i++){
            freq1[s.charAt(i) - 'a']++;
            freq2[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(freq1, freq2);
    }
}