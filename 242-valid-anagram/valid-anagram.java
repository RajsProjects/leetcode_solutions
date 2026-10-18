class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sfreq = new int[26];
        int[] tfreq = new int[26];

        int n = s.length();
        int m = t.length();

        if(n != m){
            return false;
        }

        for(int i = 0; i < n; i++){
            sfreq[s.charAt(i) - 'a']++;
            tfreq[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(sfreq, tfreq);
    }
}